package com.library.formatter;

import com.library.model.Book;
import com.library.service.IBookService;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class BookFormatter implements Formatter<Book> {
    private IBookService bookService;

    public BookFormatter(IBookService bookService) {
        this.bookService = bookService;
    }
    @Override
    public Book parse(String text, Locale locale) throws ParseException {
        return bookService.findOne(Long.valueOf(text));
    }

    @Override
    public String print(Book object, Locale locale) {
        return object.toString();
    }


}
