# Write your MySQL query statement below
with singleDep as (
    select employee_id from Employee ee 
    group by ee.employee_id
    having count(ee.employee_id) = 1
)
select e.employee_id , e.department_id
from Employee e
left join singleDep using(employee_id)
where e.primary_flag = 'Y' or singleDep.employee_id is not null


