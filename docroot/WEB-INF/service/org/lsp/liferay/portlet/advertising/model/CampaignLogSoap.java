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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.lsp.liferay.portlet.advertising.service.http.CampaignLogServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       org.lsp.liferay.portlet.advertising.service.http.CampaignLogServiceSoap
 * @generated
 */
public class CampaignLogSoap implements Serializable {
	public static CampaignLogSoap toSoapModel(CampaignLog model) {
		CampaignLogSoap soapModel = new CampaignLogSoap();

		soapModel.setCampaignLogId(model.getCampaignLogId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCampaignId(model.getCampaignId());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static CampaignLogSoap[] toSoapModels(CampaignLog[] models) {
		CampaignLogSoap[] soapModels = new CampaignLogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CampaignLogSoap[][] toSoapModels(CampaignLog[][] models) {
		CampaignLogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CampaignLogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CampaignLogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CampaignLogSoap[] toSoapModels(List<CampaignLog> models) {
		List<CampaignLogSoap> soapModels = new ArrayList<CampaignLogSoap>(models.size());

		for (CampaignLog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CampaignLogSoap[soapModels.size()]);
	}

	public CampaignLogSoap() {
	}

	public long getPrimaryKey() {
		return _campaignLogId;
	}

	public void setPrimaryKey(long pk) {
		setCampaignLogId(pk);
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

	private long _campaignLogId;
	private long _companyId;
	private long _campaignId;
	private long _userId;
}