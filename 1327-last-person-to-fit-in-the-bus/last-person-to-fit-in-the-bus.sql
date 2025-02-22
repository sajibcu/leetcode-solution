# Write your MySQL query statement below

select qq.person_name
from
(
    select q.person_name, sum(q.weight) over (order by q.turn) as weight
    from Queue as q
    order by q.turn
) qq
where qq.weight <= 1000
order by qq.weight DESC
limit 1
