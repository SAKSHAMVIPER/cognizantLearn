-- Write a query to display the names of the departments in block number 3. Sort the records in ascending order.
select department_name from Department
where department_block_number = 3
order by department_name;