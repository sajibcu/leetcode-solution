# Write your MySQL query statement below
select e.*
from 
(
    (
        select 
        salary as SecondHighestSalary
        from Employee
        group by salary
        order by salary DESC
        limit 1, 1
    )

    union all
    select null
) as e
limit 1
