SELECT A.APNT_NO, P.PT_NAME, A.PT_NO, A.MCDP_CD, D.DR_NAME, A.APNT_YMD
FROM APPOINTMENT A
LEFT OUTER JOIN DOCTOR D
ON A.MDDR_ID = D.DR_ID
LEFT OUTER JOIN PATIENT P
ON P.PT_NO = A.PT_NO
WHERE A.APNT_YMD LIKE '2022-04-13%' AND A.MCDP_CD = 'CS' AND A.APNT_CNCL_YN = 'N'
ORDER BY 6;