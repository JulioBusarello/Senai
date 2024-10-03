create database db_cliente;

use db_cliente;

create table cliente(
	id int not null primary key,
    nome varchar(45) not null,
    telefone varchar(16) not null,
    email varchar(100) not null,
    endereco varchar(150) not null
);

select * from cliente;