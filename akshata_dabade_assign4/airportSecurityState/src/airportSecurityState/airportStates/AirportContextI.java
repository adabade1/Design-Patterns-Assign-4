package airportSecurityState.src.airportSecurityState.airportStates;

import java.io.IOException;

public interface AirportContextI
{
    void setState(AirportStateI state, Days days) throws IOException;
    AirportStateI getState();
}