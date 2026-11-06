-- Write your PostgreSQL query statement below
SELECT 
    p.product_id, 
    COALESCE(
        ROUND(
            SUM(us.units * p.price)::DECIMAL / NULLIF(SUM(us.units), 0)
            , 2
        ), 0
) AS average_price
FROM prices p LEFT JOIN unitssold us
ON 
    p.product_id = us.product_id AND 
    p.start_date <= us.purchase_date AND us.purchase_date <= p.end_date
GROUP BY p.product_id
