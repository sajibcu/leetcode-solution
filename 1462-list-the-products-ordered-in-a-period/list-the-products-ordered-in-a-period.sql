select p.product_name,sum(o.unit) as unit
from Orders o
left join Products p using (product_id)
where DATE_FORMAT(o.order_date, '%Y-%m') = '2020-02'
group by o.product_id, p.product_name
having sum(o.unit) > 99