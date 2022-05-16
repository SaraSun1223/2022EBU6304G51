package coursework.Controller;

import coursework.Entity.*;//output Entity Classes

import java.io.IOException;
import java.util.*;

import coursework.backend.dblayer.*;
import org.apache.commons.lang3.StringUtils;

import javax.swing.text.html.HTMLDocument;

public class PersonalController implements PassengerUtils,StaffUtils{
    private static PersonalController personalController = new PersonalController();
    private PersonalController() {};
    public  static PersonalController getController()
    {
        return personalController;
    }

    /**
     * <p>
     *     Filter customers based on keywords, if a customer's name or id has
     *     the keyword, it will be collected.
     * </p>
     * @param passengers A list of passengers
     * @param key any keyword
     * @return A list of customers who have the keyword
     */
    public ArrayList<Passenger> filterByKeyword(ArrayList<Passenger> passengers, String key)
    {
        ArrayList<Passenger> res = new ArrayList<>();
        if(key == null)
            return passengers;
        for(Passenger i : passengers)
        {
            if(i.getFlightNumber().equals(key))
            {
                res.add(i);
            }
            else if(i.getSurname().equals(key))
            {
                res.add(i);
            }
            else if(i.getFirstName().equals(key))
            {
                res.add(i);
            }
            else if((i.getFirstName()+" "+ i.getSurname()).equals(key))
            {
                res.add(i);
            }
            else if(i.getIdNumber().equals(key))
            {
                res.add(i);
            }
            else if(i.getBookingNumber().equals(key))
            {
                res.add(i);
            }
            else if(i.getPhoneNumber().equals(key))
            {
                res.add(i);
            }
            else if(Boolean.toString(i.getStatus()).equals(key))
            {
                res.add(i);
            }
            else
            {}
        }
        return res;
    }

    public ArrayList<Reservations> FilterByKeyword(ArrayList<Reservations> reservations, String key)
    {
        ArrayList<Reservations> res = new ArrayList<>();
        if(key == null)
            return reservations;
        for(Reservations i : reservations)
        {
            if(i.getFlightNum().equals(key))
            {
                res.add(i);
            }
            else if((this.getPassengerInform(i.getBookingNum()).getFirstName()+" "+
                    this.getPassengerInform(i.getBookingNum()).getSurname()).equals(key))
            {
                res.add(i);
            }
            else if((this.getPassengerInform(i.getBookingNum()).getPhoneNumber()).equals(key))
            {
                res.add(i);
            }
            else if(i.getIDNum().equals(key))
            {
                res.add(i);
            }
            else if(i.getBaggageNum().toString().equals(key))
            {
                res.add(i);
            }
            else if((i.getBaggageWeight().toString()+"kg").equals(key))
            {
                res.add(i);
            }
            else if(i.getGate().equals(key))
            {
                res.add(i);
            }
            else if(StringUtils.join(i.getStandardMeal(),",").equals(key))
            {
                res.add(i);
            }
            else if(StringUtils.join(i.getExtraMealName(),",").equals(key))
            {
                res.add(i);
            }
            else
            {}
        }
        return res;
    }

    public ArrayList<Passenger> filterByKeyword(ArrayList<Passenger> passengers, String key1, String key2)
    {
        ArrayList<Passenger> res = new ArrayList<>();
        if(key1 == null&&key2 == null)
            return passengers;
        for(Passenger i : passengers)
        {
            if(i.getSurname().contains(key1) && i.getIdNumber().contains(key2))
            {
                res.add(i);
            }
        }
        return res;
    }

    /**
     * <p>
     *     Filter all customers based on gender
     * </p>
     * @param passengers A list of customers
     * @param status Status (true for checkin and false for not checkin)
     * @return A list of passenger who have the same status
     */
    public ArrayList<Passenger> filterByStatus(ArrayList<Passenger> passengers, boolean status)
    {
        ArrayList<Passenger> res = new ArrayList<>();

        for(Passenger i: passengers)
        {
            if(status == i.getStatus())
                res.add(i);
        }
        return res;
    }

    /**
     * <p>
     *     Get all information of all customers
     * </p>
     * @return A List of all customers
     */
    public ArrayList<Passenger> getAllPassenger() {
        ArrayList<coursework.backend.model.Passenger> passengers = null;
        try {
            passengers = DataManager.getInstance().passengers;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        ArrayList<Passenger> res = new ArrayList<>();
        for(int i = 0; i < passengers.size(); i++)
        {
            res.add(passengers.get(i).converter());
        }
        return res;
    }

    /**
     * <p>
     *     Get all information of a given customer
     * </p>
     * @param bookingNo flight booking number
     * @return  A passenger entity
     */
    public Passenger getPassengerInform(String bookingNo) {
        try {
            return PassengerManager.getPassengerById(bookingNo).converter();
        }

        catch (Exception e){

        }
        return null;
    }

    public Passenger getPassengerInform(String surname, String idNo) {
        try {
            return PassengerManager.getPassengerById(surname,idNo).converter();
        }

        catch (Exception e){

        }
        return null;
    }

    /**
     * <p>
     *     Check passenger's booking number
     * </p>
     * @param bookingNo flight booking number
     * @return Return 1 for legal passenger, 2 for non-existed passenger
     */
    public int checkPassenger(String bookingNo) {
        try {
            if(PassengerManager.getPassengerById(bookingNo) == null) {
                return 2;
            }
            else {
                return 1;
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

        return -1;
    }

    /**
     * <p>
     *     Check passenger's surname and ID number
     * </p>
     * @param surname surname
     * @param idNo ID number
     * @return Return 1 for legal passenger, 2 for non-existed passenger
     */

    public int checkPassenger(String surname, String idNo) {
        try {
            if(PassengerManager.getPassengerById(surname,idNo) == null) {
                return 2;
            }
            else {
                return 1;
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

        return -1;
    }

    /**
     * <p>
     *     Check passenger's surname and ID number
     * </p>
     * @param staffid surname
     * @param password ID number
     * @return Return 1 for legal staff, 2 for non-existed staff
     */

    public int checkStaff(String staffid, String password) {
        try {
            if(StaffManager.getStaffById(staffid,password) == null) {
                return 2;
            }
            else {
                return 1;
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

        return -1;
    }

    /**
     * <p>
     *     confirm a specific customer's checkin status
     * </p>
     * @param bookingNo flight booking number (e.g. cusId="cs2")
     */
    public void confirmCheckin(String bookingNo) {
        try {
            PassengerManager.confirmCheckin(bookingNo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * <p>
     *     confirm a specific customer's checkin status
     * </p>
     * @param surname surname
     * @param idNo ID number
     */
    public void confirmCheckin(String surname, String idNo) {
        try {
            PassengerManager.confirmCheckin(surname,idNo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * <p>
     *     Get the flight information list of a given customer
     * </p>
     * @param flightNum FlightNum
     * @return A flight information list of a given customer
     */
    public Flight getFlightInform(String flightNum) {
        try {
            return FlightManager.getFlightByFlightNum(flightNum).converter();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    /**
     * <p>
     *     Get the flight information list of a given customer
     * </p>
     * @param surname Customer surname
     * @param idNo Customer ID number
     * @return A flight information list of a given customer
     */
    public ArrayList<String> getFlightInform(String surname, String idNo) {
        Passenger passenger = getPassengerInform(surname,idNo);
        ArrayList<String> res = new ArrayList<>();
        for(String s: passenger.getFlightInform()) {
            res.add(s);
        }
        return res;
    }

    /**
     * <p>
     *     Get the reservation list of a given customer
     * </p>
     * @param bookingNo Customer ID (e.g. cusId="cs2")
     * @return A reservation list of a given customer
     */
    public ArrayList<String> getOptions(String bookingNo) {
        Passenger passenger = getPassengerInform(bookingNo);
        ArrayList<String> res = new ArrayList<>();
        for(String s: passenger.getOptions()) {
            res.add(s);
        }
        return res;

    }

    /**
     * <p>
     *     Get the reservation list of a given customer
     * </p>
     * @param surname Customer surname
     * @param idNo Customer ID number
     * @return A reservation list of a given customer
     */
    public ArrayList<String> getOptions(String surname, String idNo) {
        Passenger passenger = getPassengerInform(surname,idNo);
        ArrayList<String> res = new ArrayList<>();
        for(String s: passenger.getOptions()) {
            res.add(s);
        }
        return res;

    }

    /**
     * <p>
     *     Get all information of a given customer
     * </p>
     * @param ID ID number
     * @return  A reservations entity
     */
    public ArrayList<Reservations> getReservationsInform(String ID) {
        try {
            ArrayList<Reservations> a = new ArrayList<>();
            ArrayList<coursework.backend.model.Reservations> b = ReservationsManager.getReservationByID(ID);
            Iterator iterator = b.iterator();
            if(iterator.hasNext()){
                a.add(((coursework.backend.model.Reservations)iterator.next()).converter());

            }
            return a;
            }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Reservations getReservationsInformByID(String ID) {
        try {
        return ReservationsManager.getSingleReservationByID(ID).converter();
    }catch (Exception e){
        e.printStackTrace();
    }
        return null;
    }

    /**
     * <p>
     *     Get all information of a given customer
     * </p>
     * @param bookingNo booking number
     * @return  A reservations entity
     */
    public Reservations getReservationsInfbyBookingnum(String bookingNo) {
        try {
            return ReservationsManager.getReservationByBookingNum(bookingNo).converter();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Reservations> getAllReservations() {
        ArrayList<coursework.backend.model.Reservations> reservations = null;
        try {
            reservations = DataManager.getInstance().reservations;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        ArrayList<Reservations> res = new ArrayList<>();
        for(int i = 0; i < reservations.size(); i++)
        {
            res.add(reservations.get(i).converter());
        }
        return res;
    }



    /**
     * <p>
     *     Update passenger information
     * </p>
     * @param passenger A passenger entity
     */
    public void update(Passenger passenger)
    {
        try {
            PassengerManager.writePassengerInfo(passenger.convert());
        }
        catch (Exception e)
        {

        }
    }

    public void updateReservations(Reservations reservations)
    {
        try {
            ReservationsManager.writeReservationsInfo(reservations.convert());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
