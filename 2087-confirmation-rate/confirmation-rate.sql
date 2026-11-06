-- Write your PostgreSQL query statement below
SELECT 
    s.user_id,
    ROUND(
        COUNT(c.action) FILTER (WHERE c.action = 'confirmed')::DECIMAL / COUNT(*), 
        2
    ) AS confirmation_rate 
FROM signups s 
LEFT JOIN confirmations c 
ON s.user_id = c.user_id
GROUP BY s.user_id
