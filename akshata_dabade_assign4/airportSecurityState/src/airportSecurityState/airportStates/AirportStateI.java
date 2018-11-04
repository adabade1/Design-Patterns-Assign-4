package airportSecurityState.src.airportSecurityState.airportStates;

import java.io.IOException;

public interface AirportStateI
{
    public void increaseOrDecreaseSecurity(AirportContextI context, Days days) throws IOException;
}
