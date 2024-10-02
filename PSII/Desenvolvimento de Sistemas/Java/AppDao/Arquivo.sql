create database db_dao;

use db_dao;

create table users(
	id int auto_increment primary key,
    name varchar(255) not null,
    email varchar(255) not null
);

select * from users;