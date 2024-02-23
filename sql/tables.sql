create table if not exists seller(
    id serial primary key,
    name varchar not null,
    email varchar not null,
    passport int not null
);

create table if not exists product (
    id serial primary key,
    name varchar not null,
    count int not null,
    price int not null,
    category varchar not null,
    size int not null,
    seller_id int not null references seller(id)
);

create table if not exists client (
    id serial primary key,
    name varchar not null,
    age int not null,
    address varchar not null
);

create table if not exists cart(
    product_id int not null references product(id),
    client_id int not null references client(id),
    count int not null,

    primary key (product_id, client_id)
);

create table if not exists product_order(
    id serial primary key,
    pickup_point_address varchar not null,
    delivery_time varchar,
    cost_of_delivery varchar,
    client_id int not null references client(id)
);

create table if not exists ordered_items(
    id serial primary key,
    product_order_id int not null references product_order(id),
    product_id int not null references product(id),
    status varchar not null
);

