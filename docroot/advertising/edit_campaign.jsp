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
List<JournalArticle> articles = CampaignManagementPortletUtil.getArticleList(companyId);

if (articles.size() <= 0) {
	%>
	<span class="portlet-msg-info"><liferay-ui:message key="you-must-publish-an-article-in-the-global-site-before-you-create-a-campaign" /></span>
	<%
} else {

	String redirect = ParamUtil.getString(request, "redirect");
	System.out.println(redirect);
	long campaignId = ParamUtil.getLong(request, "campaignId");
	
	String redirectError = ParamUtil.getString(request, CampaignConstants.REDIRECT_ERROR_HEADER);
	if (redirectError.length() > 0) {
		if (redirectError.equals(CampaignConstants.REDIRECT_ERROR_NO_JOURNAL_ARTICLE_HAS_BEEN_SELECTED)) {
			%>
			<span class="portlet-msg-error"><liferay-ui:message key="you-have-not-selected-an-article" /></span>
			<%
		}
	}
	
	Campaign c = null;
	
	try {
		c = CampaignServiceUtil.getCampaign(campaignId);
	} catch (NoSuchCampaignException e) {
		
	}
	
	long journalArticlePrimaryKey = 0;
	Calendar beginDate = CalendarFactoryUtil.getCalendar(timeZone, locale);
	Calendar endDate = CalendarFactoryUtil.getCalendar(timeZone, locale);
	
	if (c!= null) {
		journalArticlePrimaryKey = c.getJournalArticlePrimaryKey();
		if (c.getBeginDate() != null) {
			beginDate.setTime(c.getBeginDate());
			endDate.setTime(c.getBeginDate());
		}
		if (c.getEndDate() != null) {
			endDate.setTime(c.getEndDate());
		}
		%>
		<liferay-ui:message key="edit-campaign" />
		<%
	} else {
		%>
		<liferay-ui:message key="new-campaign" />
		<%
	}
	
	%>
	<form action="<portlet:actionURL name="updateCampaign"><portlet:param name="redirect" value="<%= redirect %>" /></portlet:actionURL>" enctype="multipart/form-data" method="post" name="<portlet:namespace />fm" onSubmit="<portlet:namespace />updateCampaign(); return false;">	
		<aui:layout>
			<aui:column columnWidth="50" first="true">
			
				<input name="<portlet:namespace />campaignId" type="hidden" value="<%= campaignId %>" />
				<input type="hidden" id="<portlet:namespace />journalArticlePrimaryKey" name="<portlet:namespace />journalArticlePrimaryKey" value="<%= journalArticlePrimaryKey %>" />
				
				<table class="lfr-table">
					<tr>
						<td>
							<liferay-ui:message key="start-date" />
						</td>
						<td>
							<liferay-ui:input-field bean="<%= c %>" defaultValue="<%= beginDate %>" field="beginDate" model="<%= Campaign.class %>" />
						</td>
					</tr>
					<tr>
						<td>
							<liferay-ui:message key="end-date" />
						</td>
						<td>
							<liferay-ui:input-field bean="<%= c %>" defaultValue="<%= endDate %>" field="endDate" model="<%= Campaign.class %>" />
						</td>
					</tr>
				</table>
				
				<br />
			
			</aui:column>
			<aui:column columnWidth="50" last="true">
				<span class="portlet-msg-info"><liferay-ui:message key="select-an-existing-article-or-add-an-article-to-be-displayed-in-this-portlet" /></span>
				<table id="<portlet:namespace />_articles_" class="lfr-table campaign-articles">
					<tr>
						<th><liferay-ui:message key="id" /></th>
						<th><liferay-ui:message key="title" /></th>
						<th><liferay-ui:message key="author" /></th>
						<th><liferay-ui:message key="version" /></th>
						<th><liferay-ui:message key="small-image" /></th>
						<th><liferay-ui:message key="action" /></th>
					</tr>
					<%
					Iterator<JournalArticle> iter = articles.iterator();
					while (iter.hasNext()) {
						JournalArticle j = iter.next();
						long currentArticleId = Long.parseLong(j.getArticleId());
						String smallImageUrl = CampaignUtil.getSmallImageURL(j);
					%>
					<tr id="<portlet:namespace />_article_<%= currentArticleId %>" class="<%= (journalArticlePrimaryKey == currentArticleId) ? "selected" : "" %>">
						<td><%= currentArticleId%></td>
						<td><%= j.getTitle(locale) %></td>
						<td><%= j.getUserName() %></td>
						<td><%= j.getVersion() %></td>
						<td><% if (smallImageUrl.length() > 0) { %><img src="<%= smallImageUrl %>" alt="journalArticleImage" class="journalArticleImage" /><% } %></td>
						<td><button name="selectArticle" type="button" onClick="<portlet:namespace />selectJournalArticle(<%= currentArticleId%>)"><liferay-ui:message key="select-this-article" /></button></td>
					</tr>	
					<%
					}
					%>
				</table>
			</aui:column>
		
		</aui:layout>
		
		<aui:button-row>
			<input type="submit" value="<liferay-ui:message key="save" />" />
			<input type="button" value="<liferay-ui:message key="cancel" />" onClick="location.href = '<%= HtmlUtil.escape(PortalUtil.escapeRedirect(redirect)) %>';" />
		</aui:button-row>
	</form>
	
	<aui:script>
		function <portlet:namespace />updateCampaign() {
			submitForm(document.<portlet:namespace />fm);
		};
		
		<portlet:namespace />selectJournalArticle = function(articleId) {
			var children = document.getElementById('<portlet:namespace />_articles_').getElementsByTagName('tr');
			for (var i=0;i<children.length;i++) {
				children[i].className="";
			}
			document.getElementById('<portlet:namespace />journalArticlePrimaryKey').value=articleId;
			document.getElementById('<portlet:namespace />_article_'+articleId).className="selected";
		};
	</aui:script>

<%	
}
%>