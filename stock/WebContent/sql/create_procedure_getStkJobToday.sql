CREATE DEFINER='root'@'%' PROCEDURE 'getStkJobToday'()
LANGUAGE SQL
NOT DETERMINISTIC
CONTAINS SQL
SQL SECURITY DEFINER
COMMENT ''

BEGIN
-- Stock - price - 오늘데이터 수집을 위해 joblist 업데이트
update mysql.joblist
SET s_status = 0
WHERE comp = 'nvf02' AND s_url LIKE '%page=1&%';

COMMIT;

END
