package coursework.Controller;

import coursework.Entity.Passenger;

import java.util.ArrayList;

public interface StaffUtils {
    public ArrayList<Passenger> filterByKeyword(ArrayList<Passenger> passengers, String key);
    public ArrayList<Passenger> filterByKeyword(ArrayList<Passenger> passengers, String key1, String key2);
    public ArrayList<Passenger> filterByStatus(ArrayList<Passenger> passengers, boolean status);
    public ArrayList<Passenger> getAllPassenger();
}
