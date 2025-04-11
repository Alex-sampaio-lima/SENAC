-- Active: 1742298205607@@127.0.0.1@3306@sakila


-- 1. Desenvolva uma função para receber o ID do cliente e gerar como resultado, o total por mês pago por cliente.

CREATE FUNCTION cliente_pago_mes(id_cliente INT)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE resultado DECIMAL(10,2);

    SELECT SUM(p.amount) INTO resultado FROM customer as c
    INNER JOIN payment AS p ON c.customer_id = p.customer_id
    WHERE c.customer_id = id_cliente;

    RETURN resultado;
END;
DROP FUNCTION cliente_pago_mes;
SELECT cliente_pago_mes(4);



SELECT c.customer_id, SUM(p.amount) FROM customer AS c
    INNER JOIN payment AS p ON c.customer_id = p.customer_id
    WHERE c.customer_id = 1;


-- 2. Desenvolva uma procedure para gerar um relatorio com as coluna.
-- ID cliente | nome | endereço | bairro | cidade | país

SELECT * FROm address;
CREATE PROCEDURE gerar_relatorio_clientes()
BEGIN
    SELECT 
        c.customer_id AS 'ID Cliente', 
        c.first_name AS 'Nome',
        endereco.address AS 'Endereço',
        endereco.district AS 'Bairro',
        cidade.city AS 'Cidade',
        pais.country AS 'País'
    FROM customer AS c
    INNER JOIN address AS endereco ON c.address_id = endereco.address_id
    INNER JOIN city AS cidade ON endereco.city_id = cidade.city_id
    INNER JOIN country AS pais ON cidade.country_id = pais.country_id
    ORDER BY c.customer_id;
END;

CALL gerar_relatorio_clientes;

DROP PROCEDURE gerar_relatorio_clientes;

SELECT * FROM customer;
SELECT * FROm address;
SELECT * FROm country;
SELECT * FROm city;


-- 3. Supondo que no cadastro de filmes, exista o campo quantidade quando realizar o emprestimo do flime,
-- construa uma trigger para realizar a baixa do emprestimo no campo quantidade.

CREATE TRIGGER baixa_emprestimo AFTER INSERT ON rental FOR EACH ROW
BEGIN
    DECLARE id_Do_Filme_No_Inventory INT;

    SELECT film_id INTO id_Do_Filme_No_Inventory
    FROM inventory
    WHERE inventory_id = NEW.inventory_id;
    
    UPDATE film AS f SET qtd = qtd - 1 WHERE f.film_id = id_Do_Filme_No_Inventory; 
    
END;


-- 4 - Qual o comando para criar o usuário 'joão' somente com permissão de alteração de dados e extração de consultas.


CREATE USER 'joão'@'localhost' IDENTIFIED BY '1010';

GRANT SELECT ON sakila.* TO 'joão'@'localhost';









