DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS user_votes;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS restaurant_meals;
DROP TABLE IF EXISTS restaurant_votes;
DROP TABLE IF EXISTS restaurants;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE users
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name       VARCHAR                           NOT NULL,
    email      VARCHAR                           NOT NULL,
    password   VARCHAR                           NOT NULL,
    registered TIMESTAMP           DEFAULT now() NOT NULL,
    enabled    BOOL                DEFAULT TRUE  NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE user_votes
(
    user_id       INTEGER NOT NULL,
    restaurant_id INTEGER NOT NULL,
    vote_date     DATE    NOT NULL,
    CONSTRAINT user_votes_idx UNIQUE (user_id, restaurant_id, vote_date),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE restaurants
(
    id      INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name    VARCHAR NOT NULL,
    address VARCHAR NOT NULL,
    CONSTRAINT restaurant_votes_idx UNIQUE (id, name)
);
CREATE UNIQUE INDEX restaurants_unique_name_idx ON restaurants (name);

CREATE TABLE restaurant_meals
(
    restaurant_id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    meal_id       INTEGER             DEFAULT nextval('global_seq'),
    meal_date     DATE    NOT NULL,
    meal_name     VARCHAR NOT NULL,
    meal_price    INTEGER NOT NULL,
    CONSTRAINT restaurant_meal_idx UNIQUE (restaurant_id, meal_date, meal_name),
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);

CREATE TABLE restaurant_votes
(
    restaurant_id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    vote_date     DATE    NOT NULL,
    votes         INTEGER NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);