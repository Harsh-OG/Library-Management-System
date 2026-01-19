package com.jdbcconnectivity.LibraryManagement.dao;

import com.jdbcconnectivity.LibraryManagement.model.Book;
import java.util.List;

public interface BookDAO {
    void add(Book book);
    List<Book> getAll();
    void updateQuantity(int bookId, int qty);
}
