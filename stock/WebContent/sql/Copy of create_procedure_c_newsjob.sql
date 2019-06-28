CREATE PROCEDURE catchmi.c_newsjob()
LANGUAGE SQL
NOT DETERMINISTIC
CONTAINS SQL
SQL SECURITY DEFINER
COMMENT ''
BEGIN
	 DECLEAR v_end INT;
	 DECLEAR v_cnt INT;
	 DECLEAR v_date VARCHAR(20);
	 DECLEAR v_query VARCHAR(200);
	 DECLEAR i INT;
	 DECLEAR j INT;
	 
	 
	 select count(*) cnt into v_end
	 from catchmi.meta where comp = 'Naver';
	 
	 select DATE_FORMAT(NOW(),'&Y-&m-&d') dt into v_date
	 from dual;
	 
	 set i = 1;
	 
	 /** 등록된 keyword 만큼 반복 */
	 while i <= v_end do
	 	
	 	/** 각 keyword 별로 반복횟수 */
	 	select i_cnt into v_cnt
	 	from (select @RNUM := @RNUM+1 AS ROWNUM, i_cnt from (select * from cathcmi.meta where comp = 'Naver') t, (select @RNUM :=0) R) c 
	 	where c.rownum = i;
	 	
	 	set j = 1;
	 	
	 	while j <= v_cnt do
	 	
	 		insert into catchmi.joblist
	 		select comp, gbn, concat(meta_url,'&startDate=',v_date,'&endDate=',v_date,'&page=',j), '0', null, null, 'system', now()
	 		from (select @RNUM := @RNUM+1 AS ROWNUM, i_cnt from (select * from cathcmi.meta where comp = 'Naver') t, (select @RNUM :=0) R) c 
	 		where c.rownum = i;
	 		
	 		set j = j+1;
	 		
	 	end while;
	 	
	 	set i = i+1;
	 	
	 end while;
	 
	 commit;
	 
END 