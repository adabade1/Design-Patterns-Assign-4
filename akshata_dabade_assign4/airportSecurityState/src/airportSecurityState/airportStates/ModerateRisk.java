package airportSecurityState.src.airportSecurityState.airportStates;

import airportSecurityState.src.airportSecurityState.util.FileDisplayInterface;
import airportSecurityState.src.airportSecurityState.util.FileProcessor;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.System.exit;

public class ModerateRisk implements AirportStateI
{
    private int avgTrafficPerDay;
    private int avgProhibitedItemsPerDay;
    private int totalProhibitedItems = 0;
    private FileProcessor fp;
    private FileDisplayInterface fd;
    private String line;
    private int numOfDays;
    private int travellers;
    private String item;
    private Days days = new Days(fp);
    private ArrayList<String> lineData = new ArrayList<String>();
    public ModerateRisk(FileProcessor fpIn,FileDisplayInterface fdOut)
    {
        fp = fpIn;
        fd = fdOut;
    }
    @Override
    public void increaseOrDecreaseSecurity(AirportContextI context, Days days) throws IOException {
        AirportStateI low = new LowRisk(fp,fd);
        AirportStateI high = new HighRisk(fp,fd);
        lineData = days.retrieveInformation();
        if(lineData != null)
        {
            try {
                numOfDays = Integer.parseInt(lineData.get(0));
            }
            catch(NumberFormatException e)
            {
                System.err.println("Day number should be an integer value in the input file");
                System.exit(0);
            }
            travellers = Integer.parseInt(lineData.get(1));
            totalProhibitedItems = Integer.parseInt(lineData.get(2));
        }
        else if(lineData == null)
            exit(0);

        avgTrafficPerDay = getAvgTrafficPerDay(travellers, numOfDays);
        avgProhibitedItemsPerDay = getAvgProhibitedItemsPerDay(totalProhibitedItems,numOfDays);

        if (avgTrafficPerDay >= 8 || avgProhibitedItemsPerDay >= 4)
        {
            context.setState(high, days, fd);
        }

        else if((4 <= avgTrafficPerDay && 8 > avgTrafficPerDay) || (2 <= avgProhibitedItemsPerDay && avgProhibitedItemsPerDay < 4))
            context.setState(this, days, fd);

        else if((0 <= avgTrafficPerDay && 4 > avgTrafficPerDay) || (0 <= avgProhibitedItemsPerDay && avgProhibitedItemsPerDay < 2))
            context.setState(low, days, fd);

    }
    public int getAvgProhibitedItemsPerDay(int totalProhibitedItems, int totalNumberOfDays)
    {

        return (totalProhibitedItems/totalNumberOfDays);
    }
    public int getAvgTrafficPerDay(int totalNumberOfTravellers, int totalNumberOfDays)
    {
        return(totalNumberOfTravellers/totalNumberOfDays);
    }
    public String toString(){
        return "2 3 5 8 9";
    }
}
