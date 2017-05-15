drop table contacts;
create table contacts (
    id BIGINT identity
    ,firstName varchar(20)
    ,lastName varchar(30)
    ,phoneNumber varchar(13)
    ,emailAddress varchar(64)
);