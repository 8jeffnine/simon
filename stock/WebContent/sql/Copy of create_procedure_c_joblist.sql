CREATE PROCEDURE catchmi.c_joblist()
LANGUAGE SQL
NOT DETERMINISTIC
CONTAINS SQL
SQL SECURITY DEFINER
COMMENT ''
BEGIN
	 DECLARE v_end INT;
	 DECLARE v_cnt INT;
	 DECLARE i INT;
	 DECLARE j INT;
	 
	 set j = 1;
	 
	 select max(seq) into v_cnt from meta;
	 
	 while j <= v_cnt do
	 	
	 	select cast(i_end as UNSIGNED) into v_end
	 	from meta
	 	where seq = j;
	 	
	 	set i = 1;
	 	while i <= v_end do
	 		insert into joblist
	 		select comp, gbn, concat(meta_url,i), '0', null, null, rrsidno, now()
	 		from meta
	 		where seq = j;
	 		
	 		set i = i+1;
	 	end while;
	 	
	 	set j = j+1;
	 end while;
	 
	 commit;
	 
END 