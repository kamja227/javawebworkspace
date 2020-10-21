-- emp02detail.sql
create or replace procedure emp02detail
(psabun in emp02.sabun%type, cur out sys_refcursor)
is
begin
	open cur for select * from emp02 where sabun = psabun;
end;
/
--SQL>  declare
--  2   v_row emp02%rowtype;
--  3   cur sys_refcursor;
--  4   begin
--  5   emp02detail(1111, cur);
--  6   fetch cur into v_row;
--  7   dbms_output.put_line(v_row.sabun || v_row.name);
--  8   close cur;
--  9   end;
-- 10   /
