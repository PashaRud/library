
CREATE TABLE IF NOT EXISTS products
(
    product_id       BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    print_product    VARCHAR(21)   NOT NULL,
    product_name     VARCHAR(255)  NOT NULL,
    description      VARCHAR(1024) NOT NULL,
    author           VARCHAR(128)  NOT NULL,
    publication_date DATE          NOT NULL,
    publishing_house VARCHAR(128)  NOT NULL,
    quantity         BIGINT        NOT NULL
);


-- Адекватная БД для данного проекта. Не успел :(

-- CREATE TABLE IF NOT EXISTS print_products
-- (
--     id            BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
--     print_product VARCHAR(21) NOT NULL UNIQUE
-- );
--
-- CREATE TABLE authors
-- (
--     ID     BIGINT PRIMARY KEY AUTO_INCREMENT,
--     AUTHOR varchar(50) NOT NULL UNIQUE
-- );
--
--
-- CREATE TABLE GENRES
-- (
--     id    int PRIMARY KEY AUTO_INCREMENT,
--     genre varchar(20) NOT NULL UNIQUE
-- );
--
-- CREATE TABLE IF NOT EXISTS products
-- (
--     id               BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
--     print_product_id INTEGER       NOT NULL,
--     product_name     VARCHAR(255)  NOT NULL,
--     description      VARCHAR(1024) NOT NULL,
--     authors_id       INTEGER       ,
--     publication_date DATE          NOT NULL,
--     publishing_house VARCHAR(128)  NOT NULL,
--     quantity         BIGINT        NOT NULL,
--     FOREIGN KEY (print_product_id) REFERENCES print_products (id),
--     FOREIGN KEY (authors_id) REFERENCES authors (id)
-- );
--
-- CREATE TABLE BOOKS_GENRES
-- (
--     books_id  BIGINT NOT NULL,
--     genres_id BIGINT NOT NULL,
--     PRIMARY KEY (books_id, genres_id),
--     FOREIGN KEY (books_id) REFERENCES products (id),
--     FOREIGN KEY (genres_id) REFERENCES GENRES (id)
-- );

