use classicmodels;
CREATE VIEW customer_views AS
SELECT customerNumber, customerName, phone
FROM customers;

SELECT * FROM customer_views;

#UPDATE VIEW
CREATE VIEW salePerOrder AS
SELECT
    orderNumber,
    SUM(quantityOrdered * priceEach) total
FROM
    orderdetails
GROUP by orderNumber
ORDER BY total DESC;
INSERT INTO salePerOrder VALUES (123,1234);

SHOW FULL TABLES;

#select view from other view
CREATE VIEW bigSalesOrder AS
SELECT
    orderNumber,
    ROUND(total,2) as total
FROM
    salePerOrder
WHERE
        total > 60000;

CREATE OR REPLACE VIEW customerOrders AS
SELECT
    orderNumber,
    customerName,
    SUM(quantityOrdered * priceEach) total
FROM
    orderdetails
        INNER JOIN orders o USING (orderNumber)
        INNER JOIN customers USING (customerNumber)
GROUP BY orderNumber
ORDER BY orderNumber;
SELECT * FROM customerOrders;

#view with subquery
CREATE VIEW aboveAvgProducts AS
SELECT
    productCode,
    productName,
    buyPrice
FROM
    products
WHERE
        buyPrice > (
        SELECT
            AVG(buyPrice)
        FROM
            products)
ORDER BY buyPrice DESC;

#view with explicit view columns example
CREATE VIEW customerOrderStats (
                                customerName ,
                                orderCount
    )
AS
SELECT
    customerName,officeInfo
    COUNT(orderNumber)
FROM
    customers
        INNER JOIN
    orders USING (customerNumber);

CREATE ALGORITHM=MERGE VIEW contactPersons(
                                           customerName,
                                           firstName,
                                           lastName,
                                           phone
    ) AS
SELECT
    customerName,
    contactFirstName,
    contactLastName,
    phone
FROM customers;

EXPLAIN SELECT * FROM contactPersons
WHERE customerName LIKE '%Co%';

CREATE VIEW salesOrders AS
SELECT
    orderNumber,
    productCode,
    quantityOrdered,
    priceEach,
    status
FROM
    orders
        INNER JOIN
    orderdetails USING (orderNumber);

SHOW CREATE VIEW salesOrders;
SELECT * FROM salesOrders;
GRANT SELECT ON salesOrders
    TO 'root'@'localhost';

CREATE VIEW officeInfo
AS
SELECT officeCode, phone, city
FROM offices;

UPDATE officeInfo
SET
    phone = '+33 14 723 5555'
WHERE
        officeCode = 4;

SELECT
    *
FROM
    officeInfo
WHERE
        officeCode = 4;

SELECT
    table_name,
    is_updatable
FROM
    information_schema.views
WHERE
        table_schema = 'classicmodels';

#remove row through view
-- create a new table named items
CREATE TABLE items (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       price DECIMAL(11 , 2 ) NOT NULL
);

-- insert data into the items table
INSERT INTO items(name,price)
VALUES('Laptop',700.56),('Desktop',699.99),('iPad',700.50) ;

-- create a view based on items table
CREATE VIEW LuxuryItems AS
SELECT
    *
FROM
    items
WHERE
        price > 700;
-- query data from the LuxuryItems view
SELECT
    *
FROM
    LuxuryItems;

DELETE FROM LuxuryItems
WHERE
        id = 3;

SELECT
    *
FROM
    LuxuryItems;

SELECT
    *
FROM
    items;

#check option
CREATE OR REPLACE VIEW vps AS
SELECT
    employeeNumber,
    lastName,
    firstName,
    jobTitle,
    extension,
    email,
    officeCode,
    reportsTo
FROM
    employees
WHERE
        jobTitle LIKE '%VP%'
WITH CHECK OPTION;
SELECT * FROM vps;

INSERT INTO vps(
    employeeNumber,
    firstName,
    lastName,
    jobTitle,
    extension,
    email,
    officeCode,
    reportsTo
)
VALUES(
          1703,
          'Lily',
          'Bush',
          'VP',
          'x9111',
          'lilybush@classicmodelcars.com',
          1,
          1002
      );

SELECT
    *
FROM
    employees
WHERE firstName='Lily';

#show view
SELECT
    table_name view_name
FROM
    information_schema.tables
WHERE
        table_type   = 'VIEW' AND
        table_schema = 'classicmodels' AND
        table_name   LIKE 'customer%';