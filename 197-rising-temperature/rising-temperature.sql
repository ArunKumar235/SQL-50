-- Write your PostgreSQL query statement below
SELECT w1.id
FROM weather w1 CROSS JOIN weather w2
WHERE w1.recordDate = w2.recordDate + INTERVAL '1 day' AND w1.temperature > w2.temperature
