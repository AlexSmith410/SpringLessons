BEGIN;

DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users (id BIGSERIAL PRIMARY KEY,
                    name VARCHAR(255),
                    age INTEGER
);

INSERT INTO users (name, age) VALUES ('Alex', 23),
                                     ('Ivan', 57),
                                     ('Kolya', 15),
                                     ('Alik', 20),
                                     ('Rufan', 30);

DROP TABLE IF EXISTS products CASCADE;

CREATE TABLE products (id BIGSERIAL PRIMARY KEY,
                       name VARCHAR(255),
                       price INTEGER
);

INSERT INTO products (name, price) VALUES ('bread', 20),
                                          ('milk', 30),
                                          ('cereals', 50),
                                          ('pancakes', 70);

COMMIT;