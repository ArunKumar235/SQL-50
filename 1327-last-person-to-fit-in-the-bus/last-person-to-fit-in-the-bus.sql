-- Write your PostgreSQL query statement below
SELECT q1.person_name
FROM queue q1
WHERE (
    SELECT SUM(q2.weight)
    FROM queue q2
    WHERE q2.turn <= q1.turn
) <= 1000
ORDER BY q1.turn DESC
LIMIT 1;
