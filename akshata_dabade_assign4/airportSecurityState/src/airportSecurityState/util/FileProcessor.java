package airportSecurityState.src.airportSecurityState.util;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor
{
	 private BufferedReader input;

	 public FileProcessor(String file) throws Exception
	 {
	   	File f = new File(file);
    	input = new BufferedReader(new FileReader(f));
	 }
	/**
	 * This method is used to read input file line
	 * by line.
	 * @return String This returns one line at a time.
	 */
	 public String Access_File() throws IOException {
		 	String line;
		 	while((line = input.readLine()) != null)
		 	{
		 		return line;
		 	}
			line = null;
			return line;
	 }


}
