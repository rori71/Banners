create database if not exists acmefoods;
use acmefoods;

create table banner
(id integer not null auto_increment primary key,
codice varchar(20) not null, 
descrizione text default null,
area float not null)
Engine=InnoDB charset=utf8;

create table if not exists campagna_pub
(id integer not null auto_increment primary key,
nome varchar (200) default null)
Engine=InnoDB charset=utf8;

create table if not exists tariffa_inserzione
(id integer not null auto_increment primary key,
nome_testata varchar (200) not null,
nome_tariffa varchar (200) not null,
area_massima float not null,
costo float not null)
Engine=InnoDB charset=utf8;

create table if not exists inserzione
(id integer not null auto_increment primary key,
id_campagna_pub integer not null,
id_banner integer not null,
numero_pagine integer not null,
constraint foreign key (id_campagna_pub) references campagna_pub(id),
constraint foreign key (id_banner) references banner(id))
Engine=InnoDB charset=utf8;

insert into banner (codice, descrizione, area) values( 'LGSMALL','ACME FOODS small size logo',0.15);
insert into banner (codice, descrizione, area) values('PESTO','“Genoa Pesto Italian Recipe” banner',5.3);
insert into banner (codice, descrizione, area) values('HAZLNUTC','“Cream of your favourite hazel, and our nuts” banner',1.9);
insert into banner (codice, descrizione, area) values('LGMED','ACME FOODS medium size logo',0.53);
insert into banner (codice, descrizione, area) values('DECTRT','“El tortillon de la De Cekko” banner',6);

insert into campagna_pub values (null,'A');
insert into campagna_pub values (null,'B');
insert into campagna_pub values (null,'C');
insert into campagna_pub values (null,'D');
insert into campagna_pub values (null,'E');
insert into campagna_pub values (null,'F');
insert into campagna_pub values (null,'G');
insert into campagna_pub values (null,'H');
insert into campagna_pub values (null,'I');

insert into tariffa_inserzione values  (null,'Repubblica','Economy',1,5900);
insert into tariffa_inserzione values (null,'Repubblica','Message',5,7900);
insert into tariffa_inserzione values (null,'Repubblica','Impact',30,12900);
insert into tariffa_inserzione values (null,'Libero','Economy',1.5,6500);
insert into tariffa_inserzione values (null,'Libero','Economy',7.5,9900);
insert into tariffa_inserzione values (null,'Libero','Economy',40,13900);
insert into tariffa_inserzione values (null,'Il Fatto Quotidiano','Base',0.7,5200);
insert into tariffa_inserzione values (null,'Il Fatto Quotidiano','Standard',3,6900);
insert into tariffa_inserzione values (null,'Il Fatto Quotidiano','Maxxi',25,11500);

insert into inserzione values (null,1,3,2);
insert into inserzione values (null,2,2,1); 
insert into inserzione values (null,2,3,1);
insert into inserzione values (null,3,3,1);
insert into inserzione values (null,3,4,1);
insert into inserzione values (null,4,1,2);
insert into inserzione values (null,4,4,1);
insert into inserzione values (null,5,4,2);
insert into inserzione values (null,5,1,1);
insert into inserzione values (null,6,1,3);
insert into inserzione values (null,7,2,7);
insert into inserzione values (null,8,5,1);
insert into inserzione values (null,8,3,1);
insert into inserzione values (null,9,5,6);





