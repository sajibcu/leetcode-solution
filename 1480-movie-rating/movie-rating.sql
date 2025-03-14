# Write your MySQL query statement below

(select u.name as results
from MovieRating mr
left join Users u using(user_id)
group by mr.user_id, u.name
order by count(1) DESC, u.name ASC 
limit 1)

union all
(
select m.title
from MovieRating mr
left join Movies m using(movie_id)
where substr(mr.created_at,1,7 ) = '2020-02'
group by m.title
order by avg(mr.rating) DESC, m.title
limit 1
)