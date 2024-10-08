-- 잡은 물고기의 평균 길이(AVERAGE_LENGTH)
-- 소수점 3째자리에서 반올림
-- 10cm 이하의 물고기들은 10cm 로 취급
WITH FISH_INFO_1 AS (
    SELECT
    CASE WHEN LENGTH IS NULL THEN 10
    ELSE LENGTH END AS LENGTH
    FROM FISH_INFO
)

SELECT ROUND(AVG(LENGTH), 2) AS AVERAGE_LENGTH
FROM FISH_INFO_1


