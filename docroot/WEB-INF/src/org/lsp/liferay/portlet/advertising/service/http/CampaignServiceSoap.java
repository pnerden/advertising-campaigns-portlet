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

package org.lsp.liferay.portlet.advertising.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.lsp.liferay.portlet.advertising.service.CampaignServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link org.lsp.liferay.portlet.advertising.service.CampaignServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link org.lsp.liferay.portlet.advertising.model.CampaignSoap}.
 * If the method in the service utility returns a
 * {@link org.lsp.liferay.portlet.advertising.model.Campaign}, that is translated to a
 * {@link org.lsp.liferay.portlet.advertising.model.CampaignSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       CampaignServiceHttp
 * @see       org.lsp.liferay.portlet.advertising.model.CampaignSoap
 * @see       org.lsp.liferay.portlet.advertising.service.CampaignServiceUtil
 * @generated
 */
public class CampaignServiceSoap {
	public static long getCampaignIdToDisplay() throws RemoteException {
		try {
			long returnValue = CampaignServiceUtil.getCampaignIdToDisplay();

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.lsp.liferay.portlet.advertising.model.CampaignSoap createCampaign(
		long journalArticlePrimaryKey, java.util.Date beginDate,
		java.util.Date endDate) throws RemoteException {
		try {
			org.lsp.liferay.portlet.advertising.model.Campaign returnValue = CampaignServiceUtil.createCampaign(journalArticlePrimaryKey,
					beginDate, endDate);

			return org.lsp.liferay.portlet.advertising.model.CampaignSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.lsp.liferay.portlet.advertising.model.CampaignSoap getCampaign(
		long campaignId) throws RemoteException {
		try {
			org.lsp.liferay.portlet.advertising.model.Campaign returnValue = CampaignServiceUtil.getCampaign(campaignId);

			return org.lsp.liferay.portlet.advertising.model.CampaignSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.lsp.liferay.portlet.advertising.model.CampaignSoap[] getCampaigns()
		throws RemoteException {
		try {
			java.util.List<org.lsp.liferay.portlet.advertising.model.Campaign> returnValue =
				CampaignServiceUtil.getCampaigns();

			return org.lsp.liferay.portlet.advertising.model.CampaignSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static long removeCampaign(long campaignId)
		throws RemoteException {
		try {
			long returnValue = CampaignServiceUtil.removeCampaign(campaignId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.lsp.liferay.portlet.advertising.model.CampaignSoap updateCampaign(
		long campaignId, long journalArticlePrimaryKey,
		java.util.Date beginDate, java.util.Date endDate)
		throws RemoteException {
		try {
			org.lsp.liferay.portlet.advertising.model.Campaign returnValue = CampaignServiceUtil.updateCampaign(campaignId,
					journalArticlePrimaryKey, beginDate, endDate);

			return org.lsp.liferay.portlet.advertising.model.CampaignSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.lsp.liferay.portlet.advertising.model.CampaignSoap updateCampaign(
		long campaignId, long journalArticlePrimaryKey,
		java.util.Date beginDate, java.util.Date endDate, int campaignStatus)
		throws RemoteException {
		try {
			org.lsp.liferay.portlet.advertising.model.Campaign returnValue = CampaignServiceUtil.updateCampaign(campaignId,
					journalArticlePrimaryKey, beginDate, endDate, campaignStatus);

			return org.lsp.liferay.portlet.advertising.model.CampaignSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.lsp.liferay.portlet.advertising.model.CampaignSoap startCampaign(
		long campaignId) throws RemoteException {
		try {
			org.lsp.liferay.portlet.advertising.model.Campaign returnValue = CampaignServiceUtil.startCampaign(campaignId);

			return org.lsp.liferay.portlet.advertising.model.CampaignSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.lsp.liferay.portlet.advertising.model.CampaignSoap pauseCampaign(
		long campaignId) throws RemoteException {
		try {
			org.lsp.liferay.portlet.advertising.model.Campaign returnValue = CampaignServiceUtil.pauseCampaign(campaignId);

			return org.lsp.liferay.portlet.advertising.model.CampaignSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.lsp.liferay.portlet.advertising.model.CampaignSoap stopCampaign(
		long campaignId) throws RemoteException {
		try {
			org.lsp.liferay.portlet.advertising.model.Campaign returnValue = CampaignServiceUtil.stopCampaign(campaignId);

			return org.lsp.liferay.portlet.advertising.model.CampaignSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CampaignServiceSoap.class);
}