
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {

	public static void main(String[] args) {

		final String url = "jdbc:mysql://helios.hud.ac.uk:3306/gary";
		Connection con = null;

		System.out.println("Opening Connection...");
		try {
			Class.forName ("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "gary", "garypa55");
		} catch (SQLException c) {
			System.err.println ("Failed to Make Connection!");
			System.exit(1);
		} 
		catch (ClassNotFoundException e) {
			System.err.println ("Failed to Register Driver!");
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
