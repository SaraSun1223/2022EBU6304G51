package coursework.Controller;

import coursework.Entity.*;
import coursework.backend.dblayer.DataManager;
import coursework.backend.dblayer.PassengerManager;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @Version 2
 * @author Junyue Li
 */

public interface PassengerUtils {
    public Passenger getPassengerInform(String bookingNo);
    public Passenger getPassengerInform(String surname, String idNo);
    public void confirmCheckin(String bookingNo);
    public void confirmCheckin(String surname, String idNo);
    public Flight getFlightInform(String bookingNo);

    public ArrayList<Reservations> getReservationsInform(String ID);
    public Reservations getReservationsInformByID(String ID);
    public Reservations getReservationsInfbyBookingnum(String bookingNo);
    public ArrayList<String> getFlightInform(String surname, String idNo);
    public ArrayList<String> getOptions(String bookingNo);
    public ArrayList<String> getOptions(String surname, String idNo);

}

