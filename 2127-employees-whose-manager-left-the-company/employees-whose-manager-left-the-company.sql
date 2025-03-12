# Write your MySQL query statement below

select e.employee_id
from Employees e
where e.manager_id is not null and e.salary <30000 
 AND NOT EXISTS (
      SELECT 1 FROM Employees ee WHERE ee.employee_id = e.manager_id
  )
order by e.employee_id asc
