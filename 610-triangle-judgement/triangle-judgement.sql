# Write your MySQL query statement below

select 
x,
y,
z,
IF( x+y > z and x+z > y and y+z > x , 'Yes', 'No') as triangle
-- Case 
--     when z >= y and z >= x and x + y <= z then 'No'
--     WHEN y >= x and y >= z and x+z <= y THEN 'No'
--     WHEN x >= z and x >= y  and z + y <= x THEN 'No'
--     ElSE 'Yes'
--     END as triangle
from 
Triangle
