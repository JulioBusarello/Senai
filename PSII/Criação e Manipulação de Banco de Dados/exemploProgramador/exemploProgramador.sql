#excluindo o banco
drop database exemploprogramador2;

#criando o banco
create database exemploprogramador2;

#obrigando o uso do banco
use exemploprogramador2;

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
    data_contratacao date not null,
    salario decimal(10,2) not null,
    comissao decimal(10,2),
    id_departamento int not null,
    lider int,
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
insert into departamento (id_departamento, nm_departamento, localizacao) values (10, "Contábil", "New York"), (20, "Pesquisa e Desenvolvimento", "Dallas"), (30, "Vendas", "Chicago"), (40, "Operações", "Boston");

#Adicionando dados na tabela grade_salarial
insert into grade_salarial (id_grade_salarial, menor_salario, maior_salario) values (1, "700", "1200"), (2, "1201", "1400"), (3, "1401", "2000"), (4, "2001", "3000"), (5, "3001", "9999");

#Adicionando dados na tabela empregado
insert into empregado (id_empregado, nm_empregado, funcao, lider, data_contratacao, salario, comissao, id_departamento) 
	values (7839, "King", "Presidente", null, "1981-11-17", 5000, null, 10),
	(7566, "Jones", "Gerente", 7839, "1981-07-02", 2975, null, 20),
    (7698, "Blake", "Gerente", 7839, "1981-05-01", 2850, null, 30),
    (7782, "Clark", "Gerente", 7839, "1981-06-09", 2450, null, 10),
    (7499, "Allen", "Vendedor", 7698, "1981-02-20", 1600, 300, 30),
    (7521, "Ward", "Vendedor", 7698, "1981-02-22", 1250, 500, 30),
    (7654, "Martin", "Vendedor", 7698, "1981-09-28", 1250, 1400, 30),
    (7788, "Scott", "Analista", 7566, "1982-12-09", 3000, null, 20),
    (7844, "Turner", "Vendedor", 7698, "1981-09-08", 1500, 0, 30),
    (7876, "Adamns", "Escriturário", 7788, "1983-01-12", 1100, null, 20),
    (7900, "James", "Escriturário", 7698, "1981-12-03", 950, null, 30),
    (7902, "Ford", "Analista", 7566, "1981-12-03", 300, null, 20),
    (7934, "Miller", "Escriturário", 7782, "1982-01-23", 1300, null, 10),
    (7369, "Smith", "Escriturário", 7902, "1980-12-17", 800, null, 20);