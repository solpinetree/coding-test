-- A : Front End 스킬, Python 스킬 함께 가지고 있는 개발자
-- B : C# 스킬을 가진 개발자
-- C : 그 외의 Front End 개발자
-- Grade 가 존재하는 개발자의 GRADE, ID, EMAIL 조회
-- GRADE, ID ASC

WITH FRONT_CODE AS(
    SELECT BIT_OR(CODE) FROM SKILLCODES
    WHERE CATEGORY =  'Front End'
)

SELECT 
CASE WHEN (SKILL_CODE & (SELECT * FROM FRONT_CODE) ) > 0 
AND (SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'Python')) = (SELECT CODE FROM SKILLCODES WHERE NAME = 'Python')
THEN 'A'
WHEN (SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'C#')) = (SELECT CODE FROM SKILLCODES WHERE NAME = 'C#') THEN 'B'
WHEN (SKILL_CODE & (SELECT * FROM FRONT_CODE) ) > 0 THEN 'C' END
AS GRADE, ID, EMAIL
FROM DEVELOPERS
HAVING GRADE IS NOT NULL
ORDER BY GRADE, ID