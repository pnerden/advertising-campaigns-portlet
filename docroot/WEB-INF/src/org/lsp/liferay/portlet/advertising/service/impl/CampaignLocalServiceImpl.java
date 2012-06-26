/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.lsp.liferay.portlet.advertising.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.lsp.liferay.portlet.advertising.NoSuchCampaignException;
import org.lsp.liferay.portlet.advertising.model.Campaign;
import org.lsp.liferay.portlet.advertising.service.base.CampaignLocalServiceBaseImpl;
import org.lsp.liferay.portlet.advertising.util.CampaignConstants;
import org.lsp.liferay.portlet.advertising.util.CampaignUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.CompanyLocalServiceUtil;

/**
 * The implementation of the campaign local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.lsp.liferay.portlet.advertising.service.CampaignLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see org.lsp.liferay.portlet.advertising.service.base.CampaignLocalServiceBaseImpl
 * @see org.lsp.liferay.portlet.advertising.service.CampaignLocalServiceUtil
 */
public class CampaignLocalServiceImpl extends CampaignLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.lsp.liferay.hook.login.advertising.service.CampaignLocalServiceUtil} to access the campaign local service.
	 */
	
	public long getCampaignIdToDisplay(long companyId, long userId) throws PortalException, SystemException {
		Calendar cal = Calendar.getInstance(CompanyLocalServiceUtil.getCompany(companyId).getTimeZone());
		List<Campaign> campaignList = filterByAlreadyDisplayed(campaignPersistence.findByActiveCampaignsByDate(companyId, CampaignConstants.STATUS_ACTIVE, cal.getTime(), cal.getTime()), userId);
		return CampaignUtil.campaignLottery(campaignList);
	}
	
	public Campaign createCampaign(long companyId, long journalArticlePrimaryKey, Date beginDate, Date endDate) throws PortalException, SystemException {
		
		long campaignId = counterLocalService.increment();
		Campaign campaign = campaignPersistence.create(campaignId);
		
		campaign.setCompanyId(companyId);
		campaign.setJournalArticlePrimaryKey(journalArticlePrimaryKey);
		campaign.setBeginDate(beginDate);
		campaign.setEndDate(endDate);
		campaign.setCampaignStatus(CampaignConstants.STATUS_INACTIVE);
		campaignPersistence.update(campaign, false);
		
		return campaign;
		
	}
	
	public Campaign getCampaign(long companyId, long campaignId) throws SystemException {
		return campaignPersistence.fetchByCampaignId(campaignId, companyId);
	}
	
	public List<Campaign> getCampaigns(long companyId) throws SystemException {
		return campaignPersistence.findByCompanyId(companyId);
	}
	
	public Campaign updateCampaign(long campaignId, long companyId, long journalArticlePrimaryKey, Date beginDate, Date endDate) throws SystemException, PortalException {
		return updateCampaign(campaignId, companyId, journalArticlePrimaryKey, beginDate, endDate, CampaignConstants.STATUS_INACTIVE);
	}
	
	public Campaign updateCampaign(long campaignId, long companyId, long journalArticlePrimaryKey, Date beginDate, Date endDate, int campaignStatus) throws SystemException, PortalException {
		Campaign result = getCampaign(companyId, campaignId);
		result.setCompanyId(companyId);
		result.setJournalArticlePrimaryKey(journalArticlePrimaryKey);
		result.setBeginDate(beginDate);
		result.setEndDate(endDate);
		result.setCampaignStatus(campaignStatus);
		campaignPersistence.update(result, false);
		
		return result;
	}
	
	public long removeCampaign(long companyId, long campaignId) throws NoSuchCampaignException, SystemException {
		stopCampaign(companyId, campaignId);
		campaignPersistence.removeByCampaignId(campaignId, companyId);
		return campaignId;
	}
	
	private List<Campaign> filterByAlreadyDisplayed(List<Campaign> campaignList, long userId) throws SystemException {
		List<Campaign> result = new Vector<Campaign>();
		Iterator<Campaign> iter = campaignList.iterator();
		while (iter.hasNext()) {
			Campaign c = iter.next();
			if (campaignLogPersistence.fetchByLogFinder(c.getCampaignId(), c.getCompanyId(), userId) == null) {
				result.add(c);
			}
		}
		return result;
	}
	
	public Campaign startCampaign(long companyId, long campaignId) throws SystemException {
		return activate(companyId, campaignId);
	}
	
	public Campaign pauseCampaign(long companyId, long campaignId) throws SystemException {
		return disactivate(companyId, campaignId);
	}
	
	public Campaign stopCampaign(long companyId, long campaignId) throws SystemException {
		Campaign result = getCampaign(companyId, campaignId);
		result.setEndDate(new Date());
		result.setCampaignStatus(CampaignConstants.STATUS_INACTIVE);
		campaignPersistence.update(result, false);
		campaignLogPersistence.removeByCampaignId(campaignId, companyId);
		return result;
	}
	
	public Campaign activate(long companyId, long campaignId) throws SystemException {
		Campaign result = getCampaign(companyId, campaignId);
		result.setCampaignStatus(CampaignConstants.STATUS_ACTIVE);
		
		campaignPersistence.update(result, false);
		
		return result;
		
	}
	
	public Campaign disactivate(long companyId, long campaignId) throws SystemException {
		Campaign result = getCampaign(companyId, campaignId);
		result.setCampaignStatus(CampaignConstants.STATUS_PAUSE);
		
		campaignPersistence.update(result, false);
		
		return result;
		
	}
	
}