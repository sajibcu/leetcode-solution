# Write your MySQL query statement below

select a.machine_id,
 round (
( SUM(CASE when a.activity_type = 'end' then a.timestamp else 0.0 end) -
    SUM(CASE when a.activity_type = 'start' then a.timestamp else 0.0 end)
 ) / 
SUM(CASE when a.activity_type = 'end' then 1 else 0 end)
 , 3)
as processing_time
from Activity a
group by a.machine_id
