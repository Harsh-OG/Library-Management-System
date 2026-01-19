package com.jdbcconnectivity.LibraryManagement.service;

import com.jdbcconnectivity.LibraryManagement.model.Issue;
import java.util.List;

public interface IssueService {

    void issueBook(Issue issue);

    void returnBook(int issueId);

    List<Issue> getAllIssuedBooks();
}
