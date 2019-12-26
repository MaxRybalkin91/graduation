insert into users (id, username, password, registered, is_enabled)
values (100000, 'admin', 'admin', date(now()), true),
       (100001, 'user', 'password', date(now()), true),
       (100002, 'user2', 'password', date(now()), true);

insert into user_role (user_id, roles)
values (100000, 'ADMIN'),
       (100000, 'USER'),
       (100001, 'USER'),
       (100002, 'USER');