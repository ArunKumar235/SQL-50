-- Write your PostgreSQL query statement below
SELECT * FROM users
WHERE mail ~ '^[A-Za-z][A-Za-z0-9_.-]*@leetcode[.]com$'
