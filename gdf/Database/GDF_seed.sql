
/*
DROP SEQUENCES
*/
DROP SEQUENCE dish_type_id_seq;
DROP SEQUENCE order_id_seq;
DROP SEQUENCE dish_id_seq;



--CREATE SEQUENCES AND TRIGGERS


CREATE SEQUENCE dish_id_seq
    START WITH 1
    INCREMENT BY 1;
    
CREATE OR REPLACE TRIGGER dish_id_trigger
    BEFORE INSERT ON dish
    FOR EACH ROW
BEGIN
    IF :new.dish_id IS NULL THEN
        SELECT dish_id_seq.nextval INTO :new.dish_id
        FROM dual;
    END IF;
END;
/

CREATE SEQUENCE order_id_seq
    START WITH 1
    INCREMENT BY 1;
    
CREATE OR REPLACE TRIGGER order_id_trigger
    BEFORE INSERT ON orders
    FOR EACH ROW
BEGIN
    IF :new.order_id IS NULL THEN
        SELECT order_id_seq.nextval INTO :new.order_id
        FROM dual;
    END IF;
END;
/

CREATE SEQUENCE dish_type_id_seq
    START WITH 1
    INCREMENT BY 1;
    
CREATE OR REPLACE TRIGGER dish_type_id_trigger
    BEFORE INSERT ON dish_type
    FOR EACH ROW
BEGIN
    IF :new.dish_type_id IS NULL THEN
        SELECT dish_type_id_seq.nextval INTO :new.dish_type_id
        FROM dual;
    END IF;
END;
/

/*

DROP TABLE FOREIGN KEY CONSTRAINTS

*/ 
ALTER TABLE ORDERS DROP CONSTRAINT FK_OrdersOrderTypeId;
ALTER TABLE ORDERS DROP CONSTRAINT FK_OrdersOrderStatusId;
ALTER TABLE ORDER_LINE DROP CONSTRAINT FK_OrderLineOrderId;
ALTER TABLE ORDER_LINE DROP CONSTRAINT FK_OrderLineDishId;
ALTER TABLE CATEGORIES DROP CONSTRAINT FK_CategoriesDishId;
ALTER TABLE CATEGORIES DROP CONSTRAINT FK_CategoriesDishTypeId;
ALTER TABLE GDF_USER DROP CONSTRAINT FK_GDFUserUserTypeId;

/*

TRUNCATE ALL TABLES
*/
TRUNCATE TABLE order_line;
TRUNCATE TABLE orders;
TRUNCATE TABLE order_status;
TRUNCATE TABLE order_type;
TRUNCATE TABLE dish;
TRUNCATE TABLE dish_type;
TRUNCATE TABLE gdf_user;
TRUNCATE TABLE user_type;
TRUNCATE TABLE categories;
/*
POPULATE TABLES
*/
--Dish Type
INSERT INTO dish_type ( dish_type ) VALUES ('Chicken');
INSERT INTO dish_type ( dish_type) VALUES ('Pork');
INSERT INTO dish_type ( dish_type ) VALUES ('Beef');
INSERT INTO dish_type (dish_type ) VALUES ('Seafood');
INSERT INTO dish_type ( dish_type ) VALUES ('Tofu');
INSERT INTO dish_type ( dish_type ) VALUES ('Rice');
INSERT INTO dish_type ( dish_type ) VALUES ('Noodle');
INSERT INTO dish_type ( dish_type ) VALUES ('Vegetables');
INSERT INTO dish_type ( dish_type ) VALUES ('Egg');
INSERT INTO dish_type ( dish_type ) VALUES ('Soup');

--Order_type
INSERT INTO order_type ( order_type_id,order_type ) VALUES (1,'Delivery');
INSERT INTO order_type ( order_type_id,order_type ) VALUES (2,'Carry Out');

--Order_Status
INSERT INTO order_status ( order_status_id,order_status ) VALUES (1,'Received');
INSERT INTO order_status ( order_status_id,order_status ) VALUES (2,'Cooking');
INSERT INTO order_status ( order_status_id,order_status ) VALUES (3,'Out for Delivery');
INSERT INTO order_status ( order_status_id,order_status ) VALUES (4,'Delivered');

--categories
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (1,6);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (1,1);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (2,6);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (3,6);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (3,2);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (4,6);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (4,4);

--user
INSERT INTO gdf_user (
    user_id,
    username,
    user_firstname,
    user_lastname,
    user_email,
    user_password,
    user_type_id
) VALUES (
    1,
    'pjackson',
    'Patrick',
    'Jackson',
    'pjackson@gmail.com',
    '$2a$10$QN3oZuo0TAHS0FKzmijkl./Mu6LXDVip3WYJo242I2hnM2L8FWQD2',
    2
);
INSERT INTO gdf_user (
    user_id,
    username,
    user_firstname,
    user_lastname,
    user_email,
    user_password,
    user_type_id
) VALUES (
    2,
    'tinfoil',
    'Tin',
    'Van',
    'tinfoil@gmail.com',
    '$2a$10$EIYGT/TPJugusuKvbtsE5eBe1BO2YajV4qWpYUmaH0bWR91vhX0ae',
    2
); 
INSERT INTO gdf_user (
    user_id,
    username,
    user_firstname,
    user_lastname,
    user_email,
    user_password,
    user_type_id
) VALUES (
    3,
    'admin',
    'Tim',
    'Hunt',
    'admin@gmail.com',
    '$2a$10$VgkHIhT8Vt661ExClSWsDOtYlIN5WKvLclZzagz8X23atR2Y9VHCi',
    1
);

--user_type
INSERT INTO user_type ( user_type_id,user_type ) VALUES (1,'Employee' );
INSERT INTO user_type ( user_type_id,user_type ) VALUES (2,'Customer' );

--order
INSERT INTO orders (
    order_submitted,
    order_resolved,
    order_type,
    order_status,
    user_id
) VALUES (
    '31-JAN-2017 09:26:50.12',
    '11-FEB-2017 09:26:50.12',
    1,
    4,
    1
);
INSERT INTO orders (
    order_submitted,
    order_resolved,
    order_type,
    order_status,
    user_id
) VALUES (
    '31-JAN-2017 09:26:50.12',
    null,
    2,
    2,
    2
);
INSERT INTO orders (
    order_submitted,
    order_resolved,
    order_type,
    order_status,
    user_id
) VALUES (
    '31-JAN-2017 09:26:50.12',
    null,
    2,
    2,
    2
);

--DISH_LINE
INSERT INTO order_line (
    order_id,
    dish_id,
    quantity
) VALUES (
    1,
    1,
    1
);
INSERT INTO order_line (
    order_id,
    dish_id,
    quantity
) VALUES (
    1,
    2,
    1
);
INSERT INTO order_line (
    order_id,
    dish_id,
    quantity
) VALUES (
    2,
    3,
    2
);

--DISH
INSERT INTO dish ( dish_name,dish_price ) VALUES (
    
    'Orange Chicken',
    10.95
);
INSERT INTO dish ( dish_name,dish_price ) VALUES (
    
    'General TSo Chicken',
    10.45
);
INSERT INTO dish ( dish_name,dish_price ) VALUES (
    
    'Pork Fried Rice',
    9.35
);
INSERT INTO dish ( dish_name,dish_price ) VALUES (
    
    'Shrimp Fried Rice',
    9.35
);


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
    

commit;