CREATE DATABASE class;
USE class;
# create table
CREATE TABLE class (
    ID INT NOT NULL ,
    TEN NVARCHAR(50) NOT NULL ,
    TUOI INT NOT NULL ,
    KHOAHOC NVARCHAR(50) NOT NULL ,
    SOTIEN FLOAT NOT NULL
);
INSERT INTO class VALUES (1,'Hoang',21,'CNTT',400000);
INSERT INTO class VALUES (2,'Viet',19,'DTVT',320000);
INSERT INTO class VALUES (3,'Thanh',18,'KTDN',400000);
INSERT INTO class VALUES (4,'Nhan',19,'CK',450000);
INSERT INTO class VALUES (5,'Huong',20,'TCNH',500000);
INSERT INTO class VALUES (5,'Huong',20,'TCNH',200000);

#all row with name 'huong'
SELECT * FROM class WHERE TEN = 'Huong';
SELECT TEN, SUM(SOTIEN) FROM class WHERE TEN = 'Huong';
SELECT TEN FROM class GROUP BY TEN;
