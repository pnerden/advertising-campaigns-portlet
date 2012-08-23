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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.lsp.liferay.portlet.advertising.NoSuchCampaignException;
import org.lsp.liferay.portlet.advertising.model.Campaign;
import org.lsp.liferay.portlet.advertising.model.impl.CampaignImpl;
import org.lsp.liferay.portlet.advertising.model.impl.CampaignModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the campaign service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignPersistence
 * @see CampaignUtil
 * @generated
 */
public class CampaignPersistenceImpl extends BasePersistenceImpl<Campaign>
	implements CampaignPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CampaignUtil} to access the campaign persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CampaignImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_CAMPAIGNID = new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignModelImpl.FINDER_CACHE_ENABLED, CampaignImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCampaignId",
			new String[] { Long.class.getName(), Long.class.getName() },
			CampaignModelImpl.CAMPAIGNID_COLUMN_BITMASK |
			CampaignModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNID = new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCampaignId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignModelImpl.FINDER_CACHE_ENABLED, CampaignImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignModelImpl.FINDER_CACHE_ENABLED, CampaignImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			CampaignModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVECAMPAIGNSBYDATE =
		new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignModelImpl.FINDER_CACHE_ENABLED, CampaignImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByActiveCampaignsByDate",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Date.class.getName(), Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_ACTIVECAMPAIGNSBYDATE =
		new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByActiveCampaignsByDate",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Date.class.getName(), Date.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignModelImpl.FINDER_CACHE_ENABLED, CampaignImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignModelImpl.FINDER_CACHE_ENABLED, CampaignImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the campaign in the entity cache if it is enabled.
	 *
	 * @param campaign the campaign
	 */
	public void cacheResult(Campaign campaign) {
		EntityCacheUtil.putResult(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImpl.class, campaign.getPrimaryKey(), campaign);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNID,
			new Object[] {
				Long.valueOf(campaign.getCampaignId()),
				Long.valueOf(campaign.getCompanyId())
			}, campaign);

		campaign.resetOriginalValues();
	}

	/**
	 * Caches the campaigns in the entity cache if it is enabled.
	 *
	 * @param campaigns the campaigns
	 */
	public void cacheResult(List<Campaign> campaigns) {
		for (Campaign campaign : campaigns) {
			if (EntityCacheUtil.getResult(
						CampaignModelImpl.ENTITY_CACHE_ENABLED,
						CampaignImpl.class, campaign.getPrimaryKey()) == null) {
				cacheResult(campaign);
			}
			else {
				campaign.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all campaigns.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CampaignImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CampaignImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the campaign.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Campaign campaign) {
		EntityCacheUtil.removeResult(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImpl.class, campaign.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(campaign);
	}

	@Override
	public void clearCache(List<Campaign> campaigns) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Campaign campaign : campaigns) {
			EntityCacheUtil.removeResult(CampaignModelImpl.ENTITY_CACHE_ENABLED,
				CampaignImpl.class, campaign.getPrimaryKey());

			clearUniqueFindersCache(campaign);
		}
	}

	protected void clearUniqueFindersCache(Campaign campaign) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CAMPAIGNID,
			new Object[] {
				Long.valueOf(campaign.getCampaignId()),
				Long.valueOf(campaign.getCompanyId())
			});
	}

	/**
	 * Creates a new campaign with the primary key. Does not add the campaign to the database.
	 *
	 * @param campaignId the primary key for the new campaign
	 * @return the new campaign
	 */
	public Campaign create(long campaignId) {
		Campaign campaign = new CampaignImpl();

		campaign.setNew(true);
		campaign.setPrimaryKey(campaignId);

		return campaign;
	}

	/**
	 * Removes the campaign with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param campaignId the primary key of the campaign
	 * @return the campaign that was removed
	 * @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignException if a campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign remove(long campaignId)
		throws NoSuchCampaignException, SystemException {
		return remove(Long.valueOf(campaignId));
	}

	/**
	 * Removes the campaign with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the campaign
	 * @return the campaign that was removed
	 * @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignException if a campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Campaign remove(Serializable primaryKey)
		throws NoSuchCampaignException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Campaign campaign = (Campaign)session.get(CampaignImpl.class,
					primaryKey);

			if (campaign == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCampaignException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(campaign);
		}
		catch (NoSuchCampaignException nsee) {
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
	protected Campaign removeImpl(Campaign campaign) throws SystemException {
		campaign = toUnwrappedModel(campaign);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, campaign);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(campaign);

		return campaign;
	}

	@Override
	public Campaign updateImpl(
		org.lsp.liferay.portlet.advertising.model.Campaign campaign,
		boolean merge) throws SystemException {
		campaign = toUnwrappedModel(campaign);

		boolean isNew = campaign.isNew();

		CampaignModelImpl campaignModelImpl = (CampaignModelImpl)campaign;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, campaign, merge);

			campaign.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CampaignModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((campaignModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(campaignModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						Long.valueOf(campaignModelImpl.getCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}
		}

		EntityCacheUtil.putResult(CampaignModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImpl.class, campaign.getPrimaryKey(), campaign);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNID,
				new Object[] {
					Long.valueOf(campaign.getCampaignId()),
					Long.valueOf(campaign.getCompanyId())
				}, campaign);
		}
		else {
			if ((campaignModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CAMPAIGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(campaignModelImpl.getOriginalCampaignId()),
						Long.valueOf(campaignModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CAMPAIGNID,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNID,
					new Object[] {
						Long.valueOf(campaign.getCampaignId()),
						Long.valueOf(campaign.getCompanyId())
					}, campaign);
			}
		}

		return campaign;
	}

	protected Campaign toUnwrappedModel(Campaign campaign) {
		if (campaign instanceof CampaignImpl) {
			return campaign;
		}

		CampaignImpl campaignImpl = new CampaignImpl();

		campaignImpl.setNew(campaign.isNew());
		campaignImpl.setPrimaryKey(campaign.getPrimaryKey());

		campaignImpl.setCompanyId(campaign.getCompanyId());
		campaignImpl.setCampaignId(campaign.getCampaignId());
		campaignImpl.setJournalArticlePrimaryKey(campaign.getJournalArticlePrimaryKey());
		campaignImpl.setBeginDate(campaign.getBeginDate());
		campaignImpl.setEndDate(campaign.getEndDate());
		campaignImpl.setCampaignStatus(campaign.getCampaignStatus());

		return campaignImpl;
	}

	/**
	 * Returns the campaign with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign
	 * @return the campaign
	 * @throws com.liferay.portal.NoSuchModelException if a campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Campaign findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the campaign with the primary key or throws a {@link org.lsp.liferay.portlet.advertising.NoSuchCampaignException} if it could not be found.
	 *
	 * @param campaignId the primary key of the campaign
	 * @return the campaign
	 * @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignException if a campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign findByPrimaryKey(long campaignId)
		throws NoSuchCampaignException, SystemException {
		Campaign campaign = fetchByPrimaryKey(campaignId);

		if (campaign == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + campaignId);
			}

			throw new NoSuchCampaignException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				campaignId);
		}

		return campaign;
	}

	/**
	 * Returns the campaign with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign
	 * @return the campaign, or <code>null</code> if a campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Campaign fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the campaign with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param campaignId the primary key of the campaign
	 * @return the campaign, or <code>null</code> if a campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign fetchByPrimaryKey(long campaignId)
		throws SystemException {
		Campaign campaign = (Campaign)EntityCacheUtil.getResult(CampaignModelImpl.ENTITY_CACHE_ENABLED,
				CampaignImpl.class, campaignId);

		if (campaign == _nullCampaign) {
			return null;
		}

		if (campaign == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				campaign = (Campaign)session.get(CampaignImpl.class,
						Long.valueOf(campaignId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (campaign != null) {
					cacheResult(campaign);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CampaignModelImpl.ENTITY_CACHE_ENABLED,
						CampaignImpl.class, campaignId, _nullCampaign);
				}

				closeSession(session);
			}
		}

		return campaign;
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
	public Campaign findByCampaignId(long campaignId, long companyId)
		throws NoSuchCampaignException, SystemException {
		Campaign campaign = fetchByCampaignId(campaignId, companyId);

		if (campaign == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("campaignId=");
			msg.append(campaignId);

			msg.append(", companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCampaignException(msg.toString());
		}

		return campaign;
	}

	/**
	 * Returns the campaign where campaignId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param campaignId the campaign ID
	 * @param companyId the company ID
	 * @return the matching campaign, or <code>null</code> if a matching campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign fetchByCampaignId(long campaignId, long companyId)
		throws SystemException {
		return fetchByCampaignId(campaignId, companyId, true);
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
	public Campaign fetchByCampaignId(long campaignId, long companyId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { campaignId, companyId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CAMPAIGNID,
					finderArgs, this);
		}

		if (result instanceof Campaign) {
			Campaign campaign = (Campaign)result;

			if ((campaignId != campaign.getCampaignId()) ||
					(companyId != campaign.getCompanyId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CAMPAIGN_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

			query.append(_FINDER_COLUMN_CAMPAIGNID_COMPANYID_2);

			query.append(CampaignModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				qPos.add(companyId);

				List<Campaign> list = q.list();

				result = list;

				Campaign campaign = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNID,
						finderArgs, list);
				}
				else {
					campaign = list.get(0);

					cacheResult(campaign);

					if ((campaign.getCampaignId() != campaignId) ||
							(campaign.getCompanyId() != companyId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CAMPAIGNID,
							finderArgs, campaign);
					}
				}

				return campaign;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CAMPAIGNID,
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
				return (Campaign)result;
			}
		}
	}

	/**
	 * Returns all the campaigns where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	public List<Campaign> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
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
	public List<Campaign> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<Campaign> list = (List<Campaign>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Campaign campaign : list) {
				if ((companyId != campaign.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CAMPAIGN_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CampaignModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<Campaign>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first campaign in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign
	 * @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignException if a matching campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		Campaign campaign = fetchByCompanyId_First(companyId, orderByComparator);

		if (campaign != null) {
			return campaign;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignException(msg.toString());
	}

	/**
	 * Returns the first campaign in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign, or <code>null</code> if a matching campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Campaign> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last campaign in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign
	 * @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignException if a matching campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		Campaign campaign = fetchByCompanyId_Last(companyId, orderByComparator);

		if (campaign != null) {
			return campaign;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignException(msg.toString());
	}

	/**
	 * Returns the last campaign in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign, or <code>null</code> if a matching campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		List<Campaign> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the campaigns before and after the current campaign in the ordered set where companyId = &#63;.
	 *
	 * @param campaignId the primary key of the current campaign
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign
	 * @throws org.lsp.liferay.portlet.advertising.NoSuchCampaignException if a campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign[] findByCompanyId_PrevAndNext(long campaignId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		Campaign campaign = findByPrimaryKey(campaignId);

		Session session = null;

		try {
			session = openSession();

			Campaign[] array = new CampaignImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, campaign, companyId,
					orderByComparator, true);

			array[1] = campaign;

			array[2] = getByCompanyId_PrevAndNext(session, campaign, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Campaign getByCompanyId_PrevAndNext(Session session,
		Campaign campaign, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAMPAIGN_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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

		else {
			query.append(CampaignModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(campaign);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Campaign> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	public List<Campaign> findByActiveCampaignsByDate(long companyId,
		int campaignStatus, Date beginDate, Date endDate)
		throws SystemException {
		return findByActiveCampaignsByDate(companyId, campaignStatus,
			beginDate, endDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Campaign> findByActiveCampaignsByDate(long companyId,
		int campaignStatus, Date beginDate, Date endDate, int start, int end)
		throws SystemException {
		return findByActiveCampaignsByDate(companyId, campaignStatus,
			beginDate, endDate, start, end, null);
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
	public List<Campaign> findByActiveCampaignsByDate(long companyId,
		int campaignStatus, Date beginDate, Date endDate, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVECAMPAIGNSBYDATE;
		finderArgs = new Object[] {
				companyId, campaignStatus, beginDate, endDate,
				
				start, end, orderByComparator
			};

		List<Campaign> list = (List<Campaign>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Campaign campaign : list) {
				if ((companyId != campaign.getCompanyId()) ||
						(campaignStatus != campaign.getCampaignStatus()) ||
						!Validator.equals(beginDate, campaign.getBeginDate()) ||
						!Validator.equals(endDate, campaign.getEndDate())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_CAMPAIGN_WHERE);

			query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_COMPANYID_2);

			query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_CAMPAIGNSTATUS_2);

			if (beginDate == null) {
				query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_BEGINDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_BEGINDATE_2);
			}

			if (endDate == null) {
				query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_ENDDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_ENDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CampaignModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(campaignStatus);

				if (beginDate != null) {
					qPos.add(CalendarUtil.getTimestamp(beginDate));
				}

				if (endDate != null) {
					qPos.add(CalendarUtil.getTimestamp(endDate));
				}

				list = (List<Campaign>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first campaign in the ordered set where companyId = &#63; and campaignStatus = &#63; and beginDate &le; &#63; and endDate &ge; &#63;.
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
	public Campaign findByActiveCampaignsByDate_First(long companyId,
		int campaignStatus, Date beginDate, Date endDate,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		Campaign campaign = fetchByActiveCampaignsByDate_First(companyId,
				campaignStatus, beginDate, endDate, orderByComparator);

		if (campaign != null) {
			return campaign;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", campaignStatus=");
		msg.append(campaignStatus);

		msg.append(", beginDate=");
		msg.append(beginDate);

		msg.append(", endDate=");
		msg.append(endDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignException(msg.toString());
	}

	/**
	 * Returns the first campaign in the ordered set where companyId = &#63; and campaignStatus = &#63; and beginDate &le; &#63; and endDate &ge; &#63;.
	 *
	 * @param companyId the company ID
	 * @param campaignStatus the campaign status
	 * @param beginDate the begin date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign, or <code>null</code> if a matching campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign fetchByActiveCampaignsByDate_First(long companyId,
		int campaignStatus, Date beginDate, Date endDate,
		OrderByComparator orderByComparator) throws SystemException {
		List<Campaign> list = findByActiveCampaignsByDate(companyId,
				campaignStatus, beginDate, endDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last campaign in the ordered set where companyId = &#63; and campaignStatus = &#63; and beginDate &le; &#63; and endDate &ge; &#63;.
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
	public Campaign findByActiveCampaignsByDate_Last(long companyId,
		int campaignStatus, Date beginDate, Date endDate,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		Campaign campaign = fetchByActiveCampaignsByDate_Last(companyId,
				campaignStatus, beginDate, endDate, orderByComparator);

		if (campaign != null) {
			return campaign;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", campaignStatus=");
		msg.append(campaignStatus);

		msg.append(", beginDate=");
		msg.append(beginDate);

		msg.append(", endDate=");
		msg.append(endDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignException(msg.toString());
	}

	/**
	 * Returns the last campaign in the ordered set where companyId = &#63; and campaignStatus = &#63; and beginDate &le; &#63; and endDate &ge; &#63;.
	 *
	 * @param companyId the company ID
	 * @param campaignStatus the campaign status
	 * @param beginDate the begin date
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign, or <code>null</code> if a matching campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign fetchByActiveCampaignsByDate_Last(long companyId,
		int campaignStatus, Date beginDate, Date endDate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByActiveCampaignsByDate(companyId, campaignStatus,
				beginDate, endDate);

		List<Campaign> list = findByActiveCampaignsByDate(companyId,
				campaignStatus, beginDate, endDate, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the campaigns before and after the current campaign in the ordered set where companyId = &#63; and campaignStatus = &#63; and beginDate &le; &#63; and endDate &ge; &#63;.
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
	public Campaign[] findByActiveCampaignsByDate_PrevAndNext(long campaignId,
		long companyId, int campaignStatus, Date beginDate, Date endDate,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignException, SystemException {
		Campaign campaign = findByPrimaryKey(campaignId);

		Session session = null;

		try {
			session = openSession();

			Campaign[] array = new CampaignImpl[3];

			array[0] = getByActiveCampaignsByDate_PrevAndNext(session,
					campaign, companyId, campaignStatus, beginDate, endDate,
					orderByComparator, true);

			array[1] = campaign;

			array[2] = getByActiveCampaignsByDate_PrevAndNext(session,
					campaign, companyId, campaignStatus, beginDate, endDate,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Campaign getByActiveCampaignsByDate_PrevAndNext(Session session,
		Campaign campaign, long companyId, int campaignStatus, Date beginDate,
		Date endDate, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAMPAIGN_WHERE);

		query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_COMPANYID_2);

		query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_CAMPAIGNSTATUS_2);

		if (beginDate == null) {
			query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_BEGINDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_BEGINDATE_2);
		}

		if (endDate == null) {
			query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_ENDDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_ENDDATE_2);
		}

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

		else {
			query.append(CampaignModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(campaignStatus);

		if (beginDate != null) {
			qPos.add(CalendarUtil.getTimestamp(beginDate));
		}

		if (endDate != null) {
			qPos.add(CalendarUtil.getTimestamp(endDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(campaign);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Campaign> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	public List<Campaign> findByActiveCampaignsByDate(long companyId,
		int campaignStatus, Date beginDate, Date[] endDates)
		throws SystemException {
		return findByActiveCampaignsByDate(companyId, campaignStatus,
			beginDate, endDates, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Campaign> findByActiveCampaignsByDate(long companyId,
		int campaignStatus, Date beginDate, Date[] endDates, int start, int end)
		throws SystemException {
		return findByActiveCampaignsByDate(companyId, campaignStatus,
			beginDate, endDates, start, end, null);
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
	public List<Campaign> findByActiveCampaignsByDate(long companyId,
		int campaignStatus, Date beginDate, Date[] endDates, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVECAMPAIGNSBYDATE;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderArgs = new Object[] {
					companyId, campaignStatus, beginDate,
					StringUtil.merge(endDates)
				};
		}
		else {
			finderArgs = new Object[] {
					companyId, campaignStatus, beginDate,
					StringUtil.merge(endDates),
					
					start, end, orderByComparator
				};
		}

		List<Campaign> list = (List<Campaign>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Campaign campaign : list) {
				if ((companyId != campaign.getCompanyId()) ||
						(campaignStatus != campaign.getCampaignStatus()) ||
						!Validator.equals(beginDate, campaign.getBeginDate()) ||
						!ArrayUtil.contains(endDates, campaign.getEndDate())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_CAMPAIGN_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_CAMPAIGNSTATUS_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			if (beginDate == null) {
				query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_BEGINDATE_4);
			}
			else {
				query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_BEGINDATE_5);
			}

			conjunctionable = true;

			if ((endDates == null) || (endDates.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < endDates.length; i++) {
					Date endDate = endDates[i];

					if (endDate == null) {
						query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_ENDDATE_4);
					}
					else {
						query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_ENDDATE_5);
					}

					if ((i + 1) < endDates.length) {
						query.append(WHERE_AND);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CampaignModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(campaignStatus);

				if (beginDate != null) {
					qPos.add(CalendarUtil.getTimestamp(beginDate));
				}

				if (endDates != null) {
					qPos.add(endDates);
				}

				list = (List<Campaign>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns all the campaigns.
	 *
	 * @return the campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public List<Campaign> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Campaign> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Campaign> findAll(int start, int end,
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

		List<Campaign> list = (List<Campaign>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CAMPAIGN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CAMPAIGN.concat(CampaignModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Campaign>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Campaign>)QueryUtil.list(q, getDialect(),
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
	 * Removes the campaign where campaignId = &#63; and companyId = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @param companyId the company ID
	 * @return the campaign that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public Campaign removeByCampaignId(long campaignId, long companyId)
		throws NoSuchCampaignException, SystemException {
		Campaign campaign = findByCampaignId(campaignId, companyId);

		return remove(campaign);
	}

	/**
	 * Removes all the campaigns where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (Campaign campaign : findByCompanyId(companyId)) {
			remove(campaign);
		}
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
	public void removeByActiveCampaignsByDate(long companyId,
		int campaignStatus, Date beginDate, Date endDate)
		throws SystemException {
		for (Campaign campaign : findByActiveCampaignsByDate(companyId,
				campaignStatus, beginDate, endDate)) {
			remove(campaign);
		}
	}

	/**
	 * Removes all the campaigns from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Campaign campaign : findAll()) {
			remove(campaign);
		}
	}

	/**
	 * Returns the number of campaigns where campaignId = &#63; and companyId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param companyId the company ID
	 * @return the number of matching campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCampaignId(long campaignId, long companyId)
		throws SystemException {
		Object[] finderArgs = new Object[] { campaignId, companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CAMPAIGN_WHERE);

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
	 * Returns the number of campaigns where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAMPAIGN_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
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
	public int countByActiveCampaignsByDate(long companyId, int campaignStatus,
		Date beginDate, Date endDate) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, campaignStatus, beginDate, endDate
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_ACTIVECAMPAIGNSBYDATE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_CAMPAIGN_WHERE);

			query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_COMPANYID_2);

			query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_CAMPAIGNSTATUS_2);

			if (beginDate == null) {
				query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_BEGINDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_BEGINDATE_2);
			}

			if (endDate == null) {
				query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_ENDDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_ENDDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(campaignStatus);

				if (beginDate != null) {
					qPos.add(CalendarUtil.getTimestamp(beginDate));
				}

				if (endDate != null) {
					qPos.add(CalendarUtil.getTimestamp(endDate));
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_ACTIVECAMPAIGNSBYDATE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
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
	public int countByActiveCampaignsByDate(long companyId, int campaignStatus,
		Date beginDate, Date[] endDates) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId, campaignStatus, beginDate, StringUtil.merge(endDates)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_ACTIVECAMPAIGNSBYDATE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_CAMPAIGN_WHERE);

			boolean conjunctionable = false;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_COMPANYID_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_CAMPAIGNSTATUS_5);

			conjunctionable = true;

			if (conjunctionable) {
				query.append(WHERE_AND);
			}

			if (beginDate == null) {
				query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_BEGINDATE_4);
			}
			else {
				query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_BEGINDATE_5);
			}

			conjunctionable = true;

			if ((endDates == null) || (endDates.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < endDates.length; i++) {
					Date endDate = endDates[i];

					if (endDate == null) {
						query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_ENDDATE_4);
					}
					else {
						query.append(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_ENDDATE_5);
					}

					if ((i + 1) < endDates.length) {
						query.append(WHERE_AND);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(campaignStatus);

				if (beginDate != null) {
					qPos.add(CalendarUtil.getTimestamp(beginDate));
				}

				if (endDates != null) {
					qPos.add(endDates);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_ACTIVECAMPAIGNSBYDATE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of campaigns.
	 *
	 * @return the number of campaigns
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CAMPAIGN);

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
	 * Initializes the campaign persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.lsp.liferay.portlet.advertising.model.Campaign")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Campaign>> listenersList = new ArrayList<ModelListener<Campaign>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Campaign>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CampaignImpl.class.getName());
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
	private static final String _SQL_SELECT_CAMPAIGN = "SELECT campaign FROM Campaign campaign";
	private static final String _SQL_SELECT_CAMPAIGN_WHERE = "SELECT campaign FROM Campaign campaign WHERE ";
	private static final String _SQL_COUNT_CAMPAIGN = "SELECT COUNT(campaign) FROM Campaign campaign";
	private static final String _SQL_COUNT_CAMPAIGN_WHERE = "SELECT COUNT(campaign) FROM Campaign campaign WHERE ";
	private static final String _FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2 = "campaign.campaignId = ? AND ";
	private static final String _FINDER_COLUMN_CAMPAIGNID_COMPANYID_2 = "campaign.companyId = ?";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "campaign.companyId = ?";
	private static final String _FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_COMPANYID_2 =
		"campaign.companyId = ? AND ";
	private static final String _FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_COMPANYID_5 =
		"(" +
		_removeConjunction(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_COMPANYID_2) +
		")";
	private static final String _FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_CAMPAIGNSTATUS_2 =
		"campaign.campaignStatus = ? AND ";
	private static final String _FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_CAMPAIGNSTATUS_5 =
		"(" +
		_removeConjunction(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_CAMPAIGNSTATUS_2) +
		")";
	private static final String _FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_BEGINDATE_1 =
		"campaign.beginDate <= NULL AND ";
	private static final String _FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_BEGINDATE_2 =
		"campaign.beginDate <= ? AND ";
	private static final String _FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_BEGINDATE_4 =
		"(" +
		_removeConjunction(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_BEGINDATE_1) +
		")";
	private static final String _FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_BEGINDATE_5 =
		"(" +
		_removeConjunction(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_BEGINDATE_2) +
		")";
	private static final String _FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_ENDDATE_1 = "campaign.endDate >= NULL";
	private static final String _FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_ENDDATE_2 = "campaign.endDate >= ?";
	private static final String _FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_ENDDATE_4 = "(" +
		_removeConjunction(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_ENDDATE_1) +
		")";
	private static final String _FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_ENDDATE_5 = "(" +
		_removeConjunction(_FINDER_COLUMN_ACTIVECAMPAIGNSBYDATE_ENDDATE_2) +
		")";

	private static String _removeConjunction(String sql) {
		int pos = sql.indexOf(" AND ");

		if (pos != -1) {
			sql = sql.substring(0, pos);
		}

		return sql;
	}

	private static final String _ORDER_BY_ENTITY_ALIAS = "campaign.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Campaign exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Campaign exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CampaignPersistenceImpl.class);
	private static Campaign _nullCampaign = new CampaignImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Campaign> toCacheModel() {
				return _nullCampaignCacheModel;
			}
		};

	private static CacheModel<Campaign> _nullCampaignCacheModel = new CacheModel<Campaign>() {
			public Campaign toEntityModel() {
				return _nullCampaign;
			}
		};
}