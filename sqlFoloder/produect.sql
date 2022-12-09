--Product NUM: 이미지이름 + 성별 + 사이즈
--SEX: 남자-M, 여자-W, 혼합= U
--사이즈: S/M/L/XL/FREE

-- PRODUCT 테이블 테스트 자료 추가
INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('GrayMM-UF',1,'GrayMM.JPG','32000','회색 맨투맨','120','U','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('BlackMM-UF',1,'BlackMM.jpg','32000','검은색 맨투맨','120','U','FREE','TRUE');


--
INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('BlackMM-UF',1,'BlackMM.jpg','32000','검은색 맨투맨','120','U','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('GrayOMM-WF',8001,'GrayOMM.jpg','30000','밝은 회색 맨투맨','200','W','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('GrayHT-MF',8000,'GrayHT.jpg','28000','회색 클럽 후드티','210','M','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('BlackHT-UF',8000,'BlackHT.jpg','32000','검은색 클럽 후드티','70','U','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('BlueHT-UF',8001,'BlueHT.jpg','32000','진한 파란색 후드티','90','U','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('Gray2OMM-UF',8001,'Gray2OMM.jpg','32000','밝은 회색의 오버핏 맨투맨','132','U','FREE','TRUE');




commit;

--SELECT
SELECT *
FROM PRODUCT
WHERE product_num =  'GrayOMM-WF';
SELECT *
FROM PRODUCT;

--DROP
DELETE FROM product
WHERE product_num ='BlueHT-UF';

--제품 타입 테스트 8000부터 시작(테스트 데이터 1 제외)
INSERT INTO product_type (type_num, type_name, description)
VALUES ('1','클럽 맨투맨','편하게 데일리로 입을 수 있는 맨투맨');

INSERT INTO product_type (type_num, type_name, description)
VALUES (product_type_seq.NEXTVAL ,'헤비 후드티','핏이 매력적인 후드티');

INSERT INTO product_type (type_num, type_name, description)
VALUES (product_type_seq.NEXTVAL ,'오버핏 맨투맨','언제 어디서나 스타일리쉬한 맨투맨');

SELECT *
FROM product_type;