alter table TMBKT_TRAWL_APPLICATION add constraint FK_TMBKT_TRAWL_APPLICATION_CUSTOMER_ID foreign key (CUSTOMER_ID) references DF_CONTRACTOR(CORRESPONDENT_ID);
create index IDX_TMBKT_TRAWL_APPLICATION_CUSTOMER on TMBKT_TRAWL_APPLICATION (CUSTOMER_ID);
