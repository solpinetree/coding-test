-- 자동차 종류가 '트럭'인 자동차의 대여 기록
-- HISTORY_ID, 대여 금액 (FEE)
-- ORDER BY 대여금액(FEE) DESC, HISTORY_ID DESC
WITH TRUCK AS(
    SELECT * 
    FROM CAR_RENTAL_COMPANY_CAR
    WHERE CAR_TYPE = '트럭'
), TRUCK_HISTORY AS(
    SELECT *, TIMESTAMPDIFF(DAY, START_DATE, END_DATE) + 1 AS DURATION
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE CAR_ID IN (SELECT CAR_ID FROM TRUCK) 
), TRUCK_DISCOUNT AS(
    SELECT 
    DURATION_TYPE, DISCOUNT_RATE
    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    WHERE CAR_TYPE = '트럭'
)

SELECT 
h.HISTORY_ID AS HISTORY_ID,
CASE WHEN h.DURATION >= 90  
     THEN FLOOR(t.DAILY_FEE * h.DURATION *
     (1 - 0.01 * (SELECT DISCOUNT_RATE FROM TRUCK_DISCOUNT WHERE DURATION_TYPE = '90일 이상')))
     WHEN h.DURATION >= 30  
     THEN FLOOR(t.DAILY_FEE * h.DURATION *
     (1 - 0.01 * (SELECT DISCOUNT_RATE FROM TRUCK_DISCOUNT WHERE DURATION_TYPE = '30일 이상')))
     WHEN h.DURATION >= 7 
     THEN FLOOR(t.DAILY_FEE * h.DURATION *
     (1 - 0.01 * (SELECT DISCOUNT_RATE FROM TRUCK_DISCOUNT WHERE DURATION_TYPE = '7일 이상')))
     ELSE FLOOR(t.DAILY_FEE * h.DURATION) END AS FEE
FROM TRUCK_HISTORY h, TRUCK t
WHERE h.CAR_ID = t.CAR_ID
ORDER BY FEE DESC, HISTORY_ID DESC
     
     