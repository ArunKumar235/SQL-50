-- Write your PostgreSQL query statement below
SELECT ROUND(
    AVG(CASE WHEN order_date = customer_pref_delivery_date THEN 1.0 ELSE 0.0 END) * 100.0
    , 2
) AS immediate_percentage
FROM delivery
WHERE (customer_id, order_date) IN (
    SELECT customer_id, MIN(order_date) 
    FROM delivery
    GROUP BY customer_id
)
