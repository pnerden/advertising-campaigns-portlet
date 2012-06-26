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

<%@ include file="/html/common/advertising/init.jsp" %>

<%
if (session.getAttribute("advertising-campaign-journal-article-id") != null) {

	long journalArticleIdToDisplay = Long.valueOf(session.getAttribute("advertising-campaign-journal-article-id").toString());
	
	if (journalArticleIdToDisplay > 0) {

	%>
	
	<script type="text/javascript" src="/html/common/advertising/advertisement.js"></script>
	<link rel="stylesheet" type="text/css" href="/html/common/advertising/advertisement.css" />
	
	<%
		try {
			long globalGroupId = GroupLocalServiceUtil.fetchFriendlyURLGroup(companyId, "/null").getGroupId();
			JournalArticle j = JournalArticleServiceUtil.getArticle(globalGroupId, String.valueOf(journalArticleIdToDisplay));
			String content = j.getContentByLocale(UserLocalServiceUtil.getUser(10196).getLocale().toString());
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = db.parse(new InputSource(new StringReader(content)));
			document.getDocumentElement().normalize();
			content = document.getFirstChild().getTextContent().trim();
	%>
	
	<aui:script>
		addObject = new LSPADD('<%= content %>');
	</aui:script>
	
	<%
			
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			session.removeAttribute("advertising-campaign-journal-article-id");
		}
	}
}
%>