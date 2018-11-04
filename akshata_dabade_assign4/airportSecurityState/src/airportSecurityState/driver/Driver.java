package airportSecurityState.src.airportSecurityState.driver;

import airportSecurityState.src.airportSecurityState.airportStates.AirportContextI;
import airportSecurityState.src.airportSecurityState.airportStates.AirportSecurity;
import airportSecurityState.src.airportSecurityState.airportStates.Days;
import airportSecurityState.src.airportSecurityState.airportStates.LowRisk;
import airportSecurityState.src.airportSecurityState.util.FileProcessor;
public class Driver
{
    public static void main(String args[]) throws Exception {
        FileProcessor fp = new FileProcessor("C:\\Users\\Akshata\\Desktop\\in.txt");
        AirportContextI context = new AirportSecurity(new LowRisk(fp));
        LowRisk low = new LowRisk(fp);
        Days days = new Days(fp);

//        System.out.println(days.setDays());
//        System.out.println(days.getTravellers());
        low.increaseOrDecreaseSecurity(context, days);
        System.out.println(context.getState().toString());
    }
}
