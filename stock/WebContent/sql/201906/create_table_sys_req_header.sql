CREATE TABLE `sys_req_header` (
	`seq` INT(11) NOT NULL AUTO_INCREMENT,
	`compcd` VARCHAR(8) NOT NULL,
	`method` VARCHAR(8) NULL DEFAULT NULL,
	`accept` VARCHAR(20) NULL DEFAULT NULL,
	`a_encoding` VARCHAR(50) NULL DEFAULT NULL,
	`a_lang` VARCHAR(50) NULL DEFAULT NULL,
	`cache` VARCHAR(50) NULL DEFAULT NULL,
	`host` VARCHAR(50) NULL DEFAULT NULL,
	`referer` VARCHAR(50) NULL DEFAULT NULL,
	`origin` VARCHAR(50) NULL DEFAULT NULL,
	`proxy` VARCHAR(20) NULL DEFAULT NULL,
	`upgrade` VARCHAR(8) NULL DEFAULT NULL,
	`x_requested` VARCHAR(50) NULL DEFAULT NULL,
	`cookie` VARCHAR(200) NULL DEFAULT NULL,
	`rrsidno` VARCHAR(30) NULL DEFAULT 'SYSTEM',
	`rrt` DATETIME NULL DEFAULT NULL,
	PRIMARY KEY (`seq`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=2
;
