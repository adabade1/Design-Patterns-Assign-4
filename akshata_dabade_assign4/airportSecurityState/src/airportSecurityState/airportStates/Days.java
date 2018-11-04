package airportSecurityState.src.airportSecurityState.airportStates;

import airportSecurityState.src.airportSecurityState.util.FileProcessor;

import java.io.IOException;
import java.util.ArrayList;

public class Days {
    public String line;
    public int totalProhibitedItems = 0;
    public FileProcessor fp;
    public int days = 0;
    public int travellers = 0;
    public String day;
    public String item;
    public int flag = 0;
    public ArrayList<Integer> numberOfDays = new ArrayList<Integer>();


    public Days(FileProcessor fpIn) {
        fp = fpIn;
    }

    public ArrayList<String> retrieveInformation() throws IOException {

        if ((line = fp.Access_File()) != null) {
            ArrayList<String> lineData = new ArrayList<String>();
            flag = 1;
            travellers++;
            day = line.split(";")[0].split(":")[1];
            item = line.split(";")[1].split(":")[1];
            if (!numberOfDays.contains(days)) {
                numberOfDays.add(days);
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
