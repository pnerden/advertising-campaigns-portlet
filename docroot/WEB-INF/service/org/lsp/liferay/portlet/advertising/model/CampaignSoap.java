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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.lsp.liferay.portlet.advertising.service.http.CampaignServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       org.lsp.liferay.portlet.advertising.service.http.CampaignServiceSoap
 * @generated
 */
public class CampaignSoap implements Serializable {
	public static CampaignSoap toSoapModel(Campaign model) {
		CampaignSoap soapModel = new CampaignSoap();

		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCampaignId(model.getCampaignId());
		soapModel.setJournalArticlePrimaryKey(model.getJournalArticlePrimaryKey());
		soapModel.setBeginDate(model.getBeginDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setCampaignStatus(model.getCampaignStatus());

		return soapModel;
	}

	public static CampaignSoap[] toSoapModels(Campaign[] models) {
		CampaignSoap[] soapModels = new CampaignSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CampaignSoap[][] toSoapModels(Campaign[][] models) {
		CampaignSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CampaignSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CampaignSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CampaignSoap[] toSoapModels(List<Campaign> models) {
		List<CampaignSoap> soapModels = new ArrayList<CampaignSoap>(models.size());

		for (Campaign model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CampaignSoap[soapModels.size()]);
	}

	public CampaignSoap() {
	}

	public long getPrimaryKey() {
		return _campaignId;
	}

	public void setPrimaryKey(long pk) {
		setCampaignId(pk);
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

	private long _companyId;
	private long _campaignId;
	private long _journalArticlePrimaryKey;
	private Date _beginDate;
	private Date _endDate;
	private int _campaignStatus;
}