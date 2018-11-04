package airportSecurityState.src.airportSecurityState.airportStates;

import java.io.IOException;

public class AirportSecurity implements AirportContextI {
    private AirportStateI currentState;
//    public AirportStateI LowRisk = new LowRisk();
//    public AirportStateI ModerateRisk = new ModerateRisk();
//    public AirportStateI HighRisk = new HighRisk();


    public AirportSecurity(AirportStateI state) throws IOException {
        currentState = state;

    }
    @Override
    public void setState(AirportStateI state, Days days) throws IOException {
        currentState = state;
        //System.out.println(currentState.toString());
        currentState.increaseOrDecreaseSecurity(this, days);
    }
    public AirportStateI getState()
    {
        //System.out.println("Current state is "+ currentState.toString());
        return currentState;
    }
}
