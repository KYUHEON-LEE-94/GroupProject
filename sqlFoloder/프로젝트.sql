--!!! ����!! ���� ���̺� ������ ���� �ϰ�, ���������� �߰����ּ���

--contact ���̺��, grade�� pk�� �������� ����ϴ� ��Ȳ�Դϴ�.
--�ּ����� ������ ���ؼ� contact_seq�� 1���ͽ���, grade_seq�� 4000���� �����ϴ� ������ �߽��ϴ�.


-- members ���̺�------------------------------------------------------
CREATE TABLE members (
	member_id	varchar2(30)	NOT NULL,
	member_pw	varchar2(30)	NOT NULL,
	member_name	varchar2(30)	NULL,
	member_email	varchar2(255)	NULL,
	phone_num	varchar2(30)	NULL,
	home_num	varchar2(30)	NULL,
	member_address	varchar2(255)	NULL,
	join_date	DATE DEFAULT  SYSDATE
);
-- pk
ALTER TABLE members ADD CONSTRAINT PK_MEMBERS PRIMARY KEY (
	member_id
);

INSERT INTO members (member_id, member_pw, member_name, member_email, phone_num,member_address)
VALUES ('xmanxman', '111111', '�̱���', 'panpan68@naver.com', '010-2112-4330','���� Ư���� �����');

INSERT INTO members (member_id, member_pw, member_name, member_email)
VALUES ('Nonmember', '111111', '��ȸ��', 'None@none');


SELECT *
FROM members;
----------------------------------------------------------------------

--contatct ���̺�-----------------------------------------------------
CREATE TABLE contact (
	contact_num	number	NOT NULL,
	member_id	varchar2(30)	NOT NULL,
	contact_name	varchar2(30)	NULL,
	contact_email	varchar2(255)	NULL,
	title	varchar2(255)	NULL,
	content	varchar2(2000)	NULL
);

ALTER TABLE contact
RENAME COLUMN content_detail TO content;

--pk
ALTER TABLE contact ADD CONSTRAINT PK_CONTACT PRIMARY KEY (
	contact_num
);
--������ �߰�
CREATE SEQUENCE contact_seq
START WITH 1
INCREMENT BY 1; 

INSERT INTO contact (contact_num, member_id, contact_name, contact_email, title, content)
VALUES (contact_seq.nextval, 'test', '����', 'test@naver.com', 'test Exmaple', '����');
--------------------------------------------------------------------

--����--------------------------------------------------------------
CREATE TABLE grade (
	grade_num	number	NOT NULL,
	product_num	varchar2(100)	NOT NULL,
	member_id	varchar2(30)	NOT NULL,
	score	number	NULL
);
--pk
ALTER TABLE grade ADD CONSTRAINT PK_GRADE PRIMARY KEY (
	grade_num
);

--������ �߰�
CREATE SEQUENCE grade_seq
START WITH 4000
INCREMENT BY 1; 

INSERT INTO grade (grade_num, product_num, member_id, score)
VALUES (grade_seq.nextval, 'test', '����', 5);
-------------------------------------------------------------------

---��ٱ���--------------------
CREATE TABLE shopping_basket (
	member_id	varchar2(30)	NOT NULL,
	product_num	varchar2(30)	NOT NULL,
	shopping_quantity	number	NULL,
	shopping_date	DATE DEFAULT  SYSDATE
);
--pk
ALTER TABLE shopping_basket ADD CONSTRAINT PK_SHOPPING_BASKET PRIMARY KEY (
	member_id,
	product_num
);
--fk
ALTER TABLE shopping_basket ADD CONSTRAINT FK_members_TO_shopping_basket FOREIGN KEY (member_id)
REFERENCES members (member_id);

ALTER TABLE shopping_basket ADD CONSTRAINT FK_product_TO_shopping_basket FOREIGN KEY (product_num)
REFERENCES product (product_num);

--�ֹ�-------------------------------------------------------------------------------------------
CREATE TABLE order_detail (
	order_num	varchar2(100)	NOT NULL,
	member_id	varchar2(30)	NOT NULL,
	recipient_name	varchar2(30)	NULL,
	order_name	varchar2(30)	NULL,
	order_address	varchar2(255)	NULL,
    recipient_address varchar2(255) NULL,
	order_phone	varchar2(30)	NULL,
	order_date	DATE DEFAULT  SYSDATE,
	delivery_charge	number	NULL,
	total_amount	number	NULL,
	order_quantity	number	NULL,
	payment_method	varchar2(30)	NULL

);
--pk
ALTER TABLE order_detail ADD CONSTRAINT PK_ORDER PRIMARY KEY (
	order_num
);

ALTER TABLE order_detail
RENAME COLUMN order_adress TO order_address;

---------------------------------------------------------------------------------------------

--�ֹ� ���-----------------------------------------------------------------------------------
CREATE TABLE order_list (
	order_num	varchar2(100)	NOT NULL,
	product_num	varchar2(100)	NOT NULL,
	member_id	varchar2(30)	NOT NULL
);
--pk
ALTER TABLE order_list ADD CONSTRAINT PK_ORDER_LIST PRIMARY KEY (
	order_num,
	product_num,
	member_id
);
--fk
ALTER TABLE order_list ADD CONSTRAINT FK_order_TO_order_list FOREIGN KEY (order_num)
REFERENCES order_detail (order_num);

ALTER TABLE order_list ADD CONSTRAINT FK_product_TO_order_list FOREIGN KEY (product_num)
REFERENCES product (product_num);

ALTER TABLE order_list ADD CONSTRAINT FK_members_TO_order_list FOREIGN KEY (member_id)
REFERENCES members (member_id);
------------------------------------------------------------------------------------------

-- ��ǰ-----------------------------------------------------------------------------------
CREATE TABLE product (
	product_num	varchar2(100)	NOT NULL,     
	type_num	number	NOT NULL,              
	product_photo	varchar2(255)	NULL,
	product_price	number	NULL,
	product_name	varchar2(50)	NULL,
	product_quantity	number	NULL,
	sex	varchar2(20)	NULL,
	product_size	varchar2(20)	NULL,
	status	varchar2(20)	NULL
);
--pk
ALTER TABLE product ADD CONSTRAINT PK_PRODUCT PRIMARY KEY (
	product_num
);
--fk
ALTER TABLE product ADD CONSTRAINT FK_product_TO_product_type FOREIGN KEY (type_num)
REFERENCES product_type (type_num);

INSERT INTO product (product_num, type_num, product_photo, product_price,product_name,product_quantity,sex,product_size,status)
VALUES ('GrayMM',1,'GrayMM.JPG','32000','ȸ�� ������','120','U','FREE','TRUE');
----------------------------------------------------------------------------------------

-- ��ǰ ����------------------------------------------------------------------------------
CREATE TABLE product_type (
	type_num	number	NOT NULL,
	type_name	varchar2(100)	NULL,
	description	varchar2(2000)	NULL
);

ALTER TABLE product_type ADD CONSTRAINT PK_PRODUCT_TYPE PRIMARY KEY (
	type_num
);

INSERT INTO product_type (type_num, type_name, description)
VALUES ('1','Ŭ�� ������','���ϰ� ���ϸ��� ���� �� �ִ� ������');

--������ �߰�
CREATE SEQUENCE product_type_seq
START WITH 8000
INCREMENT BY 1;

SELECT *
FROM order_list;

SELECT *
FROM order_detail;

SELECT *
FROM product;

SELECT *
FROM members;

DELETE FROM order_detail
WHERE ORDER_ADDRESS = '���';

DELETE FROM order_detail
WHERE MEMBER_ID = 'Nonmember';

DELETE FROM order_list
WHERE MEMBER_ID = 'Nonmember';

commit;

    select
        orderlist0_.member_id as member_id1_2_,
        orderlist0_.order_num as order_num2_2_,
        orderlist0_.product_num as product_num3_2_ 
    from
        order_list orderlist0_ 
    where
        orderlist0_.product_num='Gray2OMM-UF';















