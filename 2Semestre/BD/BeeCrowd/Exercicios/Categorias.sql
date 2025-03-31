CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR (255),
    amount NUMERIC (10, 2),
    price NUMERIC(10, 2),
    id_categories INT,
    FOREIGN KEY (id_categories) REFERENCES categories(id)
)

DROP TABLE products;

CREATE TABLE categories (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
)

DROP TABLE categories;


INSERT INTO products (name, amount, price, id_categories)
               VALUES('Lamshade', 100, 800, 4);
INSERT INTO products (name, amount, price, id_categories)
               VALUES('Table for painting', 1000, 560, 9);
INSERT INTO products (name, amount, price, id_categories)
               VALUES('Notebook desk', 10000, 25.50, 9);
INSERT INTO products (name, amount, price, id_categories)
               VALUES('Computer desk', 350, 320.50, 6);
INSERT INTO products (name, amount, price, id_categories)
               VALUES('Chair', 3000, 210.64, 9);
INSERT INTO products (name, amount, price, id_categories)
               VALUES('Home alarm', 750, 460, 4);


INSERT INTO categories (name) VALUES ('old stock');
INSERT INTO categories (name) VALUES ('new stock');
INSERT INTO categories (name) VALUES ('modern');
INSERT INTO categories (name) VALUES ('commercial');
INSERT INTO categories (name) VALUES ('recyclable');
INSERT INTO categories (name) VALUES ('executive');
INSERT INTO categories (name) VALUES ('superior');
INSERT INTO categories (name) VALUES ('wood');
INSERT INTO categories (name) VALUES ('super luxury');
INSERT INTO categories (name) VALUES ('vintage');


SELECT * FROM products;

SELECT * FROM categories;

SELECT p.id, c.name FROM products AS p
    INNER JOIN categories AS c ON p.id_categories = c.id
WHERE c.name LIKE 'super%';