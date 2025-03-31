SELECT * FROM getcount;

INSERT INTO getcount (str) VALUES ('orelha');
INSERT INTO getcount (str) VALUES ('Macaco');
INSERT INTO getcount (str) VALUES ('Gorila');
INSERT INTO getcount (str) VALUES ('Manchester');
INSERT INTO getcount (str) VALUES ('Se eu estou andando e olho para o lado');
INSERT INTO getcount (str) VALUES ('A E I O U');
INSERT INTO getcount (str) VALUES ('@');

SELECT * FROM getcount;

CREATE FUNCTION contar_vogais(str VARCHAR(255))
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE count INT
    IF str = 'a'
        SET count = 1;

END $$

SELECT getcount.str FROM getcount
  WHERE getcount.str LIKE 'A%';


SELECT getcount.str FROM getcount WHERE LEFT(getcount.str, 1) = 'a';




SELECT count(*) AS 'res' FROM getcount 
    WHERE LEFT(getcount.str, 1) IN ('a' OR 'e' OR 'i' OR 'o' OR 'i');


SELECT COUNT(str) AS 'Total de vogais' FROM getcount
    WHERE CHAR_LENGTH(str) IN('a');


SELECT getcount.str AS str,
    SUM(CHAR_LENGTH(getcount.str) - CHAR_LENGTH(REPLACE(LOWER(getcount.str), 'a', ''))) + 
    SUM(CHAR_LENGTH(getcount.str) - CHAR_LENGTH(REPLACE(LOWER(getcount.str), 'e', ''))) +
    SUM(CHAR_LENGTH(getcount.str) - CHAR_LENGTH(REPLACE(LOWER(getcount.str), 'i', ''))) +
    SUM(CHAR_LENGTH(getcount.str) - CHAR_LENGTH(REPLACE(LOWER(getcount.str), 'o', ''))) +
    SUM(CHAR_LENGTH(getcount.str) - CHAR_LENGTH(REPLACE(LOWER(getcount.str), 'u', ''))) 
    AS res
FROM getcount
GROUP BY str;


SELECT * FROM getcount;



CREATE PROCEDURE WhileExample(a INT)
BEGIN
    DECLARE i INT DEFAULT 1;

    WHILE i <= a DO
        SELECT i;
        SET i = i + 1;
    END WHILE;

    RETURN i;
END $$


DROP PROCEDURE `WhileExample`;
CALL `WhileExample`(50);