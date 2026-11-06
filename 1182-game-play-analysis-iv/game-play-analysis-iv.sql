-- Write your PostgreSQL query statement below

WITH first_login AS (
    SELECT player_id, MIN(event_date) AS first_date
    FROM activity 
    GROUP BY player_id
)

SELECT 
    ROUND(
        COUNT(CASE WHEN a.event_date - f.first_date = 1 THEN 1 ELSE NULL END)::DECIMAL / COUNT(DISTINCT a.player_id)
        , 2
    ) AS fraction
FROM first_login f
LEFT JOIN activity a
ON f.player_id = a.player_id
