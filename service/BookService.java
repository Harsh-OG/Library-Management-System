package com.jdbcconnectivity.LibraryManagement.service;

import com.jdbcconnectivity.LibraryManagement.model.Book;
import java.util.List;

public interface BookService {
    void addBook(Book book);
    List<Book> getAllBooks();
    void updateQuantity(int bookId, int qty);
}
