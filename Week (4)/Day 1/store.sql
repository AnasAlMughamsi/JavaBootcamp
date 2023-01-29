
create database store;

create table countries(
    code int primary key ,
    name varchar(20) unique ,
    continent_name varchar(20) not null
);

create table users(
    id int primary key ,
    full_name varchar(20) ,
    email varchar(20) unique ,
    gender varchar(1) check ( gender='f' or gender='m' ),
    date_of_birth varchar(15) ,
    create_at datetime ,
    country_code int ,
    foreign key (country_code) references countries(code)
);

create table orders(
    id int primary key ,
    status varchar(20),
    create_at datetime,
    user_id int ,

    foreign key (user_id) references users(id)

);

create table products(
    id int primary key ,
    name varchar(10) ,
    price int ,
    status varchar(10) ,
    create_at datetime
);

create table order_product(
    order_id int ,
    product_id int ,
    quantity int ,
    foreign key (order_id) references orders(id),
    foreign key (product_id) references products(id)
);



insert into countries values (00966, 'Saudi Arabia', 'Asia');
insert into users values (211, 'Anas', 'Anas@gmail.com', 'm', '30/04/1995', '2010-11-12', 00966);
insert into users values (215, 'test', 'test@gmail.com', 'm', '30/04/1999', '2010-11-12', 00966);
insert into orders values (342, 'available', '2022-12-22', 211);
insert into products values (555, 'book', 15, 'available', '2019-01-01');
insert into order_product values (342,555,10);
update products set name = 'video game' where id = 555;
delete from users where id = 215;