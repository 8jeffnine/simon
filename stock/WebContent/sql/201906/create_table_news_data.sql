CREATE TABLE mysql.news_data (
	seq INT(11) NOT NULL AUTO_INCREMENT,
	news_code VARCHAR(30) NULL DEFAULT NULL,
	dt VARCHAR(8) NULL DEFAULT NULL,
	title VARCHAR(100) NULL DEFAULT NULL,
	link LONGTEXT NOT NULL,
	rrsidno VARCHAR(30) NULL DEFAULT 'SYSTEM',
	rrt DATETIME NULL DEFAULT NULL,
	modidno VARCHAR(30) NULL DEFAULT NULL,
	modrrt DATETIME NULL DEFAULT NULL,
	PRIMARY KEY(seq)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=0
;
