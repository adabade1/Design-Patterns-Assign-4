package airportSecurityState.src.airportSecurityState.airportStates;

import java.io.IOException;

public interface AirportStateI
{
    public void increaseOrDecreaseSecurity(AirportContextI context, Days days) throws IOException;
    public int getAvgProhibitedItemsPerDay(int totalProhibitedItems, int totalNumberOfDays);
    public int getAvgTrafficPerDay(int totalNumberOfTravellers, int totalNumberOfDays);
    public String toString();
    public String toStateName();
}
