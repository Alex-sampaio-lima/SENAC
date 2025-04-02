-- Active: 1742298205607@@127.0.0.1@3306@sakila

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

CREATE PROCEDURE valor_total_cliente_comissao()
BEGIN
    SELECT p.customer_id as Cod, c.first_name as Cliente, p.staff_id as 'Gerente', SUM(p.amount) as 'Valor Total', FORMAT((SUM(p.amount) * 0.05),  2) as 'Comissão do Gerente'
    FROM payment as p
    INNER JOIN customer as c USING (customer_id)
    GROUP BY customer_id, staff_id;
END;

DROP PROCEDURE valor_total_cliente_comissao;

CALL valor_total_cliente_comissao ();
-- 2 - Construa uma função para incluir endereço completo de um cliente

CREATE FUNCTION cadastrar_cidade(nome VARCHAR(255), nome_pais VARCHAR(255))
RETURNS INT
-- aqui dizemos que essa Function vai retornar um VARCHAR(255)
DETERMINISTIC

BEGIN
-- DECLARE endereco VARHCAR(255)
    DECLARE pais_id INT;
    DECLARE cidade_id INT;
    -- aqui declaramos uma variavel para retornamos
    SELECT country_id INTO pais_id FROM country WHERE country = nome_pais;
        IF pais_id IS NULL THEN
            SET pais_id = cadastrar_pais(nome_pais);
        END IF;
        INSERT INTO city (city, country_id) VALUES (nome, pais_id);
            SELECT LAST_INSERT() INTO cidade_id;
        RETURN cidade_id;
END;

CREATE FUNCTION cadastrar_pais(nome VARCHAR(255))
RETURNS INT
-- aqui dizemos que essa Funciton vai retornar um VARCHAR(255)
DETERMINISTIC

BEGIN 
    -- DECLARE endereco VARCHAR(255)
    DECLARE pais_id INT;

    INSERT INTO country (country) VALUES (nome);
        SELECT LAST_INSERT_ID() INTO pais_id;
    RETURN paid_id;
END;




DROP FUNCTION endereco_completo;


-- 3 - Construa uma trigger para dar baixa do empréstimo(locação) do filme
-- que o usuário alugar(supondo que exista um campo com a quantidade, no cadastro do filme)









-- 4 - Qual o procedimento para criar um usuário novo de acesso ao banco sakila com privilégios de extrai consultas.








