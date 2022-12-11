--Product NUM: �̹����̸� + ���� + ������
--SEX: ����-M, ����-W, ȥ��= U
--������: S/M/L/XL/FREE
-- �������� 8000~8500 typeNum
--�ĵ�Ƽ�� 8501 ~ 9000 tpyNum

-- PRODUCT ���̺� �׽�Ʈ �ڷ� �߰�
INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('GrayMM-UF',8000,'GrayMM.JPG','32000','ȸ�� ������','120','U','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('BlackMM-UF',8000,'BlackMM.jpg','32000','������ ������','120','U','FREE','TRUE');


--

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('GrayOMM-WF',8001,'GrayOMM.jpg','30000','���� ȸ�� ������','200','W','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('GrayHT-MF',8501,'GrayHT.jpg','28000','ȸ�� Ŭ�� �ĵ�Ƽ','210','M','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('BlackHT-UF',8501,'BlackHT.jpg','32000','������ Ŭ�� �ĵ�Ƽ','70','U','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('BlueHT-UF',8501,'BlueHT.jpg','32000','���� �Ķ��� �ĵ�Ƽ','90','U','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity, sex, product_size,status)
VALUES ('Gray2OMM-UF',8001,'Gray2OMM.jpg','32000','���� ȸ���� ������ ������','132','U','FREE','TRUE');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity, sex, product_size,status, description)
VALUES ('WhiteOMM-UF',8001,'WhiteOMM.jpg','28000','�Ͼ�� ������ ������','50','U','FREE','TRUE', 'Ʈ������ ����������, ���� �� �ڿ������� ��Ʈ�� ���带 ������ �� �ֽ��ϴ�.');

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity, sex, product_size,status)
VALUES ('YellowMM-UF',8000,'YellowMM.jpg','25000','����� ������','0','U','FREE','FALSE');


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

--�÷� �߰�
ALTER TABLE PRODUCT ADD description VARCHAR2(2000);

--�� ����
UPDATE PRODUCT SET description = '������ ���������� �ĵ�� ���� ���� �� �ִ� �ƴ��� ������ Ư¡���ϴ�.   ����� ���������� �δ���� ������ ������ �� �ֽ��ϴ�.' 
WHERE product_num = 'GrayHT-MF';

UPDATE PRODUCT SET description = '�Ѱ��� �ε巯�� �˰��� Ư¡�� ��ǰ�Դϴ�.   ������� ������ ���ļ� ������Ź���� ����� �����ϴ�.' 
WHERE product_num = 'GrayMM-UF';

UPDATE PRODUCT SET description = '�Ѱ��� �ε巯�� �˰��� Ư¡�� ��ǰ�Դϴ�.   ������� ������ ���ļ� ������Ź���� ����� �����ϴ�.' 
WHERE product_num = 'BlackMM-UF';

UPDATE PRODUCT SET description = '�Ѱ��� �ε巯�� �˰��� Ư¡�� ��ǰ�Դϴ�.   ������� ������ ���ļ� ������Ź���� ����� �����ϴ�.  ���� ȸ���� ��Ÿ�ϸ��ϱ� ���� ��ǰ�Դϴ�.' 
WHERE product_num = 'GrayOMM-WF';

--DROP
DELETE FROM product
WHERE product_num ='BlueHT-UF';

--��ǰ Ÿ�� �׽�Ʈ 8000���� ����(�׽�Ʈ ������ 1 ����)
INSERT INTO product_type (type_num, type_name, description)
VALUES (product_type_hood_seq.NEXTVAL,'Ŭ�� ������','���ϰ� ���ϸ��� ���� �� �ִ� ������');

INSERT INTO product_type (type_num, type_name, description)
VALUES (product_type_hood_seq.NEXTVAL ,'��� �ĵ�Ƽ','���� �ŷ����� �ĵ�Ƽ');

DELETE FROM product_type
WHERE type_num = 1;

INSERT INTO product_type (type_num, type_name, description)
VALUES (product_type_seq.NEXTVAL ,'������ ������','���� ��𼭳� ��Ÿ�ϸ����� ������');

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


