/*
 Usado no JdbcTemplate
O Hibernate ira criar a tabela de acordo com o mapeamento da entidade person. Atraves da propriedade schema=update que e a default
create table person
(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);



insert into person(id, name, location, birth_date) values (1000, 'cleberson', 'rua das camelias', '1985-03-02 09:30:00');
insert into person(id, name, location, birth_date) values (1001, 'bruna', 'rua das camelias', '1984-05-10 15:00:00');
insert into person(id, name, location, birth_date) values (1002, 'cristina', 'rua das camelias', '1956-03-01 07:35:00');
insert into person(id, name, location, birth_date) values (1003, 'ana', 'rua das orquideas', '1962-07-12 20:10:00');
*/

-- Usado no Jpa
insert into person(name, location, birth_date) values ('cleberson', 'rua das camelias', '1985-03-02 09:30:00');
insert into person(name, location, birth_date) values ('bruna', 'rua das camelias', '1984-05-10 15:00:00');
insert into person(name, location, birth_date) values ('cristina', 'rua das camelias', '1956-03-01 07:35:00');
insert into person(name, location, birth_date) values ('ana', 'rua das orquideas', '1962-07-12 20:10:00');