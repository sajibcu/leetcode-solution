with t as ( 
    select a.account_id,
CASE 
    when a.income < 20000 then 'Low Salary'
    when a.income between 20000 and 50000 then 'Average Salary'
    else 'High Salary'end as category
from Accounts a
), categories AS (
    SELECT 'Low Salary' AS category
    UNION ALL
    SELECT 'Average Salary'
    UNION ALL
    SELECT 'High Salary'
) 

select c.category, 
sum(case when t.account_id is null then 0 else 1 end) as accounts_count
from 
categories c
left join t using(category)
group by c.category
