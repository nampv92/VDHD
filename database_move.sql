create database moviestore;
use moviestore
create table if not exists star_store(id int primary key not null auto_increment, movieName varchar(30), duration float, price float, value int);
create table if not exists cloud_store(id int primary key not null auto_increment, movieName varchar(30), duration float, price float, value int);
create table if not exists wind_store(id int primary key not null auto_increment, movieName varchar(30), duration float, price float, value int);

insert into star_store(movieName, duration, price, value) values ("Co nang danh da", 5, 20, 1);
insert into star_store(movieName, duration, price, value) values ("Nguoi dep tay do", 7, 30, 1);
insert into cloud_store(movieName, duration, price, value) values ("Co nang danh da", 6, 21, 1);
insert into wind_store(movieName, duration, price, value) values ("Co nang danh da", 7, 21, 1);
