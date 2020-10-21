drop table bbs01;
drop sequence bbs01_seq;
--
create table bbs01(
   num number primary key,
   sub varchar2(30) default '제목없음',
   nalja DATE,
   id varchar2(30),
   cntnt varchar2(2000),
   no number, 
   ref number, 
   lev number
);
create sequence bbs01_seq;
--dummy date

commit;