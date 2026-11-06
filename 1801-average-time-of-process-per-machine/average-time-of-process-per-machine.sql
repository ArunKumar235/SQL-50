-- Write your PostgreSQL query statement below
SELECT 
    a.machine_id, 
    ROUND(
        (
            SUM(a.timestamp) FILTER (WHERE a.activity_type = 'end')  
            - 
            SUM(a.timestamp) FILTER (WHERE a.activity_type = 'start')
        )::DECIMAL / (
            COUNT(*) FILTER (WHERE a.activity_type = 'start')
        ), 3
    ) AS processing_time
FROM activity a
GROUP BY a.machine_id
