drop database bdlocadora;

create database bdlocadora;

use bdlocadora;

create table cliente(
	idCliente int not null primary key,
    nome varchar(45) not null,
    rua varchar(45) not null,
    complemento varchar(45) not null,
    bairro varchar(45) not null,
    cep varchar(9) not null,
    cidade varchar(45) not null,
    uf varchar(2) not null,
    telefone varchar(16) not null
);

create table dependente(
	idDependente int not null primary key,
    nome varchar(45),
    idCliente integer not null,
    constraint cliente_idCliente_dependente_fk foreign key (idCliente) references cliente(idCliente)
);

create table tipo_pagamento(
	idTipo_Pagamento int not null primary key,
    nome varchar(45) not null
);

create table locacao(
	idLocacao int not null primary key,
    dataLocacao date not null,
    valorTotal decimal(10,2) not null,
    idCliente int not null,
    idTipo_Pagamento int not null,
    idDependente int,
    constraint Cliente_idCliente_Locacao_fk foreign key (idCliente) references cliente(idCliente),
    constraint Tipo_Pagamento_idTipo_Pagamento_Locacao_fk foreign key (idTipo_Pagamento) references tipo_pagamento(idTipo_Pagamento),
    constraint Dependente_idDependente_Locacao_fk foreign key (idDependente) references dependente(idDependente)
);

create table ator(
	idAtor int not null primary key,
    nome varchar(45) not null
);

create table categoria(
	idCategoria int not null primary key,
    nome varchar(45)
);

create table status(
	idStatus int not null primary key,
    nome varchar(45) not null
);

create table classificacao(
	idClassificacao integer not null primary key,
    nome varchar(45) not null,
    prazoDevolucao int not null,
    valor decimal(10,2) not null
);

create table midia(
	idMidia int not null primary key,
    nome varchar(45) not null,
    valorMidia decimal(10,2) not null
);

create table filme(
	idFilme int not null primary key,
    nome varchar(45) not null,
    sinopse varchar(45) not null,
    duracao int not null,
    idClassificacao int not null,
    idCategoria int not null,
    constraint Classificacao_idClassificacao_Filme_fk foreign key (idClassificacao) references classificacao(idClassificacao),
    constraint Categoria_idCategoria_Filme_fk foreign key (idCategoria) references categoria(idCategoria)
);

create table filme_has_ator(
	idFilme int not null,
    idAtor int not null,
    primary key(idFilme, idAtor),
    constraint Filme_idFilme_fk foreign key (idFilme) references filme(idFilme),
    constraint Ator_idAtor_fk foreign key (idAtor) references ator(idAtor)
);

create table exemplar(
	idExemplar int not null primary key,
    idFilme int not null,
    idMidia int not null,
    idStatus int not null,
    constraint Filme_idFilme_Exemplar_fk foreign key (idFilme) references filme(idFilme),
    constraint Midia_idMidia_Exemplar_fk foreign key (idMidia) references midia(idMidia),
    constraint Status_idStatus_Exemplar_fk foreign key (idStatus) references status(idStatus)
);

create table retirada(
	idRetirada int not null primary key,
    idLocacao int not null,
    idExemplar int not null,
    valorUnitario decimal(10,2) not null,
    dataDevolucaoPrevista date not null,
    constraint Locacao_idLocacao_Retirada_fk foreign key (idLocacao) references locacao (idLocacao),
    constraint Exemplar_idExemplar_Retirada_fk foreign key (idExemplar) references exemplar (idExemplar)
);

create table devolucao(
	idDevolucao int not null primary key,
    dataDevolucao date not null,
    idRetirada int not null,
    constraint Retirada_idRetirada_Devolucao_fk foreign key (idRetirada) references retirada(idRetirada)
);

create table multa(
	idMulta int not null primary key,
    dataMulta date not null,
    valorMulta decimal(10,2) not null,
    qtdDiasAtraso int not null,
    valorTotalMulta decimal(10,2) not null,
    idDevolucao int not null,
    constraint Devolucao_idDevolucao_Multa_fk foreign key (idDevolucao) references devolucao(idDevolucao)
);

create table reserva(
	idReserva int not null primary key,
    idExemplar int not null,
    dataReserva date not null,
    idCliente int not null,
    constraint Exemplar_idExemplar_Reserva_fk foreign key (idExemplar) references exemplar(idExemplar),
    constraint Cliente_idCliente_Reserva_fk foreign key (idCliente) references cliente(idCliente)
);