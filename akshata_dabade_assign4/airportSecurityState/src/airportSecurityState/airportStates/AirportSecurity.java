package airportSecurityState.src.airportSecurityState.airportStates;

import airportSecurityState.src.airportSecurityState.util.FileDisplayInterface;

import java.io.IOException;

public class AirportSecurity implements AirportContextI {
    private AirportStateI currentState;

    public AirportSecurity(AirportStateI state) throws IOException {
        currentState = state;
    }
    @Override
    public void setState(AirportStateI state, Days days, FileDisplayInterface fdOut) throws IOException {
        currentState = state;
        fdOut.WriteToFile(currentState.toString());
        currentState.increaseOrDecreaseSecurity(this, days);
    }
    public AirportStateI getState()
    {
        return currentState;
    }
}
