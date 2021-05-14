select *from
 (select rownum rn, a.*
 from 
 (select * 
 from board 
 order by re_ref desc, re_seq asc) a)
 where rn between ? and ?
 ;
 
select * from
 (select rownum rn, a.*
 from 
 (select * 
 from board where title like '%'||?||'%'
 order by re_ref desc, re_seq asc) a)
 where rn between ? and ?
;

select * from
 (select rownum rn, a.*
 from 
 (select * 
 from board where content like '%'||?||'%'
 order by re_ref desc, re_seq asc) a)
 where rn between ? and ?
;