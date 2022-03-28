DECLARE 
    d_name  Department.Department_name%type := 'TESTING';
    d_loc   Department.LOCATION_ID%type := 'CHN-102'; 
BEGIN
        INSERT INTO Department(Department_ID,Department_name,location_id) 
        SELECT MAX(Department_ID)+10 , d_name, d_loc FROM Department;
END;
  /