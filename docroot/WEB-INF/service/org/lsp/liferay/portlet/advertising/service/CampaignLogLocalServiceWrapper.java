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
 * This class is a wrapper for {@link CampaignLogLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       CampaignLogLocalService
 * @generated
 */
public class CampaignLogLocalServiceWrapper implements CampaignLogLocalService,
	ServiceWrapper<CampaignLogLocalService> {
	public CampaignLogLocalServiceWrapper(
		CampaignLogLocalService campaignLogLocalService) {
		_campaignLogLocalService = campaignLogLocalService;
	}

	/**
	* Adds the campaign log to the database. Also notifies the appropriate model listeners.
	*
	* @param campaignLog the campaign log
	* @return the campaign log that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.advertising.model.CampaignLog addCampaignLog(
		org.lsp.liferay.portlet.advertising.model.CampaignLog campaignLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLogLocalService.addCampaignLog(campaignLog);
	}

	/**
	* Creates a new campaign log with the primary key. Does not add the campaign log to the database.
	*
	* @param campaignLogId the primary key for the new campaign log
	* @return the new campaign log
	*/
	public org.lsp.liferay.portlet.advertising.model.CampaignLog createCampaignLog(
		long campaignLogId) {
		return _campaignLogLocalService.createCampaignLog(campaignLogId);
	}

	/**
	* Deletes the campaign log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignLogId the primary key of the campaign log
	* @return the campaign log that was removed
	* @throws PortalException if a campaign log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.advertising.model.CampaignLog deleteCampaignLog(
		long campaignLogId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLogLocalService.deleteCampaignLog(campaignLogId);
	}

	/**
	* Deletes the campaign log from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignLog the campaign log
	* @return the campaign log that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.advertising.model.CampaignLog deleteCampaignLog(
		org.lsp.liferay.portlet.advertising.model.CampaignLog campaignLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLogLocalService.deleteCampaignLog(campaignLog);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _campaignLogLocalService.dynamicQuery();
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
		return _campaignLogLocalService.dynamicQuery(dynamicQuery);
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
		return _campaignLogLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _campaignLogLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _campaignLogLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.lsp.liferay.portlet.advertising.model.CampaignLog fetchCampaignLog(
		long campaignLogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLogLocalService.fetchCampaignLog(campaignLogId);
	}

	/**
	* Returns the campaign log with the primary key.
	*
	* @param campaignLogId the primary key of the campaign log
	* @return the campaign log
	* @throws PortalException if a campaign log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.advertising.model.CampaignLog getCampaignLog(
		long campaignLogId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLogLocalService.getCampaignLog(campaignLogId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignLogLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the campaign logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of campaign logs
	* @param end the upper bound of the range of campaign logs (not inclusive)
	* @return the range of campaign logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.lsp.liferay.portlet.advertising.model.CampaignLog> getCampaignLogs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLogLocalService.getCampaignLogs(start, end);
	}

	/**
	* Returns the number of campaign logs.
	*
	* @return the number of campaign logs
	* @throws SystemException if a system exception occurred
	*/
	public int getCampaignLogsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLogLocalService.getCampaignLogsCount();
	}

	/**
	* Updates the campaign log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param campaignLog the campaign log
	* @return the campaign log that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.advertising.model.CampaignLog updateCampaignLog(
		org.lsp.liferay.portlet.advertising.model.CampaignLog campaignLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLogLocalService.updateCampaignLog(campaignLog);
	}

	/**
	* Updates the campaign log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param campaignLog the campaign log
	* @param merge whether to merge the campaign log with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the campaign log that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.lsp.liferay.portlet.advertising.model.CampaignLog updateCampaignLog(
		org.lsp.liferay.portlet.advertising.model.CampaignLog campaignLog,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLogLocalService.updateCampaignLog(campaignLog, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _campaignLogLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_campaignLogLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _campaignLogLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public void markDisplayed(long campaignId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_campaignLogLocalService.markDisplayed(campaignId, userId);
	}

	public void clearCampaign(long companyId, long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaignLogLocalService.clearCampaign(companyId, campaignId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CampaignLogLocalService getWrappedCampaignLogLocalService() {
		return _campaignLogLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCampaignLogLocalService(
		CampaignLogLocalService campaignLogLocalService) {
		_campaignLogLocalService = campaignLogLocalService;
	}

	public CampaignLogLocalService getWrappedService() {
		return _campaignLogLocalService;
	}

	public void setWrappedService(
		CampaignLogLocalService campaignLogLocalService) {
		_campaignLogLocalService = campaignLogLocalService;
	}

	private CampaignLogLocalService _campaignLogLocalService;
}