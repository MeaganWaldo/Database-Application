//
// Project Phase 2
// Creator: Meagan Waldo
// Last Updated: 05/07/21
// Course: 2021 Spring-CS-482-M70-DATABASE MGT SYS I
// Purpose: The purpose of this code is to contain methods to connect to the database and insert code
// that will modify the data.
//


package Driver;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Driver {


	//
	// This code is to perform single insertion when given a file.
	// Parameters: Two strings that contains the data to be inserted. 
	// The one called table contains the name of the table to have data
	// inserted into while the one called line contains the data that is
	// to be inserted into the table.
	// Returns: Nothing.
	//
	public static void insert1(String line, String table) {

		Connection myConn = null;

		// Try to connect to the database.
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phase1","root", "nmsumnw");
		} // end of try
		catch (SQLException e) {
			application2.lblNewLabel.setText("Error: " + e.getMessage());
			e.printStackTrace();
		} // end of catch

		Statement myStmt = null;

		// Try to create a statement that will be sent to MySQL database.
		try {
			myStmt = myConn.createStatement();
		} // end of try 
		catch (SQLException e) {
			application2.lblNewLabel.setText("Error: " + e.getMessage());
			e.printStackTrace();
		} // end of catch

		// Try to execute the statement being sent to the MySQL database.
		try {
			myStmt.executeUpdate("insert into "+ table +" values (" + line +");");	
		} // end of try
		catch (SQLException e) {
			application2.lblNewLabel.setText("Error: " + e.getMessage());
			e.printStackTrace();
		} // end of catch
	} // end of insert1


	//
	// This code is to perform bulk insertion when given a file.
	// Parameters: Two strings that contains the data to be inserted. 
	// The one called table contains the name of the table to have data
	// inserted into while the one called line contains the data that is
	// to be inserted into the table.
	// Returns: Nothing.
	//
	public static void insert2(String line, String table) {

		Connection myConn = null;

		// Try to connect to the database.
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phase1","root", "nmsumnw");
		} // end of try
		catch (SQLException e) {
			application3.lblNewLabel.setText("Error: " + e.getMessage());
			e.printStackTrace();
		} // end of catch

		Statement myStmt = null;

		// Try to create a statement that will be sent to MySQL database.
		try {
			myStmt = myConn.createStatement();
		} // end of try
		catch (SQLException e) {
			application3.lblNewLabel.setText("Error: " + e.getMessage());
			e.printStackTrace();
		} // end of catch

		// Try to execute the statement being sent to the MySQL database.
		try {
			myStmt.executeUpdate("LOAD DATA INFILE '" + line +"' INTO TABLE "+ table +" FIELDS TERMINATED BY ', ' OPTIONALLY ENCLOSED BY '''' LINES TERMINATED BY '\\n'");
		} // end of try
		catch (SQLException e) {
			application3.lblNewLabel.setText("Error: " + e.getMessage());
			e.printStackTrace();
		} // end of catch
	} // end of insert2


	//
	// This code is to delete all data from a table when given a table name.
	// Parameters: One string that contains the data to be inserted. 
	// The sting called line contains the name of the table to have data
	// deleted from.
	// Returns: Nothing.
	//
	public static void delete(String line) {

		Connection myConn = null;

		// Try to connect to the database.
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phase1","root", "nmsumnw");
		} // end of try
		catch (SQLException e) {
			application4.lblNewLabel.setText("Error: " + e.getMessage());
			e.printStackTrace();
		} // end of catch

		Statement myStmt = null;

		// Try to create a statement that will be sent to MySQL database.
		try {
			myStmt = myConn.createStatement();
		} // end of try
		catch (SQLException e) {
			application4.lblNewLabel.setText("Error: " + e.getMessage());
			e.printStackTrace();
		} // end of catch

		// Try to execute the statement being sent to the MySQL database.
		try {
			myStmt.executeUpdate("DELETE FROM " + line + ";");
		} // end of try
		catch (SQLException e) {
			application4.lblNewLabel.setText("Error: " + e.getMessage());
			e.printStackTrace();
		} // end of catch
	} // end of delete


	//
	// This code is used to get the table for a user inputed query.
	// Parameters: One string called SQL that contains the SQL query.
	// Returns: ResultSet of the query.
	//
	public static ResultSet query(String SQL) {

		ResultSet answer = null;
		Connection myConn = null;

		// Try to connect to the database.
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phase1","root", "nmsumnw");
		} // end of try
		catch (SQLException e) {
			application5.lblNewLabel.setText("Error: " + e.getMessage());
			e.printStackTrace();
		} // end of catch

		Statement myStmt = null;

		// Try to create a statement that will be sent to MySQL database.
		try {
			myStmt = myConn.createStatement();
		} // end of try
		catch (SQLException e) {
			application5.lblNewLabel.setText("Error: " + e.getMessage());
			e.printStackTrace();
		} // end of catch

		// Try to execute the statement being sent to the MySQL database.
		try {
			answer = myStmt.executeQuery(SQL);
		} // end of try
		catch (SQLException e) {
			application5.lblNewLabel.setText("Error: " + e.getMessage());
			e.printStackTrace();
		} // end of catch

		return answer;
	} // end of query
} // end of Driver