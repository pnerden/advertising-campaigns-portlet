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

import org.lsp.liferay.portlet.advertising.model.CampaignLog;
import org.lsp.liferay.portlet.advertising.service.base.CampaignLogLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

/**
 * The implementation of the campaign log local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.lsp.liferay.portlet.advertising.service.CampaignLogLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see org.lsp.liferay.portlet.advertising.service.base.CampaignLogLocalServiceBaseImpl
 * @see org.lsp.liferay.portlet.advertising.service.CampaignLogLocalServiceUtil
 */
public class CampaignLogLocalServiceImpl extends CampaignLogLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.lsp.liferay.hook.login.advertising.service.CampaignLogLocalServiceUtil} to access the campaign log local service.
	 */
	
	public void markDisplayed(long campaignId, long userId) throws SystemException, PortalException {
		
		User user = userLocalService.getUserById(userId);
		
		long campaignLogId = counterLocalService.increment();
		CampaignLog campaignLog = campaignLogPersistence.create(campaignLogId);
		
		campaignLog.setCompanyId(user.getCompanyId());
		campaignLog.setCampaignId(campaignId);
		campaignLog.setUserId(user.getUserId());
		
		campaignLogPersistence.update(campaignLog, false);
		
	}
	
	public void clearCampaign(long companyId, long campaignId) throws SystemException {
		campaignLogPersistence.removeByCampaignId(campaignId, companyId);
	}
}