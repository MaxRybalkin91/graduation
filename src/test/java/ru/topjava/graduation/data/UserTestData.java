package ru.topjava.graduation.data;

import ru.topjava.graduation.model.User;

public class UserTestData {
    public static final User OWNER_1 = new User(1, "'owner'1", "'owner'");
    public static final User OWNER_2 = new User(2, "'owner'2", "'owner'");
    public static final User OWNER_3 = new User(3, "'owner'3", "'owner'");

    public static final User USER = new User(4, "user1", "password");
    public static final User USER_2 = new User(5, "user2", "password");
    public static final User USER_3 = new User(6, "user3", "password");
}
