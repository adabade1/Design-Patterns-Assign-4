package airportSecurityState.src.airportSecurityState.airportStates;

public class AirportSecurity implements AirportContextI {
    private AirportStateI currentState;
    public AirportStateI LowRisk = new LowRisk();
    public AirportStateI ModerateRisk = new ModerateRisk();
    public AirportStateI HighRisk = new HighRisk();


    public AirportSecurity()
    {
        
    }
    @Override
    public void setState(AirportStateI state)
    {
        currentState = state;
    }
}
