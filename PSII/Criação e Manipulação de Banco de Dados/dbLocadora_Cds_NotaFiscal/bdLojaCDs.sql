drop database bdlojacds;

create database bdlojacds;

use bdlojacds;

create table Genero(
	idGenero integer not null primary key,
    nome varchar(45) not null
);

create table Gravadora(
	idGravadora integer not null primary key,
    nome varchar(45) not null,
    endereco varchar(150) not null
);

create table Categoria(
	idCategoria integer not null primary key,
    nome varchar(45) not null
);

create table Artista(
	idArtista integer not null primary key ,
    nome varchar(45) not null,
    dataNascimento date not null,
    idGenero integer not null,
    idArtistaInspiracao integer,
    idGravadora integer not null,
    constraint Genero_idGenero_Artista_fk foreign key (idGenero) references Genero (idGenero),
    constraint Gravadora_idGravadora_Artista_fk foreign key (idGravadora) references Gravadora (idGravadora),
    constraint Artista_idArtista_Artista_fk foreign key (idArtistaInspiracao) references Artista (idArtista)
);

create table CD(
	idCD integer not null primary key,
    titulo varchar(45) not null,
    idCategoria integer not null,
    idArtista integer not null,
    quantidade integer not null,
    constraint Categoria_idCategoria_CD_fk foreign key (idCategoria) references Categoria (idCategoria),
    constraint Artista_idArtista_CD_fk foreign key (idArtista) references Artista (idArtista)
);

create table Musica(
	idMusica integer not null primary key,
    titulo varchar(45) not null,
    idCD integer not null,
    faixa integer not null,
    idGenero integer not null,
    constraint CD_idCD_fk foreign key (idCd) references CD (idCD),
    constraint Genero_idGenero_Musica_fk foreign key (idGenero) references Genero (idGenero)
);

create table Telefone(
	idTelefone integer not null primary key,
    telefone varchar(16) not null,
    idGravadora integer not null,
    constraint Gravadora_idGravadora_Telefone_fk foreign key (idGravadora) references Gravadora (idGravadora)
);

create table Vendedor(
	idVendedor integer not null primary key,
    nome varchar(45) not null,
    idGravadora integer not null,
    constraint Gravadora_idGravadora_Vendedor_fk foreign key (idGravadora) references Gravadora (idGravadora)
);

create table Autor(
	idAutor integer not null primary key ,
    nome varchar(45) not null,
    cpf varchar(14) not null
);

create table Musica_has_Autor(
	idMusica integer not null,
    idAutor integer not null,
    primary key (idMusica, idAutor),
    constraint Autor_idAutor_Musica_fk foreign key (idAutor) references Autor (idAutor),
    constraint Musica_idMusica_Autor_fk foreign key (idMusica) references Musica (idMusica)
);