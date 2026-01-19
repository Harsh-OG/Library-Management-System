package com.jdbcconnectivity.LibraryManagement.service;

import com.jdbcconnectivity.LibraryManagement.model.Member;
import java.util.List;

public interface MemberService {
    void addMember(Member member);
    List<Member> getAllMembers();
}
