package org.lsp.liferay.portlet.advertising.events;

/**
 * Copyright (c) 2011-2012 Patrick NERDEN. All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lsp.liferay.portlet.advertising.service.CampaignLocalServiceUtil;
import org.lsp.liferay.portlet.advertising.service.CampaignLogLocalServiceUtil;
import org.lsp.liferay.portlet.advertising.util.CampaignConstants;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.LastPath;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.util.PortalUtil;

public class AdvertisingLandingPageAction extends Action {
	
	public void run(HttpServletRequest request, HttpServletResponse response) {
		
		long userId = PortalUtil.getUserId(request);
		long companyId = PortalUtil.getCompanyId(request);

		String path;
		try {
			path = PrefsPropsUtil.getString(companyId, PropsKeys.DEFAULT_LANDING_PAGE_PATH);
		
			if (_log.isDebugEnabled()) {
				_log.debug(PropsKeys.DEFAULT_LANDING_PAGE_PATH + StringPool.EQUAL + path);
			}
			
			long campaignIdToDisplay = CampaignLocalServiceUtil.getCampaignIdToDisplay(companyId, userId);
			
			_log.debug("Redirecting User to: "+path);
            LastPath lastPath = new LastPath(request.getContextPath(), path);
            if (_log.isDebugEnabled()) {
            	_log.debug("lastPath = " + lastPath.toString());
            }
            HttpSession session = request.getSession();
            session.setAttribute(WebKeys.LAST_PATH, lastPath);
            
            if (campaignIdToDisplay > 0) {
	            session.setAttribute(CampaignConstants.CAMPAIGN_HEADER, CampaignLocalServiceUtil.getCampaign(campaignIdToDisplay).getJournalArticlePrimaryKey());
	            CampaignLogLocalServiceUtil.markDisplayed(campaignIdToDisplay, userId);
            }
			
		} catch (SystemException e) {
			_log.error(e.getMessage(), e);
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}
		
	}
	
	private static Log _log = LogFactoryUtil.getLog(AdvertisingLandingPageAction.class);
	
}