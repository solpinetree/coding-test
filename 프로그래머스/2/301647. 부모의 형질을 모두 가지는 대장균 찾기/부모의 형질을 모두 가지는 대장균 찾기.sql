SELECT s.ID, s.GENOTYPE, p.GENOTYPE AS PARENT_GENOTYPE
FROM ECOLI_DATA p, ECOLI_DATA s
WHERE 
(s.PARENT_ID = p.ID) AND
(p.GENOTYPE & s.GENOTYPE = p.GENOTYPE)
ORDER BY s.ID;
