# Write your MySQL query statement below
(SELECT u.name AS results
FROM movierating mr LEFT JOIN users u
ON mr.user_id = u.user_id
GROUP BY mr.user_id, u.name
ORDER BY COUNT(mr.user_id) DESC, name ASC
LIMIT 1)

UNION ALL

(SELECT m.title AS results
FROM movierating mr LEFT JOIN movies m
ON mr.movie_id = m.movie_id
WHERE mr.created_at BETWEEN '2020-02-01' AND '2020-02-29'
GROUP BY mr.movie_id
ORDER BY AVG(mr.rating) DESC, m.title ASC
LIMIT 1)
