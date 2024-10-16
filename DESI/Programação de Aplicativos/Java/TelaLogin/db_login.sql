create database if not exists db_login;
use db_login;

create table Login(
	id int(10) not null auto_increment primary key,
    user_login varchar(50) not null,
    password_login varchar(50) not null,
    nome_login varchar(50) not null
);

INSERT INTO Login (id, user_login, password_login, nome_login) VALUES (1, "admin", "admin123", "admin");
