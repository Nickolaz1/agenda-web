create database bdAgenda;
use bdAgenda;

create table tbContatos(
    id int primary key auto_increment,
    nome varchar(50) not null,
    fone varchar(15) not null,
    email varchar(50)
);
