package airportSecurityState.src.airportSecurityState.airportStates;
import airportSecurityState.src.airportSecurityState.util.FileDisplayInterface;
import airportSecurityState.src.airportSecurityState.util.FileProcessor;
import airportSecurityState.src.airportSecurityState.util.MyLogger;

import java.io.IOException;
import java.util.ArrayList;

import static airportSecurityState.src.airportSecurityState.util.MyLogger.DebugLevel.STATE_CHANGE_DECREASE;
import static airportSecurityState.src.airportSecurityState.util.MyLogger.DebugLevel.STATE_CHANGE_INCREASE;
import static java.lang.System.exit;

public class LowRisk implements AirportStateI
{
    private int avgTrafficPerDay;
    private int totalProhibitedItems = 0;
    private int avgProhibitedItemsPerDay;
    private FileProcessor fp;
    private FileDisplayInterface fd;
    private String line;
    private int numOfDays;
    private int travellers;
    private String item;
    private Days days = new Days(fp);
    private ArrayList<String> lineData = new ArrayList<String>();
    public LowRisk(FileProcessor fpIn, FileDisplayInterface fdOut)
    {
        fp = fpIn;
        fd = fdOut;
    }

    @Override
    public void increaseOrDecreaseSecurity(AirportContextI context, Days days) throws IOException
    {

        AirportStateI mod = new ModerateRisk(fp,fd);
        AirportStateI high = new HighRisk(fp,fd);
        lineData = days.retrieveInformation();
        if(lineData != null)
        {
                try {
                    numOfDays = Integer.parseInt(lineData.get(0));
                }
                catch(NumberFormatException e)
                {
                    System.err.println("Day should be an integer value in the input file. Check for day:" + lineData.get(0));
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
            MyLogger.writeMessage("State increased from low to high for traveller : "+travellers,STATE_CHANGE_INCREASE);
            context.setState(high, days, fd);
        }

        else if ((4 <= avgTrafficPerDay && 8 > avgTrafficPerDay) || (2 <= avgProhibitedItemsPerDay && avgProhibitedItemsPerDay < 4))
        {
            MyLogger.writeMessage("State increased from low to moderate for traveller : "+travellers,STATE_CHANGE_INCREASE);
            context.setState(mod, days, fd);
        }


        else
        {
//            MyLogger.writeMessage("State remained low",STATE_CHANGE_INCREASE);
//            MyLogger.writeMessage("State remained low",STATE_CHANGE_DECREASE);
            context.setState(this,days, fd);
        }

    }


    public int getAvgTrafficPerDay(int totalNumberOfTravellers, int totalNumberOfDays)
    {
        return(totalNumberOfTravellers/totalNumberOfDays);
    }

    public int getAvgProhibitedItemsPerDay(int totalProhibitedItems, int totalNumberOfDays)
    {

        return (totalProhibitedItems/totalNumberOfDays);
    }

    public String toString(){
        return "1 3 5 7 9";
    }
    public String toStateName(){
        return "LOW";
    }
}
