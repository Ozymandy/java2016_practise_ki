/*
* Create database
*/

drop database if exists inquirer;

create database customerApplication;


/*
* Create tables
*/

use inquirer;

create table customer (
id mediumint not null auto_increment,
firstName varchar(50),
lastName varchar(50),
address varchar(50),
primary key (id)
);

create table product (
id mediumint not null auto_increment,
productName varchar(50),
productCost int,
primary key (id)
);

create table order (
id mediumint not null auto_increment,
customerId int unsigned not null references customer(id),
productId int unsigned not null references product(id),
primary key (id)
);
/*
* Insert values
*/

insert into customer(firstName,lastName,address) values ('Constantine', 'Ihnatsenka','Krinichnaya st. 8-10');
insert into customer(firstName,lastName,address) values ('Eugene', 'Sergeev','Pervomaayskaya st. 90');
insert into customer(firstName,lastName,address) values ('Leonid', 'Slutsky','Kirova st.');
insert into customer(firstName,lastName,address) values ('Gonzalo', 'Castro','Dortmund');
insert into customer(firstName,lastName,address) values ('Matthias', 'Ginter','Dortmund');
insert into customer(firstName,lastName,address) values ('Kevin', 'Volland','Leverkusen BayArena');
insert into product(productName,productCost) values ('T-shirt', 100);
insert into product(productName,productCost) values ('Long sleeve short', 10);
insert into product(productName,productCost) values ('Chino', 1340);
insert into product(productName,productCost) values ('Sneakers', 1000);
insert into order(customerId,productId) values (1,2);
insert into order(customerId,productId) values (1,3);
insert into order(customerId,productId) values (2,5);
insert into order(customerId,productId) values (4,4);
insert into order(customerId,productId) values (4,5);
commit;