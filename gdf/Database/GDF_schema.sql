/*
Delete Constraints
*/

    
ALTER TABLE ORDERS DROP CONSTRAINT FK_OrdersOrderTypeId;
ALTER TABLE ORDERS DROP CONSTRAINT FK_OrdersOrderStatusId;
ALTER TABLE ORDER_LINE DROP CONSTRAINT FK_OrderLineOrderId;
ALTER TABLE ORDER_LINE DROP CONSTRAINT FK_OrderLineDishId;
ALTER TABLE CATEGORIES DROP CONSTRAINT FK_CategoriesDishId;
ALTER TABLE CATEGORIES DROP CONSTRAINT FK_CategoriesDishTypeId;
ALTER TABLE GDF_USER DROP CONSTRAINT FK_GDFUserUserTypeId;
    


/*
Delete Database Schema
*/
DROP TABLE order_line;
DROP TABLE orders;
DROP TABLE order_status;
DROP TABLE order_type;
DROP TABLE dish;
DROP TABLE dish_type;
DROP TABLE gdf_user;
DROP TABLE user_type;
DROP TABLE categories;

/*
Create Database Schema
*/


CREATE TABLE ORDERS
(
    order_id NUMBER NOT NULL,
    order_submitted Timestamp,
    order_resolved Timestamp,
    order_type NUMBER NOT NULL,
    order_status NUMBER NOT NULL,
    user_id NUMBER NOT NULL,
    CONSTRAINT PK_ORDER_ID PRIMARY KEY  (order_id)
);

CREATE TABLE ORDER_LINE
(
    order_id NUMBER NOT NULL,
    dish_id NUMBER NOT NULL,
    quantity NUMBER NOT NULL,
    CONSTRAINT PK_ORDER_LINE_ID PRIMARY KEY  (order_id, dish_id)
   
);

CREATE TABLE ORDER_TYPE
(
    order_type_id NUMBER NOT NULL,
    order_type Varchar2(160),
    CONSTRAINT PK_ORDER_TYPE_ID PRIMARY KEY  (order_type_id)
    
    
);

CREATE TABLE ORDER_STATUS
(
    order_status_id NUMBER NOT NULL,
    order_status VARCHAR2(160),
    CONSTRAINT PK_ORDER_STATUS_ID PRIMARY KEY  (order_status_id)

);

CREATE TABLE DISH
(
    dish_id NUMBER NOT NULL,
    dish_name Varchar2(160),
    dish_price NUMBER(10,2) NOT NULL,
    CONSTRAINT PK_DISH_ID PRIMARY KEY  (dish_id)
);

CREATE TABLE CATEGORIES
(
	dish_id NUMBER NOT NULL,
	dish_type_id NUMBER NOT NULL
);

CREATE TABLE DISH_TYPE
(
    dish_type_id NUMBER NOT NULL,
    dish_type Varchar2(160),
    CONSTRAINT PK_DISH_TYPE_ID PRIMARY KEY  (dish_type_id)
);

CREATE TABLE GDF_USER
(
    user_id NUMBER NOT NULL,
    username Varchar2(160),
    user_firstname Varchar2(160),
	user_lastname Varchar2(160),
	user_email Varchar2(160),
	user_password Varchar2(70),
	user_type_id NUMBER NOT NULL,
    CONSTRAINT PK_GDF_USER PRIMARY KEY (user_id)
);

CREATE TABLE USER_TYPE
(
	user_type_id NUMBER NOT NULL,
	user_type Varchar2(160),
    CONSTRAINT PK_USER_TYPE PRIMARY KEY (user_type_id)
);


/*
CREATE FOREIGN KEYS
*/

ALTER TABLE ORDERS ADD CONSTRAINT FK_OrdersOrderTypeId
    FOREIGN KEY (order_type) REFERENCES ORDER_TYPE (order_type_id);
ALTER TABLE ORDERS ADD CONSTRAINT FK_OrdersOrderStatusId
    FOREIGN KEY (order_status) REFERENCES ORDER_STATUS (order_status_id); 
ALTER TABLE ORDER_LINE ADD CONSTRAINT FK_OrderLineOrderId
    FOREIGN KEY (order_id) REFERENCES ORDERS (order_id);
ALTER TABLE ORDER_LINE ADD CONSTRAINT FK_OrderLineDishId
    FOREIGN KEY (dish_id) REFERENCES DISH (dish_id);  
ALTER TABLE CATEGORIES ADD CONSTRAINT FK_CategoriesDishId
    FOREIGN KEY (dish_id) REFERENCES DISH (dish_id);
ALTER TABLE CATEGORIES ADD CONSTRAINT FK_CategoriesDishTypeId
    FOREIGN KEY (dish_type_id) REFERENCES DISH_TYPE (dish_type_id);
ALTER TABLE GDF_USER ADD CONSTRAINT FK_GDFUserUserTypeId
    FOREIGN KEY (user_type_id) REFERENCES USER_TYPE (user_type_id);
    