CREATE DEFINER='root'@'%' PROCEDURE 'c_joblist'()
LANGUAGE SQL
NOT DETERMINISTIC
CONTAINS SQL
SQL SECURITY DEFINER
COMMENT ''

BEGIN

DECLARE v_cnt INT;
DECLARE i INT;
DECLARE j INT;

DECLARE v_wday VARCHAR(2);
DECLARE v_hday VARCHAR(2);
DECLARE v_type VARCHAR(10);
DECLARE v_var01 VARCHAR(10);
DECLARE v_var02s INT;
DECLARE v_var02e INT;

DECLARE n_wday VARCHAR(2);
DECLARE n_hday VARCHAR(2);
DECLARE n_date VARCHAR(8);
 	
 	select count(*) into v_cnt
	from job_schedule
	where useyn = 'Y';

	select weekday(sysdate()) into n_wday from dual;
	select date_format(sysdate(),'%H') into n_hday from dual;
	select date_format(sysdate(),'%Y%m%d') into n_date from dual;

	 set j = 1;	 
	 while j <= v_cnt do
	 	
	 	select c.wday, c.hday, c.type, c.var01, c.var02s, c.var02e into v_wday, v_hday, v_type, v_var01, v_var02s, v_var02e
		from (select @rownum:=@rownum+1 as rownum, a.type, a.var01, a.var02s, a.var02e, a.wday, a.hday
		from job_schedule a, (select @rownum:=0) b  
		where a.useyn = 'Y') c
		where c.rownum = j;
		
		select weekday(sysdate()) into n_wday from dual;
		select date_format(sysdate(),'%H') into n_hday from dual;
		select date_format(sysdate(),'%Y%m%d') into n_date from dual;
		
										
	 	/** 요일에 따라 수행 */
	 	if (v_wday >= n_wday ) then
		 	/** 시간에 따라 수행 */
		 	if (v_hday = n_hday ) then
			 	/** type 에 따라 수행 */
			 	if ('Stock' = v_type ) then
 					
					set i = v_var02s;
					while i <= v_var02e do
 					 	insert into joblist
				 		select 'Daum', 'price', concat('http://finance.daum.net/item/quote_yyyymmdd_sub.daum?page=',i,'&code=',v_var01,'&modify=0'), '0', null, null, 'system', now()
				 		from dual;

				 		set i = i+1;
	 				end while;
	 				
			 	elseif ('News' = v_type ) then
					/** 언론사별 반복횟수 지정 */
					set i = v_var02s;
					while i <= v_var02e do
						 	
				 		
				 		insert into joblist	 		
	 					select 'N2', v_var01, concat('http://news.naver.com/main/list.nhn?mode=LPOD&mid=sec&listType=paper&oid=',v_var01,'&date=',n_date,'&page=',i), '0', null, null, 'system', now()
	 					from dual;

						set i = i+1;
					end while;
			 	
			 	end if;
	 		end if;
	 	end if;
	 	

	 	set j = j+1;
	 end while;
	 
	 commit;

END
