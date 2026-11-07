-- Write your PostgreSQL query statement below
SELECT
    ROUND(
        COUNT(a1.player_id)::DECIMAL / (SELECT COUNT(DISTINCT player_id) FROM activity)
        , 2
    ) AS fraction
FROM activity a1 INNER JOIN activity a2
ON 
    a1.player_id = a2.player_id AND 
    a1.event_date + 1 = a2.event_date AND
    a1.event_date = (SELECT MIN(event_date) FROM activity WHERE player_id = a1.player_id)
    