-- drop database if exists db_cad;

create database db_cad;

use db_cad;

create table cliente(
	id int not null primary key,
    nome varchar(45) not null,
    telefone varchar(16) not null,
    email varchar(100) not null,
    endereco varchar(150) not null
);

create table fornecedor(
	id int not null primary key,
    contato varchar(60) not null,
    telefone varchar(16) not null,
    email varchar(70) not null,
    empresa varchar(50) not null
);

create table produto(
	id int not null primary key,
    preco decimal(10,2) not null,
    unidade varchar(45) not null,
    quantidade int not null,
    descricao varchar(255) not null
);

select * from cliente;
select * from fornecedor;
select * from produto;