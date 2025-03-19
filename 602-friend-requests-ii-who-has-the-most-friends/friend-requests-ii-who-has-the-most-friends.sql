# Write your MySQL query statement below
select
s.id,
count(1) as num 
from
(
    select requester_id as id
    from RequestAccepted

    union all

    select accepter_id as id
    from RequestAccepted 
) s
group by s.id
order by 2 desc
limit 1;
