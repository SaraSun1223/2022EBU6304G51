package coursework.TDD;

import coursework.Controller.PersonalController;
import org.junit.Before;
import org.junit.Test;
/**
 * ReservationsTest is used to run TDD tests on ReservationsManager
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
public class ReservationsTest {
    PersonalController personalController;

    @Before
    public void setUp() throws Exception {
        personalController = PersonalController.getController();
    }
    @Test
    public void getReservationsInform() {
        System.out.println("begin to test getReservationsInform()");
        System.out.println(personalController.getReservationsInform("2019213334").toString());
        System.out.println("test for getReservationsInform() end");
        System.out.println("");
    }

    @Test
    public void getReservationsInformByID(){
        System.out.println("getReservationsInformByID()");
        System.out.println(personalController.getReservationsInformByID("2019213334").toString());
        System.out.println("test for getReservationsInformByID end");
        System.out.println("");
    }

    @Test
    public void getReservationsInfbyBookingnum() {
        System.out.println("getReservationsInbyBookingnum()");
        System.out.println(personalController.getReservationsInfbyBookingnum("000001").toString());
        System.out.println("test for getReservationsInfbyBookingnum end");
        System.out.println("");

    }

}