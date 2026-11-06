-- Write your PostgreSQL query statement below
SELECT 
    s.user_id,
    ROUND(
        AVG(
            CASE c.action
                WHEN 'confirmed' THEN 1.0
                ELSE 0.0
            END
        )
        , 2
    ) AS confirmation_rate 
FROM signups s 
LEFT JOIN confirmations c 
ON s.user_id = c.user_id
GROUP BY s.user_id
