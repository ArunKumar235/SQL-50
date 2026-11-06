-- Write your PostgreSQL query statement below
SELECT e1.name
FROM employee e1 INNER JOIN employee e2 
ON e1.id = e2.managerId 
GROUP BY e1.id, e1.name
HAVING COUNT(e2.id) >= 5 -- counts the number of reportees for every parentId

-- Why prefer counting the child-side ID?
-- When joining a parent table with a child table, prefer counting the child-side ID when your goal is to count the number of matching child records.

-- Reasons:

-- It clearly represents what you want to count.

-- With an INNER JOIN, counting parent ID or child ID generally gives the same result (assuming non-NULL primary keys).

-- With a LEFT JOIN, counting the parent ID can incorrectly count a parent with no matching children as 1.

-- COUNT(child.id) ignores NULL values, so parents with no matching children get a count of 0.
