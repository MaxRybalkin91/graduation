drop table if exists meals;
drop table if exists restaurants;
drop table if exists user_role;
drop table if exists users;
drop sequence if exists hibernate_sequence;

create sequence hibernate_sequence start with 100000;

create table users
(
    id              integer            default nextval('hibernate_sequence'),
    email           varchar   not null,
    activation_code varchar            default null,
    username        varchar   not null,
    password        varchar   not null,
    registered      timestamp not null default now(),
    is_enabled      boolean   not null default true,
    primary key (id)
);
create unique index users_unique_email_idx on users (email);
create unique index users_unique_activation_code_idx on users (email, activation_code);

create table user_role
(
    user_id integer default nextval('hibernate_sequence'),
    roles   varchar not null,
    foreign key (user_id) references users (id) on delete cascade
);
create unique index user_role_unique_role_id_idx on user_role (user_id, roles);

create table restaurants
(
    id         integer            default nextval('hibernate_sequence'),
    address    varchar   not null,
    name       varchar   not null,
    registered timestamp not null default now(),
    is_enabled boolean   not null default true,
    votes      integer   not null default 0,
    primary key (id)
);
create unique index restaurants_unique_name_address_idx on restaurants (name, address);

create table meals
(
    id            integer          default nextval('hibernate_sequence'),
    date          date    not null default now(),
    description   varchar not null,
    price         integer not null,
    restaurant_id integer not null,
    primary key (id),
    foreign key (restaurant_id) references restaurants (id) on delete cascade
);
create unique index meals_unique_restId_date_description_idx on meals (restaurant_id, date, description);