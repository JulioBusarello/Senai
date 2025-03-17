-- Criação do banco de dados
CREATE DATABASE productdb;

-- Uso do banco de dados criado
USE productdb;

-- Criação da tabela 'produto'
CREATE TABLE produto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(500),
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    category VARCHAR(255),
    supplier VARCHAR(255),
    image LONGBLOB
);