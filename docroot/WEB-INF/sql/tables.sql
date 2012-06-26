create table LSPAC_Campaign (
	companyId LONG,
	campaignId LONG not null primary key,
	journalArticlePrimaryKey LONG,
	beginDate DATE null,
	endDate DATE null,
	campaignStatus INTEGER
);

create table LSPAC_CampaignLog (
	campaignLogId LONG not null primary key,
	companyId LONG,
	campaignId LONG,
	userId LONG
);