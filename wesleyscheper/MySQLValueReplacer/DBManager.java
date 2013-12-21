package MySQLValueReplacer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Manages the connection with the database (mysql only)
 * @author wesley
 */
public class DBManager {
	
	private Connection con;
	
	/**
	 * Constructor for setting up the connection with the database
	 * @param dbHost			ip address where the db is located
	 * @param dbUsername		mysql username
	 * @param dbPassword		mysql password
	 * @param dbName			name of the database
	 */
	public DBManager(String dbHost, String dbUsername, String dbPassword, String dbName){
		String connectionURL = "", dbDriver = "";
		
		connectionURL = "jdbc:mysql://" + dbHost + "/" + dbName;
		dbDriver = "com.mysql.jdbc.Driver";

		try{
			con = DriverManager.getConnection(connectionURL, dbUsername, dbPassword);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Perform execution on database
	 * @param query				query to be executed
	 * @throws Exception
	 */
	 public void executeQuery(String query){
		try{
			Statement st = con.createStatement();
			st.execute(query);
		}
		catch(Exception e){
			System.err.println("SQL error on executing query: \"" + query + "\"");
		}	
	}
		
	/**
	 * Get list with String values for a given query
	 * @param query				query to return results from
	 * @return					list with result
	 * @throws Exception
	 */
	public ArrayList<String> getStringValues(String query){
		ArrayList<String> values = new ArrayList<String>();

		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
		
			while (rs.next()){
				values.add(rs.getString(1));
			}	
			
			return values;
		}
		catch(Exception e){
			System.err.println("SQL error on getting value(s) for query: \"" + query + "\"");
		}
		return null;
	}
}