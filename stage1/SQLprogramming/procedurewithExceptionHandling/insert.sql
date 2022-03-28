Set Serveroutput on;
CREATE OR REPLACE PROCEDURE CHECK_AGE_ELIGIBILITY
(
    v_id IN number, 
    v_name IN varchar, 
    v_age IN number 
 )
AS
    ex_age EXCEPTION;
BEGIN 
    IF v_age >17 THEN 
        INSERT INTO EMPLOYEE VALUES(v_id,v_name,v_age);
        DBMS_OUTPUT.PUT_LINE('Age valid - Record inserted');
    ELSE 
        RAISE ex_age;
    END IF;
EXCEPTION
        WHEN EX_AGE THEN
            DBMS_OUTPUT.PUT_LINE('Age invalid - Record not inserted');
END;
/