-- Write your PostgreSQL query statement below
SELECT
    ROUND(
        COUNT(a.player_id)::DECIMAL / (SELECT COUNT(DISTINCT player_id) FROM activity)
        , 2
    ) AS fraction
FROM activity a
WHERE a.event_date -1 = (
    SELECT MIN(b.event_date)
    FROM activity b
    WHERE b.player_id = a.player_id
)
