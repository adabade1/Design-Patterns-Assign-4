package airportSecurityState.src.airportSecurityState.airportStates;

import airportSecurityState.src.airportSecurityState.util.FileDisplayInterface;

import java.io.IOException;

public interface AirportContextI
{
    void setState(AirportStateI state, Days days, FileDisplayInterface fdOut) throws IOException;
    AirportStateI getState();
}