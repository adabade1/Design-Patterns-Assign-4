package airportSecurityState.src.airportSecurityState.util;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class Results implements FileDisplayInterface {
    private String outputFile;
    public Results(String fpOut)
    {
        outputFile = fpOut;
    }
    /**
     * This method is used to write to the output files
     * void This returns nothing.
     */
    public void WriteToFile(String toprint) throws  IOException
    {
        PrintWriter writetofile;
        writetofile = new PrintWriter(new BufferedWriter(new FileWriter(outputFile, true)));
        writetofile.println(toprint);
        writetofile.close();
    }

}
