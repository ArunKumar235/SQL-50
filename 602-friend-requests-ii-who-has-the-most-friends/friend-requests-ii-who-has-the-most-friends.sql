-- Write your PostgreSQL query statement below
WITH all_ids AS (    
    SELECT requester_id AS id FROM requestaccepted
    UNION ALL
    SELECT  accepter_id AS id FROM requestaccepted
)

SELECT id, COUNT(*) AS num 
FROM all_ids
GROUP BY id
ORDER BY num DESC
LIMIT 1
