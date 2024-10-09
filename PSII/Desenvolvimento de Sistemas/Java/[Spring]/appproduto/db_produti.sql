create database db_produto;

use db_produto;

create table produto(
	id int auto_increment primary key,
    descricao varchar(255) not null,
    preco float not null
);