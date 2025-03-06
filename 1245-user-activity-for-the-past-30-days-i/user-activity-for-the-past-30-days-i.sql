# Write your MySQL query statement below
select activity_date as day,
count(distinct user_id ) active_users
from Activity
where activity_date > '2019-06-27' and activity_date <= '2019-07-27'
group by 1
