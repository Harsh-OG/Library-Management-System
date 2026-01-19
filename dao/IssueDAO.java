package com.jdbcconnectivity.LibraryManagement.dao;

import com.jdbcconnectivity.LibraryManagement.model.Issue;
import java.util.List;

public interface IssueDAO {

    void issueBook(Issue issue);

    void returnBook(int issueId);

    List<Issue> getAllIssuedBooks();   // ✅ renamed
}
