-- begin TMBKT_TECHNICS
create table TMBKT_TECHNICS (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CODE varchar(6) not null,
    NOMINATION varchar(100) not null,
    MODEL varchar(100),
    COMAR varchar(64),
    SERIAL_NUMBER varchar(64),
    SECOND_HAND boolean,
    WEIGHT decimal(10, 3),
    WIDTH decimal(10, 3),
    LENGTH decimal(10, 3),
    DEPTH decimal(10, 3),
    WEIGHT_REAL decimal(10, 3),
    WIDTH_REAL decimal(10, 3),
    LENGTH_REAL decimal(10, 3),
    DEPTH_REAL decimal(10, 3),
    --
    primary key (ID)
)^
-- end TMBKT_TECHNICS
-- begin TMBKT_TRAWL_APPLICATION
create table TMBKT_TRAWL_APPLICATION (
    CARD_ID uuid,
    --
    CUSTOMER_ID uuid,
    SHIPPER_ID uuid,
    CONSIGNEE_ID uuid,
    EQUIPMENT_NAME_ID uuid,
    PASSING_CARGO boolean not null,
    POINT_DEPARTURE varchar(255),
    POINT_DESTINATION varchar(255),
    CONTACT_PERSON_SHIPMENT_ID uuid,
    CONTACT_PERSON_UNLOADING_ID uuid,
    CATEGIRY_TRALL_APPLICATION varchar(50),
    DATE_DISPATCH_FACT timestamp,
    ARRIVAL_DATE_FACT timestamp,
    TRANSPORTATION_COST double precision,
    DESIRED_TRANSPORTATION_COST double precision,
    DESIRED_DELIVERY_TIME date,
    DESIRED_DATE_SHIPMENT date,
    SPECIFY_CHARACTERISTICS boolean,
    OUR_TRAWL boolean,
    TRANSPORTATION_EQUIPMENT boolean,
    THE_NEED_USE_CRANE boolean,
    NUMBER_SEATS integer,
    ADDITIONAL_CARGO varchar(255),
    ADDITIONAL_WEIGHT double precision,
    ADDITIONAL_LOAD_LENGTH double precision,
    ADDITIONAL_LOAD_WIDTH double precision,
    ADDITIONAL_LOAD_HEIGHT double precision,
    THIRD_PARTY_CARRIER boolean,
    THIRD_PARTY_CARRIER_NAME_ID uuid,
    SPECIFY_DIMENSIONS boolean,
    --
    primary key (CARD_ID)
)^^-- end TMBKT_TRAWL_APPLICATION
--Add default numerator for tmbkt$TrawlApplication
CREATE OR REPLACE FUNCTION baseInsert()
RETURNS integer
AS $$
DECLARE
    cnt integer = 0;
BEGIN
cnt = (select count(id) from DF_NUMERATOR where CODE = 'TrawlApplicationNumerator' and delete_ts is null);
if(cnt = 0) then
    INSERT INTO DF_NUMERATOR (ID, CREATE_TS, CREATED_BY, VERSION, CODE, NUMERATOR_FORMAT, SCRIPT_ENABLED,
    PERIODICITY, NUMBER_INITIAL_VALUE, LOC_NAME)
    VALUES ('f603896a-e38a-416a-bed4-97ba552e4d5a', now(), 'system', 1, 'TrawlApplicationNumerator', '[number]', FALSE, 'Y', 1,
    '{"captionWithLanguageList":[{"language":"ru","caption":"TrawlApplication"},{"language":"en","caption":"TrawlApplication"}]}'
    );
end if;
return 0;
END;
$$
LANGUAGE plpgsql;
^
select baseInsert()^
drop function if exists baseInsert()^
--Insert new doc type for tmbkt$TrawlApplication
insert into TS_CARD_TYPE (ID, CREATE_TS, CREATED_BY, NAME, DISCRIMINATOR,FIELDS_XML) values ('3e168f65-ef7d-499c-b5ef-10a169e6a07f', current_timestamp, 'admin', 'tmbkt$TrawlApplication', 1100, '')^
--Add default doc kind for tmbkt$TrawlApplication
CREATE OR REPLACE FUNCTION baseInsert()
RETURNS integer
AS $$
DECLARE
cnt integer = 0;
BEGIN
cnt = (select count(CATEGORY_ID) from DF_DOC_KIND where category_id = '03993b08-f8b4-414a-9f50-9cb70e827387');
if(cnt = 0) then
    insert into SYS_CATEGORY (ID, NAME, ENTITY_TYPE, IS_DEFAULT, CREATE_TS, CREATED_BY, VERSION, DISCRIMINATOR)
    values ( '03993b08-f8b4-414a-9f50-9cb70e827387', 'Заявка на трал', 'tmbkt$TrawlApplication', false, now(), USER, 1, 1);
    insert into DF_DOC_KIND (category_id, create_ts, created_by, version, doc_type_id, numerator_id, 
    numerator_type, category_attrs_place, tab_name, portal_publish_allowed, disable_add_process_actors, create_only_by_template)
    values ('03993b08-f8b4-414a-9f50-9cb70e827387', 'now()', 'admin', 1, '3e168f65-ef7d-499c-b5ef-10a169e6a07f', 'f603896a-e38a-416a-bed4-97ba552e4d5a', 
    1, 1, 'Ð”Ð¾Ð¿. Ð¿Ð¾Ð»Ñ�', false, false, false);
end if;return 0;
END;
$$
LANGUAGE plpgsql;
^
select baseInsert();
^
drop function if exists baseInsert()^
--Update process card_types for entity tmbkt$TrawlApplication
update wf_proc set card_types = regexp_replace(card_types, E',tmbkt\\$TrawlApplication', '') where code in ('Endorsement','Resolution','Acquaintance','Registration')^
update wf_proc set updated_by='admin', card_types = card_types || 'tmbkt$TrawlApplication,' where code in ('Endorsement','Resolution','Acquaintance','Registration')^
--Update security for entity tmbkt$TrawlApplication
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'tmbkt$TrawlApplication:create',0,(select ID from SEC_ROLE where NAME = 'SimpleUser'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'tmbkt$TrawlApplication:update',0,(select ID from SEC_ROLE where NAME = 'SimpleUser'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'tmbkt$TrawlApplication:delete',0,(select ID from SEC_ROLE where NAME = 'SimpleUser'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'tmbkt$TrawlApplication:create',1,(select ID from SEC_ROLE where NAME = 'Administrators'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'tmbkt$TrawlApplication:update',1,(select ID from SEC_ROLE where NAME = 'Administrators'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'tmbkt$TrawlApplication:delete',1,(select ID from SEC_ROLE where NAME = 'Administrators'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'tmbkt$TrawlApplication:create',1,(select ID from SEC_ROLE where NAME = 'doc_initiator'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'tmbkt$TrawlApplication:update',1,(select ID from SEC_ROLE where NAME = 'doc_initiator'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'tmbkt$TrawlApplication:delete',1,(select ID from SEC_ROLE where NAME = 'doc_initiator'));
