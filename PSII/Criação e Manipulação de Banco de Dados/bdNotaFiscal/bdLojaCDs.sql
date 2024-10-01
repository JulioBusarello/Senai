drop database bdlojacds;

create database bdlojacds;

use bdlojacds;

create table Genero(
	idGenero integer not null,
    nome varchar(45) not null,
    constraint idGenero_pk primary key (idGenero)
);

create table Gravadora(
	idGravadora integer not null,
    nome varchar(45) not null,
    endereco varchar(150) not null,
    constraint idGravadora_pk primary key (idGravadora)
);

create table Categoria(
	idCategoria integer not null,
    nome varchar(45) not null,
    constraint idCategoria_pk primary key (idCategoria)
);

create table Artista(
	idArtista integer not null,
    nome varchar(45) not null,
    dataNascimento date not null,
    idGenero integer not null,
    idArtistaInspiracao integer not null,
    idGravadora integer not null,
    constraint idArtista_pk primary key (idArtista),
    constraint Genero_idGenero_Artista_fk foreign key (idGenero) references Genero (idGenero),
    constraint Gravadora_idGravadora_Artista_fk foreign key (idGravadora) references Gravadora (idGravadora)
);

create table CD(
	idCD integer not null,
    titulo varchar(45) not null,
    idCategoria integer not null,
    idArtista integer not null,
    quantidade integer not null,
    constraint idCD_pk primary key (idCd),
    constraint Categoria_idCategoria_CD_fk foreign key (idCategoria) references Categoria (idCategoria),
    constraint Artista_idArtista_CD_fk foreign key (idArtista) references Artista (idArtista)
);

create table Musica(
	idMusica integer not null,
    titulo varchar(45) not null,
    idCD integer not null,
    faixa integer not null,
    idGenero integer not null,
    constraint idMusica_pk primary key (idMusica),
    constraint CD_idCD_fk foreign key (idCd) references CD (idCD),
    constraint Genero_idGenero_Musica_fk foreign key (idGenero) references Genero (idGenero)
);

create table Telefone(
	idTelefone integer not null,
    telefone varchar(16) not null,
    idGravadora integer not null,
    constraint idTelefone_pk primary key (idTelefone)
);

create table Vendedor(
	idVendedor integer not null,
    nome varchar(45) not null,
    idGravadora integer not null,
    constraint idVendedor_pk primary key (idVendedor),
    constraint Gravadora_idGravadora_Vendedor_fk foreign key (idGravadora) references Gravadora (idGravadora)
);

create table Autor(
	idAutor integer not null,
    nome varchar(45) not null,
    cpf varchar(14) not null,
    constraint idAutor primary key (idAutor)
);