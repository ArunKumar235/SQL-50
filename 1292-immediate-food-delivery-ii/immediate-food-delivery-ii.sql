-- Write your PostgreSQL query statement below
SELECT ROUND(
    AVG(CASE WHEN od = pd THEN 1.0 ELSE 0.0 END) * 100.0
    , 2
) AS immediate_percentage
FROM (
    SELECT customer_id, MIN(order_date) AS od, MIN(customer_pref_delivery_date) AS pd
    FROM delivery
    GROUP BY customer_id
)
