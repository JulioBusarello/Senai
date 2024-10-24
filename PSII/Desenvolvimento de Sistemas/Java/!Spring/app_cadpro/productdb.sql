CREATE SCHEMA IF NOT EXISTS productdb;
USE productdb;

CREATE TABLE `produto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `categoria` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `descricao` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `fornecedor` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `imagem` LONGBLOB,
  `nome` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `quantidade` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

select * from produto;