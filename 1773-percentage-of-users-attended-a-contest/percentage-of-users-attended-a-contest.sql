# Write your MySQL query statement below
with u as (
    select count(1) as cnt from Users
)

select 
r.contest_id,
round(
     (count(r.user_id) / u.cnt ) * 100
    ,
    2
) as percentage
from Register r
join u on 1=1
group by r.contest_id
order by 2 DESC, 1 ASC
