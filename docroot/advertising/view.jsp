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

<%@ include file="/advertising/init.jsp" %>

<%
List<Campaign> campaignList = CampaignServiceUtil.getCampaigns();

long globalGroupId = CampaignUtil.getGlobalGroupId(companyId);
%>

<span class="portlet-msg-info"><liferay-ui:message key="advertising-campaign-portlet-howto" /></span>

<%
PortletURL addCampaignURL = renderResponse.createRenderURL();
addCampaignURL.setWindowState(WindowState.MAXIMIZED);
addCampaignURL.setParameter("mvcPath", "/advertising/edit_campaign.jsp");
addCampaignURL.setParameter("redirect", currentURL);
%>

<aui:button-row>
	<aui:button name="createCampaign" type="button" value="create-campaign" onClick="<%= addCampaignURL.toString() %>" />
</aui:button-row>
	
<%
if ((campaignList != null) && (campaignList.size() > 0)) {
%>

<div id="advertising-campaign-list">
	<table class="lfr-table">
		<tr>
			<th><liferay-ui:message key="small-image" /></th>
			<th><liferay-ui:message key="id" /></th>
			<th><liferay-ui:message key="article" /></th>
			<th><liferay-ui:message key="start-date" /></th>
			<th><liferay-ui:message key="end-date" /></th>
			<th><liferay-ui:message key="status" /></th>
			<th><liferay-ui:message key="action" /></th>
		</tr>
	<%
	Iterator<Campaign> iter = campaignList.iterator();
	while (iter.hasNext()) {
		Campaign c = iter.next();
		JournalArticle j = CampaignUtil.getJournalArticle(c.getCompanyId(), c.getCampaignId());
		String smallImageUrl = CampaignUtil.getSmallImageURL(c);
		%>
		
		<%
		PortletURL deleteCampaignURL = renderResponse.createActionURL();
		deleteCampaignURL.setWindowState(WindowState.MAXIMIZED);
		deleteCampaignURL.setParameter(ActionRequest.ACTION_NAME, "deleteCampaign");
		deleteCampaignURL.setParameter("redirect", currentURL);
		deleteCampaignURL.setParameter("campaignId", String.valueOf(c.getCampaignId()));
		%>
		
		<%
		PortletURL startCampaignURL = renderResponse.createActionURL();
		startCampaignURL.setWindowState(WindowState.MAXIMIZED);
		startCampaignURL.setParameter(ActionRequest.ACTION_NAME, "startCampaign");
		startCampaignURL.setParameter("redirect", currentURL);
		startCampaignURL.setParameter("campaignId", String.valueOf(c.getCampaignId()));
		%>
		
		<%
		PortletURL stopCampaignURL = renderResponse.createActionURL();
		stopCampaignURL.setWindowState(WindowState.MAXIMIZED);
		stopCampaignURL.setParameter(ActionRequest.ACTION_NAME, "stopCampaign");
		stopCampaignURL.setParameter("redirect", currentURL);
		stopCampaignURL.setParameter("campaignId", String.valueOf(c.getCampaignId()));
		%>
		
		<%
		PortletURL pauseCampaignURL = renderResponse.createActionURL();
		pauseCampaignURL.setWindowState(WindowState.MAXIMIZED);
		pauseCampaignURL.setParameter(ActionRequest.ACTION_NAME, "pauseCampaign");
		pauseCampaignURL.setParameter("redirect", currentURL);
		pauseCampaignURL.setParameter("campaignId", String.valueOf(c.getCampaignId()));
		%>
		
		<%
		PortletURL updateCampaignURL = renderResponse.createRenderURL();
		updateCampaignURL.setWindowState(WindowState.MAXIMIZED);
		updateCampaignURL.setParameter("mvcPath", "/advertising/edit_campaign.jsp");
		updateCampaignURL.setParameter("redirect", currentURL);
		updateCampaignURL.setParameter("campaignId", String.valueOf(c.getCampaignId()));
		%>
		<tr>
			<td><a href="<%= updateCampaignURL.toString() %>"><% if (smallImageUrl.length() > 0) { %><img src="<%= smallImageUrl %>" alt="campaignImage" class="campaignImage" /><% } %></a></td>
			<td><a href="<%= updateCampaignURL.toString() %>"><%= c.getCampaignId() %></a></td>
			<td><a href="<%= updateCampaignURL.toString() %>"><%= j.getTitle(locale) %></a></td>
			<td><a href="<%= updateCampaignURL.toString() %>"><%= df.format(c.getBeginDate()) %></a></td>
			<td><a href="<%= updateCampaignURL.toString() %>"><%= df.format(c.getEndDate()) %></a></td>
			<td>
				<a href="<%= updateCampaignURL.toString() %>"><% 	if (c.getCampaignStatus() == CampaignConstants.STATUS_ACTIVE) {%> 
						<liferay-ui:message key="active" />
					<% }
						if (c.getCampaignStatus() == CampaignConstants.STATUS_PAUSE) {%> 
						<liferay-ui:message key="pause" />
					<% }
						if (c.getCampaignStatus() == CampaignConstants.STATUS_INACTIVE) {
					%>
						<liferay-ui:message key="inactive" />
					<% } %>		
				</a>
			</td>
			<td class="campaign-action-buttons">
				<aui:button-row>
					<button name="startCampaign" type="button" class="<%= (c.getCampaignStatus() == CampaignConstants.STATUS_ACTIVE) ? "selected startCampaignButton" : "startCampaignButton" %>" onClick="location.href='<%= startCampaignURL.toString() %>'" <%= (c.getCampaignStatus() == CampaignConstants.STATUS_ACTIVE) ? "disabled='true'" : "" %>>
						<img src="<%= (c.getCampaignStatus() == CampaignConstants.STATUS_ACTIVE) ? portletURL+"/advertising/images/start-activated.png" : portletURL+"/advertising/images/start.png" %>" alt="start-campaign" />
					</button>
					<button name="pauseCampaign" type="button" class="<%= (c.getCampaignStatus() == CampaignConstants.STATUS_PAUSE) ? "selected pauseCampaignButton" : "pauseCampaignButton"%>" onClick="location.href='<%= pauseCampaignURL.toString() %>'" <%= (c.getCampaignStatus() == CampaignConstants.STATUS_PAUSE) ? "disabled='true'" : "" %>>
						<img src="<%= (c.getCampaignStatus() == CampaignConstants.STATUS_PAUSE) ? portletURL+"/advertising/images/pause-activated.png" : portletURL+"/advertising/images/pause.png" %>" alt="pause-campaign" />
					</button>
					<button name="stopCampaign" type="button" class="<%= (c.getCampaignStatus() == CampaignConstants.STATUS_INACTIVE) ? "selected stopCampaignButton" : "stopCampaignButton"%>" onClick="location.href='<%= stopCampaignURL.toString() %>'" <%= (c.getCampaignStatus() == CampaignConstants.STATUS_INACTIVE) ? "disabled='true'" : "" %>>
						<img src="<%= (c.getCampaignStatus() == CampaignConstants.STATUS_INACTIVE) ? portletURL+"/advertising/images/stop-activated.png" : portletURL+"/advertising/images/stop.png" %>" alt="stop-campaign" />
					</button>
					<button name="deleteCampaign" type="button" class="deleteCampaignButton" onClick="location.href='<%= deleteCampaignURL.toString() %>'">
						<img src="<%= portletURL+"/advertising/images/trash.png" %>" alt="delete-campaign" />
					</button>
				</aui:button-row>
			</td>
		</tr>
		<%
	}
	
	%>
	</table>
</div>
<%
} else {
%>
<span class="portlet-msg-info"><liferay-ui:message key="no-campaign-has-been-found" /></span>
<%
}
%>