insert into meals (restaurant_id, name, price)
values (100003, 'ChickenBurger set', '300'),
       (100003, 'CheeseBurger set', '400'),
       (100003, 'FishBurger set', '500'),
       (100004, 'BigMac set', '300'),
       (100004, 'Happy Meal set', '400'),
       (100005, 'Sanders lunch basket', '300'),
       (100005, 'Lunch basket "5 items"', '400');

/*INSERTING OLD MEALS FOR TESTS*/
insert into meals (id, restaurant_id, date, name, price)
values (100, 100003, '2019-05-31', 'Lunch1_1', '300'),
       (200, 100004, '2019-05-30', 'Lunch2_1', '300'),
       (300, 100005, '2019-05-29', 'Lunch3_1', '500');

insert into meals (id, restaurant_id, date, name, price)
values (99999, 100003, '2019-05-01', 'Old meal', '333');