-- Write your PostgreSQL query statement below
SELECT 
    query_name, 
    ROUND(
        AVG(rating::DECIMAL / position)
        , 2
    ) AS quality, 
    ROUND(
        AVG(CASE WHEN rating < 3 THEN 1.0 ELSE 0.0 END) * 100.0
        , 2
    ) AS poor_query_percentage
FROM queries
GROUP BY query_name
