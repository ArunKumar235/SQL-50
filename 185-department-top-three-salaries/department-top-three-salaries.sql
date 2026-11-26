-- Write your PostgreSQL query statement below
SELECT d.name AS Department, e1.name AS Employee, e1.salary AS Salary
FROM employee e1
LEFT JOIN department d
ON e1.departmentId = d.id
WHERE 3 > (
    SELECT COUNT(DISTINCT e2.salary)
    FROM employee e2
    WHERE e2.salary > e1.salary AND e2.departmentId = e1.departmentId
)
