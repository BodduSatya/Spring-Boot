create database social_app;

\c social_app;


create table user_master
(
    user_id serial,
    user_name varchar not null,
    status char default 1,
    password varchar
);

create unique index user_master_user_id_uindex
	on user_master (user_id);

alter table user_master
    add constraint user_master_pk
        primary key (user_id);

