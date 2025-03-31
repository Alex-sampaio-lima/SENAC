CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    street VARCHAR(255),
    city VARCHAR(255),
    state CHAR(2),
    credit_limit DECIMAL(10, 2)
);

SELECT * FROM customers;

INSERT INTO customers (name, street, city, state, credit_limit) 
               VALUES ('Pedro Augusto da Rocha', 'Ria Pedro Carlos Hoffman', 'Porto Alegre', 'RS', 700.00);

INSERT INTO customers (name, street, city, state, credit_limit) 
               VALUES ('Antonio Carlos Mamel', 'Av. Pinheiros', 'Belo Horizonte', 'MG', 3500.50);

INSERT INTO customers (name, street, city, state, credit_limit) 
                VALUES('Luiza Augusta Mhor', 'Rua Salto Grande', 'Nitéroi', 'RJ', 4000.00);
        
INSERT INTO customers (name, street, city, state, credit_limit) 
                VALUES('Jane Ester', 'AV 7 de Setembro', 'Erechim', 'RS', 800.00);

INSERT INTO customers (name, street, city, state, credit_limit)
                VALUES('Marco Antônio dos Santos', 'Av Farrapos', 'Porto Alegre', 'RS', 4250.25);

                
SELECT * FROM customers;

UPDATE customers c SET c.street = 'Av 7 de Setembro' WHERE id = 4;

SELECT c.name AS c 
    FROM customers AS c 
WHERE c.state LIKE 'RS';

SELECT c.name AS 'Nome dos Clientes', c.street AS 'Rua dos clientes' 
    FROM customers AS c
WHERE c.city LIKE 'Porto Alegre';

SELECT * FROM customers;