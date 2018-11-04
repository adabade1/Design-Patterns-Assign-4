package airportSecurityState.src.airportSecurityState.airportStates;
import airportSecurityState.src.airportSecurityState.util.FileProcessor;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.System.exit;

public class LowRisk implements AirportStateI
{
    public int avgTrafficPerDay;
    public int totalProhibitedItems = 0;
    public int avgProhibitedItemsPerDay;
    FileProcessor fp;
   public String line;
   public int numOfDays;
   public int travellers;
   public String item;

   public Days days = new Days(fp);
   public ArrayList<String> lineData = new ArrayList<String>();
   public LowRisk(FileProcessor fpIn)
    {
        fp = fpIn;

    }

    @Override
    public void increaseOrDecreaseSecurity(AirportContextI context, Days days) throws IOException {

        ModerateRisk mod = new ModerateRisk(fp);
        HighRisk high = new HighRisk(fp);
            lineData = days.retrieveInformation();
        if(lineData != null)
        {
            numOfDays = Integer.parseInt(lineData.get(0));
            travellers = Integer.parseInt(lineData.get(1));
            totalProhibitedItems = Integer.parseInt(lineData.get(2));
        }

        else if(lineData == null)
            exit(0);
        System.out.println("no of prohibited items:" + totalProhibitedItems);
            System.out.println("Line in Low :" + lineData);
            if(numOfDays==(-1) || travellers==(-1))
                exit(0);
            avgTrafficPerDay = getAvgTrafficPerDay(travellers, numOfDays);
            avgProhibitedItemsPerDay = setAvgProhibitedItemsPerDay(totalProhibitedItems,numOfDays);
            if (avgTrafficPerDay >= 8)
            context.setState(high, days);
            else if (4 <= avgTrafficPerDay && 8 > avgTrafficPerDay)
                context.setState(mod, days);

         else
             context.setState(this,days);


        }


    public void setAvgTrafficPerDay()
    {

    }
    public int getAvgTrafficPerDay(int totalNumberOfTravellers, int totalNumberOfDays)
    {
        return(totalNumberOfTravellers/totalNumberOfDays);
    }
    public int setAvgProhibitedItemsPerDay(int totalProhibitedItems, int totalNumberOfDays)
    {

        return (totalProhibitedItems/totalNumberOfDays);
    }
    public int getAvgProhibitedItemsPerDay()
    {
        return 0;
    }
    public String toString(){
        return "[1,3,5,7,9]";
    }
}
