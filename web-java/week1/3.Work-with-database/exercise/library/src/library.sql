CREATE DATABASE library;
USE library;
CREATE TABLE Student (
    student_number NVARCHAR(15) PRIMARY KEY ,
    student_name NVARCHAR(50) NOT NULL ,
    address NVARCHAR(500) NOT NULL ,
    email NVARCHAR(50) NOT NULL ,
    image NVARCHAR(1024) NOT NULL
);

CREATE TABLE Category (
    categoryID INT PRIMARY KEY ,
    catagoryName NVARCHAR(15)
);

CREATE TABLE BorrowOrder (
    borrowID INT PRIMARY KEY ,
    returnDate DATE NOT NULL
);

CREATE TABLE Book (
    ISBN INT PRIMARY KEY ,
    title NVARCHAR(50) NOT NULL ,
    author NVARCHAR(50) NOT NULL ,
    publisher NVARCHAR(50) NOT NULL
);

ALTER TABLE Book
ADD categoryID INT,
ADD CONSTRAINT FOREIGN KEY (categoryID) REFERENCES Category(categoryID);

ALTER TABLE BorrowOrder
ADD ISBN INT,
ADD CONSTRAINT FOREIGN KEY (ISBN) REFERENCES Book(ISBN),
ADD student_number NVARCHAR(15),
ADD CONSTRAINT FOREIGN KEY (student_number) REFERENCES Student(student_number);
