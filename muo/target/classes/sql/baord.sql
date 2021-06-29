-- 테이블 생성
create sequence seq_board increment by 1 start with 1;
--테이블 
create table tbl_board(
bno number(10,0),
title varchar2(200) not null,
content varchar2(2000) not null,
writer varchar2(50) not null,
regdate date default sysdate,
updatedate date default sysdate
);

--기본키 생성
alter table tbl_board add constraint pk_board primary key (bno);

insert into tbl_board(bno,title,content,writer)
values(seq_board.nextval, '제목 테스트', '내용 테스트', 'user00');
commit;


insert into tbl_board(bno,title,content,writer)
select seq_board.nextval, title,content,writer from tbl_board;
commit;

-- 댓글 칼럼 추가된 테이블 
create table tbl_board(
bno number(10,0),
title varchar2(200) not null,
content varchar2(2000) not null,
writer varchar2(50) not null,
replyCnt number default 0,
regdate date default sysdate,
updatedate date default sysdate
);

alter table tbl_board add replycnt number default 0;

update tbl_board set replycnt = (select count(*) 
                                   from tbl_reply 
                                  where tbl_reply.bno = tbl_board.bno);