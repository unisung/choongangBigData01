-- 다른테이블의 기존 데이타로 테이블 생성
-- create table 테이블명 as select문;
create table board_temp as
select * from board;
commit;

select * from board_temp;

select count(*) from board
union all
select count(*) from board_temp
union all
select count(*) from board_temp2;

--테이블 구조 복사 
create table board_temp2 as
select * from board where 1=2;

select * from board_Temp2;

-- insert into 테이블명(칼럼1,칼럼2,..) select * from 테이블명;
insert into board_temp2
select * from board;
commit;

-- 다른 테이블의 일부 칼럼으로 테이블 생성
CREATE TABLE board_tt as
select seq, title from board
where rownum < 100;
commit;

select * from board_tt;