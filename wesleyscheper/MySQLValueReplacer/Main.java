package MySQLValueReplacer;
import java.util.List;


/**
 * Goes over every value in the database to see if it matches a value. If so, replaces it by another value. Can also be used for search only.
 * @author wesley
 */
public class Main {

	/**
	 * Starting point
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		replaceValue("exampl", "example");
	}
	
	/**
	 * Replaces all values in the database that matches @param value
	 * @param value					varchar value to be replaced (case sensitive)
	 * @param replaceValue			new varchar value for @value
	 */
	public static void replaceValue(String value, String replaceValue){
		DBManager dbManager = new DBManager("ipaddress:port", "root", "root", "database_name"); // database connection
		
		List<String> tables = dbManager.getStringValues("SHOW TABLES");
			
		for (String table : tables){ // go along every table
			List<String> columns = dbManager.getStringValues("SHOW COLUMNS FROM " + table);
			
			for (String column : columns){ // go along every column in the table
				List<String> rows = dbManager.getStringValues("SELECT " + column + " FROM " + table + " WHERE BINARY " + column + " = '" + value + "'");

				for (String rowValue : rows){ // go along every value in the row
					if (!rowValue.equals("0")){
						System.out.print("Table: " + table + " | Column: " + column + " | Found: " + rowValue + "  ==  ");
						
						// replace value
						dbManager.executeQuery("UPDATE " + table + " SET " + column + " = '" + replaceValue + "' WHERE BINARY " + column + " = '" + value + "'");
						System.out.println("VALUE: " + value + " REPLACED BY: " + replaceValue);
					}
				}
			}
		}
	}
}