-- Write your PostgreSQL query statement below
SELECT a2.machine_id, ROUND(
    (
        (SUM(a2.timestamp) - SUM(a1.timestamp)) / COUNT(*)
    )::DECIMAL, 3) AS processing_time
FROM activity a1 INNER JOIN activity a2 
ON a1.process_id = a2.process_id AND a1.machine_id = a2.machine_id AND a1.activity_type = 'start' AND a2.activity_type = 'end'
GROUP BY a2.machine_id
