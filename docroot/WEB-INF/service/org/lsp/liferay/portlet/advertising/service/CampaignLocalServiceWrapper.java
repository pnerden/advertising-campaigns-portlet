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
 * This class is a wrapper for {@link CampaignLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       CampaignLocalService
 * @generated
 */
public class CampaignLocalServiceWrapper implements CampaignLocalService,
	ServiceWrapper<CampaignLocalService> {
	public CampaignLocalServiceWrapper(
		CampaignLocalService campaignLocalService) {
		_campaignLocalService = campaignLocalService;
	}

	/**
	* Adds the campaign to the database. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.advertising.model.Campaign addCampaign(
		org.lsp.liferay.portlet.advertising.model.Campaign campaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.addCampaign(campaign);
	}

	/**
	* Creates a new campaign with the primary key. Does not add the campaign to the database.
	*
	* @param campaignId the primary key for the new campaign
	* @return the new campaign
	*/
	public org.lsp.liferay.portlet.advertising.model.Campaign createCampaign(
		long campaignId) {
		return _campaignLocalService.createCampaign(campaignId);
	}

	/**
	* Deletes the campaign with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign that was removed
	* @throws PortalException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.advertising.model.Campaign deleteCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.deleteCampaign(campaignId);
	}

	/**
	* Deletes the campaign from the database. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.advertising.model.Campaign deleteCampaign(
		org.lsp.liferay.portlet.advertising.model.Campaign campaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.deleteCampaign(campaign);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _campaignLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.lsp.liferay.portlet.advertising.model.Campaign fetchCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.fetchCampaign(campaignId);
	}

	/**
	* Returns the campaign with the primary key.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign
	* @throws PortalException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.advertising.model.Campaign getCampaign(
		long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.getCampaign(campaignId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the campaigns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of campaigns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.lsp.liferay.portlet.advertising.model.Campaign> getCampaigns(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.getCampaigns(start, end);
	}

	/**
	* Returns the number of campaigns.
	*
	* @return the number of campaigns
	* @throws SystemException if a system exception occurred
	*/
	public int getCampaignsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.getCampaignsCount();
	}

	/**
	* Updates the campaign in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @return the campaign that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.advertising.model.Campaign updateCampaign(
		org.lsp.liferay.portlet.advertising.model.Campaign campaign)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.updateCampaign(campaign);
	}

	/**
	* Updates the campaign in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param campaign the campaign
	* @param merge whether to merge the campaign with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the campaign that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.advertising.model.Campaign updateCampaign(
		org.lsp.liferay.portlet.advertising.model.Campaign campaign,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.updateCampaign(campaign, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _campaignLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_campaignLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _campaignLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public long getCampaignIdToDisplay(long companyId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.getCampaignIdToDisplay(companyId, userId);
	}

	public org.lsp.liferay.portlet.advertising.model.Campaign createCampaign(
		long companyId, long journalArticlePrimaryKey,
		java.util.Date beginDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.createCampaign(companyId,
			journalArticlePrimaryKey, beginDate, endDate);
	}

	public org.lsp.liferay.portlet.advertising.model.Campaign getCampaign(
		long companyId, long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.getCampaign(companyId, campaignId);
	}

	public java.util.List<org.lsp.liferay.portlet.advertising.model.Campaign> getCampaigns(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.getCampaigns(companyId);
	}

	public org.lsp.liferay.portlet.advertising.model.Campaign updateCampaign(
		long campaignId, long companyId, long journalArticlePrimaryKey,
		java.util.Date beginDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.updateCampaign(campaignId, companyId,
			journalArticlePrimaryKey, beginDate, endDate);
	}

	public org.lsp.liferay.portlet.advertising.model.Campaign updateCampaign(
		long campaignId, long companyId, long journalArticlePrimaryKey,
		java.util.Date beginDate, java.util.Date endDate, int campaignStatus)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.updateCampaign(campaignId, companyId,
			journalArticlePrimaryKey, beginDate, endDate, campaignStatus);
	}

	public long removeCampaign(long companyId, long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.advertising.NoSuchCampaignException {
		return _campaignLocalService.removeCampaign(companyId, campaignId);
	}

	public org.lsp.liferay.portlet.advertising.model.Campaign startCampaign(
		long companyId, long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.startCampaign(companyId, campaignId);
	}

	public org.lsp.liferay.portlet.advertising.model.Campaign pauseCampaign(
		long companyId, long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.pauseCampaign(companyId, campaignId);
	}

	public org.lsp.liferay.portlet.advertising.model.Campaign stopCampaign(
		long companyId, long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.stopCampaign(companyId, campaignId);
	}

	public org.lsp.liferay.portlet.advertising.model.Campaign activate(
		long companyId, long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.activate(companyId, campaignId);
	}

	public org.lsp.liferay.portlet.advertising.model.Campaign disactivate(
		long companyId, long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLocalService.disactivate(companyId, campaignId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CampaignLocalService getWrappedCampaignLocalService() {
		return _campaignLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCampaignLocalService(
		CampaignLocalService campaignLocalService) {
		_campaignLocalService = campaignLocalService;
	}

	public CampaignLocalService getWrappedService() {
		return _campaignLocalService;
	}

	public void setWrappedService(CampaignLocalService campaignLocalService) {
		_campaignLocalService = campaignLocalService;
	}

	private CampaignLocalService _campaignLocalService;
}