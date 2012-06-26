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

package org.lsp.liferay.portlet.advertising.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CampaignLog}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       CampaignLog
 * @generated
 */
public class CampaignLogWrapper implements CampaignLog,
	ModelWrapper<CampaignLog> {
	public CampaignLogWrapper(CampaignLog campaignLog) {
		_campaignLog = campaignLog;
	}

	public Class<?> getModelClass() {
		return CampaignLog.class;
	}

	public String getModelClassName() {
		return CampaignLog.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("campaignLogId", getCampaignLogId());
		attributes.put("companyId", getCompanyId());
		attributes.put("campaignId", getCampaignId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long campaignLogId = (Long)attributes.get("campaignLogId");

		if (campaignLogId != null) {
			setCampaignLogId(campaignLogId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	/**
	* Returns the primary key of this campaign log.
	*
	* @return the primary key of this campaign log
	*/
	public long getPrimaryKey() {
		return _campaignLog.getPrimaryKey();
	}

	/**
	* Sets the primary key of this campaign log.
	*
	* @param primaryKey the primary key of this campaign log
	*/
	public void setPrimaryKey(long primaryKey) {
		_campaignLog.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the campaign log ID of this campaign log.
	*
	* @return the campaign log ID of this campaign log
	*/
	public long getCampaignLogId() {
		return _campaignLog.getCampaignLogId();
	}

	/**
	* Sets the campaign log ID of this campaign log.
	*
	* @param campaignLogId the campaign log ID of this campaign log
	*/
	public void setCampaignLogId(long campaignLogId) {
		_campaignLog.setCampaignLogId(campaignLogId);
	}

	/**
	* Returns the company ID of this campaign log.
	*
	* @return the company ID of this campaign log
	*/
	public long getCompanyId() {
		return _campaignLog.getCompanyId();
	}

	/**
	* Sets the company ID of this campaign log.
	*
	* @param companyId the company ID of this campaign log
	*/
	public void setCompanyId(long companyId) {
		_campaignLog.setCompanyId(companyId);
	}

	/**
	* Returns the campaign ID of this campaign log.
	*
	* @return the campaign ID of this campaign log
	*/
	public long getCampaignId() {
		return _campaignLog.getCampaignId();
	}

	/**
	* Sets the campaign ID of this campaign log.
	*
	* @param campaignId the campaign ID of this campaign log
	*/
	public void setCampaignId(long campaignId) {
		_campaignLog.setCampaignId(campaignId);
	}

	/**
	* Returns the user ID of this campaign log.
	*
	* @return the user ID of this campaign log
	*/
	public long getUserId() {
		return _campaignLog.getUserId();
	}

	/**
	* Sets the user ID of this campaign log.
	*
	* @param userId the user ID of this campaign log
	*/
	public void setUserId(long userId) {
		_campaignLog.setUserId(userId);
	}

	/**
	* Returns the user uuid of this campaign log.
	*
	* @return the user uuid of this campaign log
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignLog.getUserUuid();
	}

	/**
	* Sets the user uuid of this campaign log.
	*
	* @param userUuid the user uuid of this campaign log
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_campaignLog.setUserUuid(userUuid);
	}

	public boolean isNew() {
		return _campaignLog.isNew();
	}

	public void setNew(boolean n) {
		_campaignLog.setNew(n);
	}

	public boolean isCachedModel() {
		return _campaignLog.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_campaignLog.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _campaignLog.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _campaignLog.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_campaignLog.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _campaignLog.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_campaignLog.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CampaignLogWrapper((CampaignLog)_campaignLog.clone());
	}

	public int compareTo(
		org.lsp.liferay.portlet.advertising.model.CampaignLog campaignLog) {
		return _campaignLog.compareTo(campaignLog);
	}

	@Override
	public int hashCode() {
		return _campaignLog.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.lsp.liferay.portlet.advertising.model.CampaignLog> toCacheModel() {
		return _campaignLog.toCacheModel();
	}

	public org.lsp.liferay.portlet.advertising.model.CampaignLog toEscapedModel() {
		return new CampaignLogWrapper(_campaignLog.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _campaignLog.toString();
	}

	public java.lang.String toXmlString() {
		return _campaignLog.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaignLog.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CampaignLog getWrappedCampaignLog() {
		return _campaignLog;
	}

	public CampaignLog getWrappedModel() {
		return _campaignLog;
	}

	public void resetOriginalValues() {
		_campaignLog.resetOriginalValues();
	}

	private CampaignLog _campaignLog;
}