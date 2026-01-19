package com.jdbcconnectivity.LibraryManagement.dao.impl;

import com.jdbcconnectivity.LibraryManagement.dao.IssueDAO;
import com.jdbcconnectivity.LibraryManagement.model.Issue;
import com.jdbcconnectivity.LibraryManagement.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IssueDAOImpl implements IssueDAO {

    @Override
    public void issueBook(Issue issue) {
        String sql = "INSERT INTO issue(book_id, member_id, issue_date) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, issue.getBookId());
            ps.setInt(2, issue.getMemberId());
            ps.setDate(3, issue.getIssueDate());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void returnBook(int issueId) {
        String sql = "UPDATE issue SET return_date = CURDATE() WHERE issue_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, issueId);
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Issue> getAllIssuedBooks() {
        List<Issue> list = new ArrayList<>();
        String sql = "SELECT * FROM issue";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Issue i = new Issue();
                i.setIssueId(rs.getInt("issue_id"));
                i.setBookId(rs.getInt("book_id"));
                i.setMemberId(rs.getInt("member_id"));
                i.setIssueDate(rs.getDate("issue_date"));
                i.setReturnDate(rs.getDate("return_date"));
                list.add(i);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
