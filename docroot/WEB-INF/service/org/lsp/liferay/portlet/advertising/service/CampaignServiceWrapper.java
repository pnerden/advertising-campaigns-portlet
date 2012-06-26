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
 * This class is a wrapper for {@link CampaignService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       CampaignService
 * @generated
 */
public class CampaignServiceWrapper implements CampaignService,
	ServiceWrapper<CampaignService> {
	public CampaignServiceWrapper(CampaignService campaignService) {
		_campaignService = campaignService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _campaignService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_campaignService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _campaignService.invokeMethod(name, parameterTypes, arguments);
	}

	public long getCampaignIdToDisplay()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignService.getCampaignIdToDisplay();
	}

	public org.lsp.liferay.portlet.advertising.model.Campaign createCampaign(
		long journalArticlePrimaryKey, java.util.Date beginDate,
		java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignService.createCampaign(journalArticlePrimaryKey,
			beginDate, endDate);
	}

	public org.lsp.liferay.portlet.advertising.model.Campaign getCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignService.getCampaign(campaignId);
	}

	public java.util.List<org.lsp.liferay.portlet.advertising.model.Campaign> getCampaigns()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignService.getCampaigns();
	}

	public long removeCampaign(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignService.removeCampaign(campaignId);
	}

	public org.lsp.liferay.portlet.advertising.model.Campaign updateCampaign(
		long campaignId, long journalArticlePrimaryKey,
		java.util.Date beginDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignService.updateCampaign(campaignId,
			journalArticlePrimaryKey, beginDate, endDate);
	}

	public org.lsp.liferay.portlet.advertising.model.Campaign updateCampaign(
		long campaignId, long journalArticlePrimaryKey,
		java.util.Date beginDate, java.util.Date endDate, int campaignStatus)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignService.updateCampaign(campaignId,
			journalArticlePrimaryKey, beginDate, endDate, campaignStatus);
	}

	public org.lsp.liferay.portlet.advertising.model.Campaign startCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignService.startCampaign(campaignId);
	}

	public org.lsp.liferay.portlet.advertising.model.Campaign pauseCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignService.pauseCampaign(campaignId);
	}

	public org.lsp.liferay.portlet.advertising.model.Campaign stopCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignService.stopCampaign(campaignId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CampaignService getWrappedCampaignService() {
		return _campaignService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCampaignService(CampaignService campaignService) {
		_campaignService = campaignService;
	}

	public CampaignService getWrappedService() {
		return _campaignService;
	}

	public void setWrappedService(CampaignService campaignService) {
		_campaignService = campaignService;
	}

	private CampaignService _campaignService;
}