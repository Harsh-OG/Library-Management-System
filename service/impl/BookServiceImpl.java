package com.jdbcconnectivity.LibraryManagement.service.impl;

import com.jdbcconnectivity.LibraryManagement.dao.BookDAO;
import com.jdbcconnectivity.LibraryManagement.dao.impl.BookDAOImpl;
import com.jdbcconnectivity.LibraryManagement.model.Book;
import com.jdbcconnectivity.LibraryManagement.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDAO bookDAO = new BookDAOImpl();

    public void addBook(Book book) {
        bookDAO.add(book);
    }

    public List<Book> getAllBooks() {
        return bookDAO.getAll();
    }

    public void updateQuantity(int bookId, int qty) {
        bookDAO.updateQuantity(bookId, qty);
    }
}
