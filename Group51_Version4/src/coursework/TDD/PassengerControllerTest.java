package coursework.TDD;

import coursework.Controller.PersonalController;
import coursework.Entity.Passenger;
import coursework.Entity.Reservations;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
/**
 * PassengerControllerTest is used to run TDD tests on PassengerControllerManager
 *
 * @author Shiyang Nie
 * @version:1.0
 *
 * @author Yian Zhang
 * @version:2.0
 *
 * @author Shiyang Nie
 * @version:3.0
 */
public class PassengerControllerTest {
    PersonalController personalController;
    @Before
    public void setUp() throws Exception {
        personalController = PersonalController.getController();
    }

    @Test
    public void getAllPassenger() {
        System.out.println("begin to test getAllPassenger()");
        ArrayList<Passenger> passengers = new ArrayList<>();
        passengers = personalController.getAllPassenger();
        System.out.println("All passengers are as follows");
        for(Passenger passenger : passengers) {
            System.out.println(passenger.toString());
        }
        System.out.println("test for getAllPassenger() end");
        System.out.println("");
    }

    @Test
    public void getAllReservations() {
        System.out.println("begin to test getAllReservations()");
        ArrayList<Reservations> reservations= new ArrayList<>();
        reservations = personalController.getAllReservations();
        System.out.println("All reservations are as follows");
        for(Reservations reservations1 : reservations) {
            System.out.println(reservations1.toString());
        }
        System.out.println("test for getAllReservations() end");
        System.out.println("");
    }

    @Test
    public void getPassengerInform() {
        System.out.println("begin to test getPassengerInform()");
        System.out.println(personalController.getPassengerInform("000001").toString());
        System.out.println(personalController.getPassengerInform("NIE", "2019213334").toString());
        System.out.println("test for getPassengerInform() end");
        System.out.println("");
    }

    @Test
    public void getFlightInform() {
        System.out.println("begin to test getFlightInform()");
        System.out.println(personalController.getFlightInform("CA166").toString());
        System.out.println(personalController.getFlightInform("NIE", "2019213334").toString());
        System.out.println("test for getFlightInform() end");
        System.out.println("");

    }

    @Test
    public void getOptions() {
        System.out.println("begin to test getOptions()");
        System.out.println(personalController.getOptions("000002").toString());
        System.out.println(personalController.getOptions("NIE", "2019213334").toString());
        System.out.println("test for getOptions() end");
        System.out.println("");
    }


    @Test
    public void filterByKeyword() {
        ArrayList<Passenger> passengers = personalController.getAllPassenger();
        ArrayList<Passenger> res = personalController.filterByKeyword(passengers, "MH666");
        for(Passenger i : res) {
            System.out.println(i.toString());
        }
        ArrayList<Passenger> res1 = personalController.filterByKeyword(passengers, "NIE", "2019213334");
        for(Passenger i : res1) {
            System.out.println(i.toString());
        }
    }

    @Test
    public void FilterByKeyword(){
        ArrayList<Reservations> reservations = personalController.getAllReservations();
        ArrayList<Reservations> res = personalController.FilterByKeyword(reservations,"2019213334");
        for(Reservations i : res) {
            System.out.println(i.toString());
        }
        ArrayList<Reservations> res1 = personalController.FilterByKeyword(reservations,"000002");
        for(Reservations i : res1) {
            System.out.println(i.toString());
        }
    }

    @Test
    public void filterByStatus(){
        ArrayList<Passenger> passengers = personalController.getAllPassenger();
        ArrayList<Passenger> res = personalController.filterByStatus(passengers,true);
        for(Passenger i : res) {
            System.out.println(i.toString());
        }

    }
}
