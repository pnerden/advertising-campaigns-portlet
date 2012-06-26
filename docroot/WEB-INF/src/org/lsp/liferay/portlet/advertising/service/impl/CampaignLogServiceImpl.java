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

import org.lsp.liferay.portlet.advertising.model.Campaign;
import org.lsp.liferay.portlet.advertising.service.base.CampaignLogServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * The implementation of the campaign log remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.lsp.liferay.portlet.advertising.service.CampaignLogService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see org.lsp.liferay.portlet.advertising.service.base.CampaignLogServiceBaseImpl
 * @see org.lsp.liferay.portlet.advertising.service.CampaignLogServiceUtil
 */
public class CampaignLogServiceImpl extends CampaignLogServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.lsp.liferay.hook.login.advertising.service.CampaignLogServiceUtil} to access the campaign log remote service.
	 */
	
	public void markDisplayed(long campaignId) throws SystemException, PortalException {
		PermissionChecker permissionChecker = getPermissionChecker();
		campaignLogLocalService.markDisplayed(campaignId, permissionChecker.getUserId());
	}
	
	public void clearCampaign(long companyId, long campaignId) throws SystemException, PrincipalException {
		PermissionChecker permissionChecker = getPermissionChecker();
		if (permissionChecker.hasPermission(companyId, Campaign.class.getName(), campaignId, ActionKeys.DELETE)) {
			campaignLogLocalService.clearCampaign(companyId, campaignId);
		}
	}
}