package com.java.traning.services;

import com.java.traning.Model.Member;
import com.java.traning.dao.MemberDao;
import com.java.traning.dao.MemberDaoImpl;
import com.java.traning.exception.LibraryException;

import java.util.List;

public class MemberService {
  private final MemberDao memberDao = new MemberDaoImpl();

  public String addMember(Member m) throws LibraryException {
      return memberDao.addMember(m);
  }
  public Member findById(int memberId) throws LibraryException{
    return memberDao.findById(memberId);
  }

  public List<Member> findAllMember() throws LibraryException {
    return memberDao.findAllMember();
  }
}
