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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException;
import org.lsp.liferay.portlet.advertising.model.CampaignLog;
import org.lsp.liferay.portlet.advertising.model.impl.CampaignLogImpl;
import org.lsp.liferay.portlet.advertising.model.impl.CampaignLogModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the campaign log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignLogPersistence
 * @see CampaignLogUtil
 * @generated
 */
public class CampaignLogPersistenceImpl extends BasePersistenceImpl<CampaignLog>
	implements CampaignLogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CampaignLogUtil} to access the campaign log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CampaignLogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_CAMPAIGNLOGID = new FinderPath(CampaignLogModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLogModelImpl.FINDER_CACHE_ENABLED, CampaignLogImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCampaignLogId",
			new String[] { Long.class.getName(), Long.class.getName() },
			CampaignLogModelImpl.CAMPAIGNLOGID_COLUMN_BITMASK |
			CampaignLogModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNLOGID = new FinderPath(CampaignLogModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCampaignLogId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(CampaignLogModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLogModelImpl.FINDER_CACHE_ENABLED, CampaignLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCampaignId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(CampaignLogModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLogModelImpl.FINDER_CACHE_ENABLED, CampaignLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCampaignId",
			new String[] { Long.class.getName(), Long.class.getName() },
			CampaignLogModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			CampaignLogModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNID = new FinderPath(CampaignLogModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCampaignId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_LOGFINDER = new FinderPath(CampaignLogModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLogModelImpl.FINDER_CACHE_ENABLED, CampaignLogImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByLogFinder",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			CampaignLogModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			CampaignLogModelImpl.COMPANYID_COLUMN_BITMASK |
			CampaignLogModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOGFINDER = new FinderPath(CampaignLogModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLogFinder",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CampaignLogModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLogModelImpl.FINDER_CACHE_ENABLED, CampaignLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CampaignLogModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLogModelImpl.FINDER_CACHE_ENABLED, CampaignLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CampaignLogModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the campaign log in the entity cache if it is enabled.
	 *
	 * @param campaignLog the campaign log
	 */
	public void cacheResult(CampaignLog campaignLog) {
		EntityCacheUtil.putResult(CampaignLogModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLogImpl.class, campaignLog.getPrimaryKey(), campaignLog);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNLOGID,
			new Object[] {
				Long.valueOf(campaignLog.getCampaignLogId()),
				Long.valueOf(campaignLog.getCompanyId())
			}, campaignLog);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOGFINDER,
			new Object[] {
				Long.valueOf(campaignLog.getCampaignId()),
				Long.valueOf(campaignLog.getCompanyId()),
				Long.valueOf(campaignLog.getUserId())
			}, campaignLog);

		campaignLog.resetOriginalValues();
	}

	/**
	 * Caches the campaign logs in the entity cache if it is enabled.
	 *
	 * @param campaignLogs the campaign logs
	 */
	public void cacheResult(List<CampaignLog> campaignLogs) {
		for (CampaignLog campaignLog : campaignLogs) {
			if (EntityCacheUtil.getResult(
						CampaignLogModelImpl.ENTITY_CACHE_ENABLED,
						CampaignLogImpl.class, campaignLog.getPrimaryKey()) == null) {
				cacheResult(campaignLog);
			}
			else {
				campaignLog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all campaign logs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CampaignLogImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CampaignLogImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the campaign log.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CampaignLog campaignLog) {
		EntityCacheUtil.removeResult(CampaignLogModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLogImpl.class, campaignLog.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(campaignLog);
	}

	@Override
	public void clearCache(List<CampaignLog> campaignLogs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CampaignLog campaignLog : campaignLogs) {
			EntityCacheUtil.removeResult(CampaignLogModelImpl.ENTITY_CACHE_ENABLED,
				CampaignLogImpl.class, campaignLog.getPrimaryKey());

			clearUniqueFindersCache(campaignLog);
		}
	}

	protected void clearUniqueFindersCache(CampaignLog campaignLog) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CAMPAIGNLOGID,
			new Object[] {
				Long.valueOf(campaignLog.getCampaignLogId()),
				Long.valueOf(campaignLog.getCompanyId())
			});

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LOGFINDER,
			new Object[] {
				Long.valueOf(campaignLog.getCampaignId()),
				Long.valueOf(campaignLog.getCompanyId()),
				Long.valueOf(campaignLog.getUserId())
			});
	}

	/**
	 * Creates a new campaign log with the primary key. Does not add the campaign log to the database.
	 *
	 * @param campaignLogId the primary key for the new campaign log
	 * @return the new campaign log
	 */
	public CampaignLog create(long campaignLogId) {
		CampaignLog campaignLog = new CampaignLogImpl();

		campaignLog.setNew(true);
		campaignLog.setPrimaryKey(campaignLogId);

		return campaignLog;
	}

	/**
	 * Removes the campaign log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param campaignLogId the primary key of the campaign log
	 * @return the campaign log that was removed
	 * @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException if a campaign log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CampaignLog remove(long campaignLogId)
		throws NoSuchCampaignLogException, SystemException {
		return remove(Long.valueOf(campaignLogId));
	}

	/**
	 * Removes the campaign log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the campaign log
	 * @return the campaign log that was removed
	 * @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException if a campaign log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignLog remove(Serializable primaryKey)
		throws NoSuchCampaignLogException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CampaignLog campaignLog = (CampaignLog)session.get(CampaignLogImpl.class,
					primaryKey);

			if (campaignLog == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCampaignLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(campaignLog);
		}
		catch (NoSuchCampaignLogException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CampaignLog removeImpl(CampaignLog campaignLog)
		throws SystemException {
		campaignLog = toUnwrappedModel(campaignLog);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, campaignLog);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(campaignLog);

		return campaignLog;
	}

	@Override
	public CampaignLog updateImpl(
		org.lsp.liferay.portlet.advertising.model.CampaignLog campaignLog,
		boolean merge) throws SystemException {
		campaignLog = toUnwrappedModel(campaignLog);

		boolean isNew = campaignLog.isNew();

		CampaignLogModelImpl campaignLogModelImpl = (CampaignLogModelImpl)campaignLog;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, campaignLog, merge);

			campaignLog.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CampaignLogModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else {
			if ((campaignLogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(campaignLogModelImpl.getOriginalCampaignId()),
						Long.valueOf(campaignLogModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);

				args = new Object[] {
						Long.valueOf(campaignLogModelImpl.getCampaignId()),
						Long.valueOf(campaignLogModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);
			}
		}

		EntityCacheUtil.putResult(CampaignLogModelImpl.ENTITY_CACHE_ENABLED,
			CampaignLogImpl.class, campaignLog.getPrimaryKey(), campaignLog);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNLOGID,
				new Object[] {
					Long.valueOf(campaignLog.getCampaignLogId()),
					Long.valueOf(campaignLog.getCompanyId())
				}, campaignLog);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOGFINDER,
				new Object[] {
					Long.valueOf(campaignLog.getCampaignId()),
					Long.valueOf(campaignLog.getCompanyId()),
					Long.valueOf(campaignLog.getUserId())
				}, campaignLog);
		}
		else {
			if ((campaignLogModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CAMPAIGNLOGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(campaignLogModelImpl.getOriginalCampaignLogId()),
						Long.valueOf(campaignLogModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNLOGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CAMPAIGNLOGID,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNLOGID,
					new Object[] {
						Long.valueOf(campaignLog.getCampaignLogId()),
						Long.valueOf(campaignLog.getCompanyId())
					}, campaignLog);
			}

			if ((campaignLogModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LOGFINDER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(campaignLogModelImpl.getOriginalCampaignId()),
						Long.valueOf(campaignLogModelImpl.getOriginalCompanyId()),
						Long.valueOf(campaignLogModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOGFINDER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LOGFINDER,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOGFINDER,
					new Object[] {
						Long.valueOf(campaignLog.getCampaignId()),
						Long.valueOf(campaignLog.getCompanyId()),
						Long.valueOf(campaignLog.getUserId())
					}, campaignLog);
			}
		}

		return campaignLog;
	}

	protected CampaignLog toUnwrappedModel(CampaignLog campaignLog) {
		if (campaignLog instanceof CampaignLogImpl) {
			return campaignLog;
		}

		CampaignLogImpl campaignLogImpl = new CampaignLogImpl();

		campaignLogImpl.setNew(campaignLog.isNew());
		campaignLogImpl.setPrimaryKey(campaignLog.getPrimaryKey());

		campaignLogImpl.setCampaignLogId(campaignLog.getCampaignLogId());
		campaignLogImpl.setCompanyId(campaignLog.getCompanyId());
		campaignLogImpl.setCampaignId(campaignLog.getCampaignId());
		campaignLogImpl.setUserId(campaignLog.getUserId());

		return campaignLogImpl;
	}

	/**
	 * Returns the campaign log with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign log
	 * @return the campaign log
	 * @throws com.liferay.portal.NoSuchModelException if a campaign log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the campaign log with the primary key or throws a {@link org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException} if it could not be found.
	 *
	 * @param campaignLogId the primary key of the campaign log
	 * @return the campaign log
	 * @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException if a campaign log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CampaignLog findByPrimaryKey(long campaignLogId)
		throws NoSuchCampaignLogException, SystemException {
		CampaignLog campaignLog = fetchByPrimaryKey(campaignLogId);

		if (campaignLog == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + campaignLogId);
			}

			throw new NoSuchCampaignLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				campaignLogId);
		}

		return campaignLog;
	}

	/**
	 * Returns the campaign log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign log
	 * @return the campaign log, or <code>null</code> if a campaign log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignLog fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the campaign log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param campaignLogId the primary key of the campaign log
	 * @return the campaign log, or <code>null</code> if a campaign log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CampaignLog fetchByPrimaryKey(long campaignLogId)
		throws SystemException {
		CampaignLog campaignLog = (CampaignLog)EntityCacheUtil.getResult(CampaignLogModelImpl.ENTITY_CACHE_ENABLED,
				CampaignLogImpl.class, campaignLogId);

		if (campaignLog == _nullCampaignLog) {
			return null;
		}

		if (campaignLog == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				campaignLog = (CampaignLog)session.get(CampaignLogImpl.class,
						Long.valueOf(campaignLogId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (campaignLog != null) {
					cacheResult(campaignLog);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CampaignLogModelImpl.ENTITY_CACHE_ENABLED,
						CampaignLogImpl.class, campaignLogId, _nullCampaignLog);
				}

				closeSession(session);
			}
		}

		return campaignLog;
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
	public CampaignLog findByCampaignLogId(long campaignLogId, long companyId)
		throws NoSuchCampaignLogException, SystemException {
		CampaignLog campaignLog = fetchByCampaignLogId(campaignLogId, companyId);

		if (campaignLog == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("campaignLogId=");
			msg.append(campaignLogId);

			msg.append(", companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCampaignLogException(msg.toString());
		}

		return campaignLog;
	}

	/**
	 * Returns the campaign log where campaignLogId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param campaignLogId the campaign log ID
	 * @param companyId the company ID
	 * @return the matching campaign log, or <code>null</code> if a matching campaign log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CampaignLog fetchByCampaignLogId(long campaignLogId, long companyId)
		throws SystemException {
		return fetchByCampaignLogId(campaignLogId, companyId, true);
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
	public CampaignLog fetchByCampaignLogId(long campaignLogId, long companyId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { campaignLogId, companyId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CAMPAIGNLOGID,
					finderArgs, this);
		}

		if (result instanceof CampaignLog) {
			CampaignLog campaignLog = (CampaignLog)result;

			if ((campaignLogId != campaignLog.getCampaignLogId()) ||
					(companyId != campaignLog.getCompanyId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CAMPAIGNLOG_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNLOGID_CAMPAIGNLOGID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNLOGID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignLogId);

				qPos.add(companyId);

				List<CampaignLog> list = q.list();

				result = list;

				CampaignLog campaignLog = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNLOGID,
						finderArgs, list);
				}
				else {
					campaignLog = list.get(0);

					cacheResult(campaignLog);

					if ((campaignLog.getCampaignLogId() != campaignLogId) ||
							(campaignLog.getCompanyId() != companyId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNLOGID,
							finderArgs, campaignLog);
					}
				}

				return campaignLog;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CAMPAIGNLOGID,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (CampaignLog)result;
			}
		}
	}

	/**
	 * Returns all the campaign logs where campaignId = &#63; and companyId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param companyId the company ID
	 * @return the matching campaign logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CampaignLog> findByCampaignId(long campaignId, long companyId)
		throws SystemException {
		return findByCampaignId(campaignId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<CampaignLog> findByCampaignId(long campaignId, long companyId,
		int start, int end) throws SystemException {
		return findByCampaignId(campaignId, companyId, start, end, null);
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
	public List<CampaignLog> findByCampaignId(long campaignId, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID;
			finderArgs = new Object[] { campaignId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNID;
			finderArgs = new Object[] {
					campaignId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<CampaignLog> list = (List<CampaignLog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CampaignLog campaignLog : list) {
				if ((campaignId != campaignLog.getCampaignId()) ||
						(companyId != campaignLog.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CAMPAIGNLOG_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				qPos.add(companyId);

				list = (List<CampaignLog>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first campaign log in the ordered set where campaignId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign log
	 * @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException if a matching campaign log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CampaignLog findByCampaignId_First(long campaignId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignLogException, SystemException {
		List<CampaignLog> list = findByCampaignId(campaignId, companyId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("campaignId=");
			msg.append(campaignId);

			msg.append(", companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCampaignLogException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last campaign log in the ordered set where campaignId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign log
	 * @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException if a matching campaign log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CampaignLog findByCampaignId_Last(long campaignId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignLogException, SystemException {
		int count = countByCampaignId(campaignId, companyId);

		List<CampaignLog> list = findByCampaignId(campaignId, companyId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("campaignId=");
			msg.append(campaignId);

			msg.append(", companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCampaignLogException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the campaign logs before and after the current campaign log in the ordered set where campaignId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param campaignLogId the primary key of the current campaign log
	 * @param campaignId the campaign ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign log
	 * @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignLogException if a campaign log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CampaignLog[] findByCampaignId_PrevAndNext(long campaignLogId,
		long campaignId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchCampaignLogException, SystemException {
		CampaignLog campaignLog = findByPrimaryKey(campaignLogId);

		Session session = null;

		try {
			session = openSession();

			CampaignLog[] array = new CampaignLogImpl[3];

			array[0] = getByCampaignId_PrevAndNext(session, campaignLog,
					campaignId, companyId, orderByComparator, true);

			array[1] = campaignLog;

			array[2] = getByCampaignId_PrevAndNext(session, campaignLog,
					campaignId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CampaignLog getByCampaignId_PrevAndNext(Session session,
		CampaignLog campaignLog, long campaignId, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAMPAIGNLOG_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

		query.append(_FINDER_COLUMN_CAMPAIGNID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(campaignId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(campaignLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CampaignLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	public CampaignLog findByLogFinder(long campaignId, long companyId,
		long userId) throws NoSuchCampaignLogException, SystemException {
		CampaignLog campaignLog = fetchByLogFinder(campaignId, companyId, userId);

		if (campaignLog == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("campaignId=");
			msg.append(campaignId);

			msg.append(", companyId=");
			msg.append(companyId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCampaignLogException(msg.toString());
		}

		return campaignLog;
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
	public CampaignLog fetchByLogFinder(long campaignId, long companyId,
		long userId) throws SystemException {
		return fetchByLogFinder(campaignId, companyId, userId, true);
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
	public CampaignLog fetchByLogFinder(long campaignId, long companyId,
		long userId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { campaignId, companyId, userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LOGFINDER,
					finderArgs, this);
		}

		if (result instanceof CampaignLog) {
			CampaignLog campaignLog = (CampaignLog)result;

			if ((campaignId != campaignLog.getCampaignId()) ||
					(companyId != campaignLog.getCompanyId()) ||
					(userId != campaignLog.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CAMPAIGNLOG_WHERE);

			query.append(_FINDER_COLUMN_LOGFINDER_CAMPAIGNID_2);

			query.append(_FINDER_COLUMN_LOGFINDER_COMPANYID_2);

			query.append(_FINDER_COLUMN_LOGFINDER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				qPos.add(companyId);

				qPos.add(userId);

				List<CampaignLog> list = q.list();

				result = list;

				CampaignLog campaignLog = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOGFINDER,
						finderArgs, list);
				}
				else {
					campaignLog = list.get(0);

					cacheResult(campaignLog);

					if ((campaignLog.getCampaignId() != campaignId) ||
							(campaignLog.getCompanyId() != companyId) ||
							(campaignLog.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOGFINDER,
							finderArgs, campaignLog);
					}
				}

				return campaignLog;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LOGFINDER,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (CampaignLog)result;
			}
		}
	}

	/**
	 * Returns all the campaign logs.
	 *
	 * @return the campaign logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CampaignLog> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<CampaignLog> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<CampaignLog> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<CampaignLog> list = (List<CampaignLog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CAMPAIGNLOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CAMPAIGNLOG;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CampaignLog>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CampaignLog>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes the campaign log where campaignLogId = &#63; and companyId = &#63; from the database.
	 *
	 * @param campaignLogId the campaign log ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCampaignLogId(long campaignLogId, long companyId)
		throws NoSuchCampaignLogException, SystemException {
		CampaignLog campaignLog = findByCampaignLogId(campaignLogId, companyId);

		remove(campaignLog);
	}

	/**
	 * Removes all the campaign logs where campaignId = &#63; and companyId = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCampaignId(long campaignId, long companyId)
		throws SystemException {
		for (CampaignLog campaignLog : findByCampaignId(campaignId, companyId)) {
			remove(campaignLog);
		}
	}

	/**
	 * Removes the campaign log where campaignId = &#63; and companyId = &#63; and userId = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLogFinder(long campaignId, long companyId, long userId)
		throws NoSuchCampaignLogException, SystemException {
		CampaignLog campaignLog = findByLogFinder(campaignId, companyId, userId);

		remove(campaignLog);
	}

	/**
	 * Removes all the campaign logs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CampaignLog campaignLog : findAll()) {
			remove(campaignLog);
		}
	}

	/**
	 * Returns the number of campaign logs where campaignLogId = &#63; and companyId = &#63;.
	 *
	 * @param campaignLogId the campaign log ID
	 * @param companyId the company ID
	 * @return the number of matching campaign logs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCampaignLogId(long campaignLogId, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { campaignLogId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CAMPAIGNLOGID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CAMPAIGNLOG_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNLOGID_CAMPAIGNLOGID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNLOGID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignLogId);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CAMPAIGNLOGID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of campaign logs where campaignId = &#63; and companyId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param companyId the company ID
	 * @return the number of matching campaign logs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCampaignId(long campaignId, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { campaignId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CAMPAIGNLOG_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
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
	public int countByLogFinder(long campaignId, long companyId, long userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { campaignId, companyId, userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LOGFINDER,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CAMPAIGNLOG_WHERE);

			query.append(_FINDER_COLUMN_LOGFINDER_CAMPAIGNID_2);

			query.append(_FINDER_COLUMN_LOGFINDER_COMPANYID_2);

			query.append(_FINDER_COLUMN_LOGFINDER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				qPos.add(companyId);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOGFINDER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of campaign logs.
	 *
	 * @return the number of campaign logs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CAMPAIGNLOG);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the campaign log persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.lsp.liferay.portlet.advertising.model.CampaignLog")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CampaignLog>> listenersList = new ArrayList<ModelListener<CampaignLog>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CampaignLog>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(CampaignLogImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CampaignPersistence.class)
	protected CampaignPersistence campaignPersistence;
	@BeanReference(type = CampaignLogPersistence.class)
	protected CampaignLogPersistence campaignLogPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CAMPAIGNLOG = "SELECT campaignLog FROM CampaignLog campaignLog";
	private static final String _SQL_SELECT_CAMPAIGNLOG_WHERE = "SELECT campaignLog FROM CampaignLog campaignLog WHERE ";
	private static final String _SQL_COUNT_CAMPAIGNLOG = "SELECT COUNT(campaignLog) FROM CampaignLog campaignLog";
	private static final String _SQL_COUNT_CAMPAIGNLOG_WHERE = "SELECT COUNT(campaignLog) FROM CampaignLog campaignLog WHERE ";
	private static final String _FINDER_COLUMN_CAMPAIGNLOGID_CAMPAIGNLOGID_2 = "campaignLog.campaignLogId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNLOGID_COMPANYID_2 = "campaignLog.companyId = ?";
	private static final String _FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2 = "campaignLog.campaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNID_COMPANYID_2 = "campaignLog.companyId = ?";
	private static final String _FINDER_COLUMN_LOGFINDER_CAMPAIGNID_2 = "campaignLog.campaignId = ? AND ";
	private static final String _FINDER_COLUMN_LOGFINDER_COMPANYID_2 = "campaignLog.companyId = ? AND ";
	private static final String _FINDER_COLUMN_LOGFINDER_USERID_2 = "campaignLog.userId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "campaignLog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CampaignLog exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CampaignLog exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CampaignLogPersistenceImpl.class);
	private static CampaignLog _nullCampaignLog = new CampaignLogImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CampaignLog> toCacheModel() {
				return _nullCampaignLogCacheModel;
			}
		};

	private static CacheModel<CampaignLog> _nullCampaignLogCacheModel = new CacheModel<CampaignLog>() {
			public CampaignLog toEntityModel() {
				return _nullCampaignLog;
			}
		};
}