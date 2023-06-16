DROP TABLE IF EXISTS PRICES;
CREATE TABLE PRICES
(
    ID         SERIAL PRIMARY KEY,
    BRAND_ID   INTEGER NOT NULL,
    PRICE_LIST INTEGER,
    PRODUCT_ID INTEGER,
    PRIORITY   INTEGER,
    PRICE      DECIMAL(10, 2),
    CURR       VARCHAR(50),
    START_DATE TIMESTAMP,
    END_DATE   TIMESTAMP
);
INSERT INTO PRICES (BRAND_ID,
                    PRIORITY,
                    PRODUCT_ID,
                    PRICE,
                    CURR,
                    START_DATE,
                    END_DATE,
                    PRICE_LIST)
VALUES (1, 0, 35455, 35.50, 'EUR', '2020-06-14 00.00.00', '2020-12-31 23.59.59', 1);
INSERT INTO PRICES (BRAND_ID,
                    PRIORITY,
                    PRODUCT_ID,
                    PRICE,
                    CURR,
                    START_DATE,
                    END_DATE,
                    PRICE_LIST)
VALUES (1, 1, 35455, 25.45, 'EUR', '2020-06-14 15.00.00', '2020-06-14 18.30.00', 1);
INSERT INTO PRICES (BRAND_ID,
                    PRIORITY,
                    PRODUCT_ID,
                    PRICE,
                    CURR,
                    START_DATE,
                    END_DATE,
                    PRICE_LIST)
VALUES (1, 1, 35455, 30.50, 'EUR', '2020-06-15 00.00.00', '2020-06-15 11.00.00', 1);
INSERT INTO PRICES (BRAND_ID,
                    PRIORITY,
                    PRODUCT_ID,
                    PRICE,
                    CURR,
                    START_DATE,
                    END_DATE,
                    PRICE_LIST)
VALUES (1, 1, 35455, 38.95, 'EUR', '2020-06-15 16.00.00', '2020-12-31 23.59.59', 1);
