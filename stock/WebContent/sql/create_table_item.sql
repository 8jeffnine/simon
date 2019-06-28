CREATE TABLE mysql.item (
	seq INT(11) NOT NULL AUTO_INCREMENT,
	brandname VARCHAR(100) NOT NULL,
	itemname VARCHAR(300) NOT NULL,
	disprice VARCHAR(30) NULL DEFAULT NULL,
	stdprice VARCHAR(30) NULL DEFAULT NULL,
	image_url VARCHAR(500) NOT NULL,
	colorhexcode VARCHAR(18) NULL DEFAULT NULL,
	colr VARCHAR(9) NULL DEFAULT NULL,
	colg VARCHAR(9) NULL DEFAULT NULL,
	colb VARCHAR(9) NULL DEFAULT NULL,
	rrt DATETIME NULL DEFAULT NULL,
	rrsidno VARCHAR(30) NULL DEFAULT 'SYSTEM',
	PRIMARY KEY(seq)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=0
;
