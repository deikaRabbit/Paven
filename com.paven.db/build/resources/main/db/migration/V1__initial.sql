create table customer (
    id BIGINT generated by default as Identity,
    name varchar(32),
    sex smallint,
    tel varchar(16),
    address varchar(200),
    primary key (id)
);