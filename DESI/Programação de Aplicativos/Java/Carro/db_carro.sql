create database if not exists db_carro;

use db_carro;

create table carro(
	cod_carro int primary key auto_increment,
    des_carro varchar(255) not null,
    pot_carro int not null,
    cor_carro varchar(40) not null
);