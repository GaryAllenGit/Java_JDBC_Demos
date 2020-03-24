package mySQLDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {

		final String url = "jdbc:mysql://selene.hud.ac.uk:3306/gary";
		Connection con = null;

		System.out.println("Testing Connection...");

		try {
			Class.forName ("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "ABC", "ABC");
			System.out.println("Connection Established...");
		}
		catch (SQLException c) {
			System.err.println ("Failed to Make Connection!");
			System.exit(1);
		}
		catch (ClassNotFoundException e) {
			System.err.println ("Failed to Register Driver!");
			System.exit(1);
		}

		System.out.println ("Closing Connection...");
		try {
			con.close ();
		} catch (SQLException e) {
			System.err.println ("Failed to Close Connection!");
			System.exit(1);
		}
	}
}
