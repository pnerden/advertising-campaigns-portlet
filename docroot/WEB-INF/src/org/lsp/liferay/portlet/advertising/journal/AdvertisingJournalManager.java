package org.lsp.liferay.portlet.advertising.journal;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portlet.journal.service.JournalArticleServiceUtil;

public class AdvertisingJournalManager {
	
	public static String getJournalArticleContent(long journalArticleId, String languageId) {
		
		String result = "";
		
		try {
			result = JournalArticleServiceUtil.getArticle(journalArticleId).getContentByLocale(languageId);
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		} catch (SystemException e) {
			_log.error(e.getMessage(), e);
		}
		
		return result;
		
	}
	
	private static Log _log = LogFactoryUtil.getLog(AdvertisingJournalManager.class);

}
