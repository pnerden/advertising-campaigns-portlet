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

import org.lsp.liferay.portlet.advertising.model.CampaignLog;

import java.io.Serializable;

/**
 * The cache model class for representing CampaignLog in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignLog
 * @generated
 */
public class CampaignLogCacheModel implements CacheModel<CampaignLog>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{campaignLogId=");
		sb.append(campaignLogId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", campaignId=");
		sb.append(campaignId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	public CampaignLog toEntityModel() {
		CampaignLogImpl campaignLogImpl = new CampaignLogImpl();

		campaignLogImpl.setCampaignLogId(campaignLogId);
		campaignLogImpl.setCompanyId(companyId);
		campaignLogImpl.setCampaignId(campaignId);
		campaignLogImpl.setUserId(userId);

		campaignLogImpl.resetOriginalValues();

		return campaignLogImpl;
	}

	public long campaignLogId;
	public long companyId;
	public long campaignId;
	public long userId;
}