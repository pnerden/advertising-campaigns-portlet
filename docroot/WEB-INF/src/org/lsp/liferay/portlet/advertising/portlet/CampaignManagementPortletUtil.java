package org.lsp.liferay.portlet.advertising.portlet;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.lsp.liferay.portlet.advertising.util.CampaignUtil;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class CampaignManagementPortletUtil {

	@SuppressWarnings("unchecked")
	public static List<JournalArticle> getArticleList(long companyId) throws SystemException, PortalException {
		
		long groupId = CampaignUtil.getGlobalGroupId(companyId);
		
		List<JournalArticle> result = new Vector<JournalArticle>();
				
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalArticle.class, PortalClassLoaderUtil.getClassLoader())
				.add(PropertyFactoryUtil.forName("companyId").eq(companyId))
				.add(PropertyFactoryUtil.forName("groupId").eq(groupId))
				.add(PropertyFactoryUtil.forName("status").eq(WorkflowConstants.STATUS_APPROVED))
				.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("resourcePrimKey")));
		List<Long> primaryKeys = JournalArticleLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		Iterator<Long> iter = primaryKeys.iterator();
		while (iter.hasNext()) {
			result.add(JournalArticleLocalServiceUtil.getLatestArticle(iter.next(), WorkflowConstants.STATUS_APPROVED, true));
		}
		
		return result;
	}
	
}