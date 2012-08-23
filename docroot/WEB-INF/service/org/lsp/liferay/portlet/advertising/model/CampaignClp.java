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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.lsp.liferay.portlet.advertising.service.CampaignLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class CampaignClp extends BaseModelImpl<Campaign> implements Campaign {
	public CampaignClp() {
	}

	public Class<?> getModelClass() {
		return Campaign.class;
	}

	public String getModelClassName() {
		return Campaign.class.getName();
	}

	public long getPrimaryKey() {
		return _campaignId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCampaignId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_campaignId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getCampaignId() {
		return _campaignId;
	}

	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;
	}

	public long getJournalArticlePrimaryKey() {
		return _journalArticlePrimaryKey;
	}

	public void setJournalArticlePrimaryKey(long journalArticlePrimaryKey) {
		_journalArticlePrimaryKey = journalArticlePrimaryKey;
	}

	public Date getBeginDate() {
		return _beginDate;
	}

	public void setBeginDate(Date beginDate) {
		_beginDate = beginDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public int getCampaignStatus() {
		return _campaignStatus;
	}

	public void setCampaignStatus(int campaignStatus) {
		_campaignStatus = campaignStatus;
	}

	public BaseModel<?> getCampaignRemoteModel() {
		return _campaignRemoteModel;
	}

	public void setCampaignRemoteModel(BaseModel<?> campaignRemoteModel) {
		_campaignRemoteModel = campaignRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CampaignLocalServiceUtil.addCampaign(this);
		}
		else {
			CampaignLocalServiceUtil.updateCampaign(this);
		}
	}

	@Override
	public Campaign toEscapedModel() {
		return (Campaign)Proxy.newProxyInstance(Campaign.class.getClassLoader(),
			new Class[] { Campaign.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CampaignClp clone = new CampaignClp();

		clone.setCompanyId(getCompanyId());
		clone.setCampaignId(getCampaignId());
		clone.setJournalArticlePrimaryKey(getJournalArticlePrimaryKey());
		clone.setBeginDate(getBeginDate());
		clone.setEndDate(getEndDate());
		clone.setCampaignStatus(getCampaignStatus());

		return clone;
	}

	public int compareTo(Campaign campaign) {
		int value = 0;

		if (getCampaignId() < campaign.getCampaignId()) {
			value = -1;
		}
		else if (getCampaignId() > campaign.getCampaignId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CampaignClp campaign = null;

		try {
			campaign = (CampaignClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = campaign.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{companyId=");
		sb.append(getCompanyId());
		sb.append(", campaignId=");
		sb.append(getCampaignId());
		sb.append(", journalArticlePrimaryKey=");
		sb.append(getJournalArticlePrimaryKey());
		sb.append(", beginDate=");
		sb.append(getBeginDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", campaignStatus=");
		sb.append(getCampaignStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("org.lsp.liferay.portlet.advertising.model.Campaign");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignId</column-name><column-value><![CDATA[");
		sb.append(getCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>journalArticlePrimaryKey</column-name><column-value><![CDATA[");
		sb.append(getJournalArticlePrimaryKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>beginDate</column-name><column-value><![CDATA[");
		sb.append(getBeginDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignStatus</column-name><column-value><![CDATA[");
		sb.append(getCampaignStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _companyId;
	private long _campaignId;
	private long _journalArticlePrimaryKey;
	private Date _beginDate;
	private Date _endDate;
	private int _campaignStatus;
	private BaseModel<?> _campaignRemoteModel;
}