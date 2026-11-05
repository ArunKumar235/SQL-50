-- Write your PostgreSQL query statement below
SELECT e.name, b.bonus 
FROM employee e LEFT JOIN bonus b
ON e.empId = b.empId
WHERE COALESCE(b.bonus, 0) < 1000
