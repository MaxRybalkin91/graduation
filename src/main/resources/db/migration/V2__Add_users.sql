insert into users (id, name, password)
values (1, 'owner1', 'owner'),
       (2, 'owner2', 'owner'),
       (3, 'owner3', 'owner'),
       (4, 'user1', 'password'),
       (5, 'user2', 'password'),
       (6, 'user3', 'password'),
       (7, 'admin', 'admin');

insert into user_role (user_id, roles)
values (1, 'OWNER'),
       (2, 'OWNER'),
       (3, 'OWNER'),
       (4, 'USER'),
       (5, 'USER'),
       (6, 'USER'),
       (7, 'ADMIN')