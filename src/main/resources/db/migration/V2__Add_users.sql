insert into users (email, username, password, is_enabled)
values ('admin@gmail.com', 'admin', 'admin', true),
       ('user@gmail.com', 'user', 'password', true),
       ('user2@gmail.com', 'user2', 'password', true);

insert into user_role (user_id, roles)
values (100000, 'ADMIN'),
       (100000, 'USER'),
       (100001, 'USER'),
       (100002, 'USER');