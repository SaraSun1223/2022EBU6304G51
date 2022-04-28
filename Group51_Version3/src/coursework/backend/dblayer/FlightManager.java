package coursework.backend.dblayer;
import coursework.backend.model.Flight;//output model flight
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class FlightManager {
    /**
     * get a MUTABLE reference of Flight specified by FlightNum
     * @param FlightNum
     * @return reference of that session
     * @throws IOException
     */
    public static Flight getFlightByFlightNum(String FlightNum) throws IOException {
        ArrayList<Flight> flights = DataManager.getInstance().flights;
        for (Flight flight : flights) {
            if (flight.FlightNum.equals(FlightNum)) {
                return flight;
            }
        }
        return null;
    }


}
