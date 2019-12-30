DROP TABLE IF EXISTS meals;
DROP TABLE IF EXISTS restaurants;
DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS hibernate_sequence;

CREATE SEQUENCE hibernate_sequence START WITH 100000;

CREATE TABLE users
(
    id              INTEGER      DEFAULT nextval('hibernate_sequence') PRIMARY KEY,
    email           VARCHAR(255)               NOT NULL,
    activation_code VARCHAR(255) DEFAULT NULL,
    username        VARCHAR(255)               NOT NULL,
    password        VARCHAR(255)               NOT NULL,
    registered      TIMESTAMP    DEFAULT now() NOT NULL,
    is_enabled      BOOLEAN      DEFAULT TRUE  NOT NULL
);
CREATE UNIQUE INDEX users_unique_username_email_idx ON users (username, email);
CREATE UNIQUE INDEX users_unique_activation_code_idx ON users (email, activation_code);

CREATE TABLE user_role
(
    user_id INTEGER      NOT NULL,
    roles   VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX user_role_unique_role_id_idx ON user_role (user_id, roles);

CREATE TABLE restaurants
(
    id         INTEGER   DEFAULT nextval('hibernate_sequence') PRIMARY KEY,
    address    VARCHAR(255)            NOT NULL,
    name       VARCHAR(255)            NOT NULL,
    registered TIMESTAMP DEFAULT now() NOT NULL,
    is_enabled BOOLEAN   DEFAULT TRUE  NOT NULL,
    votes      INTEGER   DEFAULT 0     NOT NULL
);
CREATE UNIQUE INDEX restaurants_unique_name_address_idx ON restaurants (name, address);

CREATE TABLE votes
(
    user_id       INTEGER            NOT NULL,
    restaurant_id INTEGER            NOT NULL,
    date          DATE DEFAULT now() NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX unique_vote_idx ON votes (user_id, restaurant_id, date);

CREATE TABLE meals
(
    id            INTEGER DEFAULT nextval('hibernate_sequence') PRIMARY KEY,
    date          DATE    DEFAULT now() NOT NULL,
    description   VARCHAR(255)          NOT NULL,
    price         INTEGER               NOT NULL,
    restaurant_id INTEGER               NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX meals_unique_restId_date_description_idx ON meals (restaurant_id, date, description);