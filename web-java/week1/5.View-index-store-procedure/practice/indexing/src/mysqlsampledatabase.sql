use classicmodels;

ALTER TABLE customers ADD KEY (customerNumber,phone);
ALTER TABLE customers ADD UNIQUE idx_customerNumber(customerNumber);
ALTER TABLE customers ADD FULLTEXT idx_customerNumber(customerNumber);
ALTER TABLE customers ADD PRIMARY KEY idx_customerNumber(customerNumber);

EXPLAIN SELECT * FROM customers WHERE customerNumber = 496 AND phone = '+64 9 5555500';
ALTER TABLE customers ADD INDEX idx_full_name(contactFirstName, contactLastName);

EXPLAIN SELECT * FROM customers WHERE contactFirstName = 'Jean' or contactLastName = 'King';
EXPLAIN SELECT * FROM customers USE INDEX (idx_full_name) WHERE contactFirstName = 'Jean' or contactLastName = 'King';
SHOW INDEX FROM customers FROM classicmodels;

ALTER TABLE customers DROP INDEX idx_full_name;
ALTER TABLE customers DROP INDEX idx_customerNumber;
ALTER TABLE customers DROP PRIMARY KEY;

