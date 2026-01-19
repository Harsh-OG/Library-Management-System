package com.jdbcconnectivity.LibraryManagement.service.impl;

import com.jdbcconnectivity.LibraryManagement.dao.MemberDAO;
import com.jdbcconnectivity.LibraryManagement.dao.impl.MemberDAOImpl;
import com.jdbcconnectivity.LibraryManagement.model.Member;
import com.jdbcconnectivity.LibraryManagement.service.MemberService;

import java.util.List;

public class MemberServiceImpl implements MemberService {

    private MemberDAO memberDAO = new MemberDAOImpl();

    public void addMember(Member member) {
        memberDAO.add(member);
    }

    public List<Member> getAllMembers() {
        return memberDAO.getAll();
    }
}
