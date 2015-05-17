insert into MODIFICATION(MODIFICATIONID, MODIFDATETIME, OPERATOR)
values (1, to_date('2015-03-29 16:42:66', 'YYYY-MM-DD HH:MI:SS'), 'initializer');
   
INSERT INTO EMPLOYEE(EMPLOYEEID, EMPLOYEEUUID, CODE, LASTNAME, FIRSTNAME, MIDDLENAME, ACTIVE, VERSTATUS, VERNO,SINCEMODIFICATIONID)
VALUES ( 1,
         'emp-0001',
         'adeac',
         'DEAC',
         'Alexandru',
         NULL,
         1,
         'C',
         1,
         1);
         
INSERT INTO EMPLOYEE(EMPLOYEEID, EMPLOYEEUUID, CODE, LASTNAME, FIRSTNAME, MIDDLENAME, ACTIVE, VERSTATUS, VERNO, SINCEMODIFICATIONID)
VALUES ( 2,
         'emp-0002',
         'mcimpean',
         'CIMPEAN',
         'Maria',
         'Mihaela',
         1,
         'C',
         1,
         1);
         
drop sequence SQ_MODIFICATION_IDENTITY;
create sequence SQ_MODIFICATION_IDENTITY start with 10;
drop sequence SQ_EMPLOYEE_IDENTITY;
create sequence SQ_EMPLOYEE_IDENTITY start with 10;