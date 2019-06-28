CREATE DEFINER='root'@'%' PROCEDURE `stock_joblist`()
LANGUAGE SQL
NOT DETERMINISTIC
CONTAINS SQL
SQL SECURITY DEFINER
COMMENT ''
BEGIN

DECLARE v_cnt INT;
DECLARE i INT;
DECLARE j INT;
 	
 	select count(*) into v_cnt
	from stock_add_scrap
	where useyn = 'Y';

	 set j = 1;	 
	 while j <= v_cnt do
	 	
	 	set i = 1;
	 	while i <= 58 do
	 	
	 		insert into joblist
	 		select 'Daum', 'price', concat('http://finance.daum.net/item/quote_yyyymmdd_sub.daum?page=',i,'&code=',stock_code,'&modify=0'), '0', null, null, 'system', now()
	 		from (select @rownum:=@rownum+1 as rownum, a.stock_code 
					from stock_meta a, (select @rownum:=0) b  
					where a.useyn = 'Y') c
	 		where c.rownum = j;
	 		
	 		set i = i+1;
	 	end while;
	 	
	 	set j = j+1;
	 end while;
	 
	 commit;
	 
END