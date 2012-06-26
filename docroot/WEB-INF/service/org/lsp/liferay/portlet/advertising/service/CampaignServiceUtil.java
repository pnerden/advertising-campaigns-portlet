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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * The utility for the campaign remote service. This utility wraps {@link org.lsp.liferay.portlet.advertising.service.impl.CampaignServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignService
 * @see org.lsp.liferay.portlet.advertising.service.base.CampaignServiceBaseImpl
 * @see org.lsp.liferay.portlet.advertising.service.impl.CampaignServiceImpl
 * @generated
 */
public class CampaignServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.lsp.liferay.portlet.advertising.service.impl.CampaignServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static long getCampaignIdToDisplay()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaignIdToDisplay();
	}

	public static org.lsp.liferay.portlet.advertising.model.Campaign createCampaign(
		long journalArticlePrimaryKey, java.util.Date beginDate,
		java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .createCampaign(journalArticlePrimaryKey, beginDate, endDate);
	}

	public static org.lsp.liferay.portlet.advertising.model.Campaign getCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaign(campaignId);
	}

	public static java.util.List<org.lsp.liferay.portlet.advertising.model.Campaign> getCampaigns()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCampaigns();
	}

	public static long removeCampaign(long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().removeCampaign(campaignId);
	}

	public static org.lsp.liferay.portlet.advertising.model.Campaign updateCampaign(
		long campaignId, long journalArticlePrimaryKey,
		java.util.Date beginDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCampaign(campaignId, journalArticlePrimaryKey,
			beginDate, endDate);
	}

	public static org.lsp.liferay.portlet.advertising.model.Campaign updateCampaign(
		long campaignId, long journalArticlePrimaryKey,
		java.util.Date beginDate, java.util.Date endDate, int campaignStatus)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCampaign(campaignId, journalArticlePrimaryKey,
			beginDate, endDate, campaignStatus);
	}

	public static org.lsp.liferay.portlet.advertising.model.Campaign startCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().startCampaign(campaignId);
	}

	public static org.lsp.liferay.portlet.advertising.model.Campaign pauseCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().pauseCampaign(campaignId);
	}

	public static org.lsp.liferay.portlet.advertising.model.Campaign stopCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().stopCampaign(campaignId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CampaignService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CampaignService.class.getName());

			if (invokableService instanceof CampaignService) {
				_service = (CampaignService)invokableService;
			}
			else {
				_service = new CampaignServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(CampaignServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(CampaignService service) {
	}

	private static CampaignService _service;
}