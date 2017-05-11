DROP PROCEDURE IF EXISTS `imap_contacts`.`DeleteFriendship`;

DELIMITER |

CREATE DEFINER = `imap_contacts` PROCEDURE `imap_contacts`.`DeleteFriendship` (IN u_key_a BINARY(4), IN u_key_b BINARY(4))
LANGUAGE SQL
DETERMINISTIC
MODIFIES SQL DATA
SQL SECURITY DEFINER
COMMENT 'Supprime une relation d\'ami'
BEGIN
	IF u_key_a <=> u_key_b THEN
		SIGNAL SQLSTATE VALUE '45000' SET MYSQL_ERRNO = 10004, MESSAGE_TEXT = 'User keys are the same';
	ELSEIF u_key_a IS NULL THEN
		SIGNAL SQLSTATE VALUE '45000' SET MYSQL_ERRNO = 10005, MESSAGE_TEXT = 'Wrong user key';
	ELSEIF u_key_b IS NULL THEN
		SIGNAL SQLSTATE VALUE '45000' SET MYSQL_ERRNO = 10005, MESSAGE_TEXT = 'Wrong user key';
	ELSE
		DELETE FROM `friends` WHERE (`user_a` = u_key_a AND `user_b` = u_key_b) OR (`user_a` = u_key_b AND `user_b` = u_key_a);
	END IF;
END;
|

DELIMITER ;
