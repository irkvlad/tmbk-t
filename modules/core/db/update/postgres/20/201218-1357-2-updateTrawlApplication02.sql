alter table TMBKT_TRAWL_APPLICATION add constraint FK_TMBKT_TRAWL_APPLICATION_SHIPPER_ID foreign key (SHIPPER_ID) references DF_COMPANY(CONTRACTOR_ID);
create index IDX_TMBKT_TRAWL_APPLICATION_SHIPPER on TMBKT_TRAWL_APPLICATION (SHIPPER_ID);
