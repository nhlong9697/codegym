USE classicmodels;
select status from orders
group by status;

select status, COUNT(*) as 'So luong status'
from orders
group by status;

SELECT status, sum(orderdetails.quantityOrdered * orderdetails.priceEach) as amount
FROM orders
INNER JOIN orderdetails on orders.orderNumber = orderdetails.orderNumber
GROUP BY status;

SELECT orderNumber, sum(quantityOrdered * priceEach) as amount
FROM orderdetails
GROUP BY orderNumber;

SELECT year(orders.orderDate) AS year, sum(orderdetails.quantityOrdered * orderdetails.priceEach) AS total
FROM orders
INNER JOIN orderdetails ON orders.orderNumber = orderdetails.orderNumber
WHERE orders.status = 'shipped'
GROUP BY year
HAVING year > 2003
