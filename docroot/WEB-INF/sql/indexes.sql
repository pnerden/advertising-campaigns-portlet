create index IX_6393495F on LSPAC_Campaign (campaignId, companyId);
create index IX_10EE31BE on LSPAC_Campaign (companyId);
create index IX_CC1CE025 on LSPAC_Campaign (companyId, campaignActivated, beginDate, endDate);
create index IX_65E0D3E6 on LSPAC_Campaign (companyId, campaignStatus, beginDate, endDate);

create index IX_7759CB03 on LSPAC_CampaignLog (campaignId, companyId);
create index IX_38E9703D on LSPAC_CampaignLog (campaignId, companyId, userId);
create index IX_E185B10F on LSPAC_CampaignLog (campaignLogId, companyId);