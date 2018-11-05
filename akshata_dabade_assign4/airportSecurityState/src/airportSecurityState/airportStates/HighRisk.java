package airportSecurityState.src.airportSecurityState.airportStates;

import airportSecurityState.src.airportSecurityState.util.FileProcessor;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.System.exit;

public class HighRisk implements AirportStateI
{
    public int avgTrafficPerDay;
    public int avgProhibitedItemsPerDay;
    public int totalProhibitedItems;
    FileProcessor fp;
    public String line;
    public int numOfDays;
    public int travellers;
    public String item;
    public Days days = new Days(fp);
    public ArrayList<String> lineData = new ArrayList<String>();
    public HighRisk(FileProcessor fpIn)
    {
        fp = fpIn;
    }
    @Override
    public void increaseOrDecreaseSecurity(AirportContextI context, Days days) throws IOException {

        LowRisk low = new LowRisk(fp);
        ModerateRisk mod = new ModerateRisk(fp);
        lineData = days.retrieveInformation();
        if(lineData != null)
        {
            numOfDays = Integer.parseInt(lineData.get(0));
            travellers = Integer.parseInt(lineData.get(1));
            totalProhibitedItems = Integer.parseInt(lineData.get(2));
        }

        else if(lineData == null)
            exit(0);
//        System.out.println("no of prohibited items:" + totalProhibitedItems);
//        System.out.println("Line in high :" + lineData);
        if(numOfDays==(-1) || travellers==(-1))
            exit(0);
            avgTrafficPerDay = getAvgTrafficPerDay(travellers, numOfDays);
        avgProhibitedItemsPerDay = setAvgProhibitedItemsPerDay(totalProhibitedItems,numOfDays);
       // System.out.println("numdays: "+numOfDays +" travellers:" + travellers + " total prohibited item :" + totalProhibitedItems + "avgtraffic: "+ avgTrafficPerDay +"avgprohibited" +avgProhibitedItemsPerDay);

        if(avgTrafficPerDay >= 8 || avgProhibitedItemsPerDay >= 4)
        context.setState(this, days);

        else if ((4 <= avgTrafficPerDay && 8 > avgTrafficPerDay) || (2 <= avgProhibitedItemsPerDay && avgProhibitedItemsPerDay < 4))
            context.setState(mod, days);


          else if ((0 <= avgTrafficPerDay && 4 > avgTrafficPerDay) || (0 <= avgProhibitedItemsPerDay && avgProhibitedItemsPerDay < 2))
                context.setState(low, days);


    }
    public int setAvgProhibitedItemsPerDay(int totalProhibitedItems, int totalNumberOfDays)
    {
        return (totalProhibitedItems/totalNumberOfDays);
    }
    public int getAvgTrafficPerDay(int totalNumberOfTravellers, int totalNumberOfDays)
    {
        return(totalNumberOfTravellers/totalNumberOfDays);
    }
    public int getAvgProhibitedItemsPerDay()
    {
        return 0;
    }
    public String toString(){
        return "[2,4,6,8,10]";
    }
}
