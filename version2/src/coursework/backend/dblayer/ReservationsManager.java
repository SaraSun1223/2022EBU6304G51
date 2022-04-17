package coursework.backend.dblayer;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import coursework.backend.model.Passenger;
import coursework.backend.model.Reservations;

public class ReservationsManager {
    public static Reservations getReservationByBookingNum(String bookingNum) throws IOException {
        ArrayList<Reservations> reservations = DataManager.getInstance().reservations;
        for (Reservations reservations1 : reservations) {
            if (reservations1.bookingNum.equals(bookingNum)) {
                return reservations1;
            }
        }
        return null;
    }

    public static  ArrayList<Reservations> getReservationByID(String id) throws IOException {
        ArrayList<Reservations> reservations = DataManager.getInstance().reservations;
        ArrayList<Reservations> reservationsCollection = new ArrayList<>();
        for (Reservations reservations1 : reservations) {
            if (reservations1.IDNum.equals(id)) {
                reservationsCollection.add(reservations1);
            }
        }
        return reservationsCollection;
    }
    public static  Reservations getSingleReservationByID(String id) throws IOException {
        ArrayList<Reservations> reservations = DataManager.getInstance().reservations;
        for (Reservations reservations1 : reservations) {
            if (reservations1.IDNum.equals(id)) {
                return reservations1;
            }
        }
        return null;
    }
    /**
     * write (add and modify) reservation information into file
     * @param reservation
     * @throws IOException
     */
    public static void writeReservationsInfo(Reservations reservation) throws IOException {
        ArrayList<Reservations> reservations = DataManager.getInstance().reservations;
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).bookingNum.equals(reservation.bookingNum)) {
                reservations.remove(i);
                reservations.add(reservation);
                DataManager.getInstance().commit();
                return;
            }
        }
        reservations.add(reservation);
        DataManager.getInstance().commit();
    }
}
