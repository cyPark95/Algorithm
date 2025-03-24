WITH RECURSIVE cte AS (SELECT ID
                      , 1 AS GENERATION
                      FROM ECOLI_DATA 
                      WHERE PARENT_ID IS NULL
                      UNION ALL
                      SELECT A.ID
                      , B.GENERATION + 1 AS GENERATION
                      FROM ECOLI_DATA A
                      JOIN cte B
                      ON B.ID = A.PARENT_ID
                      WHERE A.PARENT_ID IS NOT NULL)
                  
SELECT A.ID
FROM ECOLI_DATA A
JOIN cte B
ON B.ID = A.ID
WHERE B.GENERATION = 3
ORDER BY ID