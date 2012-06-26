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

package org.lsp.liferay.portlet.advertising.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.lsp.liferay.portlet.advertising.model.Campaign;

import java.util.List;

/**
 * The persistence utility for the campaign service. This utility wraps {@link CampaignPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignPersistence
 * @see CampaignPersistenceImpl
 * @generated
 */
public class CampaignUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Campaign campaign) {
		getPersistence().clearCache(campaign);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Campaign> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Campaign> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Campaign> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Campaign update(Campaign campaign, boolean merge)
		throws SystemException {
		return getPersistence().update(campaign, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Campaign update(Campaign campaign, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(campaign, merge, serviceContext);
	}

	/**
	* Caches the campaign in the entity cache if it is enabled.
	*
	* @param campaign the campaign
	*/
	public static void cacheResult(
		org.lsp.liferay.portlet.advertising.model.Campaign campaign) {
		getPersistence().cacheResult(campaign);
	}

	/**
	* Caches the campaigns in the entity cache if it is enabled.
	*
	* @param campaigns the campaigns
	*/
	public static void cacheResult(
		java.util.List<org.lsp.liferay.portlet.advertising.model.Campaign> campaigns) {
		getPersistence().cacheResult(campaigns);
	}

	/**
	* Creates a new campaign with the primary key. Does not add the campaign to the database.
	*
	* @param campaignId the primary key for the new campaign
	* @return the new campaign
	*/
	public static org.lsp.liferay.portlet.advertising.model.Campaign create(
		long campaignId) {
		return getPersistence().create(campaignId);
	}

	/**
	* Removes the campaign with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign that was removed
	* @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.Campaign remove(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.advertising.NoSuchCampaignException {
		return getPersistence().remove(campaignId);
	}

	public static org.lsp.liferay.portlet.advertising.model.Campaign updateImpl(
		org.lsp.liferay.portlet.advertising.model.Campaign campaign,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(campaign, merge);
	}

	/**
	* Returns the campaign with the primary key or throws a {@link org.lsp.liferay.portlet.advertising.NoSuchCampaignException} if it could not be found.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign
	* @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.Campaign findByPrimaryKey(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.advertising.NoSuchCampaignException {
		return getPersistence().findByPrimaryKey(campaignId);
	}

	/**
	* Returns the campaign with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param campaignId the primary key of the campaign
	* @return the campaign, or <code>null</code> if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.Campaign fetchByPrimaryKey(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(campaignId);
	}

	/**
	* Returns the campaign where campaignId = &#63; and companyId = &#63; or throws a {@link org.lsp.liferay.portlet.advertising.NoSuchCampaignException} if it could not be found.
	*
	* @param campaignId the campaign ID
	* @param companyId the company ID
	* @return the matching campaign
	* @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignException if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.Campaign findByCampaignId(
		long campaignId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.advertising.NoSuchCampaignException {
		return getPersistence().findByCampaignId(campaignId, companyId);
	}

	/**
	* Returns the campaign where campaignId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param campaignId the campaign ID
	* @param companyId the company ID
	* @return the matching campaign, or <code>null</code> if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.Campaign fetchByCampaignId(
		long campaignId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCampaignId(campaignId, companyId);
	}

	/**
	* Returns the campaign where campaignId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param campaignId the campaign ID
	* @param companyId the company ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching campaign, or <code>null</code> if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.Campaign fetchByCampaignId(
		long campaignId, long companyId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignId(campaignId, companyId, retrieveFromCache);
	}

	/**
	* Returns all the campaigns where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.advertising.model.Campaign> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the campaigns where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.advertising.model.Campaign> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the campaigns where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.advertising.model.Campaign> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first campaign in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign
	* @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignException if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.Campaign findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.advertising.NoSuchCampaignException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last campaign in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign
	* @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignException if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.Campaign findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.advertising.NoSuchCampaignException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the campaigns before and after the current campaign in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignId the primary key of the current campaign
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign
	* @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.Campaign[] findByCompanyId_PrevAndNext(
		long campaignId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.advertising.NoSuchCampaignException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(campaignId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the campaigns where companyId = &#63; and campaignStatus = &#63; and beginDate &le; &#63; and endDate &ge; &#63;.
	*
	* @param companyId the company ID
	* @param campaignStatus the campaign status
	* @param beginDate the begin date
	* @param endDate the end date
	* @return the matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.advertising.model.Campaign> findByActiveCampaignsByDate(
		long companyId, int campaignStatus, java.util.Date beginDate,
		java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActiveCampaignsByDate(companyId, campaignStatus,
			beginDate, endDate);
	}

	/**
	* Returns a range of all the campaigns where companyId = &#63; and campaignStatus = &#63; and beginDate &le; &#63; and endDate &ge; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param campaignStatus the campaign status
	* @param beginDate the begin date
	* @param endDate the end date
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.advertising.model.Campaign> findByActiveCampaignsByDate(
		long companyId, int campaignStatus, java.util.Date beginDate,
		java.util.Date endDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActiveCampaignsByDate(companyId, campaignStatus,
			beginDate, endDate, start, end);
	}

	/**
	* Returns an ordered range of all the campaigns where companyId = &#63; and campaignStatus = &#63; and beginDate &le; &#63; and endDate &ge; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param campaignStatus the campaign status
	* @param beginDate the begin date
	* @param endDate the end date
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.advertising.model.Campaign> findByActiveCampaignsByDate(
		long companyId, int campaignStatus, java.util.Date beginDate,
		java.util.Date endDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActiveCampaignsByDate(companyId, campaignStatus,
			beginDate, endDate, start, end, orderByComparator);
	}

	/**
	* Returns the first campaign in the ordered set where companyId = &#63; and campaignStatus = &#63; and beginDate &le; &#63; and endDate &ge; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param campaignStatus the campaign status
	* @param beginDate the begin date
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign
	* @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignException if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.Campaign findByActiveCampaignsByDate_First(
		long companyId, int campaignStatus, java.util.Date beginDate,
		java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.advertising.NoSuchCampaignException {
		return getPersistence()
				   .findByActiveCampaignsByDate_First(companyId,
			campaignStatus, beginDate, endDate, orderByComparator);
	}

	/**
	* Returns the last campaign in the ordered set where companyId = &#63; and campaignStatus = &#63; and beginDate &le; &#63; and endDate &ge; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param campaignStatus the campaign status
	* @param beginDate the begin date
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign
	* @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignException if a matching campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.Campaign findByActiveCampaignsByDate_Last(
		long companyId, int campaignStatus, java.util.Date beginDate,
		java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.advertising.NoSuchCampaignException {
		return getPersistence()
				   .findByActiveCampaignsByDate_Last(companyId, campaignStatus,
			beginDate, endDate, orderByComparator);
	}

	/**
	* Returns the campaigns before and after the current campaign in the ordered set where companyId = &#63; and campaignStatus = &#63; and beginDate &le; &#63; and endDate &ge; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignId the primary key of the current campaign
	* @param companyId the company ID
	* @param campaignStatus the campaign status
	* @param beginDate the begin date
	* @param endDate the end date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign
	* @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignException if a campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.Campaign[] findByActiveCampaignsByDate_PrevAndNext(
		long campaignId, long companyId, int campaignStatus,
		java.util.Date beginDate, java.util.Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.advertising.NoSuchCampaignException {
		return getPersistence()
				   .findByActiveCampaignsByDate_PrevAndNext(campaignId,
			companyId, campaignStatus, beginDate, endDate, orderByComparator);
	}

	/**
	* Returns all the campaigns where companyId = &#63; and campaignStatus = &#63; and beginDate &le; &#63; and endDate &ge; all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param campaignStatus the campaign status
	* @param beginDate the begin date
	* @param endDates the end dates
	* @return the matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.advertising.model.Campaign> findByActiveCampaignsByDate(
		long companyId, int campaignStatus, java.util.Date beginDate,
		java.util.Date[] endDates)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActiveCampaignsByDate(companyId, campaignStatus,
			beginDate, endDates);
	}

	/**
	* Returns a range of all the campaigns where companyId = &#63; and campaignStatus = &#63; and beginDate &le; &#63; and endDate &ge; all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param campaignStatus the campaign status
	* @param beginDate the begin date
	* @param endDates the end dates
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.advertising.model.Campaign> findByActiveCampaignsByDate(
		long companyId, int campaignStatus, java.util.Date beginDate,
		java.util.Date[] endDates, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActiveCampaignsByDate(companyId, campaignStatus,
			beginDate, endDates, start, end);
	}

	/**
	* Returns an ordered range of all the campaigns where companyId = &#63; and campaignStatus = &#63; and beginDate &le; &#63; and endDate &ge; all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param campaignStatus the campaign status
	* @param beginDate the begin date
	* @param endDates the end dates
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.advertising.model.Campaign> findByActiveCampaignsByDate(
		long companyId, int campaignStatus, java.util.Date beginDate,
		java.util.Date[] endDates, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActiveCampaignsByDate(companyId, campaignStatus,
			beginDate, endDates, start, end, orderByComparator);
	}

	/**
	* Returns all the campaigns.
	*
	* @return the campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.advertising.model.Campaign> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the campaigns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @return the range of campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.advertising.model.Campaign> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the campaigns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of campaigns
	* @param end the upper bound of the range of campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.advertising.model.Campaign> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the campaign where campaignId = &#63; and companyId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignId(long campaignId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.advertising.NoSuchCampaignException {
		getPersistence().removeByCampaignId(campaignId, companyId);
	}

	/**
	* Removes all the campaigns where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Removes all the campaigns where companyId = &#63; and campaignStatus = &#63; and beginDate &le; &#63; and endDate &ge; &#63; from the database.
	*
	* @param companyId the company ID
	* @param campaignStatus the campaign status
	* @param beginDate the begin date
	* @param endDate the end date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByActiveCampaignsByDate(long companyId,
		int campaignStatus, java.util.Date beginDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByActiveCampaignsByDate(companyId, campaignStatus,
			beginDate, endDate);
	}

	/**
	* Removes all the campaigns from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of campaigns where campaignId = &#63; and companyId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param companyId the company ID
	* @return the number of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignId(long campaignId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCampaignId(campaignId, companyId);
	}

	/**
	* Returns the number of campaigns where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns the number of campaigns where companyId = &#63; and campaignStatus = &#63; and beginDate &le; &#63; and endDate &ge; &#63;.
	*
	* @param companyId the company ID
	* @param campaignStatus the campaign status
	* @param beginDate the begin date
	* @param endDate the end date
	* @return the number of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByActiveCampaignsByDate(long companyId,
		int campaignStatus, java.util.Date beginDate, java.util.Date endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByActiveCampaignsByDate(companyId, campaignStatus,
			beginDate, endDate);
	}

	/**
	* Returns the number of campaigns where companyId = &#63; and campaignStatus = &#63; and beginDate &le; &#63; and endDate &ge; all &#63;.
	*
	* @param companyId the company ID
	* @param campaignStatus the campaign status
	* @param beginDate the begin date
	* @param endDates the end dates
	* @return the number of matching campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countByActiveCampaignsByDate(long companyId,
		int campaignStatus, java.util.Date beginDate, java.util.Date[] endDates)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByActiveCampaignsByDate(companyId, campaignStatus,
			beginDate, endDates);
	}

	/**
	* Returns the number of campaigns.
	*
	* @return the number of campaigns
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CampaignPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CampaignPersistence)PortletBeanLocatorUtil.locate(org.lsp.liferay.portlet.advertising.service.ClpSerializer.getServletContextName(),
					CampaignPersistence.class.getName());

			ReferenceRegistry.registerReference(CampaignUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(CampaignPersistence persistence) {
	}

	private static CampaignPersistence _persistence;
}