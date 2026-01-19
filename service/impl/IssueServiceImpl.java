package com.jdbcconnectivity.LibraryManagement.service.impl;

import com.jdbcconnectivity.LibraryManagement.dao.IssueDAO;
import com.jdbcconnectivity.LibraryManagement.dao.impl.IssueDAOImpl;
import com.jdbcconnectivity.LibraryManagement.model.Issue;
import com.jdbcconnectivity.LibraryManagement.service.IssueService;

import java.util.List;

public class IssueServiceImpl implements IssueService {

    private IssueDAO issueDAO = new IssueDAOImpl();

    @Override
    public void issueBook(Issue issue) {
        issueDAO.issueBook(issue);
    }

    @Override
    public void returnBook(int issueId) {
        issueDAO.returnBook(issueId);
    }

    @Override
    public List<Issue> getAllIssuedBooks() {
        return issueDAO.getAllIssuedBooks();   // ✅ FIXED
    }
}
