create table product
(
    id bigint auto_increment,
    title varchar not null ,
    cost float not null,
    constraint PRODUCT_PK
        primary key (id)
);
insert into product (title, cost) values
('хлеб',125.3 ),
('молоко',12.1),
('box',321),
('вода',123.4 );