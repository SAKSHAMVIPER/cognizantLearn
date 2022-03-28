CREATE OR REPLACE PACKAGE emp_designation
AS 
PROCEDURE emp_details (design employee.designation%TYPE, incentive NUMBER);
END emp_designation;
/

CREATE OR REPLACE PACKAGE BODY emp_designation
AS 
PROCEDURE emp_details (design employee.designation%TYPE, incentive NUMBER)
IS 
BEGIN
UPDATE employee
SET employee.salary = employee.salary + incentive
 WHERE employee.designation = design;
  DBMS_OUTPUT.put_line ( SQL%ROWCOUNT || ' employee(s) are updated.');
   END emp_details;
   END emp_designation;
   /