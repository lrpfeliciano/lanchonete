create database lanchonete;

use lanchonete;

create table lanche (
  codigo int not null auto_increment,
  nome varchar(50) not null,
  preco decimal(11,2) not null,
  primary key(codigo)
);

insert into lanche values (100, 'Cachorro quente', 5.00);
insert into lanche values (101, 'Bauru simples', 10.00);
insert into lanche values (102, 'Bauru com ovo', 10.5);
insert into lanche values (103, 'Hambúrger', 5.00);
insert into lanche values (104, 'Cheeseburguer', 6.00);
insert into lanche values (105, 'Refrigerante', 4.00);
