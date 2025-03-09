# Write your MySQL query statement below
with em as (
    select 
    e.reports_to,
    count(1) cnt,
    AVG(age) AS  age
    from Employees e
    where e.reports_to is not null
    group by e.reports_to
)
select 
em.reports_to as employee_id,
e.name,
em.cnt as reports_count,
round( em.age ) as average_age 
from em
left join Employees e on e.employee_id = em.reports_to
order by 1 asc;