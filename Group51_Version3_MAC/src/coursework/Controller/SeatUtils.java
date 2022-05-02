package coursework.Controller;

import coursework.Entity.Seat;

public interface SeatUtils {
    public Seat getSeatByStatus(boolean status);
    public Seat getStatusBySeat(String seat);
}
