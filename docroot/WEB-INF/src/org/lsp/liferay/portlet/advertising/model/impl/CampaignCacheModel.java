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

package org.lsp.liferay.portlet.advertising.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import org.lsp.liferay.portlet.advertising.model.Campaign;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Campaign in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Campaign
 * @generated
 */
public class CampaignCacheModel implements CacheModel<Campaign>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{companyId=");
		sb.append(companyId);
		sb.append(", campaignId=");
		sb.append(campaignId);
		sb.append(", journalArticlePrimaryKey=");
		sb.append(journalArticlePrimaryKey);
		sb.append(", beginDate=");
		sb.append(beginDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", campaignStatus=");
		sb.append(campaignStatus);
		sb.append("}");

		return sb.toString();
	}

	public Campaign toEntityModel() {
		CampaignImpl campaignImpl = new CampaignImpl();

		campaignImpl.setCompanyId(companyId);
		campaignImpl.setCampaignId(campaignId);
		campaignImpl.setJournalArticlePrimaryKey(journalArticlePrimaryKey);

		if (beginDate == Long.MIN_VALUE) {
			campaignImpl.setBeginDate(null);
		}
		else {
			campaignImpl.setBeginDate(new Date(beginDate));
		}

		if (endDate == Long.MIN_VALUE) {
			campaignImpl.setEndDate(null);
		}
		else {
			campaignImpl.setEndDate(new Date(endDate));
		}

		campaignImpl.setCampaignStatus(campaignStatus);

		campaignImpl.resetOriginalValues();

		return campaignImpl;
	}

	public long companyId;
	public long campaignId;
	public long journalArticlePrimaryKey;
	public long beginDate;
	public long endDate;
	public int campaignStatus;
}