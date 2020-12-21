alter table TMBKT_TRAWL_APPLICATION add column PASSING_CARGO boolean not null default false ;
alter table TMBKT_TRAWL_APPLICATION add column POINT_DEPARTURE varchar(255) ;
alter table TMBKT_TRAWL_APPLICATION add column POINT_DESTINATION varchar(255) ;
alter table TMBKT_TRAWL_APPLICATION add column CONTACT_PERSON_SHIPMENT_ID uuid ;
alter table TMBKT_TRAWL_APPLICATION add column CONTACT_PERSON_UNLOADING_ID uuid ;
