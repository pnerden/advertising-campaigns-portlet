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

import java.util.Date;
import java.util.List;

import org.lsp.liferay.portlet.advertising.model.Campaign;
import org.lsp.liferay.portlet.advertising.service.base.CampaignServiceBaseImpl;
import org.lsp.liferay.portlet.advertising.util.CampaignConstants;
import org.lsp.liferay.portlet.advertising.util.CampaignUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * The implementation of the campaign remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.lsp.liferay.portlet.advertising.service.CampaignService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see org.lsp.liferay.portlet.advertising.service.base.CampaignServiceBaseImpl
 * @see org.lsp.liferay.portlet.advertising.service.CampaignServiceUtil
 */
public class CampaignServiceImpl extends CampaignServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.lsp.liferay.portlet.advertising.service.CampaignServiceUtil} to access the campaign remote service.
	 */
	
	public long getCampaignIdToDisplay() throws PortalException, SystemException {
		PermissionChecker permissionChecker = getPermissionChecker();
		return campaignLocalService.getCampaignIdToDisplay(permissionChecker.getCompanyId(), permissionChecker.getUserId());
	}
	
	public Campaign createCampaign(long journalArticlePrimaryKey, Date beginDate, Date endDate) throws PortalException, SystemException {
		PermissionChecker permissionChecker = getPermissionChecker();
		if (permissionChecker.hasPermission(CampaignUtil.getGlobalGroupId(permissionChecker.getCompanyId()), "org.lsp.liferay.portlet.advertising.campaign", CampaignUtil.getGlobalGroupId(permissionChecker.getCompanyId()), CampaignConstants.ADD_CAMPAIGN)) {
			return campaignLocalService.createCampaign(permissionChecker.getCompanyId(), journalArticlePrimaryKey, beginDate, endDate);
		}
		throw new PortalException("You have no right to add this resource");
	}
	
	public Campaign getCampaign(long campaignId) throws PortalException, SystemException {
		PermissionChecker permissionChecker = getPermissionChecker();
		if (permissionChecker.hasPermission(CampaignUtil.getGlobalGroupId(permissionChecker.getCompanyId()), Campaign.class.getName(), campaignId, ActionKeys.VIEW)) {
			return campaignLocalService.getCampaign(permissionChecker.getCompanyId(), campaignId);
		}
		throw new PortalException("You have no right to access this resource");
	}
	
	public List<Campaign> getCampaigns() throws PortalException, SystemException {
		PermissionChecker permissionChecker = getPermissionChecker();
		if ((permissionChecker.isCompanyAdmin()) || (permissionChecker.hasPermission(CampaignUtil.getGlobalGroupId(permissionChecker.getCompanyId()), "org.lsp.liferay.hook.login.advertising.campaign", CampaignUtil.getGlobalGroupId(permissionChecker.getCompanyId()), CampaignConstants.LIST_CAMPAIGNS))) {
			return campaignLocalService.getCampaigns(permissionChecker.getCompanyId());
		}
		throw new PortalException("You have no right to access this resource");
	}
	
	public long removeCampaign(long campaignId) throws PortalException, SystemException {
		PermissionChecker permissionChecker = getPermissionChecker();
		Campaign result = campaignLocalService.getCampaign(permissionChecker.getCompanyId(), campaignId);
		if (permissionChecker.hasPermission(CampaignUtil.getGlobalGroupId(permissionChecker.getCompanyId()), Campaign.class.getName(), campaignId, ActionKeys.DELETE)) {
			return campaignLocalService.removeCampaign(result.getCompanyId(), campaignId);
		}
		throw new PortalException("You have no right to delete this resource");
	}
	
	public Campaign updateCampaign(long campaignId, long journalArticlePrimaryKey, Date beginDate, Date endDate) throws PortalException, SystemException {
		PermissionChecker permissionChecker = getPermissionChecker();
		if (permissionChecker.hasPermission(CampaignUtil.getGlobalGroupId(permissionChecker.getCompanyId()), Campaign.class.getName(), CampaignUtil.getGlobalGroupId(permissionChecker.getCompanyId()), ActionKeys.UPDATE)) {
			return campaignLocalService.updateCampaign(campaignId, permissionChecker.getCompanyId(), journalArticlePrimaryKey, beginDate, endDate);
		}
		throw new PortalException("You have no right to update this resource");
	}
	
	public Campaign updateCampaign(long campaignId, long journalArticlePrimaryKey, Date beginDate, Date endDate, int campaignStatus) throws PortalException, SystemException {
		PermissionChecker permissionChecker = getPermissionChecker();
		if (permissionChecker.hasPermission(CampaignUtil.getGlobalGroupId(permissionChecker.getCompanyId()), Campaign.class.getName(), CampaignUtil.getGlobalGroupId(permissionChecker.getCompanyId()), ActionKeys.UPDATE)) {
			return campaignLocalService.updateCampaign(campaignId, permissionChecker.getCompanyId(), journalArticlePrimaryKey, beginDate, endDate, campaignStatus);
		}
		throw new PortalException("You have no right to update this resource");
	}
	
	public Campaign startCampaign(long campaignId) throws PortalException, SystemException {
		PermissionChecker permissionChecker = getPermissionChecker();
		if (permissionChecker.hasPermission(CampaignUtil.getGlobalGroupId(permissionChecker.getCompanyId()), Campaign.class.getName(), CampaignUtil.getGlobalGroupId(permissionChecker.getCompanyId()), ActionKeys.UPDATE)) {
			return campaignLocalService.startCampaign(permissionChecker.getCompanyId(), campaignId);
		}
		throw new PortalException("You have no right to update this resource");
	}
	
	public Campaign pauseCampaign(long campaignId) throws PortalException, SystemException {
		PermissionChecker permissionChecker = getPermissionChecker();
		if (permissionChecker.hasPermission(CampaignUtil.getGlobalGroupId(permissionChecker.getCompanyId()), Campaign.class.getName(), CampaignUtil.getGlobalGroupId(permissionChecker.getCompanyId()), ActionKeys.UPDATE)) {
			return campaignLocalService.pauseCampaign(permissionChecker.getCompanyId(), campaignId);
		}
		throw new PortalException("You have no right to update this resource");
	}
	
	public Campaign stopCampaign(long campaignId) throws PortalException, SystemException {
		PermissionChecker permissionChecker = getPermissionChecker();
		if (permissionChecker.hasPermission(CampaignUtil.getGlobalGroupId(permissionChecker.getCompanyId()), Campaign.class.getName(), CampaignUtil.getGlobalGroupId(permissionChecker.getCompanyId()), ActionKeys.UPDATE)) {
			return campaignLocalService.stopCampaign(permissionChecker.getCompanyId(), campaignId);
		}
		throw new PortalException("You have no right to update this resource");
	}
}