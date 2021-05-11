select * from board where title like '%'||'테스트'||'%' order by seq desc;
select * from board where content like '%'||'테스트'||'%' order by seq desc;

select *
 from
(select rownum rn, a.*
 from 
(select * 
  from board 
  where title like '%'||'파일'||'%'
  order by seq desc) a)
--where rn between 21 and 30
where rn >= 1 and rn <= 10
;

select *
 from
(select rownum rn, a.*
 from 
(select * 
  from board 
  where content like '%'||'파일'||'%'
  order by seq desc) a)
--where rn between 21 and 30
where rn >= 1 and rn <= 10
;

select *
 from
(select rownum rn, a.*
 from 
(select * 
  from board 
  order by seq desc) a)
--where rn between 21 and 30
where rn >= 11 and rn <= 20
;
페이지번호,  시작글번호,         끝 글 번호
 1:        (1-1)*10 +1=1,   10: 1 + 9 =10 
 2:        (2-1)*10 +1=11,  20: 11 + 9 =20
 3:        (3-1)*10 +1=21,  30: 21 + 9 =30
        (페이지번호 -1)*페이지당 글 갯수 + 1, 끝 글 번호 = 시작글 번호 + 9 

        전체 페이지:     
select count(*)/10  from board; -- 10으로 나눈 나머지가 있으면 + 1 
select count(*) from board where content like '%'||'파일'||'%';  
select count(*) from board where title like '%'||'파일'||'%'; 
