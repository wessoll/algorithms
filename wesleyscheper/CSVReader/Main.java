package CSVReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Reads a CVS file from your local harddisk
 * 
 * @author wesley
 */
public class Main {

	/**
	 * Starting point
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException{
		InputStream inputStream = new FileInputStream("C:\\Users\\wesley\\Desktop\\example.csv"); // csv location
        String line = "";
        String delimiter = ";";
        
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        while ((line = br.readLine()) != null) { // iterate over every row from the csv file
        	String[] value_line = line.split(delimiter);
        	
        	// do stuff
        	System.out.println("column 1: " + value_line[0]); // print first column
        	System.out.println("column 1: " + value_line[1]); // print second column
        }
	}
}