CREATE SCHEMA IF NOT EXISTS productdb;
USE productdb;

CREATE TABLE `produto` (
  id bigint NOT NULL AUTO_INCREMENT,
  categoria varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  descricao varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  fornecedor varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  imagem LONGBLOB,
  nome varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  preco double DEFAULT NULL,
  quantidade int DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE pedido (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_pedido DATE,
    produto_id BIGINT,
    CONSTRAINT fk_produto_pedido FOREIGN KEY (produto_id) REFERENCES produto(id)
);

select * from produto;