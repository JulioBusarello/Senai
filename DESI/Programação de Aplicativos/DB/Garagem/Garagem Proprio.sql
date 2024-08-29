-- APAGAR O DATABASE
DROP SCHEMA garagem;

-- CRIAR O DATABASE
CREATE SCHEMA garagem;

-- FORÇAR USAR O DATABASE
USE GARAGEM;

-- CRIAR TABELA CAR
CREATE TABLE `car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fabricante` int(11) NOT NULL,
  `cor` int(11) NOT NULL,
  `ano` int(11) NOT NULL,
  `opcionais` int(11) NOT NULL,
  `cep` varchar(8) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `ano_fk_idx` (`ano`),
  KEY `cor_fk_idx` (`cor`),
  KEY `opcionais_fk_idx` (`opcionais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Tabela de Carros';

-- CRIAR TABELA COLOR
CREATE TABLE `color` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cor` varchar(45) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Tabela de Cores';

-- CRIAR TABELA LEVEL
CREATE TABLE `level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  `id_level_items` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `id_level_items_fk_idx` (`id_level_items`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Tabela de Level';

-- CRIAR TABELA LEVEL ITENS
CREATE TABLE `level_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` int(11) NOT NULL,
  `descricao` varchar(45) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`,`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Tabela de Detalhes de Niveis';

-- CRIAR TABELA MANUFACTORY
CREATE TABLE `manufactory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fabricante` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- CRIAR TABELA MODELO
CREATE TABLE `modelo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  `id_manufactory` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `manufactory_fk_idx` (`id_manufactory`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Tabela de Modelo de Carro';

-- CRIAR TABELA OPCIONAIS
CREATE TABLE `opcionais` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  `itens` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `opcionais_itens_fk_idx` (`itens`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Tabela de Opcionais';

-- CRIAR TABELA OPCIONAIS ITENS
CREATE TABLE `opcionais_itens` (
  `id` int(11) NOT NULL,
  `codigo` int(11) NOT NULL,
  `descricao` varchar(45) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`,`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Tabela de Itens dos Opcionais';

-- CRIAR TABELA USER
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `level_id` int(11) NOT NULL,
  `senha` varchar(16) NOT NULL,
  `email` varchar(45) NOT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `level_id_fk_idx` (`level_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Tabela de Usuario';

-- CRIAR TABELA CAR
CREATE TABLE `year` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ano` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Tabela de Ano';

ALTER TABLE `garagem`.`car`
  ADD CONSTRAINT `ano_fk` FOREIGN KEY (`ano`) REFERENCES `year` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `cor_fk` FOREIGN KEY (`cor`) REFERENCES `color` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `opcionais_fk` FOREIGN KEY (`opcionais`) REFERENCES `opcionais` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
  
ALTER TABLE `garagem`.`level`
  ADD CONSTRAINT `id_level_items_fk` FOREIGN KEY (`id_level_items`) REFERENCES `level_items` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
  
ALTER TABLE `garagem`.`modelo`
  ADD CONSTRAINT `manufactory_fk` FOREIGN KEY (`id_manufactory`) REFERENCES `manufactory` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
  
ALTER TABLE `garagem`.`opcionais`
  ADD CONSTRAINT `opcionais_itens_fk` FOREIGN KEY (`itens`) REFERENCES `opcionais_itens` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
  
ALTER TABLE `garagem`.`user`
  ADD CONSTRAINT `level_id_fk` FOREIGN KEY (`level_id`) REFERENCES `level` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
  
INSERT INTO `garagem`.`year` (`ano`) VALUES ('2020');
INSERT INTO `garagem`.`year` (`ano`) VALUES ('2021');
INSERT INTO `garagem`.`year` (`ano`) VALUES ('2022');
INSERT INTO `garagem`.`year` (`ano`) VALUES ('2023');
INSERT INTO `garagem`.`year` (`ano`) VALUES ('2024');
INSERT INTO `garagem`.`year` (`ano`) VALUES ('2025');

INSERT INTO `garagem`.`manufactory` (`fabricante`, `status`) VALUES ('Volkswagem', '1');
INSERT INTO `garagem`.`manufactory` (`fabricante`, `status`) VALUES ('BMW', '1');
INSERT INTO `garagem`.`manufactory` (`fabricante`, `status`) VALUES ('Mercedes-Benz', '1');
INSERT INTO `garagem`.`manufactory` (`fabricante`, `status`) VALUES ('Hyundai', '1');

INSERT INTO `garagem`.`color` (`cor`) VALUES ('Branca');
INSERT INTO `garagem`.`color` (`cor`) VALUES ('Preta');
INSERT INTO `garagem`.`color` (`cor`) VALUES ('Azul');
INSERT INTO `garagem`.`color` (`cor`) VALUES ('Verde');
INSERT INTO `garagem`.`color` (`cor`) VALUES ('Cinza');

INSERT INTO `garagem`.`modelo` (`descricao`, `id_manufactory`, `status`) VALUES ('Tiguan', '5', '1');
INSERT INTO `garagem`.`modelo` (`descricao`, `id_manufactory`, `status`) VALUES ('Gol', '5', '1');
INSERT INTO `garagem`.`modelo` (`descricao`, `id_manufactory`, `status`) VALUES ('Clio', '5', '1');

INSERT INTO `garagem`.`opcionais_itens` (`id`, `codigo`, `descricao`, `status`) VALUES ('1', '1', 'Ar-Condicionado', '1');
INSERT INTO `garagem`.`opcionais_itens` (`id`, `codigo`, `descricao`, `status`) VALUES ('1', '2', 'Trava-Eletrica', '1');
INSERT INTO `garagem`.`opcionais_itens` (`id`, `codigo`, `descricao`, `status`) VALUES ('1', '3', 'Direção Hidraulica', '1');

INSERT INTO `garagem`.`opcionais` (`descricao`, `itens`, `status`) VALUES ('Completo', '1', '1');

INSERT INTO `garagem`.`level_items` (`id`, `codigo`, `descricao`, `status`) VALUES ('1', '1', 'Cadastrar Veículo', '1');
INSERT INTO `garagem`.`level_items` (`id`, `codigo`, `descricao`, `status`) VALUES ('1', '2', 'Alterar Veículos', '1');
INSERT INTO `garagem`.`level_items` (`id`, `codigo`, `descricao`, `status`) VALUES ('1', '3', 'Excluir Veículos', '1');
INSERT INTO `garagem`.`level_items` (`id`, `codigo`, `descricao`, `status`) VALUES ('1', '4', 'Listar Veículos', '1');
INSERT INTO `garagem`.`level_items` (`id`, `codigo`, `descricao`, `status`) VALUES ('1', '5', 'Imprimir Veículos', '1');

INSERT INTO `garagem`.`level` (`descricao`, `id_level_items`, `status`) VALUES ('Administrador', '1', '1');
INSERT INTO `garagem`.`user` (`nome`, `level_id`, `senha`, `email`, `status`) VALUES ('Administrador', '2', '123456', 'admin@localhost', '1');