--Product NUM: 이미지이름 + 성별 + 사이즈
--SEX: 남자-M, 여자-W, 혼합= U
--사이즈: S/M/L/XL/FREE
-- 맨투맨은 8000~8500 typeNum
--후드티는 8501 ~ 9000 tpyNum

-- PRODUCT 테이블 테스트 자료 추가
INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('GrayMM-UF',8000,'GrayMM.JPG','32000','회색 맨투맨','120','U','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('BlackMM-UF',8000,'BlackMM.jpg','32000','검은색 맨투맨','120','U','FREE','TRUE');


--

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('GrayOMM-WF',8001,'GrayOMM.jpg','30000','밝은 회색 맨투맨','200','W','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('GrayHT-MF',8501,'GrayHT.jpg','28000','회색 클럽 후드티','210','M','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('BlackHT-UF',8501,'BlackHT.jpg','32000','검은색 클럽 후드티','70','U','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('BlueHT-UF',8501,'BlueHT.jpg','32000','진한 파란색 후드티','90','U','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity, sex, product_size,status)
VALUES ('Gray2OMM-UF',8001,'Gray2OMM.jpg','32000','밝은 회색의 오버핏 맨투맨','132','U','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity, sex, product_size,status, description)
VALUES ('WhiteOMM-UF',8001,'WhiteOMM.jpg','28000','하얏색 오버핏 맨투맨','50','U','FREE','TRUE', '트렌디한 오버핏으로, 착용 시 자연스럽게 스트릿 무드를 연출할 수 있습니다.');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity, sex, product_size,status)
VALUES ('YellowMM-UF',8000,'YellowMM.jpg','25000','노란색 맨투맨','0','U','FREE','FALSE');


DELETE FROM product
WHERE type_num = 1;

commit;

--SELECT
SELECT *
FROM PRODUCT
WHERE product_num =  'GrayOMM-WF';

SELECT *
FROM PRODUCT
WHERE sex =  '';

SELECT *
FROM PRODUCT;

--컬럼 추가
ALTER TABLE PRODUCT ADD description VARCHAR2(2000);

--값 변경
UPDATE PRODUCT SET description = '끈으로 조절가능한 후드와 손을 넣을 수 있는 아늑한 포켓이 특징힙니다.   깔끔한 디자인으로 부담없이 가볍게 착용할 수 있습니다.' 
WHERE product_num = 'GrayHT-MF';

UPDATE PRODUCT SET description = '겉감의 부드러운 촉감이 특징인 제품입니다.   덤블워싱 공정을 거쳐서 오랜세탁에도 축률이 적습니다.' 
WHERE product_num = 'GrayMM-UF';

UPDATE PRODUCT SET description = '겉감의 부드러운 촉감이 특징인 제품입니다.   덤블워싱 공정을 거쳐서 오랜세탁에도 축률이 적습니다.' 
WHERE product_num = 'BlackMM-UF';

UPDATE PRODUCT SET description = '겉감의 부드러운 촉감이 특징인 제품입니다.   덤블워싱 공정을 거쳐서 오랜세탁에도 축률이 적습니다.  밝은 회색을 스타일링하기 편한 제품입니다.' 
WHERE product_num = 'GrayOMM-WF';

--DROP
DELETE FROM product
WHERE product_num ='BlueHT-UF';

--제품 타입 테스트 8000부터 시작(테스트 데이터 1 제외)
INSERT INTO product_type (type_num, type_name, description)
VALUES (product_type_hood_seq.NEXTVAL,'클럽 맨투맨','편하게 데일리로 입을 수 있는 맨투맨');

INSERT INTO product_type (type_num, type_name, description)
VALUES (product_type_hood_seq.NEXTVAL ,'헤비 후드티','핏이 매력적인 후드티');

DELETE FROM product_type
WHERE type_num = 1;

INSERT INTO product_type (type_num, type_name, description)
VALUES (product_type_seq.NEXTVAL ,'오버핏 맨투맨','언제 어디서나 스타일리쉬한 맨투맨');

SELECT *
FROM product_type;

CREATE SEQUENCE product_type_hood_seq
INCREMENT BY 1
START WITH 8501
MAXVALUE 9000;

CREATE SEQUENCE product_type_MM_seq
INCREMENT BY 1
START WITH 8000
MAXVALUE 8500;


