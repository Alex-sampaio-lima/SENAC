-- Active: 1727986491233@@127.0.0.1@3306@sakila

-- 1 - Criar uma procedure para gerar o valor total gasto por cliente
-- imprima a comissão de cada gerente sendo 5% sobre o valor pago

SELECT * FROM customer;

SELECT * FROM payment;

SELECT SUM(p.amount), p.staff_id
FROM customer AS c
    INNER JOIN payment AS p ON c.customer_id = p.customer_id
GROUP BY
    c.address_id,
    p.amount,
    p.staff_id
ORDER BY p.amount DESC;

-- CREATE PROCEDURE valor_total_cliente_comissao()
-- BEGIN
    SELECT p.customer_id as Cod, c.first_name as Cliente, p.staff_id as 'Gerente', SUM(p.amount) as 'Valor Total', FORMAT((SUM(p.amount) * 0.05),  2) as 'Comissão do Gerente'
    FROM payment as p
    INNER JOIN customer as c USING (customer_id)
    GROUP BY customer_id, staff_id;
-- END;

DROP PROCEDURE valor_total_cliente_comissao;

CALL valor_total_cliente_comissao ();










-- 2 - Construa uma função para incluir endereço completo de um cliente

CREATE FUNCTION endereco_completo(endereco VARCHAR(255), bairro VARCHAR(255), cidade VARCHAR(255), nome_pais VARCHAR(255))
RETURNS VARCHAR(255)
-- Aqui dizemos que essa Function vai retornar um VARCHAR(255)
DETERMINISTIC
BEGIN
    DECLARE cidade_id INT;
    DECLARE pais_id INT;
    DECLARE local_cod GEOMETRY;
    DECLARE mensagem VARCHAR(255);
    SET mensagem = 'teste';
    SET local_cod = ST_GeomFromText('POINT(153.1408538 -27.6333361)');
        INSERT INTO country (country, last_update) VALUES (nome_pais, now());
        SET pais_id = @@IDENTITY;
        INSERT INTO city (city, country_id, last_update) VALUES (cidade, pais_id, now());
        SET cidade_id = @@IDENTITY;
        INSERT INTO address(address, address2, district, postal_code, phone, location, city_id) 
                    VALUES (endereco, '', bairro, '0000-0000', '2222', local_cod, cidade_id);
        RETURN mensagem;
END;

DROP FUNCTION endereco_completo;

SELECT endereco_completo('Romulo', 'Rua', 'São Paulo', 'Brasil2');

SELECT * FROM address ORDER BY address_id DESC;

DESC address;
DESC city;

SELECT * FROM address;

DROP FUNCTION endereco_completo;

ALTER TABLE address DROP INDEX location;

ALTER TABLE address MODIFY location GEOMETRY NULL;

SELECT * FROM address;

SHOW INDEX FROM address;

CREATE FUNCTION cadastrar_cidade(nome VARCHAR(255), nome_pais VARCHAR(255))
RETURNS INT
-- aqui dizemos que essa Function vai retornar um VARCHAR(255)
DETERMINISTIC

BEGIN
-- DECLARE endereco VARHCAR(255)
    -- aqui declaramos uma variavel para retornamos
    DECLARE pais_id INT;
    DECLARE cidade_id INT;
    -- Tenta encontrar o país com aquele nome, se encontrar, salva o country_id  na variável pais_id, se não encontrar, pais_id será NULL
    SELECT country_id INTO pais_id FROM country WHERE country = nome_pais;
        -- Se o país não exisitr, então é chamada a função cadastrar_pais para criar esse país, salva o id retornado na variavel pais_id
        IF pais_id IS NULL THEN
            SET pais_id = cadastrar_pais(nome_pais);
        END IF;
        -- Cria a nova cidade com o nome e o country_id correspondente
        INSERT INTO city (city, country_id) VALUES (nome, pais_id);
        -- Pega o ID da última inserção feita (ou seja, da cidade que acabou de ser criada) e armazena esse valor em cidade_id
            SELECT LAST_INSERT_ID() INTO cidade_id;
        RETURN cidade_id;
END;

DROP FUNCTION cadastrar_cidade;

SELECT cadastrar_cidade('São Paulo', 'Brazil');

SELECT city.city FROM city WHERE city.city = 'São Paulo';
SELECT c.city, c.city_id, c.last_update, c.country_id FROM city AS c WHERE c.city = 'São Paulo';

SELECT * FROM customer AS c;

CREATE FUNCTION cadastrar_pais(nome VARCHAR(255))
RETURNS INT
-- aqui dizemos que essa Funciton vai retornar um VARCHAR(255)
DETERMINISTIC

BEGIN 
    -- DECLARE endereco VARCHAR(255)
    DECLARE pais_id INT;

    INSERT INTO country (country) VALUES (nome);
        SELECT LAST_INSERT_ID() INTO pais_id;
    RETURN pais_id;
END;

DROP FUNCTION cadastrar_pais;

SELECT LAST_INSERT_ID(customer.customer_id);

SELECT MAX(customer_id) FROM customer;

SELECT cadastrar_pais('');

DROP FUNCTION endereco_completo;


-- 3 - Construa uma trigger para dar baixa do empréstimo(locação) do filme
-- que o usuário alugar(supondo que exista um campo com a quantidade, no cadastro do filme)

SELECT * FROM film ORDER BY film_id DESC;

SELECT * FROM inventory;
DESC rental;

CREATE FUNCTION valor_valido(qtd INT)
RETURNS VARCHAR(255)
DETERMINISTIC
BEGIN
    DECLARE mensagem VARCHAR(255);

    IF qtd = 0 THEN
        SET mensagem = 'Operação inválida, nenhum filme foi alugado ainda!';
    END IF;
    RETURN mensagem;
END;

SELECT film.film_id, valor_valido(film.qtd) AS 'Verificador' FROM film;


CREATE TRIGGER baixa_emprestimo AFTER INSERT ON rental FOR EACH ROW
BEGIN
    DECLARE id_Do_Filme_No_Inventory INT;

    SELECT film_id INTO id_Do_Filme_No_Inventory
    FROM inventory
    WHERE inventory_id = NEW.inventory_id;
    
    UPDATE film AS f SET qtd = qtd - 1 WHERE f.film_id = id_Do_Filme_No_Inventory; 
    
    -- Outra maneira de fazer isso
    -- UPDATE film SET qtd = qtd - 1 
    -- WHERE film_id = (
    --     SELECT film_id
    --     FROM inventory
    --     WHERE inventory_id = NEW.inventory_id;
    -- )
END;

DROP TRIGGER baixa_emprestimo;

SHOW TRIGGERS LIKE 'rental'

ALTER TABLE film ADD COLUMN qtd INT DEFAULT(0);
ALTER TABLE film DROP COLUMN qtd;
INSERT INTO rental (inventory_id, customer_id, return_date, staff_id) 
            VALUES (367, 220, '2025-05-27 22:42:43', 1);


SELECT * FROM film WHERE film.qtd = 1;

SELECT * FROM film WHERE film_id = 80;

SELECT * FROM rental WHERE inventory_id = 80;
DESC rental;

INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, `length`, replacement_cost, rating, special_features) 
           VALUES('Harry Potter', 'Um flime sobre', 2003, 1, 87, 10.99, 99, 20.32, 'PG', 'Trailers');


SELECT * FROM film;


-- 4 - Qual o procedimento para criar um usuário novo de acesso ao banco sakila com privilégios de extrai consultas.


-- Criando usuário
CREATE USER 'alek'@'localhost' IDENTIFIED BY '1010';

-- Concedendo permissão para o usuário
GRANT SELECT ON sakila.* TO 'alek'@'localhost';

-- Rodar o Flush Privilegies para forçar o MySQL a recarregar as permissões.
FLUSH PRIVILEGES;




-- Ver todos os usuários existentes;
SELECT user, host FROM mysql.user;

-- Verificar os privilégios do usuário;
SHOW GRANTS FOR 'alek'@'localhost';

-- Verificar usuários com acesso ao banco sakila:

SELECT user, host FROM mysql.user;


-- Como excluir um usuário
DROP USER 'alek'@'localhost';

SELECT user, host FROM mysql.user WHERE user = 'root';









-- Como copiar uma tabela

CREATE TABLE ator AS SELECT * FROM actor;

SELECT * FROM ator;

DROP TABLE ator;

-- Limpar a tabela e continuar com os atributos.
TRUNCATE ator;