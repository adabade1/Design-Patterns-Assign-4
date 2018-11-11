package airportSecurityState.src.airportSecurityState.airportStates;

import airportSecurityState.src.airportSecurityState.util.FileProcessor;

import java.io.IOException;
import java.util.ArrayList;

public class Days {
    private String line;
    private int totalProhibitedItems = 0;
    private FileProcessor fp;
    private int days = 0;
    private int travellers = 0;
    private String day;
    private String item;
    private int flag = 0;
    public ArrayList<String> numberOfDays = new ArrayList<String>();


    public Days(FileProcessor fpIn) {
        fp = fpIn;
    }

    public ArrayList<String> retrieveInformation() throws IOException {

        if ((line = fp.accessFile()) != null) {
            ArrayList<String> lineData = new ArrayList<String>();
            flag = 1;
            travellers++;
            try
            {
                day = line.split(";")[0].split(":")[1];
                item = line.split(";")[1].split(":")[1];
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.err.println("Incorrect File");
            }
            if(item.equals(null)) {
                System.err.println("Incorrect File");
            }
            if (!numberOfDays.contains(day)) {
                numberOfDays.add(day);
            }

                if(item.equalsIgnoreCase("plants") || item.equalsIgnoreCase("grains") || item.equalsIgnoreCase("nailcutters")
                        ||item.equalsIgnoreCase("endangeredanimals"))
                    totalProhibitedItems++;
            lineData.add(String.valueOf(numberOfDays.size()));
            lineData.add(String.valueOf(travellers));
            lineData.add(String.valueOf(totalProhibitedItems));
            return lineData;
        }
        return null;
    }
}
