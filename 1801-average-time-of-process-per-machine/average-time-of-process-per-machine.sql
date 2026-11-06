-- Write your PostgreSQL query statement below
SELECT 
    a.machine_id, 
    ROUND(
        (
            SUM(CASE WHEN a.activity_type = 'end' THEN a.timestamp ELSE 0.0 END)
            - 
            SUM(CASE WHEN a.activity_type = 'start' THEN a.timestamp ELSE 0.0 END)
        )::DECIMAL / (
            COUNT(*) FILTER (WHERE a.activity_type = 'start')
        ), 3
    ) AS processing_time
FROM activity a
GROUP BY a.machine_id
