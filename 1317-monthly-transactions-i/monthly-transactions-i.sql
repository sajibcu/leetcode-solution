# Write your MySQL query statement below

select substr(t.trans_date, 1,7) as month,
t.country,
count(1) as trans_count,
SUM(case when t.state = 'approved' then 1 else 0 end) as approved_count,
SUM(t.amount) as trans_total_amount,
SUM(case when t.state = 'approved' then t.amount else 0 end) as approved_total_amount
from Transactions t
group by 1 , 2
