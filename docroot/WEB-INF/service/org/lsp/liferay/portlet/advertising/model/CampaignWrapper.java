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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Campaign}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Campaign
 * @generated
 */
public class CampaignWrapper implements Campaign, ModelWrapper<Campaign> {
	public CampaignWrapper(Campaign campaign) {
		_campaign = campaign;
	}

	public Class<?> getModelClass() {
		return Campaign.class;
	}

	public String getModelClassName() {
		return Campaign.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("companyId", getCompanyId());
		attributes.put("campaignId", getCampaignId());
		attributes.put("journalArticlePrimaryKey", getJournalArticlePrimaryKey());
		attributes.put("beginDate", getBeginDate());
		attributes.put("endDate", getEndDate());
		attributes.put("campaignStatus", getCampaignStatus());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}

		Long journalArticlePrimaryKey = (Long)attributes.get(
				"journalArticlePrimaryKey");

		if (journalArticlePrimaryKey != null) {
			setJournalArticlePrimaryKey(journalArticlePrimaryKey);
		}

		Date beginDate = (Date)attributes.get("beginDate");

		if (beginDate != null) {
			setBeginDate(beginDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Integer campaignStatus = (Integer)attributes.get("campaignStatus");

		if (campaignStatus != null) {
			setCampaignStatus(campaignStatus);
		}
	}

	/**
	* Returns the primary key of this campaign.
	*
	* @return the primary key of this campaign
	*/
	public long getPrimaryKey() {
		return _campaign.getPrimaryKey();
	}

	/**
	* Sets the primary key of this campaign.
	*
	* @param primaryKey the primary key of this campaign
	*/
	public void setPrimaryKey(long primaryKey) {
		_campaign.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the company ID of this campaign.
	*
	* @return the company ID of this campaign
	*/
	public long getCompanyId() {
		return _campaign.getCompanyId();
	}

	/**
	* Sets the company ID of this campaign.
	*
	* @param companyId the company ID of this campaign
	*/
	public void setCompanyId(long companyId) {
		_campaign.setCompanyId(companyId);
	}

	/**
	* Returns the campaign ID of this campaign.
	*
	* @return the campaign ID of this campaign
	*/
	public long getCampaignId() {
		return _campaign.getCampaignId();
	}

	/**
	* Sets the campaign ID of this campaign.
	*
	* @param campaignId the campaign ID of this campaign
	*/
	public void setCampaignId(long campaignId) {
		_campaign.setCampaignId(campaignId);
	}

	/**
	* Returns the journal article primary key of this campaign.
	*
	* @return the journal article primary key of this campaign
	*/
	public long getJournalArticlePrimaryKey() {
		return _campaign.getJournalArticlePrimaryKey();
	}

	/**
	* Sets the journal article primary key of this campaign.
	*
	* @param journalArticlePrimaryKey the journal article primary key of this campaign
	*/
	public void setJournalArticlePrimaryKey(long journalArticlePrimaryKey) {
		_campaign.setJournalArticlePrimaryKey(journalArticlePrimaryKey);
	}

	/**
	* Returns the begin date of this campaign.
	*
	* @return the begin date of this campaign
	*/
	public java.util.Date getBeginDate() {
		return _campaign.getBeginDate();
	}

	/**
	* Sets the begin date of this campaign.
	*
	* @param beginDate the begin date of this campaign
	*/
	public void setBeginDate(java.util.Date beginDate) {
		_campaign.setBeginDate(beginDate);
	}

	/**
	* Returns the end date of this campaign.
	*
	* @return the end date of this campaign
	*/
	public java.util.Date getEndDate() {
		return _campaign.getEndDate();
	}

	/**
	* Sets the end date of this campaign.
	*
	* @param endDate the end date of this campaign
	*/
	public void setEndDate(java.util.Date endDate) {
		_campaign.setEndDate(endDate);
	}

	/**
	* Returns the campaign status of this campaign.
	*
	* @return the campaign status of this campaign
	*/
	public int getCampaignStatus() {
		return _campaign.getCampaignStatus();
	}

	/**
	* Sets the campaign status of this campaign.
	*
	* @param campaignStatus the campaign status of this campaign
	*/
	public void setCampaignStatus(int campaignStatus) {
		_campaign.setCampaignStatus(campaignStatus);
	}

	public boolean isNew() {
		return _campaign.isNew();
	}

	public void setNew(boolean n) {
		_campaign.setNew(n);
	}

	public boolean isCachedModel() {
		return _campaign.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_campaign.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _campaign.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _campaign.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_campaign.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _campaign.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_campaign.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CampaignWrapper((Campaign)_campaign.clone());
	}

	public int compareTo(
		org.lsp.liferay.portlet.advertising.model.Campaign campaign) {
		return _campaign.compareTo(campaign);
	}

	@Override
	public int hashCode() {
		return _campaign.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.lsp.liferay.portlet.advertising.model.Campaign> toCacheModel() {
		return _campaign.toCacheModel();
	}

	public org.lsp.liferay.portlet.advertising.model.Campaign toEscapedModel() {
		return new CampaignWrapper(_campaign.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _campaign.toString();
	}

	public java.lang.String toXmlString() {
		return _campaign.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaign.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Campaign getWrappedCampaign() {
		return _campaign;
	}

	public Campaign getWrappedModel() {
		return _campaign;
	}

	public void resetOriginalValues() {
		_campaign.resetOriginalValues();
	}

	private Campaign _campaign;
}