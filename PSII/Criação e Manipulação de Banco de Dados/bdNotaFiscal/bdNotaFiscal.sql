drop database bdnotafiscal;

create database bdnotafiscal;

use bdnotafiscal;

create table Cliente(
	idCliente integer not null primary key,
    nome varchar(45) not null,
    endereco varchar(150) not null
);

create table Vendedor(
	idVendedor integer not null primary key ,
    nome varchar(45) not null
);

create table Produto(
	idProduto integer not null primary key ,
    descricao varchar(250) not null,
    unidade varchar(2) not null,
    preco decimal not null
);

create table NotaFiscal(
	idNotaFiscal integer not null primary key,
    dataEmissao date not null,
    totalNota decimal not null,
    idCliente int not null,
    idVendedor int not null,
    constraint Cliente_idCliente_fk foreign key (idCliente) references Cliente (idCliente),
    constraint Vendedor_idVendedor_fk foreign key (idVendedor) references Vendedor (idVendedor)
);

create table ItemNotaFiscal(
	idNotaFiscal integer not null,
    idProduto integer not null,
    quantidade integer not null,
    precoProduto decimal not null,
    totalProduto decimal not null,
    PRIMARY KEY (idNotaFiscal, idProduto),
    constraint NotaFiscal_idNotaFiscal_fk foreign key (idNotaFiscal) references NotaFiscal (idNotaFiscal),
    constraint Produto_idProduto_fk foreign key (idProduto) references Produto (idProduto)
);