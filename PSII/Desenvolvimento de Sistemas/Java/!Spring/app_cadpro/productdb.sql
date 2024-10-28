CREATE SCHEMA IF NOT EXISTS productdb;
USE productdb;

CREATE TABLE `produto` (
  id bigint NOT NULL AUTO_INCREMENT,
  categoria varchar(255) NOT NULL,
  descricao varchar(255) NOT NULL,
  fornecedor varchar(255) NOT NULL,
  imagem LONGBLOB,
  nome varchar(255) NOT NULL,
  preco double NOT NULL,
  quantidade int NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE pedido (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_pedido DATE NOT NULL,
    id_produto BIGINT NOT NULL,
    CONSTRAINT fk_produto_pedido FOREIGN KEY (id_produto) REFERENCES produto(id)
);

select * from produto;