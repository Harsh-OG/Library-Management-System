package com.jdbcconnectivity.LibraryManagement.dao.impl;

import com.jdbcconnectivity.LibraryManagement.dao.MemberDAO;
import com.jdbcconnectivity.LibraryManagement.model.Member;
import com.jdbcconnectivity.LibraryManagement.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {

    public void add(Member m) {
        String sql = "INSERT INTO member(name, phone, email) VALUES(?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, m.getName());
            ps.setString(2, m.getPhone());
            ps.setString(3, m.getEmail());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Member> getAll() {
        List<Member> list = new ArrayList<>();
        String sql = "SELECT * FROM member";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Member m = new Member();
                m.setMemberId(rs.getInt("member_id"));
                m.setName(rs.getString("name"));
                m.setPhone(rs.getString("phone"));
                m.setEmail(rs.getString("email"));
                list.add(m);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
