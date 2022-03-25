-- Write a query to display list of students name and their department name who are all from 'Coimbatore'. Sort the result based on students name  
select s.student_name,
    d.department_name
from student s
    left join department d on s.department_id = d.department_id
where s.city = 'Coimbatore'
order by s.student_name;