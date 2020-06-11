CREATE DATABASE `carshop`;
USE carshop;

CREATE TABLE customers(
    customerNumber INT PRIMARY KEY,
    customerName NVARCHAR(50) NOT NULL,
    contactLastName NVARCHAR(50) NOT NULL,
    contactFirstName NVARCHAR(50) NOT NULL,
    phone NVARCHAR(50) NOT NULL,
    addressLine1 NVARCHAR(50) NOT NULL,
    addressLine2 NVARCHAR(50),
    city NVARCHAR(50) NOT NULL,
    state NVARCHAR(50) NOT NULL ,
    postalCode NVARCHAR(15) NOT NULL ,
    country NVARCHAR(50) NOT NULL ,
    creditLimit FLOAT
);
CREATE TABLE orders(
    orderNumber INT PRIMARY KEY ,
    orderDate DATE NOT NULL ,
    requiredDate DATE NOT NULL ,
    shippedDate DATE ,
    status NVARCHAR(15) NOT NULL ,
    comments TEXT,
    quantityOrdered INT NOT NULL ,
    priceEach FLOAT NOT NULL
);
CREATE TABLE payments(
    customerNumber INT PRIMARY KEY ,
    checkNumber NVARCHAR(50) NOT NULL ,
    paymentDate DATE NOT NULL ,
    amount FLOAT NOT NULL
);
CREATE TABLE products (
    productCode NVARCHAR(15) PRIMARY KEY ,
    productName NVARCHAR(70) NOT NULL ,
    productScale NVARCHAR(10) NOT NULL ,
    productVendor NVARCHAR(50) NOT NULL ,
    productDescription TEXT NOT NULL ,
    quantityInStock INT NOT NULL ,
    buyPrice FLOAT NOT NULL ,
    MSRP FLOAT NOT NULL
);
CREATE TABLE productlines (
    productLine NVARCHAR(50) PRIMARY KEY ,
    textDescription TEXT ,
    image NVARCHAR(1000)
);
CREATE TABLE employees (
    employeeNumber INT PRIMARY KEY ,
    lastName NVARCHAR(50) NOT NULL ,
    firstName NVARCHAR(50) NOT NULL ,
    email NVARCHAR(100) NOT NULL ,
    jobTitle NVARCHAR(50) NOT NULL
);
CREATE TABLE offices (
    officeCode NVARCHAR(10) PRIMARY KEY ,
    city NVARCHAR(50) NOT NULL ,
    phone NVARCHAR(50) NOT NULL ,
    addressLine1 NVARCHAR(50) NOT NULL ,
    addressLine2 NVARCHAR(50) ,
    state NVARCHAR(50) ,
    country NVARCHAR(50) NOT NULL ,
    postalCode NVARCHAR(15) NOT NULL
);

# customer - order (1:N)
ALTER TABLE orders ADD customerNumber INT ,
    ADD CONSTRAINT fk_customer_number FOREIGN KEY (customerNumber) REFERENCES customers(customerNumber);
# customer - payment (1:N)
ALTER TABLE payments
    ADD customerNumber INT ,
    ADD CONSTRAINT fk_customer_number FOREIGN KEY (customerNumber) REFERENCES customers(customerNumber);
# product - orders (N:M)
CREATE TABLE orderdetails(
    productCode NVARCHAR(15) ,
    FOREIGN KEY (productCode) REFERENCES products(productCode),
    orderNumber INT ,
    FOREIGN KEY (orderNumber) REFERENCES orders(orderNumber)
);

# productLines - products (1:N)
ALTER TABLE products
    ADD productLine NVARCHAR(50),
    ADD CONSTRAINT fk_product_line FOREIGN KEY (productLine) REFERENCES productlines(productLine);

# employees - customer (M:N)
ALTER TABLE payments
    ADD salesRepEmployeeNumber INT,
    ADD CONSTRAINT fk_employee_number FOREIGN KEY (salesRepEmployeeNumber) REFERENCES employees(employeeNumber);

# employees - employees (1:N) (many employees report to a supervisor)
ALTER TABLE employees
    ADD reportTo INT,
    ADD CONSTRAINT fk_report_to FOREIGN KEY (reportTo) REFERENCES employees(employeeNumber);

ALTER TABLE employees
    ADD officeCode NVARCHAR(10),
    ADD CONSTRAINT fk_office_code FOREIGN KEY (officeCode) REFERENCES offices(officeCode);