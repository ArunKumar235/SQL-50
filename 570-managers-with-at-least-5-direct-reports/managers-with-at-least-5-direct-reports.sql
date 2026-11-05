-- Write your PostgreSQL query statement below
SELECT e1.name FROM employee e1
INNER JOIN (
    SELECT managerId AS mId, COUNT(*) AS reports FROM employee
    WHERE managerId IS NOT NULL
    GROUP BY managerId
) e2
ON e1.id = e2.mId
WHERE e2.reports >= 5
