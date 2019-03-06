import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestConnectionUsingPropertiesFile {
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
        System.out.println("Testing Connection...");

        try {
            Class.forName (driver);
            con = DriverManager.getConnection(url, username, password);
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

        System.out.println ("All Complete");
        System.exit(0);
    }
}

