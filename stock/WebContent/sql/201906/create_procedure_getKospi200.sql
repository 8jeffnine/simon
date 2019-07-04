CREATE DEFINER='root'@'%' PROCEDURE `getKospi200`()
LANGUAGE SQL
NOT DETERMINISTIC
CONTAINS SQL
SQL SECURITY DEFINER
COMMENT ''
BEGIN
/**
 * KOSPI200 종목변경시 200에 해당하는 종목데이터 추출을 위해 NAVER-FINANCE의 정보를 수집
 * 
 */
DECLARE i INT;

SET i = 1;

while i<=20 do

INSERT INTO mysql.joblist
SELECT max(seq)+1, substr(MD5(RAND()),13), '', 'naver', concat('https://finance.naver.com/sise/entryJongmok.nhn?&page=',i)
, 0, NULL, NULL, 0, 'system', NOW() FROM joblist;

set i = i+1;

END while;

COMMIT;

END

-- call getKospi200(); // 실행시 