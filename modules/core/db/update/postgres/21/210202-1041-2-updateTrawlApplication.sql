alter table TMBKT_TRAWL_APPLICATION add column LOADER_L varchar(50) ;
alter table TMBKT_TRAWL_APPLICATION add column LOADER_U varchar(50) ;
alter table TMBKT_TRAWL_APPLICATION drop column LOADER cascade ;
