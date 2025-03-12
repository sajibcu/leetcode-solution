# Write your MySQL query statement below

select s1.id,
COALESCE(s2.student, s1.student) AS student
from Seat s1
left join Seat s2 on 
( mod(s1.id,2) = 1 && s1.id + 1 = s2.id ) or
( mod(s1.id,2) = 0 && s1.id -1  = s2.id )
