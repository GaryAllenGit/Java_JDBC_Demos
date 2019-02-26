A simple Java JDBC/MySQL demo.

Dr Gary Allen, the University of Huddersfield.

There are three programs here:
TestConnection simply opens and closes a connection to a MySQL database, to make sure the driver is loading and the connection works.

CreateDB creates a table and writes some test data into it.

QueryDB reads the test data from the table.

All the above require a suitable JDBC My SQL driver.  mysql-connector-java-5.1.18-bin.jar is included in the project home folder, and needs to be added as a Library in the Project Structure.

