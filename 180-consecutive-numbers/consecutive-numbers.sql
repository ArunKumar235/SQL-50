-- Write your PostgreSQL query statement below
SELECT DISTINCT l1.num as ConsecutiveNums
FROM logs l1 
INNER JOIN logs l2 ON l1.id +1 = l2.id AND l1.num = l2.num
INNER JOIN logs l3 ON l2.id +1 = l3.id AND l2.num = l3.num
