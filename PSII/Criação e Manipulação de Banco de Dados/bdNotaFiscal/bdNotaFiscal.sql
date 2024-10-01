drop database bdnotafiscal;

create database bdnotafiscal;

use bdnotafiscal;

create table Cliente(
	idCliente integer not null,
    nome varchar(45) not null,
    endereco varchar(150) not null,
    constraint idCliente_pk primary key (idCliente)
);

create table Vendedor(
	idVendedor integer not null,
    nome varchar(45) not null,
    constraint idVendedor_pk primary key (idVendedor)
);

create table Produto(
	idProduto integer not null,
    descricao varchar(250) not null,
    unidade varchar(2) not null,
    preco decimal not null,
    constraint idProduto_pk primary key (idProduto)
);

create table NotaFiscal(
	idNotaFiscal integer not null,
    dataEmissao date not null,
    totalNota decimal not null,
    idCliente int not null,
    idVendedor int not null,
    constraint idNotaFiscal_pk primary key (idNotaFiscal),
    constraint Cliente_idCliente_fk foreign key (idCliente) references Cliente (idCliente),
    constraint Vendedor_idVendedor_fk foreign key (idVendedor) references Vendedor (idVendedor)
);

create table ItemNotaFiscal(
	idNotaFiscal integer not null,
    idProduto integer not null,
    quantidade integer not null,
    precoProduto decimal not null,
    totalProduto decimal not null,
    constraint NotaFiscal_idNotaFiscal_fk foreign key (idNotaFiscal) references NotaFiscal (idNotaFiscal),
    constraint Produto_idProduto_fk foreign key (idProduto) references Produto (idProduto)
);