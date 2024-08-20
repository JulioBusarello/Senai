CREATE SCHEMA `garagem` ;

CREATE TABLE `car` (
  `placa` int(7) NOT NULL AUTO_INCREMENT,
  `fabricante` int(10) NOT NULL,
  `modelo` int(2) NOT NULL,
  `ano` int(2) NOT NULL,
  `cor` int(2) NOT NULL,
  `opcionais` int(2) NOT NULL,
  PRIMARY KEY (`placa`),
  KEY `fabric_fk_idx` (`fabricante`),
  KEY `model_fk_idx` (`modelo`),
  KEY `year_fk_idx` (`ano`),
  KEY `color_fk_idx` (`cor`),
  KEY `opcionais_fk_idx` (`opcionais`),
  CONSTRAINT `color_fk` FOREIGN KEY (`cor`) REFERENCES `color` (`idcolor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fabric_fk` FOREIGN KEY (`fabricante`) REFERENCES `manufactory` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `model_fk` FOREIGN KEY (`modelo`) REFERENCES `manufactory` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `opcionais_fk` FOREIGN KEY (`opcionais`) REFERENCES `opcionais` (`idopcionais`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `year_fk` FOREIGN KEY (`ano`) REFERENCES `ano` (`idano`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `manufactory` (
  `codigo` int(11) NOT NULL,
  `fabricante` varchar(20) NOT NULL,
  `modelo` varchar(20) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `garagem`.`ano` (
  `idano` INT NOT NULL AUTO_INCREMENT,
  `ano` INT(4) NOT NULL,
  PRIMARY KEY (`idano`));
  
  CREATE TABLE `garagem`.`color` (
  `idcolor` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idcolor`));

CREATE TABLE `opcionais` (
  `idopcionais` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(150) NOT NULL,
  `opc_itens` int(2) NOT NULL,
  PRIMARY KEY (`idopcionais`),
  KEY `opcionaisItens_fk_idx` (`opc_itens`),
  CONSTRAINT `opcionaisItens_fk` FOREIGN KEY (`opc_itens`) REFERENCES `opcionais_itens` (`idopcionais_itens`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
  
  CREATE TABLE `garagem`.`opcionais_itens` (
  `idopcionais_itens` INT NOT NULL AUTO_INCREMENT,
  `codigo` INT NOT NULL,
  `descricao` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`idopcionais_itens`));
  
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `level_id` int(2) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `email` varchar(90) NOT NULL,
  `status` int(1) NOT NULL,
  PRIMARY KEY (`iduser`),
  KEY `levelId_fk_idx` (`level_id`),
  CONSTRAINT `levelId_fk` FOREIGN KEY (`level_id`) REFERENCES `level` (`idlevel`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `level` (
  `idlevel` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(150) NOT NULL,
  `id_level_itens` int(2) NOT NULL,
  `status` int(1) NOT NULL,
  PRIMARY KEY (`idlevel`),
  KEY `idLevelItens_fk_idx` (`id_level_itens`),user
  CONSTRAINT `idLevelItens_fk` FOREIGN KEY (`id_level_itens`) REFERENCES `level_itens` (`idlevel_itens`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `level_itens` (
  `idlevel_itens` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` int(11) NOT NULL,
  `descricao` varchar(150) NOT NULL,
  `status` int(1) NOT NULL,
  PRIMARY KEY (`idlevel_itens`,`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;