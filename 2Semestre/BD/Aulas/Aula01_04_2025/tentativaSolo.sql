-- Active: 1727986491233@@127.0.0.1@3306@sakila


-- 1 - Criar uma procedure para gerar o valor total gasto por cliente
-- imprima a comissão de cada gerente sendo 5% sobre o valor pago

SELECT * FROM customer;

SELECT * FROM payment;

SELECT 
    p.staff_id 'Gerente',
    c.first_name AS 'Nome do Cliente',
    SUM(p.amount) AS 'Total Gasto' ,
    SUM(p.amount * 0.05) AS 'Comissão do Gerente'
FROM payment AS p
INNER JOIN customer AS c ON c.customer_id = p.customer_id
GROUP BY first_name, staff_id
ORDER BY c.first_name;


CREATE PROCEDURE valor_gasto()

BEGIN
    SELECT 
        p.staff_id AS 'Gerente',
        c.first_name AS 'Nome do Cliente',
        SUM(p.amount) AS 'Total gasto',
        SUM(p.amount * 0.05) 'Comissão do Gerente'
    FROM payment AS p
    INNER JOIN customer AS c ON c.customer_id = p.customer_id
    GROUP BY staff_id, first_name
    ORDER BY first_name;
END;


CALL valor_gasto();


-- 2 - Construa uma função para incluir endereço completo de um cliente
SELECT * FROM customer;
INSERT INTO country VALUES ('Brazil');

INSERT INTO city (city, country_id ) VALUES ('São Paulo', 15);

INSERT INTO address (address, district) VALUES ('Rua Asdrubal Gonçalves, 214', 'São Paulo');

SELECT * FROM country WHERE country = 'Brazil'; 

SELECT * FROM city;
SELECT * FROM country;

INSERT INTO customers (address_id) VALUES ('Japan');

-- Se o country estiver vazio você adiciona o país.

DESC city;
DESC country;
DESC customer;
DESC address;

SELECT * FROM city;
SELECT * FROM customer;

SELECT c.city, city_id, country_id FROM city AS c WHERE c.city = 'São Paulo';


CREATE FUNCTION cadastrar_endereco(country VARCHAR(50), city VARCHAR(50), country_id INT, );
RETURNS VARCHAR(255)
BEGIN 
    IF 











-- 3 - Construa uma trigger para dar baixa do empréstimo(locação) do filme que o usuário alugar(supondo que exista um campo com a quantidade, no cadastro do filme)



-- 4 - Qual o procedimento para criar um usuário novo de acesso ao banco sakila com privilégios de extrai consultas.
