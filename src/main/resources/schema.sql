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
