alter table TMBKT_TRAWL_APPLICATION add column CTA_STATE uuid ;
alter table TMBKT_TRAWL_APPLICATION drop column CATEGORY_TRAL cascade ;
