-- Write your PostgreSQL query statement below
WITH dates AS (
    SELECT DISTINCT visited_on AS date
    FROM customer
)

SELECT 
    c.visited_on, 
    (
        SELECT SUM(amount)
        FROM customer
        WHERE visited_on BETWEEN c.visited_on - 6 AND c.visited_on  
    ) AS amount,
    ROUND(
        (
            SELECT SUM(amount) / 7.0
            FROM customer
            WHERE visited_on BETWEEN c.visited_on - 6 AND c.visited_on
        )::NUMERIC
        , 2
    ) AS average_amount
FROM customer c
WHERE c.visited_on - 6 IN (SELECT date FROM dates)
GROUP BY c.visited_on
ORDER BY c.visited_on
