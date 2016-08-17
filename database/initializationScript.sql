/*
* Create database
*/

create schema customerApplication;


/*
* Create tables
*/

use customerApplication;

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

create table ordertable (
id mediumint not null auto_increment,
orderDate date not null,
customerId int unsigned not null references customer(id),
primary key (id)
);
create table order_product (
id mediumint not null auto_increment,
orderId int unsigned not null references ordertable(id),
productId int unsigned not null references product(id),
primary key (id)
);
