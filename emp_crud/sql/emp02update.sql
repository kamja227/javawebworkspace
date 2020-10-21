/*
declare
	res binary_integer;
begin
	emp02update(res, 'test', 1000, 7777);
	dbms_output.put_line('result:'||res);
end;
/
*/
create or replace procedure emp02update
(
	result out binary_integer,
	pname emp02.name%type,
	ppay emp02.pay%type,
	psabun emp02.sabun%type
)
is
begin
	update emp02 set name=pname, nalja=sysdate, pay=ppay where sabun=psabun;
	result := sql%rowcount;
	commit;
end;
/