package org.lsp.liferay.portlet.advertising.portlet;

import java.util.Calendar;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.lsp.liferay.portlet.advertising.CampaignEndDateException;
import org.lsp.liferay.portlet.advertising.CampaignStartDateException;
import org.lsp.liferay.portlet.advertising.service.CampaignServiceUtil;
import org.lsp.liferay.portlet.advertising.util.CampaignConstants;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class CampaignManagementPortlet extends MVCPortlet {
	
	private static final String EDIT_CAMPAIGN_URL = "/advertising/edit_campaign.jsp";

	public void updateCampaign(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
				
		long campaignId = ParamUtil.getLong(uploadPortletRequest,"campaignId");
		long journalArticlePrimaryKey = ParamUtil.getLong(uploadPortletRequest,"journalArticlePrimaryKey");
		
		if (journalArticlePrimaryKey > 0) {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			User user = UserLocalServiceUtil.getUserById(themeDisplay.getUserId());
			
			int beginDateMonth = ParamUtil.getInteger(uploadPortletRequest,"beginDateMonth");
			int beginDateDay = ParamUtil.getInteger(uploadPortletRequest,"beginDateDay");
			int beginDateYear = ParamUtil.getInteger(uploadPortletRequest,"beginDateYear");
			int beginDateHour = ParamUtil.getInteger(uploadPortletRequest,"beginDateHour");
			int beginDateMinute = ParamUtil.getInteger(uploadPortletRequest,"beginDateMinute");
			int beginDateAmPm = ParamUtil.getInteger(uploadPortletRequest,"beginDateAmPm");
	
			if (beginDateAmPm == Calendar.PM) {
				beginDateHour += 12;
			}
			
			Date beginDate = PortalUtil.getDate(beginDateMonth, beginDateDay, beginDateYear, beginDateHour, beginDateMinute,
								user.getTimeZone(), CampaignStartDateException.class);
			
			int endDateMonth = ParamUtil.getInteger(uploadPortletRequest,"endDateMonth");
			int endDateDay = ParamUtil.getInteger(uploadPortletRequest,"endDateDay");
			int endDateYear = ParamUtil.getInteger(uploadPortletRequest,"endDateYear");
			int endDateHour = ParamUtil.getInteger(uploadPortletRequest,"endDateHour");
			int endDateMinute = ParamUtil.getInteger(uploadPortletRequest,"endDateMinute");
			int endDateAmPm = ParamUtil.getInteger(uploadPortletRequest,"endDateAmPm");
	
			if (endDateAmPm == Calendar.PM) {
				endDateHour += 12;
				System.out.println("Bullshit !!");
			}
			
			Date endDate = PortalUtil.getDate(endDateMonth, endDateDay, endDateYear, endDateHour, endDateMinute,
					user.getTimeZone(), CampaignEndDateException.class);
			
			System.out.println(endDate.toString());
			
			if (campaignId <= 0) {		
				CampaignServiceUtil.createCampaign(journalArticlePrimaryKey, beginDate, endDate);
			} else {
				CampaignServiceUtil.updateCampaign(campaignId, journalArticlePrimaryKey, beginDate, endDate);
			}
		} else {
			String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),portletName,themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
			redirectURL.setParameter("jspPage", EDIT_CAMPAIGN_URL);
			redirectURL.setParameter("redirect", ParamUtil.getString(actionRequest, "redirect"));
			redirectURL.setParameter(CampaignConstants.REDIRECT_ERROR_HEADER, CampaignConstants.REDIRECT_ERROR_NO_JOURNAL_ARTICLE_HAS_BEEN_SELECTED);
			actionRequest.setAttribute(WebKeys.REDIRECT ,redirectURL.toString());
			sendRedirect(actionRequest, actionResponse);
			throw(new PortalException("No article has been selected"));
		}
		
	}
	
	public void deleteCampaign(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		CampaignServiceUtil.removeCampaign(ParamUtil.getLong(uploadPortletRequest,"campaignId"));
	}

	public void startCampaign(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		CampaignServiceUtil.startCampaign(ParamUtil.getLong(uploadPortletRequest,"campaignId"));
	}
	
	public void stopCampaign(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		CampaignServiceUtil.stopCampaign(ParamUtil.getLong(uploadPortletRequest,"campaignId"));
	}
	
	public void pauseCampaign(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		CampaignServiceUtil.pauseCampaign(ParamUtil.getLong(uploadPortletRequest,"campaignId"));
	}
	
}
