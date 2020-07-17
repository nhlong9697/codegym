package com.library.service.impl;

import com.library.model.Book;
import com.library.repository.IBookRepository;
import com.library.service.IBookService;
import com.library.service.exception.NoBookToBorrowException;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Long id) {
        bookRepository.delete(id);
    }

    @Override
    public void returnBook(Long id) {
        Book bookToReturn = bookRepository.findOne(id);
        bookToReturn.setAmount(bookToReturn.getAmount() + 1);
        bookRepository.save(bookToReturn);
    }

    @Override
    public void borrowBook(Long id) throws NoBookToBorrowException {
        Book bookToBorrow = bookRepository.findOne(id);
        if (bookToBorrow.getAmount() > 0) {
            bookToBorrow.setAmount(bookToBorrow.getAmount() - 1);
            bookRepository.save(bookToBorrow);
        } else {
            throw new NoBookToBorrowException();
        }
    }
}
