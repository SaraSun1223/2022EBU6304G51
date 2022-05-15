package coursework.backend.dblayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import coursework.backend.model.Passenger;


public class PassengerManager {

    public static void confirmCheckin(String bookingNum) throws IOException{
        Passenger passenger = getPassengerById(bookingNum);
        passenger.status=true;
        DataManager.getInstance().commit();
    }

    public static void confirmCheckin(String surname, String IdNumber) throws IOException{
        Passenger passenger = getPassengerById(surname, IdNumber);
        passenger.status=true;
        DataManager.getInstance().commit();
    }

    public static Passenger getPassengerById(String bookingNum) throws IOException {
        ArrayList<Passenger> passengers = DataManager.getInstance().passengers;
        for (Passenger passenger : passengers) {
            if (passenger.bookingNumber.equals(bookingNum)) {
                return passenger;
            }
        }
        return null;
    }

    public static Passenger getPassengerById(String surname, String IdNumber) throws IOException {
        ArrayList<Passenger> passengers = DataManager.getInstance().passengers;
        for (Passenger passenger : passengers) {
            if (passenger.surname.equals(surname)&&passenger.idNumber.equals(IdNumber)) {
                return passenger;
            }
        }
        return null;
    }

    /**
     * write (add and modify) passenger information into file
     * @param passenger
     * @throws IOException
     */
    public static void writePassengerInfo(Passenger passenger) throws IOException {
        ArrayList<Passenger> passengers = DataManager.getInstance().passengers;
        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).bookingNumber.equals(passenger.bookingNumber)) {
                passengers.remove(i);
                passengers.add(passenger);
                DataManager.getInstance().commit();
                return;
            }
        }
        passengers.add(passenger);
        DataManager.getInstance().commit();
    }

}
