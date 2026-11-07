-- Write your PostgreSQL query statement below
SELECT teacher_id, COUNT(subject_id) AS cnt
FROM (
    SELECT teacher_id, subject_id
    FROM teacher
    GROUP BY teacher_id, subject_id
)
GROUP BY teacher_id
