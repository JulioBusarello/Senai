# Júlio Henrique Busarello
# AI PSII 2024/1 V1

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

#1) Recuperar o número de empregados que exercem a função de Analista.
SELECT count(id_empregado) 'QTD EMPREGADOS'
	FROM empregado
		WHERE funcao LIKE 'Analista';
        
#2) Exibir o menor e o maior salário entre os empregados, assim como a média e a soma de
# todos os salários de todos os empregados. Coloque apelidos nas colunas Máximo, Mínimo,
# Soma e Média, respectivamente.
SELECT MIN(salario) 'MÍNIMO', MAX(salario) MÁXIMO, AVG(salario) MÉDIA, SUM(salario) SOMA
	FROM empregado;
    
#3) Exibir o menor e o maior salário dentre os empregados, assim como a média e a soma de
# todos os salários de todos os empregados agrupados por função.
SELECT funcao FUNCAO, MIN(salario) MINIMO, MAX(salario) MÁXIMO, AVG(salario) MÉDIA, SUM(salario) SOMA
	FROM empregado
		GROUP BY funcao;
        
#4) Exibir o nome e o número de empregados com o mesmo cargo.
SELECT funcao FUNCAO, count(funcao) 'QTD EMPREGADOS'
	FROM empregado
		GROUP BY funcao;
        
#5) Exibir o nome do departamento, o nome do local, o número de empregados e o salário
# médio de todos os empregados que atuam no departamento.
SELECT d.nm_departamento DEPARTAMENTO, d.localizacao LOCALIZACAO, count(e.id_empregado) 'QTD EMPREGADOS', AVG(e.salario) 'MÉDIA SALARIAL'
	FROM departamento d, empregado e
		WHERE e.id_departamento = d.id_departamento
			GROUP BY d.id_departamento;
            
#6) Recuperar o nome do departamento onde o salário médio for superior a R$ 2.500.
SELECT d.nm_departamento DEPARTAMENTO, AVG(e.salario) 'MÉDIA SALARIAL '
	FROM departamento d, empregado e
		WHERE e.id_departamento = d.id_departamento 
			GROUP BY d.nm_departamento
				HAVING AVG(e.salario) > 2500;
                
#7) Exibir o nome do departamento e o local onde o número de empregados for igual ou
# menor a 5 (deve listar o departamento que não tem ninguém).
SELECT d.nm_departamento DEPARTAMENTO, d.localizacao LOCALIZAÇÃO, coalesce(count(e.id_empregado),0) 'QTD EMPREGADOS'
	FROM empregado e RIGHT JOIN departamento d
		ON d.id_departamento = e.id_departamento 
			GROUP BY d.nm_departamento
				HAVING coalesce(count(e.id_empregado),0) <= 5;
                
#8) Recuperar o nome e a quantidade de liderados que o funcionário possui. 
SELECT m.nm_empregado LIDER, count(e.lider) 'QTD LIDERADOS'
	FROM empregado e, empregado m 
		WHERE e.lider = m.id_empregado
			GROUP BY e.lider;
            
#9) Recuperar o nome do departamento, salário mínimo, salário máximo do departamento
SELECT d.nm_departamento DEPARTAMENTO, coalesce(MIN(e.salario),0) 'SALÁRIO MÍNIMO', coalesce(MAX(e.salario),0) 'SALÁRIO MÁXIMO'
	FROM empregado e RIGHT JOIN departamento d 
		ON d.id_departamento = e.id_departamento
			GROUP BY d.nm_departamento;
            
#10) Recuperar a quantidade de cada grade salarial por departamento.
SELECT d.nm_departamento DEPARTAMENTO, g.id_grade_salarial 'GRADE SALARIAL', COUNT(e.id_empregado) 'QTD GRADE'
	FROM  grade_salarial g, empregado e, departamento d 
		WHERE d.id_departamento = e.id_departamento AND e.salario BETWEEN g.menor_salario AND g.maior_salario
				GROUP BY d.nm_departamento, g.id_grade_salarial
					ORDER BY d.nm_departamento;