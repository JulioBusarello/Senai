create database if not exists db_produto;

use db_produto;

create table produto(
	idProduto int auto_increment primary key,
    descricao varchar(255) not null,
    preco float not null
);

create table pedido(
	idPedido int auto_increment primary key,
    data_Pedido date not null,
    id_Produto int not null,
    constraint produto_idProduto_pedido_fk foreign key (id_Produto) references produto(idProduto)
);