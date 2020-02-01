insert into users (id, name, password)
values (1, 'admin1', 'admin'),
       (2, 'admin2', 'admin'),
       (3, 'admin3', 'admin'),
       (4, 'user1', 'password'),
       (5, 'user2', 'password'),
       (6, 'user3', 'password');

insert into user_role (user_id, roles)
values (1, 'ADMIN'),
       (1, 'USER'),
       (2, 'ADMIN'),
       (2, 'USER'),
       (3, 'ADMIN'),
       (3, 'USER'),
       (4, 'USER'),
       (5, 'USER'),
       (6, 'USER')