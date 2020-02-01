package ru.topjava.graduation.data;

import ru.topjava.graduation.model.User;

public class UserTestData {
    public static final User ADMIN_1 = new User(1, "admin1", "admin");
    public static final User ADMIN_2 = new User(2, "admin2", "admin");
    public static final User ADMIN_3 = new User(3, "admin3", "admin");

    public static final User USER = new User(4, "user1", "password");
    public static final User USER_2 = new User(5, "user2", "password");
    public static final User USER_3 = new User(6, "user3", "password");
}
