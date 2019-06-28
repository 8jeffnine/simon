CREATE TABLE mysql.meta (
	seq INT(11) NOT NULL AUTO_INCREMENT,
	comp VARCHAR(30) NULL DEFAULT NULL,
	gbn VARCHAR(10) NULL DEFAULT NULL,
	meta_url LONGTEXT NOT NULL,
	i_start VARCHAR(10) NULL DEFAULT NULL,
	i_end VARCHAR(10) NULL DEFAULT NULL,
	i_cnt VARCHAR(10) NULL DEFAULT NULL,
	ppi VARCHAR(10) NULL DEFAULT NULL,
	rrsidno VARCHAR(30) NULL DEFAULT 'SYSTEM',
	rrt DATETIME NULL DEFAULT NULL,
	PRIMARY KEY(seq)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=0
;
