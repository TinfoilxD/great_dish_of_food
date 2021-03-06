
/*
DROP SEQUENCES
*/
DROP SEQUENCE dish_type_id_seq;
DROP SEQUENCE order_id_seq;
DROP SEQUENCE dish_id_seq;
DROP SEQUENCE user_id_seq;


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

CREATE SEQUENCE user_id_seq
    START WITH 120
    INCREMENT BY 1;
    
CREATE OR REPLACE TRIGGER user_id_trigger
    BEFORE INSERT ON gdf_user
    FOR EACH ROW
BEGIN
    IF :new.user_id IS NULL THEN
        SELECT user_id_seq.nextval INTO :new.user_id
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
ADD CONSTRAINTS
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


--user_type
INSERT INTO user_type ( user_type_id,user_type ) VALUES (1,'Employee' );
INSERT INTO user_type ( user_type_id,user_type ) VALUES (2,'Customer' );

--Order_Status
INSERT INTO order_status ( order_status_id,order_status ) VALUES (1,'Received');
INSERT INTO order_status ( order_status_id,order_status ) VALUES (2,'Cooking');
INSERT INTO order_status ( order_status_id,order_status ) VALUES (3,'Out for Delivery');
INSERT INTO order_status ( order_status_id,order_status ) VALUES (4,'Delivered');

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

INSERT INTO gdf_user (
    user_id,
    username,
    user_firstname,
    user_lastname,
    user_email,
    user_password,
    user_type_id
) VALUES (
    4,
    'lemon',
    'Lemon',
    'Ade',
    'lemonade@lemon.com',
    '$2a$10$VgkHIhT8Vt661ExClSWsDOtYlIN5WKvLclZzagz8X23atR2Y9VHCi',
    2
);



--DISH
INSERT INTO dish ( dish_name,dish_price ) VALUES (
    
    'Orange Chicken',
    10.95
);
INSERT INTO dish ( dish_name,dish_price ) VALUES (
    
    'General Tso''s Chicken',
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
INSERT INTO dish ( dish_name,dish_price ) VALUES (
    
    'Brocolli Beef',
    10.95
);
INSERT INTO dish ( dish_name,dish_price ) VALUES (
    
    'Sesame Chicken',
    10.95
);
INSERT INTO dish ( dish_name,dish_price ) VALUES (
    
    'Kung Pao Chicken',
    10.95
);
INSERT INTO dish ( dish_name,dish_price ) VALUES (
    
    'Chicken Lo Mein',
    9.95
);
INSERT INTO dish ( dish_name,dish_price ) VALUES (
    
    'Shrimp Tempura(5)',
    9.95
);
INSERT INTO dish ( dish_name,dish_price ) VALUES (
    
    'Spring Rolls(8)',
    11.95
);


--categories
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (1,6);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (1,1);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (2,1);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (2,6);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (3,2);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (3,6);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (3,2);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (4,6);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (4,4);



INSERT INTO categories ( dish_id,dish_type_id ) VALUES (5,3);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (5,6);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (5,8);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (6,1);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (6,6);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (7,1);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (7,6);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (8,1);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (8,7);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (9,4);
INSERT INTO categories ( dish_id,dish_type_id ) VALUES (10,8);


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
INSERT INTO orders (
    order_submitted,
    order_resolved,
    order_type,
    order_status,
    user_id
) VALUES (
    '06-MAY-2017 11:30:00.00',
    null,
    1,
    1,
    4
);
INSERT INTO orders (
    order_submitted,
    order_resolved,
    order_type,
    order_status,
    user_id
) VALUES (
    '08-MAY-2017 12:30:00.00',
    null,
    1,
    1,
    4
);
INSERT INTO orders (
    order_submitted,
    order_resolved,
    order_type,
    order_status,
    user_id
) VALUES (
    '01-MAY-2017 12:30:00.00',
    null,
    1,
    4,
    4
);
INSERT INTO orders (
    order_submitted,
    order_resolved,
    order_type,
    order_status,
    user_id
) VALUES (
    '14-MAY-2017 12:30:00.00',
    null,
    1,
    1,
    4
);
INSERT INTO orders (
    order_submitted,
    order_resolved,
    order_type,
    order_status,
    user_id
) VALUES (
    '17-MAY-2017 12:00:00.00',
    null,
    1,
    1,
    4
);
INSERT INTO orders (
    order_submitted,
    order_resolved,
    order_type,
    order_status,
    user_id
) VALUES (
    '19-MAY-2017 12:30:00.00',
    null,
    1,
    1,
    4
);
INSERT INTO orders (
    order_submitted,
    order_resolved,
    order_type,
    order_status,
    user_id
) VALUES (
    '21-MAY-2017 11:30:00.00',
    null,
    1,
    1,
    4
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

INSERT INTO order_line (
    order_id,
    dish_id,
    quantity
) VALUES (
    4,
    1,
    1
);
INSERT INTO order_line (
    order_id,
    dish_id,
    quantity
) VALUES (
    4,
    3,
    1
);
INSERT INTO order_line (
    order_id,
    dish_id,
    quantity
) VALUES (
    4,
    10,
    1
);
INSERT INTO order_line (
    order_id,
    dish_id,
    quantity
) VALUES (
    6,
    2,
    1
);
INSERT INTO order_line (
    order_id,
    dish_id,
    quantity
) VALUES (
    7,
    3,
    2
);
INSERT INTO order_line (
    order_id,
    dish_id,
    quantity
) VALUES (
    7,
    8,
    1
);
INSERT INTO order_line (
    order_id,
    dish_id,
    quantity
) VALUES (
    7,
    9,
    1
);
INSERT INTO order_line (
    order_id,
    dish_id,
    quantity
) VALUES (
    8,
    3,
    1
);
INSERT INTO order_line (
    order_id,
    dish_id,
    quantity
) VALUES (
    9,
    5,
    4
);
INSERT INTO order_line (
    order_id,
    dish_id,
    quantity
) VALUES (
    9,
    6,
    1
);
INSERT INTO order_line (
    order_id,
    dish_id,
    quantity
) VALUES (
    10,
    7,
    1
);

commit;