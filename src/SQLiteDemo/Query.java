package SQLiteDemo;

import java.sql.*;

public class Query {

	public static void main(String[] args) {

		final String url = "jdbc:sqlite:test_db.sqlite";

		Connection con = null;

		System.out.println("Opening Connection...");
		try {
			con = DriverManager.getConnection(url);
		} catch (SQLException c) {
			System.err.println ("Failed to Make Connection!");
			System.exit(1);
		}

		System.out.println("Querying Data...");
		try {
			Statement s = con.createStatement();

			ResultSet rs = s.executeQuery ("select name from firstnames");

			while (rs.next()) {
				System.out.println (rs.getString(1));
			}
		}
		catch (SQLException c) {
			System.err.println ("Failed to Query Data!");
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
