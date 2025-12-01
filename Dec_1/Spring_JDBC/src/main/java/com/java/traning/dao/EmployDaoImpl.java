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

  @Override
  public Employ searchEmployDao(int empno) {
    String sql = "SELECT * FROM employ WHERE empno = ?";
    List<Employ> employList= jdbcTemplate.query(sql, new Object[]{empno}, new RowMapper<Employ>() {
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
    if (employList.size()!=0){
      return employList.get(0);
    }
    return null;
  }

  @Override
  public String addEMployDao(Employ employ) {
    String sql = "INSERT INTO employ(empno, name, gender, dept, desig, basic) VALUES (?, ?, ?, ?, ?, ?)";
    jdbcTemplate.update(sql, new Object[]{employ.getEmpno(), employ.getName(), employ.getGender().toString(), employ.getDept(), employ.getDesig(), employ.getBasic()});

    return "Employ record inserted";
  }

  @Override
  public String updateEmployDao(Employ employ) {
    String sql = "UPDATE employ SET Name = ?, Gender = ?, Dept = ?, Desig = ?, Basic = ? where Empno = ?";
    jdbcTemplate.update(sql, new Object[]{employ.getName(),
      employ.getGender().toString(), employ.getDept(), employ.getDesig(), employ.getBasic(), employ.getEmpno()});
    return "Employ record are Updated";
  }

  @Override
  public String deleteEmployDao(int empno) {
    String sql = "DELETE FROM employ WHERE empno=?";
    jdbcTemplate.update(sql, new Object[]{empno});
    return "Employ record deleted...";
  }

  @Override
  public int authenticate(String user, String pwd) {
    String cmd = "select count(*) cnt from Login where userName=? AND Passcode=?";
    List<Integer> count =jdbcTemplate.query(cmd, new Object[]{user, pwd}, new RowMapper<Integer>() {

      @Override
      public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getInt("cnt");
      }
    });
    return count.get(0);
  }
}
