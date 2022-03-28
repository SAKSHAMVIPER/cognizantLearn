DECLARE 
    
    R number := 3;      
    PI number := 3.14;
BEGIN 
    FOR R IN 3..7
    LOOP 
        INSERT INTO Circle  VALUES(R,PI*R*R);
    END LOOP;

END;

/





 