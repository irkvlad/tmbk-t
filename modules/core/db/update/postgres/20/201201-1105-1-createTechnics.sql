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
    WEIGHT decimal(10, 3),
    WIDTH decimal(10, 3),
    LENGTH decimal(10, 3),
    DEPTH decimal(10, 3),
    SECOND_HAND boolean,
    --
    primary key (ID)
);
