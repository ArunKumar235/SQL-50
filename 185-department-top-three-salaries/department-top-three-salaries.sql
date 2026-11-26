-- Write your PostgreSQL query statement below
SELECT d.name AS Department, e1.name AS Employee, e1.salary AS Salary
FROM employee e1
LEFT JOIN department d
ON e1.departmentId = d.id
WHERE e1.salary IN (
    SELECT DISTINCT e2.salary
    FROM employee e2
    WHERE e2.departmentId = e1.departmentId
    ORDER BY e2.salary DESC
    LIMIT 3
)
