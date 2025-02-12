-- # Write your MySQL query statement below
select e.name
from Employee e
where e.id in ( 
    select ee.managerId from Employee ee 
    where ee.managerId is not null and ee.managerId <> ee.id 
    group by ee.managerId
    having (count(1) > 4)
)

