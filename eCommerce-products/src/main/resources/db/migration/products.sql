CREATE TABLE products
(
    id                 BIGINT PRIMARY KEY,
    name               VARCHAR(255) NOT NULL,
    category           VARCHAR(255) NOT NULL,
    description        VARCHAR(255) NOT NULL,
    quantity           INT          NOT NULL,
    created_date       DATE         NOT NULL,
    last_modified_date DATE

);

INSERT INTO products (id, name, category, description, quantity, created_date, last_modified_date)
VALUES (1001, 'Dell 5401', 'Laptop', 'Dell description', 12, '2020-05-20', '2020-06-30');

INSERT INTO products (id, name, category, description, quantity, created_date, last_modified_date)
VALUES (1002, 'Dell U2413', 'Monitor', 'Dell monitor', 15, '2020-05-20', '2020-06-30');

INSERT INTO products (id, name, category, description, quantity, created_date, last_modified_date)
VALUES (1003, 'Samsung', 'Monitor', 'Samsung monitor', 9, '2020-06-30', '2020-07-15');
