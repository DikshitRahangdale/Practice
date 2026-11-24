package mySQL;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterClass;

public class firstMySQL {
	Connection connection;
	Statement statement;
	ResultSet resultSet;

	@Test
	public void f() throws SQLException {
		statement = connection.createStatement();
		resultSet = statement.executeQuery("select * from employees");
		while (resultSet.next()) {
			System.out.println(resultSet.getString("first_name"));
		}
	}

	@BeforeClass
	public void beforeClass() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/companyinfo", "root", "Dikshit");
	}

	@AfterClass
	public void afterClass() throws SQLException {
		connection.close();
	}

}
