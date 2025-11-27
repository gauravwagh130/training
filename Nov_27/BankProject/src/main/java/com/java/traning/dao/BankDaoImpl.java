package com.java.traning.dao;

import com.java.traning.model.Accounts;
import com.java.traning.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankDaoImpl implements BankDao{
  Connection conn = null;
  PreparedStatement ps = null;
  public int generateAccountNo() throws SQLException, ClassNotFoundException {
    conn = ConnectionHelper.getConnection();
    String sql = """
      select case when max(accountNo) IS NULL THEN 1
      else max(accountNo)+1 end accno from accounts
      """;

    ps = conn.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    rs.next();
    int accno =rs.getInt("accno");
    return accno;
  }
  @Override
  public String createAccount(Accounts account) throws SQLException, ClassNotFoundException {
    int accno = generateAccountNo();
    account.setAccountNo(accno);
    conn = ConnectionHelper.getConnection();
    String sql = """
            INSERT INTO Accounts
            (AccountNo, FirstName, LastName, City, State, Amount, CheqFacil, AccountType)
            VALUES (?,?,?,?,?,?,?,?)
        """;
    ps = conn.prepareStatement(sql);
    ps.setInt(1, accno);
    ps.setString(2, account.getFirstName());
    ps.setString(3, account.getLastName());
    ps.setString(4, account.getCity());
    ps.setString(5, account.getState());
    ps.setDouble(6, account.getAmount());
    ps.setString(7, account.getCheqFacil());
    ps.setString(8, account.getAccountType());
    ps.executeUpdate();
    return "Bank Account created Successfully...";
  }

  @Override
  public Accounts searchAccount(int accountNo) throws SQLException, ClassNotFoundException {
    conn = ConnectionHelper.getConnection();
    String sql = "SELECT * FROM Accounts WHERE accountNo = ?";
    ps = conn.prepareStatement(sql);
    ps.setInt(1, accountNo);
    ResultSet rs= ps.executeQuery();
    Accounts accounts = null;
    if (rs.next()) {
      accounts = new Accounts();
      accounts.setAccountNo(rs.getInt("AccountNo"));
      accounts.setFirstName(rs.getString("FirstName"));
      accounts.setLastName(rs.getString("LastName"));
      accounts.setCity(rs.getString("City"));
      accounts.setState(rs.getString("State"));
      accounts.setAmount(rs.getDouble("Amount"));
      accounts.setCheqFacil(rs.getString("CheqFacil"));
      accounts.setAccountType(rs.getString("AccountType"));
    }
    return accounts;
  }

  @Override
  public String updateAccount(int accountNo, String city, String state) throws SQLException, ClassNotFoundException {
    Accounts accountFound = searchAccount(accountNo);
    if (accountFound!= null){
      conn = ConnectionHelper.getConnection();
      String sql = """
      UPDATE Accounts SET city =?, State=? WHERE accountNo=?
      """;
      ps = conn.prepareStatement(sql);
      ps.setString(1, city);
      ps.setString(2, state);
      ps.setInt(3, accountNo);
      ps.executeUpdate();
      return "Account are updated...";
    }

    return "Account No not found...";
  }

  @Override
  public String closeAccount(int accountNo) throws SQLException, ClassNotFoundException {
    Accounts accountFound = searchAccount(accountNo);
    if (accountFound != null) {
      conn = ConnectionHelper.getConnection();
      String sql = "UPDATE Accounts SET status ='inactive' WHERE accountNO= ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, accountNo);
      ps.executeUpdate();
      return "Account Deleted Successfully...";
    }
    return "Account not found";
  }

  @Override
  public String depositAccount(int accountNo, double amount)
    throws SQLException, ClassNotFoundException {

    Accounts accounts = searchAccount(accountNo);
    if (accounts == null) {
      return "Account No Not Found...";
    }

    String updateSql = "UPDATE Accounts SET Amount = Amount + ? WHERE AccountNo = ?";
    String insertSql = "INSERT INTO Trans(AccountNo, TransAmount, TransType) VALUES(?,?,?)";

    try (Connection conn = ConnectionHelper.getConnection()) {
      conn.setAutoCommit(false);

      try (PreparedStatement ps1 = conn.prepareStatement(updateSql);
           PreparedStatement ps2 = conn.prepareStatement(insertSql)) {

        ps1.setDouble(1, amount);
        ps1.setInt(2, accountNo);
        ps1.executeUpdate();

        ps2.setInt(1, accountNo);
        ps2.setDouble(2, amount);
        ps2.setString(3, "C");
        ps2.executeUpdate();

        conn.commit();
        return "Account Deposited Successfully...";
      } catch (SQLException e) {
        conn.rollback();
        throw e;
      }
    }
  }

  @Override
  public String withdrawAccount(int accountNo, double amount)
    throws SQLException, ClassNotFoundException {

    Accounts accounts = searchAccount(accountNo);

    if (accounts == null) {
      return "Account No Not Found...";
    }

    double balance = accounts.getAmount();
    if (balance < amount) {
      return "Insufficient Balance...";
    }

    String updateSql = "UPDATE Accounts SET Amount = Amount - ? WHERE AccountNo = ?";
    String transSql   = "INSERT INTO Trans(AccountNo, TransAmount, TransType) VALUES(?,?,?)";

    try (Connection conn = ConnectionHelper.getConnection()) {
      conn.setAutoCommit(false);

      try (PreparedStatement ps1 = conn.prepareStatement(updateSql);
           PreparedStatement ps2 = conn.prepareStatement(transSql)) {

        ps1.setDouble(1, amount);
        ps1.setInt(2, accountNo);
        ps1.executeUpdate();

        ps2.setInt(1, accountNo);
        ps2.setDouble(2, amount);
        ps2.setString(3, "D");
        ps2.executeUpdate();

        conn.commit();
        return "Account Withdraw Successfully...";

      } catch (SQLException e) {
        conn.rollback();
        throw e;
      }
    }
  }
}
