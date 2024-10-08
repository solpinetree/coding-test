WITH MAX_PRICE AS(
SELECT CATEGORY, MAX(PRICE) AS MAX_PRICE
FROM FOOD_PRODUCT
GROUP BY CATEGORY
)


SELECT f.CATEGORY, p.MAX_PRICE, f.PRODUCT_NAME
FROM FOOD_PRODUCT f, MAX_PRICE p
WHERE f.CATEGORY = p.CATEGORY
AND f.PRICE = p.MAX_PRICE
AND f.CATEGORY IN ('과자', '국', '김치', '식용유')
GROUP BY CATEGORY
ORDER BY p.MAX_PRICE DESC;
