package com.library.service;

import com.library.model.Book;
import com.library.service.exception.NoBookToBorrowException;

public interface IBookService {
    Iterable<Book> findAll();

    Book findById(Long id);

    void save(Book book);

    void remove(Long id);

    void returnBook(Long id);

    void borrowBook(Long id) throws NoBookToBorrowException;
}
