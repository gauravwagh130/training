package com.java.traning.dao;

import com.java.traning.Model.Member;
import com.java.traning.exception.LibraryException;
import com.java.traning.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao{
  @Override
  public String addMember(Member m) throws LibraryException {
    String sql = "INSERT INTO members(name, email) VALUES (?, ?, ?)";
    try {
      Connection conn = ConnectionHelper.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, m.getName());
      ps.setString(2, m.getEmail());
      ps.executeUpdate();
      try (ResultSet rs = ps.getGeneratedKeys()) {
        if (rs.next()) m.setMemberId(rs.getInt(1));
      }
    } catch (SQLException | ClassNotFoundException e) {
      throw new LibraryException("Error in adding member",e);
    }
    return "Member are added...";
  }

  @Override
  public Member findById(int memberId) throws LibraryException {
    String sql = "SELECT * FROM members WHERE member_id =?";
    Member m = new Member();
    try {
      Connection conn = ConnectionHelper.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, memberId);
      ResultSet rs = ps.executeQuery();
      if(rs.next()){
        return mapRow(rs);
      }
    } catch (SQLException | ClassNotFoundException e) {
      throw new LibraryException("Error in finding member by id",e);
    }
    return null;
  }

  @Override
  public List<Member> findAllMember() throws LibraryException {
    List<Member> list = new ArrayList<>();
    String sql = "SELECT * FROM members";
    try {
      Connection conn = ConnectionHelper.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()){
        list.add(mapRow(rs));
      }
    } catch (SQLException | ClassNotFoundException e) {
      throw new LibraryException("Error in finding member",e);
    }
    return list;
  }

  private Member mapRow(ResultSet rs) throws SQLException {
    Member m = new Member();
    m.setMemberId(rs.getInt("member_id"));
    m.setName(rs.getString("name"));
    m.setEmail(rs.getString("email"));
    return m;
  }
}
