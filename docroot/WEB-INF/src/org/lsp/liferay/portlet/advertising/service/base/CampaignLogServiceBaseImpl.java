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

package org.lsp.liferay.portlet.advertising.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import org.lsp.liferay.portlet.advertising.model.CampaignLog;
import org.lsp.liferay.portlet.advertising.service.CampaignLocalService;
import org.lsp.liferay.portlet.advertising.service.CampaignLogLocalService;
import org.lsp.liferay.portlet.advertising.service.CampaignLogService;
import org.lsp.liferay.portlet.advertising.service.CampaignService;
import org.lsp.liferay.portlet.advertising.service.persistence.CampaignLogPersistence;
import org.lsp.liferay.portlet.advertising.service.persistence.CampaignPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the campaign log remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.lsp.liferay.portlet.advertising.service.impl.CampaignLogServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see org.lsp.liferay.portlet.advertising.service.impl.CampaignLogServiceImpl
 * @see org.lsp.liferay.portlet.advertising.service.CampaignLogServiceUtil
 * @generated
 */
public abstract class CampaignLogServiceBaseImpl extends BaseServiceImpl
	implements CampaignLogService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.lsp.liferay.portlet.advertising.service.CampaignLogServiceUtil} to access the campaign log remote service.
	 */

	/**
	 * Returns the campaign local service.
	 *
	 * @return the campaign local service
	 */
	public CampaignLocalService getCampaignLocalService() {
		return campaignLocalService;
	}

	/**
	 * Sets the campaign local service.
	 *
	 * @param campaignLocalService the campaign local service
	 */
	public void setCampaignLocalService(
		CampaignLocalService campaignLocalService) {
		this.campaignLocalService = campaignLocalService;
	}

	/**
	 * Returns the campaign remote service.
	 *
	 * @return the campaign remote service
	 */
	public CampaignService getCampaignService() {
		return campaignService;
	}

	/**
	 * Sets the campaign remote service.
	 *
	 * @param campaignService the campaign remote service
	 */
	public void setCampaignService(CampaignService campaignService) {
		this.campaignService = campaignService;
	}

	/**
	 * Returns the campaign persistence.
	 *
	 * @return the campaign persistence
	 */
	public CampaignPersistence getCampaignPersistence() {
		return campaignPersistence;
	}

	/**
	 * Sets the campaign persistence.
	 *
	 * @param campaignPersistence the campaign persistence
	 */
	public void setCampaignPersistence(CampaignPersistence campaignPersistence) {
		this.campaignPersistence = campaignPersistence;
	}

	/**
	 * Returns the campaign log local service.
	 *
	 * @return the campaign log local service
	 */
	public CampaignLogLocalService getCampaignLogLocalService() {
		return campaignLogLocalService;
	}

	/**
	 * Sets the campaign log local service.
	 *
	 * @param campaignLogLocalService the campaign log local service
	 */
	public void setCampaignLogLocalService(
		CampaignLogLocalService campaignLogLocalService) {
		this.campaignLogLocalService = campaignLogLocalService;
	}

	/**
	 * Returns the campaign log remote service.
	 *
	 * @return the campaign log remote service
	 */
	public CampaignLogService getCampaignLogService() {
		return campaignLogService;
	}

	/**
	 * Sets the campaign log remote service.
	 *
	 * @param campaignLogService the campaign log remote service
	 */
	public void setCampaignLogService(CampaignLogService campaignLogService) {
		this.campaignLogService = campaignLogService;
	}

	/**
	 * Returns the campaign log persistence.
	 *
	 * @return the campaign log persistence
	 */
	public CampaignLogPersistence getCampaignLogPersistence() {
		return campaignLogPersistence;
	}

	/**
	 * Sets the campaign log persistence.
	 *
	 * @param campaignLogPersistence the campaign log persistence
	 */
	public void setCampaignLogPersistence(
		CampaignLogPersistence campaignLogPersistence) {
		this.campaignLogPersistence = campaignLogPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return CampaignLog.class;
	}

	protected String getModelClassName() {
		return CampaignLog.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = campaignLogPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = CampaignLocalService.class)
	protected CampaignLocalService campaignLocalService;
	@BeanReference(type = CampaignService.class)
	protected CampaignService campaignService;
	@BeanReference(type = CampaignPersistence.class)
	protected CampaignPersistence campaignPersistence;
	@BeanReference(type = CampaignLogLocalService.class)
	protected CampaignLogLocalService campaignLogLocalService;
	@BeanReference(type = CampaignLogService.class)
	protected CampaignLogService campaignLogService;
	@BeanReference(type = CampaignLogPersistence.class)
	protected CampaignLogPersistence campaignLogPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private CampaignLogServiceClpInvoker _clpInvoker = new CampaignLogServiceClpInvoker();
}