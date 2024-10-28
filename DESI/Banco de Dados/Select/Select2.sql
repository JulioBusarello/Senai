# Júlio Henrique Busarello
# T DESI 2024/1 N1
# 23/10/2024

#Cria a tabela caso ela não exista
CREATE DATABASE IF NOT EXISTS db_tecnicoatividade;

#Força o uso da tabela
USE db_tecnicoatividade;

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

#1
SELECT e.nm_empregado, e.id_empregado, d.nm_departamento 
	FROM empregado e, departamento d 
		WHERE e.id_departamento = d.id_departamento;

#2
SELECT d.nm_departamento, d.localizacao, e.nm_empregado, e.funcao, e.salario 
	FROM departamento d, empregado e 
		WHERE e.id_departamento = d.id_departamento AND d.localizacao LIKE 'NEW YORK';

#3
SELECT e.nm_empregado, d.nm_departamento, d.localizacao 
	FROM departamento d, empregado e 
		WHERE e.id_departamento = d.id_departamento AND e.comissao IS NOT NULL;

#4
SELECT e.nm_empregado, e.funcao, d.nm_departamento, e.salario, g.id_grade_salarial 
	FROM departamento d, empregado e, grade_salarial g 
		WHERE e.id_departamento = d.id_departamento AND e.salario BETWEEN g.menor_salario AND g.maior_salario;

#5
SELECT e.id_empregado 'Empregado', e.nm_empregado 'Nome empregado', m.id_empregado 'ID Líder', m.nm_empregado 'Nome líder' 
	FROM empregado e 
		LEFT JOIN empregado m ON e.lider = m.id_empregado;

#6
SELECT e.nm_empregado, d.nm_departamento, g.id_grade_salarial 
	FROM empregado e, departamento d, grade_salarial g 
		WHERE e.id_departamento = d.id_departamento AND e.salario BETWEEN g.menor_salario AND g.maior_salario;

#7
SELECT e.nm_empregado, e.salario, e.data_contratacao 
	FROM empregado e, departamento d
		WHERE e.id_departamento = d.id_departamento AND d.nm_departamento LIKE 'PESQUISA E DESENVOLVIMENTO'
			ORDER BY e.salario DESC;

#8
SELECT e.*
	FROM departamento d, empregado e 
		WHERE e.id_departamento = d.id_departamento AND d.localizacao LIKE 'Chicago' AND e.comissao IS NULL;

#9
SELECT e.id_empregado, e.nm_empregado, d.id_departamento, d.nm_departamento
	FROM departamento d, empregado e
		WHERE e.id_departamento = d.id_departamento AND e.salario BETWEEN 1500 AND 3000;

#10
SELECT e.nm_empregado 'Nome Empregado', e.salario 'Salário Empregado', e.data_contratacao 'Data Contratação Empregado', d.nm_departamento 'Departamento empregado', m.nm_empregado 'Nome Líder', m.salario 'Salário Líder', m.data_contratacao 'Data contratação Líder'
	FROM departamento d
		JOIN empregado e ON e.id_departamento = d.id_departamento
			LEFT JOIN empregado m ON e.lider = m.id_empregado
				ORDER BY e.nm_empregado ASC;