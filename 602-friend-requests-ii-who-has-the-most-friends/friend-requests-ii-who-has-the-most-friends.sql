# Write your MySQL query statement below
select
s.id,
sum(s.cnt) as num 
from
(
    select requester_id as id,
    count(1) cnt
    from RequestAccepted
    group by requester_id

    union all

    select accepter_id as id,
    count(1) cnt
    from RequestAccepted
    group by accepter_id
) s
group by s.id
order by 2 desc
limit 1;
