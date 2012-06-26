package org.lsp.liferay.portlet.advertising.util;

import java.util.List;

import org.lsp.liferay.portlet.advertising.model.Campaign;
import org.lsp.liferay.portlet.advertising.service.CampaignLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleServiceUtil;

public class CampaignUtil {
	
	private static final String SMALL_IMAGE_URL_PATTERN = "/image/journal/article?img_id={i}";
	private static final String GLOBAL_GROUP_URL = "/null"; 
	
	public static long campaignLottery(List<Campaign> campaignList) {
		
		int size = campaignList.size();
		
		if (size == 0) {
			return 0;
		}
		
		if (size == 1) {
			return campaignList.get(0).getCampaignId();
		}
		
		int random = (int)(Math.random() * (size));
		
		return campaignList.get(random).getCampaignId();
		
	}

	public static long getGlobalGroupId(long companyId) throws SystemException { 
		return GroupLocalServiceUtil.fetchFriendlyURLGroup(companyId, GLOBAL_GROUP_URL).getGroupId();
	}
	
	public static JournalArticle getJournalArticle(long companyId, long campaignId) throws PortalException, SystemException {
		return JournalArticleServiceUtil.getArticle(getGlobalGroupId(companyId), String.valueOf(CampaignLocalServiceUtil.getCampaign(companyId, campaignId).getJournalArticlePrimaryKey()));
	}
	
	public static String getSmallImageURL(Campaign c) throws SystemException, PortalException {
		JournalArticle j = getJournalArticle(c.getCompanyId(), c.getCampaignId());
//		String content = j.getContentByLocale(UserLocalServiceUtil.getUser(Long.valueOf(request.getRemoteUser())).getLocale().toString());
//		System.out.println(content);
//		DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//		Document document = (Document) parser.parse(new InputSource(new StringReader(content)));
//		document.getDocumentElement().normalize();
//		System.out.println(document.getFirstChild().getFirstChild().getTextContent());
//		Node rootNode = ((Element) document).getElementsByTagName("root").item(0);
//		System.out.println(rootNode.getTextContent());
//		Node contentNode = ((Element) rootNode).getElementsByTagName("static-content").item(0);
//		System.out.println(contentNode.getTextContent());
//		content = contentNode.getNodeValue().trim();
//		System.out.println(content);
		return getSmallImageURL(j);
	}
	
	public static String getSmallImageURL(JournalArticle j) {
		String result = "";
		if (j.getSmallImage()) {
			if (j.getSmallImageURL().length() > 0) {
				result = j.getSmallImageURL();
			} else {
				result = SMALL_IMAGE_URL_PATTERN.replaceAll("\\{i\\}", String.valueOf(j.getSmallImageId()));
			}
		}
		return result;
	}
	
}