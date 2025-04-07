-- Active: 1727986491233@@127.0.0.1@3306@outsidestudy


DROP FUNCTION IF EXISTS SomaValoresInteiros;

CREATE FUNCTION SomaValoresInteiros(valor1 INT, valor2 INT)
RETURNS INT
DETERMINISTIC
BEGIN 
    DECLARE resultado INT;
    SET resultado = valor1 + valor2;
    RETURN resultado;
END;

SELECT `SomaValoresInteiros`(132, 32);


DROP FUNCTION calcular_desconto;

CREATE FUNCTION calcular_desconto(valor DECIMAL(10,2))
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE desconto DECIMAL(10,2);

    IF valor > 5.00 THEN
        SET desconto = valor * 0.05;
    ELSEIF valor > 2.00 THEN
        SET desconto = valor * 0.03;
    ELSE 
        SET desconto = valor * 0.02;
    END IF;

    RETURN desconto;
END;

SELECT calcular_desconto(190.50);






















