CREATE DATABASE IF NOT EXISTS productdb;
USE productdb;

CREATE TABLE produto(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) not null,
    descricao VARCHAR(500),
    preco DECIMAL(10,2) NOT NULL,
    quantidade INT NOT NULL,
    categoria VARCHAR(255),
    fornecedor VARCHAR(255),
    imagem LONGBLOB
);
