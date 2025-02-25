# Write your MySQL query statement below

select s.user_id,
IFNULL(round(co.confirmed / co.total , 2), 0.00 )as confirmation_rate
from Signups as s
left join 

(
    SELECT 
        c.user_id, 
        COUNT(1) AS total,
        COUNT(CASE WHEN c.action = 'confirmed' THEN 1 END) AS confirmed
        -- COUNT(CASE WHEN c.action = 'timeout' THEN 1 END) AS timeout
    FROM Confirmations AS c
    GROUP BY c.user_id
) co on s.user_id = co.user_id