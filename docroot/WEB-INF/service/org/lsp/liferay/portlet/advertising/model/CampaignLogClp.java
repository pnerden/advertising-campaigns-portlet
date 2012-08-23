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
import com.liferay.portal.util.PortalUtil;

import org.lsp.liferay.portlet.advertising.service.CampaignLogLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class CampaignLogClp extends BaseModelImpl<CampaignLog>
	implements CampaignLog {
	public CampaignLogClp() {
	}

	public Class<?> getModelClass() {
		return CampaignLog.class;
	}

	public String getModelClassName() {
		return CampaignLog.class.getName();
	}

	public long getPrimaryKey() {
		return _campaignLogId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCampaignLogId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_campaignLogId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("campaignLogId", getCampaignLogId());
		attributes.put("companyId", getCompanyId());
		attributes.put("campaignId", getCampaignId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
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

	public long getCampaignLogId() {
		return _campaignLogId;
	}

	public void setCampaignLogId(long campaignLogId) {
		_campaignLogId = campaignLogId;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public BaseModel<?> getCampaignLogRemoteModel() {
		return _campaignLogRemoteModel;
	}

	public void setCampaignLogRemoteModel(BaseModel<?> campaignLogRemoteModel) {
		_campaignLogRemoteModel = campaignLogRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CampaignLogLocalServiceUtil.addCampaignLog(this);
		}
		else {
			CampaignLogLocalServiceUtil.updateCampaignLog(this);
		}
	}

	@Override
	public CampaignLog toEscapedModel() {
		return (CampaignLog)Proxy.newProxyInstance(CampaignLog.class.getClassLoader(),
			new Class[] { CampaignLog.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CampaignLogClp clone = new CampaignLogClp();

		clone.setCampaignLogId(getCampaignLogId());
		clone.setCompanyId(getCompanyId());
		clone.setCampaignId(getCampaignId());
		clone.setUserId(getUserId());

		return clone;
	}

	public int compareTo(CampaignLog campaignLog) {
		long primaryKey = campaignLog.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CampaignLogClp campaignLog = null;

		try {
			campaignLog = (CampaignLogClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = campaignLog.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{campaignLogId=");
		sb.append(getCampaignLogId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", campaignId=");
		sb.append(getCampaignId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("org.lsp.liferay.portlet.advertising.model.CampaignLog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>campaignLogId</column-name><column-value><![CDATA[");
		sb.append(getCampaignLogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignId</column-name><column-value><![CDATA[");
		sb.append(getCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _campaignLogId;
	private long _companyId;
	private long _campaignId;
	private long _userId;
	private String _userUuid;
	private BaseModel<?> _campaignLogRemoteModel;
}