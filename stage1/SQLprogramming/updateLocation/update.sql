begin

update department

set LOCATION_ID='HQ-BLR-101'

WHERE LOCATION_ID LIKE 'HQ%';

END;

/