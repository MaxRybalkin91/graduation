alter table if exists meals
    drop constraint if exists meals_restaurant_id_constraint;
alter table if exists user_role
    drop constraint if exists user_id_constraint;
drop table if exists meals cascade;
drop table if exists restaurants cascade;
drop table if exists user_role cascade;
drop table if exists users cascade;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start 1 increment 1;
create table meals
(
    id            integer not null,
    date          date,
    description   varchar,
    price         integer,
    restaurant_id integer not null,
    primary key (id)
);
create table restaurants
(
    id         integer not null,
    address    varchar,
    name       varchar,
    registered timestamp,
    votes      integer,
    primary key (id)
);
create table user_role
(
    user_id integer not null,
    roles   varchar
);
create table users
(
    id         integer not null,
    is_enabled boolean not null,
    password   varchar,
    registered timestamp,
    username   varchar,
    primary key (id)
);
alter table if exists meals
    add constraint meals_restaurant_id_constraint foreign key (restaurant_id) references restaurants;
alter table if exists user_role
    add constraint user_id_constraint foreign key (user_id) references users