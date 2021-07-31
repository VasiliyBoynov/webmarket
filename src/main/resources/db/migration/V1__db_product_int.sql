create table category
(
    id bigint auto_increment,
    name varchar not null,
    time_create timestamp default current_timestamp not null,
    time_update timestamp default current_timestamp not null,
    time_delete timestamp,
    primary key (id)
);

insert into category (name) values
('спорт'),
('хозяйственный отдел'),
('продукты питания');
create table product
(
    id bigint auto_increment,
    title varchar not null ,
    cost float not null,
    id_category bigint,
    time_create timestamp default current_timestamp not null,
    time_update timestamp default current_timestamp not null,
    time_delete timestamp,
    FOREIGN KEY (id_category) REFERENCES category (id),
    constraint PRODUCT_PK
        primary key (id)
);

insert into product (title, cost, id_category) values
('хлеб',125.3,3),
('молоко',12.1,3),
('box',321,2),
('вода',123.4,3);