package com.java.traning.dao;

import com.java.traning.Model.Member;
import com.java.traning.exception.LibraryException;

import java.util.List;

public interface MemberDao {
  String addMember(Member m) throws LibraryException;
  Member findById(int memberId) throws LibraryException;
  List<Member> findAllMember() throws LibraryException;
//  String deleteMember(int memberId) throws LibraryException;

}
