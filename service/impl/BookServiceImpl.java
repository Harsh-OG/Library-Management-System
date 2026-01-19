package com.jdbcconnectivity.LibraryManagement.service.impl;

import com.jdbcconnectivity.LibraryManagement.dao.BookDAO;
import com.jdbcconnectivity.LibraryManagement.dao.impl.BookDAOImpl;
import com.jdbcconnectivity.LibraryManagement.model.Book;
import com.jdbcconnectivity.LibraryManagement.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDAO bookDAO = new BookDAOImpl();

    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    // ✅ IMPLEMENT THIS
    @Override
    public void updateBookQuantity(int bookId, int change) {
        bookDAO.updateBookQuantity(bookId, change);
    }
}
