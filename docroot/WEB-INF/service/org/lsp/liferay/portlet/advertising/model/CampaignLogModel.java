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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the CampaignLog service. Represents a row in the &quot;LSPAC_CampaignLog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.lsp.liferay.portlet.advertising.model.impl.CampaignLogModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.lsp.liferay.portlet.advertising.model.impl.CampaignLogImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignLog
 * @see org.lsp.liferay.portlet.advertising.model.impl.CampaignLogImpl
 * @see org.lsp.liferay.portlet.advertising.model.impl.CampaignLogModelImpl
 * @generated
 */
public interface CampaignLogModel extends BaseModel<CampaignLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a campaign log model instance should use the {@link CampaignLog} interface instead.
	 */

	/**
	 * Returns the primary key of this campaign log.
	 *
	 * @return the primary key of this campaign log
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this campaign log.
	 *
	 * @param primaryKey the primary key of this campaign log
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the campaign log ID of this campaign log.
	 *
	 * @return the campaign log ID of this campaign log
	 */
	public long getCampaignLogId();

	/**
	 * Sets the campaign log ID of this campaign log.
	 *
	 * @param campaignLogId the campaign log ID of this campaign log
	 */
	public void setCampaignLogId(long campaignLogId);

	/**
	 * Returns the company ID of this campaign log.
	 *
	 * @return the company ID of this campaign log
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this campaign log.
	 *
	 * @param companyId the company ID of this campaign log
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the campaign ID of this campaign log.
	 *
	 * @return the campaign ID of this campaign log
	 */
	public long getCampaignId();

	/**
	 * Sets the campaign ID of this campaign log.
	 *
	 * @param campaignId the campaign ID of this campaign log
	 */
	public void setCampaignId(long campaignId);

	/**
	 * Returns the user ID of this campaign log.
	 *
	 * @return the user ID of this campaign log
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this campaign log.
	 *
	 * @param userId the user ID of this campaign log
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this campaign log.
	 *
	 * @return the user uuid of this campaign log
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this campaign log.
	 *
	 * @param userUuid the user uuid of this campaign log
	 */
	public void setUserUuid(String userUuid);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(CampaignLog campaignLog);

	public int hashCode();

	public CacheModel<CampaignLog> toCacheModel();

	public CampaignLog toEscapedModel();

	public String toString();

	public String toXmlString();
}