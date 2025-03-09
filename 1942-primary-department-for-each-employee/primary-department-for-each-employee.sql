# Write your MySQL query statement below

select e.employee_id , e.department_id
from Employee e
where e.primary_flag = 'Y' or e.employee_id in (
    select employee_id from Employee ee 
    where ee.employee_id = e.employee_id 
    group by ee.employee_id
    having count(ee.employee_id) = 1
)


