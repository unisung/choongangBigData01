create table users(
id varchar2(20)primary key,
password varchar2(20) not null,
name varchar2(20) not null,
role varchar2(20)  default 'user'
);
