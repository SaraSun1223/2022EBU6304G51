package coursework.backend.dblayer;


import coursework.Controller.SeatController;
import coursework.backend.model.Seat;

import java.io.IOException;
import java.util.ArrayList;


public class SeatManager {

    public static Seat getStatusBySeat(String seat) throws IOException {
        DataManager.getInstance().updateDataManager();
        ArrayList<Seat> seats = DataManager.getInstance().seats;
        for (Seat s : seats) {
            if (s.seat.equals(seat)) {
                return s;
            }
        }
        return null;
    }

    public static Seat getSeatByStatus(boolean status) throws IOException {
        DataManager.getInstance().updateDataManager();
        ArrayList<Seat> seats = DataManager.getInstance().seats;
        for (Seat s : seats) {
            if (s.status==status) {
                return s;
            }
        }
        return null;
    }
    public static Seat getPriceBySeat(String seat) throws IOException {
        DataManager.getInstance().updateDataManager();
        ArrayList<Seat> seats = DataManager.getInstance().seats;
        for (Seat s : seats) {
            if (s.seat.equals(seat)) {
                return s;
            }
        }
        return null;
    }

    public static void writeSeatInfo(Seat seat) throws IOException {
        ArrayList<Seat> seats = DataManager.getInstance().seats;
        for (int i = 0; i < seats.size(); i++) {
            if (seats.get(i).seat.equals(seat.seat)) {
                seats.remove(i);
                seats.add(seat);
                DataManager.getInstance().commit();
                return;
            }
        }
    }
}