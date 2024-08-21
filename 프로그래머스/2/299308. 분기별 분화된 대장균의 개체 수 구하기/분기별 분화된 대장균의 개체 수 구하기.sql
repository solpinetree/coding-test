WITH TMP AS 
(
    SELECT 
    ID, PARENT_ID, SIZE_OF_COLONY, DIFFERENTIATION_DATE, GENOTYPE,
    CASE 
    WHEN MONTH(DIFFERENTIATION_DATE) in ('1', '2', '3') 
    THEN '1Q'
    WHEN MONTH(DIFFERENTIATION_DATE) in ('4', '5', '6') 
    THEN '2Q'
    WHEN MONTH(DIFFERENTIATION_DATE) in ('7', '8', '9') 
    THEN '3Q'
    ELSE '4Q'
    END AS QUARTER
    FROM ECOLI_DATA
)

SELECT QUARTER, COUNT(ID) ECOLI_COUNT from TMP
GROUP BY QUARTER;