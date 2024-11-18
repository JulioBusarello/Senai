CREATE DATABASE IF NOT EXISTS escoladb;
use escoladb;

CREATE TABLE `aluno` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `nome` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `telefone` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `professor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `nome` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `salario` double DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `atividade` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `localizacao` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nome` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tipo` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `professor_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm4kosbh83qjr7cqhegg4wv0y3` (`professor_id`),
  CONSTRAINT `FKm4kosbh83qjr7cqhegg4wv0y3` FOREIGN KEY (`professor_id`) REFERENCES `professor` (`id`)
);

CREATE TABLE `aluno_atividade` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `aluno_id` bigint DEFAULT NULL,
  `atividade_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd9dy714t2ld7ogoqr3kfvsdkh` (`aluno_id`),
  KEY `FKmu32rpk7o5uxob8erjw5ferr2` (`atividade_id`),
  CONSTRAINT `FKd9dy714t2ld7ogoqr3kfvsdkh` FOREIGN KEY (`aluno_id`) REFERENCES `aluno` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKmu32rpk7o5uxob8erjw5ferr2` FOREIGN KEY (`atividade_id`) REFERENCES `atividade` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;