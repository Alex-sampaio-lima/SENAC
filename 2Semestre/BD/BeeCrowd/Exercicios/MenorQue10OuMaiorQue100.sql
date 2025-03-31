-- Active: 1727986491233@@127.0.0.1@3306@beecrowd
CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    amount NUMERIC(10, 2),
    price NUMERIC(10, 2)
)

DROP TABLE products;


INSERT INTO products (name, amount, price) 
               VALUES('Two-door wardrobe', 100, 80);

INSERT INTO products (name, amount, price)
              VALUES('Dinning table', 1000, 560);

INSERT INTO products (name, amount, price)
               VALUES('Towel holder', 10000, 5.50);

INSERT INTO products (name, amount, price)
               VALUES('Computer desk', 350, 100);

INSERT INTO products (name, amount, price)
               VALUES('Chair', 3000, 210.64);

INSERT INTO products (name, amount, price)
               VALUES('Single bed', 750, 99);

SELECT * FROM products;


SELECT p.id, p.name 
    FROM products AS p
WHERE p.price < 10 OR p.price > 100;


