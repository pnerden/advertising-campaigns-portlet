<%--
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
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%@ page import="com.liferay.portlet.journal.model.JournalArticle" %>
<%@ page import="com.liferay.portlet.journal.service.JournalArticleServiceUtil" %>

<%@ page import="org.lsp.liferay.portlet.advertising.NoSuchCampaignException" %>
<%@ page import="org.lsp.liferay.portlet.advertising.model.Campaign" %>
<%@ page import="org.lsp.liferay.portlet.advertising.portlet.CampaignManagementPortletUtil" %>
<%@ page import="org.lsp.liferay.portlet.advertising.service.CampaignServiceUtil" %>
<%@ page import="org.lsp.liferay.portlet.advertising.util.CampaignConstants" %>
<%@ page import="org.lsp.liferay.portlet.advertising.util.CampaignUtil" %>

<%@ page import="java.text.DateFormat" %>

<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale" %>

<%@ page import="javax.portlet.ActionRequest" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.WindowState" %>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
String portletResource = ParamUtil.getString(request, "portletResource");
String portletNameSpace = "_"+request.getAttribute("PORTLET_ID")+"_";
String portletURL = request.getContextPath();

String portalURL = themeDisplay.getPortalURL();
String currentURL = PortalUtil.getCurrentURL(request);
long companyId = themeDisplay.getCompanyId();
DateFormat df = DateFormat.getDateInstance();
%>