package airportSecurityState.src.airportSecurityState.airportStates;

import airportSecurityState.src.airportSecurityState.driver.Driver;
import airportSecurityState.src.airportSecurityState.util.FileDisplayInterface;
import airportSecurityState.src.airportSecurityState.util.MyLogger;

import java.io.IOException;

import static airportSecurityState.src.airportSecurityState.util.MyLogger.DebugLevel.CURRENT_STATE;

public class AirportSecurity implements AirportContextI {
    private AirportStateI currentState;

    public AirportSecurity(AirportStateI state) throws IOException {
        currentState = state;
    }
    @Override
    public void setState(AirportStateI state, Days days, FileDisplayInterface fdOut) throws IOException {
        currentState = state;
        MyLogger.writeMessage("Current state is  : "+ currentState.toStateName(),CURRENT_STATE);
        fdOut.writeToFile(currentState.toString());
        currentState.increaseOrDecreaseSecurity(this, days);
    }
    public AirportStateI getState()
    {
        return currentState;
    }
}
