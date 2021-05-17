drop table board;

/* 답변형 테이블 */
create table board(
seq number(5) primary key,
title varchar2(200),
writer varchar2(200),
content varchar2(2000),
regdate date default sysdate,
cnt number(5) default 0,
re_ref number(5),
re_lev number(5),
re_seq number(5)
);

alter table board add uploadFile varchar2(100);

-- 답변형 테이블 수정 
alter table board add re_ref number(5);
alter table board add re_lev number(5);
alter table board add re_seq number(5);
-- 좋아요 싫어요 칼럼 추가
alter table board add good number(5) default 0;
alter table board add bad number(5) default 0;

select * from board;

select * from board order by seq desc;

update board set re_seq=0 where seq=7146;
commit;
update board set re_lev=0 where seq=7146;
commit;

select * from board where re_seq=0;
select * from board where seq=re_ref;
select * from board where re_ref=7146 and seq!=re_ref;

update board set re_ref=7146 where seq between 7146 and 7156;
commit;


select max(seq) from board;

create sequence board_temp_seq start with 5000 increment by 1;

insert into board(seq, title, writer,content,regdate,cnt)
select board_temp_seq.nextval, title,writer,content,sysdate,0 from board;
commit;

select  title,writer,content,sysdate,0 from board;

drop table users;

create table users(
id varchar2(20)primary key,
password varchar2(20) not null,
name varchar2(20) not null,
role varchar2(20)  default 'user'
);


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





