--Product NUM: �̹����̸� + ���� + ������
--SEX: ����-M, ����-W, ȥ��= U
--������: S/M/L/XL/FREE

-- PRODUCT ���̺� �׽�Ʈ �ڷ� �߰�
INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('GrayMM-UF',1,'GrayMM.JPG','32000','ȸ�� ������','120','U','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('BlackMM-UF',1,'BlackMM.jpg','32000','������ ������','120','U','FREE','TRUE');


--
INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('BlackMM-UF',1,'BlackMM.jpg','32000','������ ������','120','U','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('GrayOMM-WF',8001,'GrayOMM.jpg','30000','���� ȸ�� ������','200','W','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('GrayHT-MF',8000,'GrayHT.jpg','28000','ȸ�� Ŭ�� �ĵ�Ƽ','210','M','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('BlackHT-UF',8000,'BlackHT.jpg','32000','������ Ŭ�� �ĵ�Ƽ','70','U','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('BlueHT-UF',8001,'BlueHT.jpg','32000','���� �Ķ��� �ĵ�Ƽ','90','U','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('Gray2OMM-UF',8001,'Gray2OMM.jpg','32000','���� ȸ���� ������ ������','132','U','FREE','TRUE');




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

--��ǰ Ÿ�� �׽�Ʈ 8000���� ����(�׽�Ʈ ������ 1 ����)
INSERT INTO product_type (type_num, type_name, description)
VALUES ('1','Ŭ�� ������','���ϰ� ���ϸ��� ���� �� �ִ� ������');

INSERT INTO product_type (type_num, type_name, description)
VALUES (product_type_seq.NEXTVAL ,'��� �ĵ�Ƽ','���� �ŷ����� �ĵ�Ƽ');

INSERT INTO product_type (type_num, type_name, description)
VALUES (product_type_seq.NEXTVAL ,'������ ������','���� ��𼭳� ��Ÿ�ϸ����� ������');

SELECT *
FROM product_type;