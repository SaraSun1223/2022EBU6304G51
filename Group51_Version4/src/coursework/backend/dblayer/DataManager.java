package coursework.backend.dblayer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import coursework.backend.model.*;

public class DataManager {
    private static DataManager instance = null;


    /**
     * get the unique instance of DataManager
     * @return reference of DataManager object
     * @throws IOException
     */
    public static DataManager getInstance() throws IOException {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public ArrayList<Passenger>    passengers;
    public ArrayList<Reservations>    reservations;
    public ArrayList<Flight> flights;
    public ArrayList<Staff>  staffs;
    public ArrayList<Menu> meals;
    public ArrayList<Seat> seats;
    /**
     * DataManager constructor
     * @throws IOException
     */
    private DataManager() throws IOException {

        /**
         * Read information which are stored in JSON files.
         */
        passengers = (ArrayList<Passenger>) JSON.parseArray(IO.read("passenger.json"), Passenger.class);
        reservations = (ArrayList<Reservations>) JSON.parseArray(IO.read("Reservations.json"), Reservations.class);
        flights = (ArrayList<Flight>) JSON.parseArray(IO.read("Flight.json"),Flight.class);
        staffs = (ArrayList<Staff>) JSON.parseArray(IO.read("Staff.json"), Staff.class);
        meals = (ArrayList<Menu>) JSON.parseArray(IO.read("Menu.json"), Menu.class);
        seats = (ArrayList<Seat>) JSON.parseArray(IO.read("Seat.json"), Seat.class);
    }

    public void updateDataManager() throws IOException{
        passengers = (ArrayList<Passenger>) JSON.parseArray(IO.read("passenger.json"), Passenger.class);
        reservations = (ArrayList<Reservations>) JSON.parseArray(IO.read("Reservations.json"), Reservations.class);
        flights = (ArrayList<Flight>) JSON.parseArray(IO.read("Flight.json"),Flight.class);
        staffs = (ArrayList<Staff>) JSON.parseArray(IO.read("Staff.json"), Staff.class);
        meals = (ArrayList<Menu>) JSON.parseArray(IO.read("Menu.json"), Menu.class);
        seats = (ArrayList<Seat>) JSON.parseArray(IO.read("Seat.json"), Seat.class);

    }

    /**
     * write all data from memory into disk (files)
     * @throws IOException
     */
    public void commit() throws IOException {
        IO.write("passenger.json", JSON.toJSONString(passengers));
        IO.write("Reservations.json", JSON.toJSONString(reservations));
        IO.write("Flight.json", JSON.toJSONString(flights));
        IO.write("Staff.json", JSON.toJSONString(staffs));
        IO.write("Menu.json", JSON.toJSONString(meals));
        IO.write("Seat.json", JSON.toJSONString(seats));

    }





}
