-- Write your PostgreSQL query statement below
SELECT w1.id
FROM weather w1 INNER JOIN weather w2
ON w1.recordDate = w2.recordDate + INTERVAL '1 day' AND w1.temperature > w2.temperature
