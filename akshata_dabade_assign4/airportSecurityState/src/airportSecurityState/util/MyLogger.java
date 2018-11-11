package airportSecurityState.src.airportSecurityState.util;
public class MyLogger {
    // FIXME: Add more enum values as needed for the assignment
    public static enum DebugLevel { CURRENT_STATE, STATE_CHANGE_INCREASE, STATE_CHANGE_DECREASE ,NONE, PROHIBITED_ITEM_DETECTED, PRINT_TO_FILE
    }

    private static DebugLevel debugLevel;

    /**
     * This method is used to set the debug value by integer
     * void This returns nothing.
     */
    public static void setDebugValue (int levelIn) {
        switch (levelIn)
        {
            case 4: debugLevel = DebugLevel.CURRENT_STATE; break;
            case 3: debugLevel = DebugLevel.PROHIBITED_ITEM_DETECTED; break;
            case 2: debugLevel = DebugLevel.STATE_CHANGE_INCREASE; break;
            case 1: debugLevel = DebugLevel.STATE_CHANGE_DECREASE; break;
            case 0: debugLevel = DebugLevel.PRINT_TO_FILE; break;
            default: debugLevel = DebugLevel.NONE; break;
        }
    }
    /**
     * This method is used to set debug value by enum
     * void This returns nothing.
     */
    public static void setDebugValue (DebugLevel levelIn)
    {
        debugLevel = levelIn;
    }
    /**
     * This method is used to write a given message on the std out
     * void This returns nothing.
     */
    public static void writeMessage (String message ,DebugLevel levelIn) {
        if (levelIn == debugLevel)
            System.out.println(message);
    }
    /**
     * This method is used to display the current debug level
     * String This returns a string of debug level
     */
    public String toString()
    {
        return "The debug level has been set to the following " + debugLevel;
    }
}