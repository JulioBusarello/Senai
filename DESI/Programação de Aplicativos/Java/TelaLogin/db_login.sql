create database if not exists db_login;

use db_login;

create table Login(
	id int(10) not null auto_increment primary key,
    user_login varchar(50) not null,
    password_login varchar(50) not null,
    nome_login varchar(50) not null
);

insert into Login (user_login, password_login, nome_Login) values ("julio", "teste1234", "juliobusarello");
INSERT INTO Login (id, user_login, password_login, nome_login) VALUES (2, "teste", "123", "teste");
