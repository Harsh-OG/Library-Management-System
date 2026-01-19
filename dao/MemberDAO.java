package com.jdbcconnectivity.LibraryManagement.dao;

import com.jdbcconnectivity.LibraryManagement.model.Member;
import java.util.List;

public interface MemberDAO {
    void add(Member member);
    List<Member> getAll();
}
