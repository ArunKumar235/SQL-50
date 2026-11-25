-- Write your PostgreSQL query statement below
SELECT (
    SELECT DISTINCT salary
    FROM employee
    ORDER BY salary DESC
    OFFSET 1
    LIMIT 1
) AS SecondHighestSalary
