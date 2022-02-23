package org.study.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.study.cust.Account;
import org.study.cust.Checking;
import org.study.cust.Customer;
import org.study.cust.Savings;

public class Dbservice {
	String url="jdbc:mysql://localhost:3306/bank_db";
	String user="bank";
	String password="securepassword";
	private Connection connect() {
		Connection  connection;
		try {
			connection=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			connection=null;
		}
		return connection;
	}
 public int addAccount(String firstName,String lastName,AccountType type, Double balance) {
	 int userId=-1;
	 int accountId=-1;
	 Connection connection=connect();
	 try {
		connection.setAutoCommit(false);
		String addUsersql="insert into users(firstName,lastName) values(?,?)";
		PreparedStatement addUser=connection.prepareStatement(addUsersql,Statement.RETURN_GENERATED_KEYS);
		addUser.setString(1,firstName);
		addUser.setString(2,lastName);
		addUser.executeUpdate();
		ResultSet rs=addUser.getGeneratedKeys();
		if(rs.next()) {
			userId=rs.getInt(1);
		}
		//add account 
		String addAccountSql="insert into accounts(Type,Balance) values(?,?)";
		PreparedStatement addAccount=connection.prepareStatement(addAccountSql,Statement.RETURN_GENERATED_KEYS);
		addAccount.setString(1,type.name());
		addAccount.setDouble(2, balance);
		addAccount.executeUpdate();
		ResultSet Ars=addAccount.getGeneratedKeys();
		if(Ars.next()) {
			accountId=Ars.getInt(1);
		}
		if(userId>0 && accountId>0) {
			String linkAccountsql="insert into mapping (userId,AccountId) values(?,?)";
			PreparedStatement linkAccount=connection.prepareStatement(linkAccountsql);
			linkAccount.setInt(1, userId);
			linkAccount.setInt(2, accountId);
			linkAccount.executeUpdate();
			connection.commit();
		}
		else {
			connection.rollback();
		}
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return accountId;
 }

 public Customer GetAccount(int accountId) {
     Customer customer = null;
     Connection connection = connect();
     try {
         try (PreparedStatement findUser = connection.prepareStatement(
                 "SELECT FirstName,LastName,SSN,Type,Balance "
                 + "FROM Users a JOIN Mappings b on a.ID = b.UserId "
                 + "JOIN Accounts c on b.AccountId = c.ID "
                 + "WHERE c.ID = ?")) {
             findUser.setInt(1, accountId);
             ResultSet findUserResults = findUser.executeQuery();
             if (findUserResults.next()) {
                 String firstName = findUserResults.getString("FirstName");
                 String lastName = findUserResults.getString("LastName");
                 String accountType = findUserResults.getString("Type");
                 Double balance = findUserResults.getDouble("Balance");
                 Account account;
                 if (accountType.equals(AccountType.checking.name())) {
                     account = new Checking(accountId, balance);
                 } else {
                     account = new Savings(accountId, balance);
                 }
                 customer = new Customer(firstName, lastName, account);
             }
         }
     } catch (SQLException ex) {
         System.err.println("An error has occured." + ex.getMessage());
     }
     return customer;
 }
 //Update (Edit Account)
 public boolean UpdateAccount(int accountId, Double newBalance){
     boolean success = false;
     Connection connection = connect();
     try {
         try (PreparedStatement updateBalance = connection.prepareStatement(
                 "UPDATE Accounts SET Balance = ? WHERE ID = ?")) {
             updateBalance.setDouble(1, newBalance);
             updateBalance.setInt(2, accountId);
             updateBalance.executeUpdate();
         }
         success = true;
     } catch (SQLException ex) {
         System.err.println("An error has occured." + ex.getMessage());
     }
     return success;
 }
 //Delete (Remove Account)
 public boolean DeleteAccount(int accountId) {
     boolean success = false;
     Connection connection = connect();
     try {
         try (PreparedStatement deleteRecords = connection.prepareStatement(
                 "DELETE Users,Accounts FROM Users "
                 + "JOIN Mappings on Users.ID = Mappings.UserId "
                 + "JOIN Accounts on Accounts.ID = Mappings.AccountId "
                 + "WHERE Accounts.ID = ?")) {
             deleteRecords.setInt(1, accountId);
             deleteRecords.executeUpdate();
         }
         success = true;
     } catch (SQLException ex) {
         System.err.println("An error has occured." + ex.getMessage());
     }
     return success;
 }

 public ArrayList<Customer> GetAllAccounts() {
     ArrayList<Customer> customers = new ArrayList<Customer>();
     Connection connection = connect();
     try {
         try (PreparedStatement findUser = connection.prepareStatement(
                 "SELECT AccountId,FirstName,LastName,SSN,Type,Balance "
                 + "FROM Users a JOIN Mappings b on a.ID = b.UserId "
                 + "JOIN Accounts c on b.AccountId = c.ID")) {
             ResultSet findUserResults = findUser.executeQuery();
             while (findUserResults.next()) {
                 String firstName = findUserResults.getString("FirstName");
                 String lastName = findUserResults.getString("LastName");
                 String ssn = findUserResults.getString("SSN");
                 String accountType = findUserResults.getString("Type");
                 Double balance = findUserResults.getDouble("Balance");
                 int accountId = findUserResults.getInt("AccountId");
                 Account account;
                 if (accountType.equals(AccountType.checking.name())) {
                     account = new Checking(accountId, balance);
                 } else {
                     account = new Savings(accountId, balance);
                 }
                 Customer customer = new Customer(firstName, lastName, account);
                 customers.add(customer);
             }
         }
     } catch (SQLException ex) {
         System.err.println("An error has occured." + ex.getMessage());
     }
     return customers;
 }
}