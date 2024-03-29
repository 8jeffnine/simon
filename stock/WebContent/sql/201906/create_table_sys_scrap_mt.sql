CREATE TABLE `sys_scrap_mt` (
	`seq` INT(11) NOT NULL AUTO_INCREMENT,
	`scrap_id` VARCHAR(30) NOT NULL,
	`scrap_prs` VARCHAR(30) NOT NULL,
	`scrap_src` VARCHAR(50) NOT NULL,
	`scrap_dt` VARCHAR(8) NOT NULL,
	`s_url` LONGTEXT NOT NULL,
	`s_strdt` DATETIME NULL DEFAULT NULL,
	`s_enddt` DATETIME NULL DEFAULT NULL,
	`s_stat` VARCHAR(10) NOT NULL DEFAULT '0',
	`p_stat` VARCHAR(10) NOT NULL DEFAULT '0',
	`rrsidno` VARCHAR(30) NOT NULL DEFAULT 'SYSTEM',
	`rrt` DATETIME NULL DEFAULT NULL,
	`modidno` VARCHAR(30) NULL DEFAULT NULL,
	`modrrt` DATETIME NULL DEFAULT NULL,
	`useyn` VARCHAR(4) NULL DEFAULT 'Y',
	PRIMARY KEY (`seq`),
	UNIQUE INDEX `scrap_id` (`scrap_id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=91
;
