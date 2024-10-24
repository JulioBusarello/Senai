# Júlio Henrique Busarello
# AI PSII 2024/1 V1
# 24/10/2024

#Cria a tabela caso ela não exista
CREATE DATABASE IF NOT EXISTS db_programadoratividade;

#Força o uso da tabela
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

#Inserindo dados na tabela departamento
INSERT INTO DEPARTAMENTO VALUES (10,'CONTÁBIL','NEW YORK');
INSERT INTO DEPARTAMENTO VALUES (20,'PESQUISA E DESENVOLVIMENTO','DALLAS');
INSERT INTO DEPARTAMENTO VALUES (30,'VENDAS','CHICAGO');
INSERT INTO DEPARTAMENTO VALUES (40,'OPERAÇÕES','BOSTON');

#Inserindo dados na tabela empregado
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

#Inserindo dados na tabela grade_salarial
INSERT INTO GRADE_SALARIAL VALUES (1,700,1200);
INSERT INTO GRADE_SALARIAL VALUES (2,1201,1400);
INSERT INTO GRADE_SALARIAL VALUES (3,1401,2000);
INSERT INTO GRADE_SALARIAL VALUES (4,2001,3000);
INSERT INTO GRADE_SALARIAL VALUES (5,3001,9999);

# -- Atividade
                
#1) Recuperar o nome, o número do empregado e o nome do departamento de todos os empregados;
SELECT e.id_empregado, e.nm_empregado, d.nm_departamento 
	FROM empregado e, departamento d 
		WHERE e.id_departamento = d.id_departamento;

#2) Recuperar o nome e a localização dos departamentos e o nome, a atividade e o salário dos empregados que trabalham em NEW YORK;
SELECT d.nm_departamento, d.localizacao, e.nm_empregado, e.funcao, e.salario 
	FROM empregado e, departamento d 
		WHERE e.id_departamento = d.id_departamento AND d.localizacao LIKE 'NEW YORK';


#3) Recuperar o nome do empregado, o nome do departamento e a localização de todos os empregados que recebem comissão;
SELECT e.nm_empregado, d.nm_departamento, d.localizacao 
	FROM empregado e, departamento d 
		WHERE e.id_departamento = d.id_departamento AND e.comissao IS NOT NULL;


#4) Recuperar o nome, salário e data de contratação de todos os empregados que trabalham no departamento de Pesquisa e Desenvolvimento, ordenados pelo maior salário.
SELECT e.nm_empregado, e.salario, e.data_contratacao 
	FROM empregado e, departamento d 
		WHERE e.id_departamento = d.id_departamento AND d.nm_departamento LIKE 'Pesquisa e Desenvolvimento' ORDER BY e.salario DESC;

#5) Recuperar todos os dados dos empregados que trabalham em Chicago e não tem comissão.
SELECT e.* 
	FROM empregado e, departamento d 
		WHERE e.id_departamento = d.id_departamento AND d.localizacao LIKE 'Chicago' AND e.comissao IS NULL;

#6) Recuperar o número e o nome dos empregados, o número e o nome do departamento dos empregados que recebam na faixa de R$ 1.000 e R$ 2.300.
SELECT e.id_empregado, e.nm_empregado, e.id_departamento, d.nm_departamento 
	FROM empregado e, departamento d 
		WHERE e.id_departamento = d.id_departamento AND e.salario BETWEEN 1000 AND 2300;

#7) Recuperar o nome e a função do empregado, o nome do departamento, o salário do empregado e a grade salarial (ID_GRADE_SALARIAL) de todos os empregados;
SELECT e.nm_empregado, e.funcao, d.nm_departamento, e.salario, g.id_grade_salarial 
	FROM empregado e, departamento d, grade_salarial g 
		WHERE e.id_departamento = d.id_departamento AND e.salario BETWEEN g.menor_salario AND g.maior_salario;

#8) Recuperar o nome e o número do empregado junto com o nome e o número do líder; coloque um apelido nas colunas ID Empregado, Nome Empregado, ID Líder e Nome Líder;
SELECT e.id_empregado 'Id empregado', e.nm_empregado 'Nome empregado', m.id_empregado 'Id líder', m.nm_empregado 'Nome líder'
	FROM empregado e LEFT JOIN empregado m
		ON e.lider = m.id_empregado;

#9) Recuperar o nome do empregado, o nome do departamento e a classificação salarial.
SELECT e.nm_empregado, d.nm_departamento, g.id_grade_salarial
	FROM empregado e, departamento d, grade_salarial g
		WHERE e.id_departamento = d.id_departamento AND e.salario BETWEEN g.menor_salario AND g.maior_salario;

#10) Recuperar nome, salário e data de contratação do empregado, o nome do departamento que o funcionário trabalha e o nome, o salário e data de contratação do líder, ordenados pelo nome do funcionário. Utilize apelidos para as colunas para facilitar a leitura.
SELECT e.nm_empregado 'NOME EMPREGADO', e.salario 'SALÁRIO EMPREGADO', e.data_contratacao 'DATA CONTRATAÇÃO', d.nm_departamento 'DEPARTAMENTO', m.nm_empregado 'NOME LÍDER', m.salario 'SALÁRIO LÍDER', m.data_contratacao 'DATA CONTRATAÇÃO'
	FROM departamento d
		JOIN empregado e ON e.id_departamento = d.id_departamento
			LEFT JOIN empregado m ON e.lider = m.id_empregado
				ORDER BY e.nm_empregado ASC;