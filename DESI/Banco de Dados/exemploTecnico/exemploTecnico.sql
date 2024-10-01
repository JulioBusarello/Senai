#excluindo o banco
drop database exemploTecnico;

#criando o banco
create database exemploTecnico;

#obrigando o uso do banco
use exemploTecnico;

create table departamento(
	id_departamento int not null,
    nm_departamento varchar(30) not null,
    localizacao varchar(20) not null,
    constraint id_departamento_pk
    primary key (id_departamento)
);

create table empregado(
	id_empregado int not null,
    nm_empregado varchar(45) not null,
    funcao varchar(45) not null,
    data_contratacao date not null,
    salario decimal(10,2) not null,
    comissao decimal(10,2),
    id_departamento int not null,
    lider int,
    constraint id_empregado_pk
    primary key (id_empregado),
    constraint empregado_id_lider_fk
    foreign key (lider) references empregado (id_empregado),
    constraint empregado_id_departamento_fk
    foreign key (id_departamento) references departamento(id_departamento)
);

create table grade_salarial(
	id_grade_salarial int NOT NULL,
    menor_salario decimal(10,2) NOT NULL,
    maior_salario decimal(10,2) NOT NULL,
    constraint id_grade_salarial_pk
    primary key (id_grade_salarial)
);

#Exemplo de inserção dois dados ao mesmo tempo
insert into departamento (id_departamento, nm_departamento, localizacao)
values(50, "Desenvolvimento", "Detroit"), (60, "Web-design", "Timbo");

#Adicionando na ordem do banco
insert into departamento values (70, "Suporte", "Detroit"), (80, "RH", "Indahell");

#Mostrar todos os dados do departamento
-- select * from departamento;

#Salvando conforme a tabela
insert into empregado values (1, "Hermano", "Professor","2014-03-02", "1000", null, 60, null);
insert into empregado values (2, "Gerson", "Professor","2019-05-01", "1500", null, 60, null);
insert into empregado values (3, "Gustavo", "Professor","2021-10-01", "500", null, 70, null);

#Especificando cada dado
insert into empregado (id_empregado, nm_empregado, funcao, data_contratacao, salario, comissao, id_departamento) values
(4, "Sabrina", "Atendimento", "2023-12-01", 400 , 100, 70);

#Atualizando dados ja existentes
update empregado set nm_empregado = "Hermano Roepke"
	where id_empregado = 1;
    
#Mudar todos os dados de uma vez
/*update empregado set nm_empregado = "Ruim"
	where id_empregado > 0;*/
    
#Arquivar possíveis erros
-- rollback;
#Não tem volta
-- commit;

#Mostrar todos os dados do empregado
-- select * from empregado;

/*desc empregado;
desc departamento;
desc grade_salarial;*/

delete from departamento where id_departamento = 80;