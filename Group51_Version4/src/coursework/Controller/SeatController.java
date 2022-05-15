package coursework.Controller;

import coursework.Entity.*;//output Entity Classes
import coursework.backend.dblayer.SeatManager;
import java.util.ArrayList;
import java.util.Objects;

public class SeatController implements SeatUtils{
    private static SeatController seatController = new SeatController();

    private SeatController() {
    }

    ;

    public static SeatController getController() {
        return seatController;
    }

    /**
     * @param seat The seat of passenger
     * @return The status
     */

    public Seat getStatusBySeat(String seat) {
        try {
            return Objects.requireNonNull(SeatManager.getStatusBySeat(seat)).converter();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param status The status of the seat
     * @return A list of seat
     */

    public Seat getSeatByStatus(boolean status) {
        try {
            return Objects.requireNonNull(SeatManager.getSeatByStatus(status)).converter();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @param seat The seat of passenger
     * @return The price
     */

    public Seat getPriceBySeat(String seat) {
        try {
            return Objects.requireNonNull(SeatManager.getPriceBySeat(seat)).converter();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Seat> filterByTrue(ArrayList<Seat> seat)
    {
        ArrayList<Seat> seats = new ArrayList<>();
//        if(status == null)
//            return passengers;
        for(Seat i : seat)
        {
            if(i.getStatus())
            {
                seats.add(i);
            }
        }
        return seats;
    }
    public void updateSeats(coursework.Entity.Seat seat){
        try {
            SeatManager.writeSeatInfo(seat.convert());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}