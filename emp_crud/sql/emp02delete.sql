create or replace procedure emp02delete
(result out binary_integer, psabun emp02.sabun%type)
is
begin
	delete from emp02 where sabun=psabun;
	result := sql%rowcount;
	commit;
end;
/