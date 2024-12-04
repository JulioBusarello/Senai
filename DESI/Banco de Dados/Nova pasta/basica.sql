USE db_tecnico;
DROP PROCEDURE IF EXISTS ola_mundo;

DELIMITER $$
USE db_tecnico $$
CREATE PROCEDURE ola_mundo()
BEGIN
	SELECT "OLA MUNDO";
END $$

DELIMITER ;

CALL ola_mundo();