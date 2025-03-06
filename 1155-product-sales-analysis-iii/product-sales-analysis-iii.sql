with s as (
    select product_id, year, quantity,price,
    RANK() over (partition by product_id order by year asc ) as rank
    from Sales
)
select 
product_id, 
year as first_year,
quantity, price
from s
where rank = 1
