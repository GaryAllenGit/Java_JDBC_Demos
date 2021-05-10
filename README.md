A simple Java JDBC/MySQL and SQLite demo.

Dr Gary Allen, the University of Huddersfield.

UPDATED 10/5/2021:  Added latest version of the mySQL driver, and removed the code that registers the driver as this is now done automatically so the code was depricated.

NOTE - These demos assume that you have an account on the MySQL server 'selene.hud.ac.uk".  Also, I have obviously removed my actual username and passwork from the files before distributing this code, so you will need to enter your own user credentials.


There are three versions of this demo:
One using MySQL with the user credentials hard coded.
One using MySQL with the user credentials in a properties file.
One using SQLite

Each demo has three programs in it:
TestConnection, which simply opens and closes a connection to a database, to make sure the driver is loading and the connection works.
CreateDB, which creates a table and writes some test data into it.
QueryDB, which reads the test data from the table.

The first two demos require a suitable JDBC My SQL driver, while the latter requires a SQLite driver.  The two jar files:
mysql-connector-java-5.1.18-bin.jar, and
sqlite-jdbc-3.23.1.jar
are included in the Drivers folder, and need to be added as Libraries in the Project Structure.
