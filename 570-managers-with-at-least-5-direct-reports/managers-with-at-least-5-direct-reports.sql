-- # Write your MySQL query statement below
select e.name
from Employee e
inner join  ( 
    select ee.managerId from Employee ee 
    where ee.managerId is not null and ee.managerId <> ee.id 
    group by ee.managerId
    having (count(1) > 4)
) m on m.managerId = e.id

