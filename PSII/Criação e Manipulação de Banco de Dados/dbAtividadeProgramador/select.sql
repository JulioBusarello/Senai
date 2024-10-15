# Júlio Henrique Busarello
# AI PSII 2024/1 V1
# 15/10/2024

# Cria a tabela caso ela não exista
CREATE DATABASE IF NOT EXISTS db_programadoratividade;

# Força o uso da tabela
USE db_programadoratividade;

CREATE TABLE GRADE_SALARIAL (
	ID_GRADE_SALARIAL INT NOT NULL PRIMARY KEY,
	MENOR_SALARIO DECIMAL(10,2) NOT NULL,
	MAIOR_SALARIO DECIMAL(10,2) NOT NULL
);

CREATE TABLE DEPARTAMENTO (
	ID_DEPARTAMENTO INT NOT NULL PRIMARY KEY,
	NM_DEPARTAMENTO VARCHAR(30) NOT NULL,
	LOCALIZACAO VARCHAR(20) NOT NULL
);

CREATE TABLE EMPREGADO (
	ID_EMPREGADO INT NOT NULL PRIMARY KEY,
	NM_EMPREGADO VARCHAR(45) NOT NULL,
	FUNCAO VARCHAR(45) NOT NULL,
	LIDER INTEGER NULL,
	DATA_CONTRATACAO DATE NOT NULL,
	SALARIO DECIMAL(10,2) NOT NULL,
	COMISSAO DECIMAL(10,2) NULL,
	ID_DEPARTAMENTO INTEGER NOT NULL,
	FOREIGN KEY(ID_DEPARTAMENTO) REFERENCES DEPARTAMENTO(ID_DEPARTAMENTO),
	FOREIGN KEY(LIDER) REFERENCES EMPREGADO(ID_EMPREGADO)
);

# Inserindo dados na tabela departamento
INSERT INTO DEPARTAMENTO VALUES (10,'CONTÁBIL','NEW YORK');
INSERT INTO DEPARTAMENTO VALUES (20,'PESQUISA E DESENVOLVIMENTO','DALLAS');
INSERT INTO DEPARTAMENTO VALUES (30,'VENDAS','CHICAGO');
INSERT INTO DEPARTAMENTO VALUES (40,'OPERAÇÕES','BOSTON');

# Inserindo dados na tabela empregado
INSERT INTO EMPREGADO VALUES (7839,'KING','PRESIDENTE',NULL,'1981-11-17',5000,NULL,10);
INSERT INTO EMPREGADO VALUES (7698,'BLAKE','GERENTE',7839,'1981-05-01',2850,NULL,30);
INSERT INTO EMPREGADO VALUES (7782,'CLARK','GERENTE',7839,'1981-06-09',2450,NULL,10);
INSERT INTO EMPREGADO VALUES (7566,'JONES','GERENTE',7839,'1981-07-02',2975,NULL,20);
INSERT INTO EMPREGADO VALUES (7654,'MARTIN','VENDEDOR',7698,'1981-09-28',1250,1400,30);
INSERT INTO EMPREGADO VALUES (7499,'ALLEN','VENDEDOR',7698,'1981-02-20',1600,300,30);
INSERT INTO EMPREGADO VALUES (7844,'TURNER','VENDEDOR',7698,'1981-09-08',1500,0,30);
INSERT INTO EMPREGADO VALUES (7900,'JAMES','ESCRITURÁRIO',7698,'1981-12-03',950,NULL,30);
INSERT INTO EMPREGADO VALUES (7521,'WARD','VENDEDOR',7698,'1981-02-22',1250,500,30);
INSERT INTO EMPREGADO VALUES (7902,'FORD','ANALISTA',7566,'1981-12-03',3000,NULL,20);
INSERT INTO EMPREGADO VALUES (7369,'SMITH','ESCRITURÁRIO',7902,'1980-12-17',800,NULL,20);
INSERT INTO EMPREGADO VALUES (7788,'SCOTT','ANALISTA',7566,'1982-12-09',3000,NULL,20);
INSERT INTO EMPREGADO VALUES (7876,'ADAMS','ESCRITURÁRIO',7788,'1983-01-12',1100,NULL,20);
INSERT INTO EMPREGADO VALUES (7934,'MILLER','ESCRITURÁRIO',7782,'1982-01-23',1300,NULL,10);

# Inserindo dados na tabela grade_salarial
INSERT INTO GRADE_SALARIAL VALUES (1,700,1200);
INSERT INTO GRADE_SALARIAL VALUES (2,1201,1400);
INSERT INTO GRADE_SALARIAL VALUES (3,1401,2000);
INSERT INTO GRADE_SALARIAL VALUES (4,2001,3000);
INSERT INTO GRADE_SALARIAL VALUES (5,3001,9999);

-- Atividade

#1) recuperar a localização do departamento de operações;
SELECT localizacao FROM departamento WHERE nm_departamento like "Operações";

#2) recuperar todos os empregados que exercem a função de escriturário;
SELECT * FROM empregado WHERE funcao like 'ESCRITURÁRIO';

#3) recuperar o nome, o salário e a comissão dos empregados (que possuem comissão), ordenados pelo maior salário;
SELECT nm_empregado, salario, comissao FROM empregado WHERE comissao IS NOT NULL ORDER BY salario DESC;

#4) recuperar o nome, a atividade e a data de contratação dos empregados que trabalham no departamento 20 e recebem mais de R$ 1.000;
SELECT nm_empregado, funcao, data_contratacao FROM empregado WHERE id_departamento = 20 AND salario > 1000;

#5) recuperar os empregados que são gerentes;
SELECT * FROM empregado WHERE funcao LIKE "GERENTE";

#6) recuperar as informações dos empregados que possuem a letra "o" no nome;
SELECT * FROM empregado WHERE nm_empregado LIKE '%O%';

#7) recuperar o nome e o número do departamento de todos os empregados que trabalham nos departamentos 10 e 30 por ordem alfabética de nome do empregado;
SELECT nm_empregado, id_departamento FROM empregado WHERE id_departamento IN (10,30) ORDER BY nm_empregado ASC;

#8) recuperar as informações dos empregados que foram contratados no ano de 1981.
SELECT * FROM empregado WHERE data_contratacao LIKE '1981%';

#9) recuperar todos os empregados com comissão maior ou igual a 1000 por ordem alfabética de nome do empregado;
SELECT * FROM empregado WHERE comissao >= 1000 ORDER BY nm_empregado ASC;

#10) recuperar empregados que tem salário inferior a R$ 1.300 ordenados pelo salário;
SELECT * FROM empregado WHERE salario < 1300 ORDER BY salario DESC;