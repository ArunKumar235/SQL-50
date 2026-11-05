-- Write your PostgreSQL query statement below
SELECT DISTINCT v.author_id AS id FROM views v WHERE v.author_id = v.viewer_id ORDER BY id