alter table TMBKT_TRAWL_APPLICATION add constraint FK_TMBKT_TRAWL_APPLICATION_CONSIGNEE_ID foreign key (CONSIGNEE_ID) references DF_CONTRACTOR(CORRESPONDENT_ID);
create index IDX_TMBKT_TRAWL_APPLICATION_CONSIGNEE on TMBKT_TRAWL_APPLICATION (CONSIGNEE_ID);
