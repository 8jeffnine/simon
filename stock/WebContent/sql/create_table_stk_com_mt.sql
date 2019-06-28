CREATE TABLE `sys_cd_mt` (
	`seq` INT(11) NOT NULL AUTO_INCREMENT,
	`group_cd` VARCHAR(20) NOT NULL,
	`detail_cd` VARCHAR(20) NOT NULL,
	`lang_key` VARCHAR(4) NULL DEFAULT NULL,
	`cd_name` VARCHAR(50) NULL DEFAULT NULL,
	`cd_desc` VARCHAR(100) NULL DEFAULT NULL,
	`use_yn` VARCHAR(4) NULL DEFAULT NULL,
	`rrsidno` VARCHAR(50) NULL DEFAULT NULL,
	`rrt` DATETIME NULL DEFAULT NULL,
	`modidno` VARCHAR(50) NULL DEFAULT NULL,
	`modrrt` DATETIME NULL DEFAULT NULL,
	PRIMARY KEY (`seq`),
	UNIQUE INDEX `group_cd_detail_cd_lang_key` (`group_cd`, `detail_cd`, `lang_key`)
)
ENGINE=InnoDB
;
