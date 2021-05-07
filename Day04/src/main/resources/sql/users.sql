create table users(
id varchar2(20)primary key,
password varchar2(20) not null,
name varchar2(20) not null,
postcode char(5),
roadAddress varchar2(150),
jubunAddress varchar2(150),
detailAddress varchar2(100),
extraAddress varchar2(50),
role varchar2(20)  default 'user'
);

alter table users add postcode char(5);
alter table users add roadAddress varchar2(150);
alter table users add jubunAddress varchar2(150);
alter table users add detailAddress varchar2(1o0);
alter table users add extraAddress varchar2(50);


