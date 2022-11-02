CREATE TABLE IF NOT EXISTS users
(
    user_id   BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    email     VARCHAR(1024),
    UNIQUE (email)
);

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

CREATE TABLE IF NOT EXISTS bookings
(
    booking_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    product_id BIGINT,
    booker_id  BIGINT,
    start_date timestamp WITHOUT TIME ZONE NOT NULL,
    end_date   timestamp WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT fk_bookings_to_items FOREIGN KEY (product_id) REFERENCES products (product_id),
    CONSTRAINT fk_bookings_to_users FOREIGN KEY (booker_id) REFERENCES users (user_id)
);