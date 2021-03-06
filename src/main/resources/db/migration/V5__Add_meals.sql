insert into meals (id, restaurant_id, name, price, owner_id)
values (21, 11, 'ChickenBurger set', '300', 1),
       (22, 11, 'CheeseBurger set', '400', 1),
       (23, 11, 'FishBurger set', '500', 1),
       (24, 12, 'BigMac set', '300', 2),
       (25, 12, 'Happy Meal set', '400', 2),
       (26, 13, 'Sanders lunch basket', '300', 3),
       (27, 13, 'Lunch basket "5 items"', '400', 3);

/*INSERTING OLD MEALS FOR TESTS*/
insert into meals (id, restaurant_id, date, name, price, owner_id)
values (111, 11, '2019-05-31', 'Lunch1_1', '300', 1),
       (112, 11, '2019-05-31', 'Lunch2_1', '300', 1),
       (113, 11, '2019-05-31', 'Lunch3_1', '300', 1),
       (121, 12, '2019-05-31', 'Lunch1_2', '300', 2),
       (122, 12, '2019-05-31', 'Lunch2_2', '300', 2),
       (123, 12, '2019-05-31', 'Lunch3_2', '300', 2),
       (131, 13, '2019-05-31', 'Lunch1_3', '300', 3),
       (132, 13, '2019-05-31', 'Lunch2_3', '300', 3),
       (133, 13, '2019-05-31', 'Lunch3_3', '300', 3);

/*INSERTING FUTURE MEALS FOR TESTS*/
insert into meals (id, restaurant_id, date, name, price, owner_id)
values (211, 11, '2020-05-01', 'Lunch1_1_future', '300', 1),
       (212, 11, '2020-05-01', 'Lunch2_1_future', '300', 1),
       (213, 11, '2020-05-01', 'Lunch3_1_future', '300', 1),
       (221, 12, '2020-05-01', 'Lunch1_2_future', '300', 2),
       (222, 12, '2020-05-01', 'Lunch2_2_future', '300', 2),
       (223, 12, '2020-05-01', 'Lunch3_2_future', '300', 2),
       (231, 13, '2020-05-01', 'Lunch1_3_future', '300', 3),
       (232, 13, '2020-05-01', 'Lunch2_3_future', '300', 3),
       (233, 13, '2020-05-01', 'Lunch3_3_future', '300', 3);