create table DOCUMENT (
    ID bigint primary key,
    TYPE int,
    NUMBER varchar,
    ISSUER varchar,
    ISSUE_DATE timestamp,
    EXPIRATION_DATE timestamp,
    PERSON_ID int,
    constraint FK_PERSON_ID foreign key (PERSON_ID) references PERSON (ID)
);