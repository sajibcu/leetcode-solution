# Write your MySQL query statement below
select COALESCE (
    ( select num
    from MyNumbers
    group by 1
    having count(1) = 1
    order by 1 desc
    limit 1
    ), null
) as num
