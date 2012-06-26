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

package org.lsp.liferay.portlet.advertising.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CampaignLogService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       CampaignLogService
 * @generated
 */
public class CampaignLogServiceWrapper implements CampaignLogService,
	ServiceWrapper<CampaignLogService> {
	public CampaignLogServiceWrapper(CampaignLogService campaignLogService) {
		_campaignLogService = campaignLogService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _campaignLogService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_campaignLogService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _campaignLogService.invokeMethod(name, parameterTypes, arguments);
	}

	public void markDisplayed(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_campaignLogService.markDisplayed(campaignId);
	}

	public void clearCampaign(long companyId, long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		_campaignLogService.clearCampaign(companyId, campaignId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CampaignLogService getWrappedCampaignLogService() {
		return _campaignLogService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCampaignLogService(
		CampaignLogService campaignLogService) {
		_campaignLogService = campaignLogService;
	}

	public CampaignLogService getWrappedService() {
		return _campaignLogService;
	}

	public void setWrappedService(CampaignLogService campaignLogService) {
		_campaignLogService = campaignLogService;
	}

	private CampaignLogService _campaignLogService;
}