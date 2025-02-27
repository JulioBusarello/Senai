# Júlio Henrique Busarello
# T DESI 2024/1 N1

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

# -- Atividades

#1 Selecionar os nomes dos empregados cujo salário é superior à média salarial de todos os empregados.
SELECT nm_empregado EMPREGADO, salario SALÁRIO
	FROM empregado 
		WHERE salario > (SELECT AVG(salario) FROM empregado);

#2 Selecionar os empregados cujo salário está acima da média salarial do seu próprio departamento.
SELECT e.nm_empregado EMPREGADO, e.salario SALÁRIO, d.nm_departamento DEPARTAMENTO
	FROM empregado e
		JOIN departamento d ON e.id_departamento = d.id_departamento
			WHERE e.salario > (SELECT AVG(e2.salario) FROM empregado e2 WHERE e2.id_departamento = e.id_departamento);
        
#3 Selecionar todas as funções distintas desempenhadas pelos empregados, sem repetições.
SELECT DISTINCT funcao 
	FROM empregado;
    
#4 Selecionar o nome do empregado e a quantidade de anos trabalhados na empresa.
SELECT nm_empregado EMPREGADO, timestampdiff(year, data_contratacao, curdate()) 'ANOS EMPRESA'
	FROM empregado;
    
#5 Selecionar o nome do departamento e o total de dias de trabalho de todos os funcionários do departamento.
SELECT d.nm_departamento DEPARTAMENTO, coalesce(SUM(timestampdiff(day, e.data_contratacao, curdate())),0) 'DIAS EMPRESA'
	FROM empregado e RIGHT JOIN departamento d
		ON d.id_departamento = e.id_departamento
			GROUP BY nm_departamento;

#6 Selecionar o nome do empregado, o nome do líder, a data de contratação do empregado e do líder (no formato dd/mm/yyyy), 
# e a diferença entre as datas de contratação do líder e do empregado em anos, meses e dias.
SELECT e.nm_empregado EMPREGADO, l.nm_empregado LÍDER, 
	date_format(e.data_contratacao, '%d/%m/%Y') 'CONTRATAÇÃO EMPREGADO', 
	date_format(l.data_contratacao, '%d/%m/%Y') 'CONTRATAÇÃO LÍDER',
    ABS(timestampdiff(year, e.data_contratacao, l.data_contratacao)) 'DIFERENÇA EM ANOS',
    ABS(timestampdiff(month, e.data_contratacao, l.data_contratacao)) %12 'DIFERENÇA EM MESES',
    ABS(datediff(e.data_contratacao, l.data_contratacao)) %30 'DIFERENÇA EM DIAS'
		FROM empregado e LEFT JOIN empregado l
			ON e.lider = l.id_empregado;
            
#7 Selecionar uma string com as duas primeiras letras do nome do empregado, seguidas pelo caractere "*" juntamente com
# o nome do departamento, função, e o nome do líder abreviado para as três primeiras letras seguidas do caractere "*".
SELECT concat(LEFT(e.nm_empregado, 3), '*') 'EMPREGADO', d.nm_departamento 'DEPARTAMENTO', e.funcao 'FUNÇÃO', concat(LEFT(l.nm_empregado, 3), '*') 'LÍDER'
	FROM departamento d, empregado e LEFT JOIN  empregado l 
		ON e.lider = l.id_empregado
			WHERE e.id_departamento = d.id_departamento;
            
#8 Selecionar o nome do empregado, o nome do departamento e a classificação da grade salarial de cada empregado, 
# substituindo o ID_GRADE_SALARIAL por descrições textuais: 1-ruim, 2-abaixo da média, 3-mediano, 4-acima da média, 5-excelente.
SELECT e.nm_empregado 'EMPREGADO', d.nm_departamento 'DEPARTAMENTO', concat(g.menor_salario, " - ", g.maior_salario) 'VALOR GRADE SALARIAL',
	CASE g.id_grade_salarial
		WHEN 1 THEN "RUIM"
        WHEN 2 THEN "ABAIXO DA MÉDIA"
        WHEN 3 THEN "MEDIANO"
        WHEN 4 THEN "ACIMA DA MÉDIA"
        WHEN 5 THEN "EXCELENTE"
	END 'STATUS GRADE SALARIAL'
	FROM grade_salarial g, empregado e, departamento d 
		WHERE e.id_departamento = d.id_departamento 
			AND salario BETWEEN g.menor_salario AND g.maior_salario
				GROUP BY e.nm_empregado;
                
#9 Recuperar o nome de cada departamento e a porcentagem de participação no pagamento total da empresa, 
# considerando a soma dos salários e comissões dos empregados de cada departamento.
SELECT d.nm_departamento DEPARTAMENTO, REPLACE(CONCAT(CAST(ROUND(SUM(e.salario + coalesce(e.comissao, 0)) / (
	SELECT SUM(e2.salario + coalesce(e2.comissao, 0))
		FROM empregado e2
        ) * 100, 2) AS CHAR), '%'), '.',',') 'PORCENTAGEM'
			FROM empregado e RIGHT JOIN departamento d
				ON e.id_departamento = d.id_departamento
					GROUP BY d.nm_departamento;
                    
#10 Selecionar os empregados que são líderes, juntamente com a quantidade de subordinados, 
# a data de contratação do líder (no formato dd/mm/yyyy), e a soma dos salários e comissões de todos os seus subordinados,
# utilizando apelidos nas colunas para identificação
SELECT l.nm_empregado 'LIDER', l.funcao 'FUNCAO',  COUNT(e.id_empregado) 'QTD LIDERADOS', DATE_FORMAT(l.data_contratacao, '%d/%m/%Y') 'CONTRATACAO', 
	SUM(e.salario + coalesce(e.comissao,0))
		FROM empregado e, empregado l
			WHERE e.lider = l.id_empregado
				GROUP BY l.id_empregado;