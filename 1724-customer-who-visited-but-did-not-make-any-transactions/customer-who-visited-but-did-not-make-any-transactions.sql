-- Write your PostgreSQL query statement below
SELECT customer_id, COUNT(customer_id) AS count_no_trans
FROM visits v
WHERE NOT EXISTS (
    SELECT 1 FROM transactions t
    WHERE v.visit_id = t.visit_id
)
GROUP BY customer_id
