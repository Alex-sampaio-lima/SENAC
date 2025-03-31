CREATE TABLE products (
    id INT PRIMARY KEY  AUTO_INCREMENT,
    name VARCHAR(255),
    amount NUMERIC(10, 2),
    price NUMERIC(10, 2),
    id_providers INT,
    id_categories INT,
    FOREIGN KEY (id_providers) REFERENCES providers(id),
    FOREIGN KEY (id_categories) REFERENCES categories(id)
);

DROP TABLE products;

CREATE TABLE providers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    street VARCHAR(255),
    city VARCHAR (255),
    state CHAR (2)
);

CREATE TABLE categories (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);


INSERT INTO providers (name, street, city, state) 
                VALUES('Henrique', 'Av Brasil', 'Rio de Janeiro', 'RJ');
INSERT INTO providers (name, street, city, state) 
                VALUES('Marcelo Augusto', 'Rua Imigrantes', 'Belo Horizonte', 'MG');
INSERT INTO providers (name, street, city, state) 
                VALUES('Caroline', 'Av São Paulo', 'Salvador', 'BA');
INSERT INTO providers (name, street, city, state) 
                VALUES('Guilherme Staff', 'Rua Central', 'Porto Alegre', 'RS');
INSERT INTO providers (name, street, city, state) 
                VALUES('Isabela Moraes', 'Av Juiz Grande', 'Curitiba', 'PR');
INSERT INTO providers (name, street, city, state) 
                VALUES('Francisco Aceerr', 'Av Paulista', 'São Paulo', 'SP');

SELECT * FROM providers;

INSERT INTO categories (name) VALUES ('old stock');
INSERT INTO categories (name) VALUES ('new stock');
INSERT INTO categories (name) VALUES ('modern');
INSERT INTO categories (name) VALUES ('commercial');
INSERT INTO categories (name) VALUES ('recyclabe');
INSERT INTO categories (name) VALUES ('executive');
INSERT INTO categories (name) VALUES ('superior');
INSERT INTO categories (name) VALUES ('wood');
INSERT INTO categories (name) VALUES ('super luxury');
INSERT INTO categories (name) VALUES ('vintage');

SELECT * FROM categories;

INSERT INTO products (name, amount, price, id_providers, id_categories) 
             VALUES  ('Two-door wardrobe', 100, 800, 6, 8);
INSERT INTO products (name, amount, price, id_providers, id_categories) 
             VALUES  ('Dinning table',1000 , 560, 1, 9);
INSERT INTO products (name, amount, price, id_providers, id_categories) 
             VALUES  ('Towel holder', 10000 , 25.50, 5, 1);
INSERT INTO products (name, amount, price, id_providers, id_categories) 
             VALUES  ('Computer desk', 350, 320.50, 4, 6);
INSERT INTO products (name, amount, price, id_providers, id_categories) 
             VALUES  ('Chair', 3000, 210.64, 3, 6);
INSERT INTO products (name, amount, price, id_providers, id_categories) 
             VALUES  ('Single bed', 750, 460, 1, 2);

SELECT * FROM products;

SELECT products.name, providers.name FROM products 
    INNER JOIN providers ON products.id_providers = providers.id
WHERE products.id_categories = 6;


