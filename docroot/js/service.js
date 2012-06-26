Liferay.Service.register("Liferay.Service.LSPLA", "org.lsp.liferay.portlet.advertising.service", "advertising-campaigns-portlet");

Liferay.Service.registerClass(
	Liferay.Service.LSPLA, "Campaign",
	{
		getJournalArticleIdToDisplay: true,
		createCampaign: true,
		getCampaign: true,
		getCampaigns: true,
		removeCampaign: true,
		updateCampaign: true,
		startCampaign: true,
		pauseCampaign: true,
		stopCampaign: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.LSPLA, "CampaignLog",
	{
		markDisplayed: true,
		clearCampaign: true
	}
);

Liferay.Service.register("Liferay.Service.LSPAC", "org.lsp.liferay.portlet.advertising.service", "advertising-campaigns-portlet");

Liferay.Service.registerClass(
	Liferay.Service.LSPAC, "Campaign",
	{
		getCampaignIdToDisplay: true,
		createCampaign: true,
		getCampaign: true,
		getCampaigns: true,
		removeCampaign: true,
		updateCampaign: true,
		startCampaign: true,
		pauseCampaign: true,
		stopCampaign: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.LSPAC, "CampaignLog",
	{
		markDisplayed: true,
		clearCampaign: true
	}
);