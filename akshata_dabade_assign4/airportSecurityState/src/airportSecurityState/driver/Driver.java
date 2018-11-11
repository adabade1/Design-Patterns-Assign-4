package airportSecurityState.src.airportSecurityState.driver;
import airportSecurityState.src.airportSecurityState.airportStates.*;
import airportSecurityState.src.airportSecurityState.util.FileDisplayInterface;
import airportSecurityState.src.airportSecurityState.util.FileProcessor;
import airportSecurityState.src.airportSecurityState.util.MyLogger;
import airportSecurityState.src.airportSecurityState.util.Results;
import java.io.File;

public class Driver
{
    public static void main(String args[]) throws Exception {

        if (args.length != 3 || (args[0].equals("${arg0}")) || (args[1].equals("${arg1}")) || (args[2].equals("${arg2}"))) {
            System.out.println("Error: Incorrect number of arguments. Program accepts 3 arguments. Input File, Output File and Debug Value.");
            System.exit(0);
        }

        File inputFile = new File(args[0]);
        if(!inputFile.exists())
        {
            System.err.println("Input file does not exist.");
            System.exit(0);
        }
        File outputFile = new File(args[1]);
        if(outputFile.exists()) {
            if (outputFile.length() != 0) {
                System.err.println("Output file should be empty.");
                System.exit(0);
            }
        }
        int debugValue=0;
        try
        {
            debugValue = Integer.parseInt(args[2]);
            if(debugValue < 0 || debugValue > 4) {
                System.err.println("Debug value should be an integer value between 0 and 4 inclusive.");
                System.exit(0);
            }

        }
        catch(NumberFormatException e)
        {
            System.err.println("Debug value should be an integer value between 0 and 4 inclusive");
            System.exit(0);
        }
        FileProcessor fp = new FileProcessor(args[0]);
        FileDisplayInterface fd = new Results(args[1]);
        MyLogger.setDebugValue(debugValue);
        AirportStateI low = new LowRisk(fp,fd);
        Days days = new Days(fp);
        AirportContextI context = new AirportSecurity(low);
        low.increaseOrDecreaseSecurity(context, days);
    }
}
