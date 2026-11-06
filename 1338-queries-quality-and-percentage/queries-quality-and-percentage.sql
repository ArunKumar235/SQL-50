-- Write your PostgreSQL query statement below
SELECT 
    query_name, 
    ROUND(
        SUM(rating::DECIMAL / position) / COUNT(*)
        , 2
    ) AS quality, 
    ROUND(
        SUM(CASE WHEN rating < 3 THEN 1.0 ELSE 0.0 END) * 100.0 / COUNT(*)
        , 2
    ) AS poor_query_percentage
FROM queries
GROUP BY query_name
