-- Write your PostgreSQL query statement below
SELECT stud.student_id, stud.student_name, sub.subject_name, COUNT(exam.student_id) AS attended_exams
FROM students stud CROSS JOIN subjects sub 
LEFT JOIN examinations exam 
ON exam.student_id = stud.student_id AND exam.subject_name = sub.subject_name 
GROUP BY stud.student_id, stud.student_name, sub.subject_name
