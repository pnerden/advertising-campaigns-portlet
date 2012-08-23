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

import org.lsp.liferay.portlet.advertising.model.CampaignLog;

import java.util.List;

/**
 * The persistence utility for the campaign log service. This utility wraps {@link CampaignLogPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignLogPersistence
 * @see CampaignLogPersistenceImpl
 * @generated
 */
public class CampaignLogUtil {
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
	public static void clearCache(CampaignLog campaignLog) {
		getPersistence().clearCache(campaignLog);
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
	public static List<CampaignLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CampaignLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CampaignLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CampaignLog update(CampaignLog campaignLog, boolean merge)
		throws SystemException {
		return getPersistence().update(campaignLog, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CampaignLog update(CampaignLog campaignLog, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(campaignLog, merge, serviceContext);
	}

	/**
	* Caches the campaign log in the entity cache if it is enabled.
	*
	* @param campaignLog the campaign log
	*/
	public static void cacheResult(
		org.lsp.liferay.portlet.advertising.model.CampaignLog campaignLog) {
		getPersistence().cacheResult(campaignLog);
	}

	/**
	* Caches the campaign logs in the entity cache if it is enabled.
	*
	* @param campaignLogs the campaign logs
	*/
	public static void cacheResult(
		java.util.List<org.lsp.liferay.portlet.advertising.model.CampaignLog> campaignLogs) {
		getPersistence().cacheResult(campaignLogs);
	}

	/**
	* Creates a new campaign log with the primary key. Does not add the campaign log to the database.
	*
	* @param campaignLogId the primary key for the new campaign log
	* @return the new campaign log
	*/
	public static org.lsp.liferay.portlet.advertising.model.CampaignLog create(
		long campaignLogId) {
		return getPersistence().create(campaignLogId);
	}

	/**
	* Removes the campaign log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignLogId the primary key of the campaign log
	* @return the campaign log that was removed
	* @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException if a campaign log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.CampaignLog remove(
		long campaignLogId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException {
		return getPersistence().remove(campaignLogId);
	}

	public static org.lsp.liferay.portlet.advertising.model.CampaignLog updateImpl(
		org.lsp.liferay.portlet.advertising.model.CampaignLog campaignLog,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(campaignLog, merge);
	}

	/**
	* Returns the campaign log with the primary key or throws a {@link org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException} if it could not be found.
	*
	* @param campaignLogId the primary key of the campaign log
	* @return the campaign log
	* @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException if a campaign log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.CampaignLog findByPrimaryKey(
		long campaignLogId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException {
		return getPersistence().findByPrimaryKey(campaignLogId);
	}

	/**
	* Returns the campaign log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param campaignLogId the primary key of the campaign log
	* @return the campaign log, or <code>null</code> if a campaign log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.CampaignLog fetchByPrimaryKey(
		long campaignLogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(campaignLogId);
	}

	/**
	* Returns the campaign log where campaignLogId = &#63; and companyId = &#63; or throws a {@link org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException} if it could not be found.
	*
	* @param campaignLogId the campaign log ID
	* @param companyId the company ID
	* @return the matching campaign log
	* @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException if a matching campaign log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.CampaignLog findByCampaignLogId(
		long campaignLogId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException {
		return getPersistence().findByCampaignLogId(campaignLogId, companyId);
	}

	/**
	* Returns the campaign log where campaignLogId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param campaignLogId the campaign log ID
	* @param companyId the company ID
	* @return the matching campaign log, or <code>null</code> if a matching campaign log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.CampaignLog fetchByCampaignLogId(
		long campaignLogId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCampaignLogId(campaignLogId, companyId);
	}

	/**
	* Returns the campaign log where campaignLogId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param campaignLogId the campaign log ID
	* @param companyId the company ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching campaign log, or <code>null</code> if a matching campaign log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.CampaignLog fetchByCampaignLogId(
		long campaignLogId, long companyId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignLogId(campaignLogId, companyId,
			retrieveFromCache);
	}

	/**
	* Returns all the campaign logs where campaignId = &#63; and companyId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param companyId the company ID
	* @return the matching campaign logs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.advertising.model.CampaignLog> findByCampaignId(
		long campaignId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCampaignId(campaignId, companyId);
	}

	/**
	* Returns a range of all the campaign logs where campaignId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param companyId the company ID
	* @param start the lower bound of the range of campaign logs
	* @param end the upper bound of the range of campaign logs (not inclusive)
	* @return the range of matching campaign logs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.advertising.model.CampaignLog> findByCampaignId(
		long campaignId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignId(campaignId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the campaign logs where campaignId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param companyId the company ID
	* @param start the lower bound of the range of campaign logs
	* @param end the upper bound of the range of campaign logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaign logs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.advertising.model.CampaignLog> findByCampaignId(
		long campaignId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignId(campaignId, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first campaign log in the ordered set where campaignId = &#63; and companyId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign log
	* @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException if a matching campaign log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.CampaignLog findByCampaignId_First(
		long campaignId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException {
		return getPersistence()
				   .findByCampaignId_First(campaignId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first campaign log in the ordered set where campaignId = &#63; and companyId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign log, or <code>null</code> if a matching campaign log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.CampaignLog fetchByCampaignId_First(
		long campaignId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignId_First(campaignId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last campaign log in the ordered set where campaignId = &#63; and companyId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign log
	* @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException if a matching campaign log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.CampaignLog findByCampaignId_Last(
		long campaignId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException {
		return getPersistence()
				   .findByCampaignId_Last(campaignId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last campaign log in the ordered set where campaignId = &#63; and companyId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign log, or <code>null</code> if a matching campaign log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.CampaignLog fetchByCampaignId_Last(
		long campaignId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignId_Last(campaignId, companyId,
			orderByComparator);
	}

	/**
	* Returns the campaign logs before and after the current campaign log in the ordered set where campaignId = &#63; and companyId = &#63;.
	*
	* @param campaignLogId the primary key of the current campaign log
	* @param campaignId the campaign ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign log
	* @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException if a campaign log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.CampaignLog[] findByCampaignId_PrevAndNext(
		long campaignLogId, long campaignId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException {
		return getPersistence()
				   .findByCampaignId_PrevAndNext(campaignLogId, campaignId,
			companyId, orderByComparator);
	}

	/**
	* Returns the campaign log where campaignId = &#63; and companyId = &#63; and userId = &#63; or throws a {@link org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException} if it could not be found.
	*
	* @param campaignId the campaign ID
	* @param companyId the company ID
	* @param userId the user ID
	* @return the matching campaign log
	* @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException if a matching campaign log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.CampaignLog findByLogFinder(
		long campaignId, long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException {
		return getPersistence().findByLogFinder(campaignId, companyId, userId);
	}

	/**
	* Returns the campaign log where campaignId = &#63; and companyId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param campaignId the campaign ID
	* @param companyId the company ID
	* @param userId the user ID
	* @return the matching campaign log, or <code>null</code> if a matching campaign log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.CampaignLog fetchByLogFinder(
		long campaignId, long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLogFinder(campaignId, companyId, userId);
	}

	/**
	* Returns the campaign log where campaignId = &#63; and companyId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param campaignId the campaign ID
	* @param companyId the company ID
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching campaign log, or <code>null</code> if a matching campaign log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.CampaignLog fetchByLogFinder(
		long campaignId, long companyId, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLogFinder(campaignId, companyId, userId,
			retrieveFromCache);
	}

	/**
	* Returns all the campaign logs.
	*
	* @return the campaign logs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.advertising.model.CampaignLog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the campaign logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of campaign logs
	* @param end the upper bound of the range of campaign logs (not inclusive)
	* @return the range of campaign logs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.advertising.model.CampaignLog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the campaign logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of campaign logs
	* @param end the upper bound of the range of campaign logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of campaign logs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.lsp.liferay.portlet.advertising.model.CampaignLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the campaign log where campaignLogId = &#63; and companyId = &#63; from the database.
	*
	* @param campaignLogId the campaign log ID
	* @param companyId the company ID
	* @return the campaign log that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.CampaignLog removeByCampaignLogId(
		long campaignLogId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException {
		return getPersistence().removeByCampaignLogId(campaignLogId, companyId);
	}

	/**
	* Removes all the campaign logs where campaignId = &#63; and companyId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignId(long campaignId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCampaignId(campaignId, companyId);
	}

	/**
	* Removes the campaign log where campaignId = &#63; and companyId = &#63; and userId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @param companyId the company ID
	* @param userId the user ID
	* @return the campaign log that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.lsp.liferay.portlet.advertising.model.CampaignLog removeByLogFinder(
		long campaignId, long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException {
		return getPersistence().removeByLogFinder(campaignId, companyId, userId);
	}

	/**
	* Removes all the campaign logs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of campaign logs where campaignLogId = &#63; and companyId = &#63;.
	*
	* @param campaignLogId the campaign log ID
	* @param companyId the company ID
	* @return the number of matching campaign logs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignLogId(long campaignLogId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCampaignLogId(campaignLogId, companyId);
	}

	/**
	* Returns the number of campaign logs where campaignId = &#63; and companyId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param companyId the company ID
	* @return the number of matching campaign logs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignId(long campaignId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCampaignId(campaignId, companyId);
	}

	/**
	* Returns the number of campaign logs where campaignId = &#63; and companyId = &#63; and userId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param companyId the company ID
	* @param userId the user ID
	* @return the number of matching campaign logs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLogFinder(long campaignId, long companyId,
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLogFinder(campaignId, companyId, userId);
	}

	/**
	* Returns the number of campaign logs.
	*
	* @return the number of campaign logs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CampaignLogPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CampaignLogPersistence)PortletBeanLocatorUtil.locate(org.lsp.liferay.portlet.advertising.service.ClpSerializer.getServletContextName(),
					CampaignLogPersistence.class.getName());

			ReferenceRegistry.registerReference(CampaignLogUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(CampaignLogPersistence persistence) {
	}

	private static CampaignLogPersistence _persistence;
}