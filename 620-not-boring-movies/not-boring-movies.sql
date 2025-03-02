# Write your MySQL query statement below
select *
from Cinema c
where c.id %2 = 1 and c.description <> 'boring' 
order by c.rating DESC
