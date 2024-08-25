WITH FOR_DATE AS(
    SELECT CAR_ID,
    MAX(START_DATE) AS MIN_DATE,
    MIN(END_DATE) AS MAX_DATE
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE <= '2022-10-16'
    AND END_DATE >= '2022-10-16'
    GROUP BY CAR_ID
)

SELECT c.CAR_ID, 	
CASE WHEN f.MIN_DATE <= '2022-10-16' AND f.MAX_DATE >= '2022-10-16' THEN '대여중'
ELSE '대여 가능'
END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY c
LEFT OUTER JOIN FOR_DATE f
ON f.CAR_ID = c.CAR_ID
GROUP BY c.CAR_ID
ORDER BY c.CAR_ID DESC;