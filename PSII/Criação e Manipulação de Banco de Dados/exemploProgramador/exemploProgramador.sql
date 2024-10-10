#excluindo o banco
drop database if exists db_exemploProgramador;

#criando o banco
create database if not exists db_exemploProgramador;

#obrigando o uso do banco
use db_exemploProgramador;

create table pessoa(
	cd_pessoa integer,
    nm_pessoa varchar(255),
    fl_estado_civil char(1) default 'S'
);

create table departamento(
	id_departamento int not null primary key,
    nm_departamento varchar(30) not null,
    localizacao varchar(20) not null,
    constraint nm_departamento_uk unique (nm_departamento)
);

create table empregado(
	id_empregado int not null primary key,
    nm_empregado varchar(45) not null,
    funcao varchar(45) not null,
    lider int,
    data_contratacao date not null,
    salario decimal(10,2) not null,
    comissao decimal(10,2),
    id_departamento int not null,
    constraint empregado_id_lider_fk foreign key (lider) references empregado (id_empregado),
    constraint empregado_id_departamento_fk foreign key (id_departamento) references departamento(id_departamento)
);

create table grade_salarial(
	id_grade_salarial int NOT NULL primary key,
    menor_salario decimal(10,2) NOT NULL,
    maior_salario decimal(10,2) NOT NULL
);

/*
insert into pessoa values (1, "Hermano",'S');
insert into pessoa values (2, "Gerson",'C');

-- select * from pessoa;
truncate table pessoa;

#Exemplo de inserção dois dados ao mesmo tempo
insert into departamento (id_departamento, nm_departamento, localizacao)
values(50, "Desenvolvimento", "Detroit"), (60, "Web-design", "Timbo");

#Adicionando na ordem do banco
insert into departamento values (70, "Suporte", "Detroit"), (80, "RH", "Indahell");

#Atualizando dados na tabela
update departamento set nm_departamento = "Programação" where id_departamento = 50;*/

#Adicionando dados na tabela departamento
INSERT INTO departamento VALUES (10,'CONTÁBIL','NEW YORK');
INSERT INTO departamento VALUES (20,'PESQUISA E DESENVOLVIMENTO','DALLAS');
INSERT INTO departamento VALUES (30,'VENDAS','CHICAGO');
INSERT INTO departamento VALUES (40,'OPERAÇÕES','BOSTON');

#Adicionando dados na tabela grade_salarial
INSERT INTO grade_salarial VALUES (1,700,1200);
INSERT INTO grade_salarial VALUES (2,1201,1400);
INSERT INTO grade_salarial VALUES (3,1401,2000);
INSERT INTO grade_salarial VALUES (4,2001,3000);
INSERT INTO grade_salarial VALUES (5,3001,9999);

#Adicionando dados na tabela empregado
INSERT INTO empregado VALUES (7839,'KING','PRESIDENTE',NULL,'1981-11-17',5000,NULL,10);
INSERT INTO empregado VALUES (7698,'BLAKE','GERENTE',7839,'1981-05-01',2850,NULL,30);
INSERT INTO empregado VALUES (7782,'CLARK','GERENTE',7839,'1981-06-09',2450,NULL,10);
INSERT INTO empregado VALUES (7566,'JONES','GERENTE',7839,'1981-07-02',2975,NULL,20);
INSERT INTO empregado VALUES (7654,'MARTIN','VENDEDOR',7698,'1981-09-28',1250,1400,30);
INSERT INTO empregado VALUES (7499,'ALLEN','VENDEDOR',7698,'1981-02-20',1600,300,30);
INSERT INTO empregado VALUES (7844,'TURNER','VENDEDOR',7698,'1981-09-08',1500,0,30);
INSERT INTO empregado VALUES (7900,'JAMES','ESCRITURÁRIO',7698,'1981-12-03',950,NULL,30);
INSERT INTO empregado VALUES (7521,'WARD','VENDEDOR',7698,'1981-02-22',1250,500,30);
INSERT INTO empregado VALUES (7902,'FORD','ANALISTA',7566,'1981-12-03',3000,NULL,20);
INSERT INTO empregado VALUES (7369,'SMITH','ESCRITURÁRIO',7902,'1980-12-17',800,NULL,20);
INSERT INTO empregado VALUES (7788,'SCOTT','ANALISTA',7566,'1982-12-09',3000,NULL,20);
INSERT INTO empregado VALUES (7876,'ADAMS','ESCRITURÁRIO',7788,'1983-01-12',1100,NULL,20);
INSERT INTO empregado VALUES (7934,'MILLER','ESCRITURÁRIO',7782,'1982-01-23',1300,NULL,10);
INSERT INTO empregado VALUES (1722, 'JULIO','PROGRAMADOR',NULL,'2024-01-21',7200,NULL, 20);

#Verificando dados selecionados de uma tabela
SELECT nm_empregado, funcao, salario, lider FROM empregado;

#Verificando todos os dados da tabela
SELECT * FROM grade_salarial;

#Verificando dados com outro nome na coluna
SELECT nm_empregado NOME, funcao FUNÇÃO, salario "SALÁRIO FIXO" FROM empregado;

#Selecionando dados selecionados com condições específicas
SELECT nm_empregado, funcao, salario FROM empregado WHERE id_empregado = 1722;
SELECT nm_empregado, funcao, salario FROM empregado WHERE id_departamento = 10 AND salario >= 1300;
SELECT nm_empregado, funcao, salario FROM empregado WHERE nm_empregado LIKE '%S'; /* Caso o % esteja no inicio, o nome deve terminar com S('%S'), caso o % esteja no final deve 
começar com S('S%'), também é possível utilizar o _ para o tanto de letras que o nome deve ter ('____S')*/
SELECT nm_empregado, funcao, salario FROM empregado WHERE comissao IS NULL;
SELECT nm_empregado, funcao, salario FROM empregado WHERE id_departamento IN (10,30);
SELECT nm_empregado, funcao, salario FROM empregado WHERE id_departamento = 10 OR id_departamento = 30;
SELECT nm_empregado, funcao, salario FROM empregado WHERE salario BETWEEN 800 AND 1200; /* salario >= 800 AND salario <= 1200 */
SELECT nm_empregado, funcao, salario FROM empregado ORDER BY nm_empregado ASC; /* ASC, Ordem Alfabética. DESK Ordem Alfábetica Contrária */
SELECT nm_empregado, funcao, salario FROM empregado WHERE UPPER(NM_EMPREGADO) LIKE 'smit%';
