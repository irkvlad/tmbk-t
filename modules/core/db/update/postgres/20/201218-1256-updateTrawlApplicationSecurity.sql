--Update security for entity tmbkt$TrawlApplication

-- begin addSecGroupConstraintsForTrawlApplication
insert into SEC_CONSTRAINT (ID, CREATE_TS, CREATED_BY, ENTITY_NAME, JOIN_CLAUSE, WHERE_CLAUSE, GROUP_ID) values 
('736d91cf-1fbc-4a64-b406-d467cb97fb48', current_timestamp, 'admin', 'tmbkt$TrawlApplication', ', ts$CardAcl acl', '{E}.id = acl.card.id and (acl.user.id = :session$userId or acl.global = true)', '8e6306e2-9e10-414a-b437-24c91ffef804')^
insert into SEC_CONSTRAINT (ID, CREATE_TS, CREATED_BY, ENTITY_NAME, JOIN_CLAUSE, WHERE_CLAUSE, GROUP_ID) values 
('bd4b0c66-1c4a-420d-843c-70857a442d39', current_timestamp, 'admin', 'tmbkt$TrawlApplication', ', ts$CardAcl acl', '{E}.id = acl.card.id and (acl.user.id = :session$userId or acl.department.id in (:session$departmentIds) or acl.global = true)', '8d9ba07c-9ffa-11e1-b99d-8fc5b41c7fbb')^
insert into SEC_CONSTRAINT (ID, CREATE_TS, CREATED_BY, ENTITY_NAME, JOIN_CLAUSE, WHERE_CLAUSE, GROUP_ID) values 
('7c15f0ff-4076-4371-b836-0471ac813939', current_timestamp, 'admin', 'tmbkt$TrawlApplication', ', ts$CardAcl acl', '{E}.id = acl.card.id and (acl.user.id = :session$userId or acl.department.id in (:session$departmentIds) or acl.global = true)', '9fa89a54-9ffa-11e1-b13e-9f4a54bff17e')^
insert into SEC_CONSTRAINT (ID, CREATE_TS, CREATED_BY, ENTITY_NAME, JOIN_CLAUSE, WHERE_CLAUSE, GROUP_ID) values 
('d1c3ff94-b193-4f84-a703-5f64a469af70', current_timestamp, 'admin', 'tmbkt$TrawlApplication', ', ts$CardAcl acl', '{E}.id = acl.card.id and (acl.user.id = :session$userId or acl.global = true)', '9e44a053-a31f-4edd-b19b-39e942161dd2')^
insert into SEC_CONSTRAINT (ID, CREATE_TS, CREATED_BY, ENTITY_NAME, JOIN_CLAUSE, WHERE_CLAUSE, GROUP_ID) values 
('b6cbc78e-ae6f-474c-961b-dc53277f710a', current_timestamp, 'admin', 'tmbkt$TrawlApplication', 'join {E}.aclList acl', '({E}.docOfficeData.officeFile.state >= 30 and {E}.template = false or (acl.user.id = :session$userId or acl.global = true))', 'cff945e4-e363-0dc0-d70d-4b5bdb2a2269')^

-- end addSecGroupConstraintsForTrawlApplication

insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'tmbkt$TrawlApplication:create',0,(select ID from SEC_ROLE where NAME = 'SimpleUser'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'tmbkt$TrawlApplication:update',0,(select ID from SEC_ROLE where NAME = 'SimpleUser'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'tmbkt$TrawlApplication:delete',0,(select ID from SEC_ROLE where NAME = 'SimpleUser'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'tmbkt$TrawlApplication:create',1,(select ID from SEC_ROLE where NAME = 'Administrators'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'tmbkt$TrawlApplication:update',1,(select ID from SEC_ROLE where NAME = 'Administrators'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'tmbkt$TrawlApplication:delete',1,(select ID from SEC_ROLE where NAME = 'Administrators'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'tmbkt$TrawlApplication:create',1,(select ID from SEC_ROLE where NAME = 'doc_initiator'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'tmbkt$TrawlApplication:update',1,(select ID from SEC_ROLE where NAME = 'doc_initiator'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'tmbkt$TrawlApplication:delete',1,(select ID from SEC_ROLE where NAME = 'doc_initiator'));
