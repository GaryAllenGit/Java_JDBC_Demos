package SQLiteDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {

	public static void main(String[] args) {

		final String url = "jdbc:sqlite:test_db.sqlite";

		Connection con = null;

		System.out.println("Opening Connection...");
		try {
			con = DriverManager.getConnection(url);
		}
		catch (SQLException c) {
			System.err.println ("Failed to Make Connection!");
			System.exit(1);
		}

		System.out.println("Creating Data...");
		try {
			Statement s = con.createStatement();
			s.executeUpdate ("drop table if exists firstnames");
			s.executeUpdate ("create table firstnames (name varchar (32))");
			s.executeUpdate ("insert into firstnames values ('tom')");
			s.executeUpdate ("insert into firstnames values ('dick')");
			s.executeUpdate ("insert into firstnames values ('harry')");
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.err.println ("Failed to Create Data!");
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
