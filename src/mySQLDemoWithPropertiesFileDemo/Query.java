package mySQLDemoWithPropertiesFileDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Query {

	public static void main(String[] args) {

		String username = "";
		String password = "";
		String url = "";
		String driver = "";

		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(new File("credentials.properties")));

			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
		} catch (IOException e) {
			System.err.println ("Failed to Load Properties!");
			System.exit(1);
		}

        Connection con = null;

		System.out.println("Opening Connection...");
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException c) {
			System.err.println ("Failed to Make Connection!");
			System.exit(1);
		}

		System.out.println("Querying Data...");
		try {
			Statement s = con.createStatement();

			s.executeQuery ("select name from firstnames");

			ResultSet rs = s.getResultSet ();

			while (rs.next ()) {
				System.out.println (rs.getString(1));
			}
		}
		catch (SQLException c) {
			System.err.println ("Failed to mySQLDemo.Query Data!");
			System.exit(1);
		}
		
		System.out.println("Closing Connection...");
		try {
			con.close ();
		} catch (SQLException e) {
			System.err.println ("Failed to Close Connection!");
			System.exit(1);
		}
	}
}
