package com.jdbcconnectivity.LibraryManagement.dao;

import com.jdbcconnectivity.LibraryManagement.model.Book;
import java.util.List;

public interface BookDAO {

    void addBook(Book book);

    List<Book> getAllBooks();

    void updateBookQuantity(int bookId, int change);
}
