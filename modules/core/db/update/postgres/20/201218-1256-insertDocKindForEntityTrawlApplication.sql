--Add default doc kind for tmbkt$TrawlApplication
CREATE OR REPLACE FUNCTION baseInsert()
RETURNS integer
AS $$
DECLARE
cnt integer = 0;
BEGIN
cnt = (select count(CATEGORY_ID) from DF_DOC_KIND where category_id = 'a3376fdb-42e0-4990-a6b9-c5acf2fc9976');
if(cnt = 0) then
    insert into SYS_CATEGORY (ID, NAME, ENTITY_TYPE, IS_DEFAULT, CREATE_TS, CREATED_BY, VERSION, DISCRIMINATOR)
    values ( 'a3376fdb-42e0-4990-a6b9-c5acf2fc9976', 'Заявка на трал', 'tmbkt$TrawlApplication', false, now(), USER, 1, 1);

    insert into DF_DOC_KIND (category_id, create_ts, created_by, version, doc_type_id, numerator_id, 
    numerator_type, category_attrs_place, tab_name, portal_publish_allowed, disable_add_process_actors, create_only_by_template)
    values ('a3376fdb-42e0-4990-a6b9-c5acf2fc9976', 'now()', 'admin', 1, 'c02d5f9d-9910-446d-8cd2-a06829de85e8', '2f06085d-2617-4ef2-a9c0-9bf1e1ca5d41', 
    1, 1, 'Ð”Ð¾Ð¿. Ð¿Ð¾Ð»Ñ�', false, false, false);
end if;return 0;

END;
$$
LANGUAGE plpgsql;
^
select baseInsert();
^
drop function if exists baseInsert()^
