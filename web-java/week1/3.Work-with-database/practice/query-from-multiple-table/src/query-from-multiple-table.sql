USE `classicmodels`;
# inner join
SELECT customers.customerNumber, customers.customerName, customers.phone, payments.paymentDate, payments.amount
FROM customers INNER JOIN payments
ON customers.customerNumber = payments.customerNumber
WHERE city = 'Las Vegas';

# left join
SELECT customers.customerName, customers.customerNumber, orders.orderNumber, orders.status
FROM customers LEFT JOIN orders
ON customers.customerNumber = orders.customerNumber;

# customers that havent made orders
SELECT customers.customerName, customers.customerNumber, orders.orderNumber, orders.status
FROM customers LEFT JOIN orders
ON customers.customerNumber = orders.customerNumber
WHERE orders.orderNumber IS NULL;
