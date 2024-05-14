SELECT D.DEPT_ID, D.DEPT_NAME_EN, E.AVG_SAL
FROM HR_DEPARTMENT D
INNER JOIN (
    SELECT DEPT_ID, ROUND(AVG(SAL),0) AS AVG_SAL
    FROM HR_EMPLOYEES
    GROUP BY DEPT_ID
) AS E
ON E.DEPT_ID = D.DEPT_ID
ORDER BY 3 DESC;