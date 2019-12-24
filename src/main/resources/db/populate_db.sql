DELETE
FROM user_roles;
DELETE
FROM user_votes;
DELETE
FROM users;
DELETE
FROM restaurant_meals;
DELETE
FROM restaurant_votes;
DELETE
FROM restaurants;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('ROLE_USER', 100000),
       ('ROLE_ADMIN', 100001),
       ('ROLE_USER', 100001);

INSERT INTO restaurants (name, address)
VALUES ('Пельменная', 'ул.Советская 1'),
       ('Черный Кот', 'ул.Ленина 10');