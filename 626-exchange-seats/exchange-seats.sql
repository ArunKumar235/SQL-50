-- Write your PostgreSQL query statement below
SELECT (
    CASE 
        WHEN s2.id IS NOT NULL AND s1.id % 2 = 1 THEN s2.id
        WHEN s1.id % 2 = 0 THEN s1.id - 1
        ELSE s1.id
    END 
) AS id, s1.student 
FROM seat s1
LEFT JOIN seat s2
ON s1.id + 1 = s2.id
ORDER BY id
