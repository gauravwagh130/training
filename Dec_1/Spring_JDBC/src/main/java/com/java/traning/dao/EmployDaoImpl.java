package com.java.traning.dao;

import com.java.traning.model.Employ;
import com.java.traning.model.Gender;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployDaoImpl implements EmployDao{
  private JdbcTemplate jdbcTemplate;

  public JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Employ> showEmployDao() {
    String sql = "SELECT * FROM employ";
    List<Employ> employList = jdbcTemplate.query(sql, new RowMapper<Employ>() {
      @Override
      public Employ mapRow(ResultSet resultSet, int i) throws SQLException {
        Employ employ = new Employ();
        employ.setEmpno(resultSet.getInt("empno"));
        employ.setName(resultSet.getString("name"));
        employ.setGender(Gender.valueOf(resultSet.getString("gender")));
        employ.setDept(resultSet.getString("dept"));
        employ.setDesig(resultSet.getString("desig"));
        employ.setBasic(resultSet.getDouble("basic"));
        return employ;
      }
    });
    return employList;
  }
}
