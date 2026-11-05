-- Write your PostgreSQL query statement below
SELECT customer_id, COUNT(customer_id) AS count_no_trans
FROM visits v
WHERE v.visit_id NOT IN (
    SELECT t.visit_id FROM transactions t
)
GROUP BY customer_id
