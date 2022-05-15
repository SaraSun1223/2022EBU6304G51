package coursework.TDD;

import coursework.backend.dblayer.PassengerManager;
import org.junit.Test;

import java.io.IOException;
/**
 * PassengerTest is used to run TDD tests on PassengerManager
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
public class PassengerTest {
    @Test
    public void getPassengerById() throws IOException {
        System.out.println("begin to test getPassengerById()");
        System.out.println(PassengerManager.getPassengerById("000003").converter().toString());
        System.out.println(PassengerManager.getPassengerById("NIE","2019213334").converter().toString());
        System.out.println("test for getPassengerById() end");
        System.out.println("");
    }


    @Test
    public void confirmCheckin() throws IOException {
        System.out.println("begin to test confirmCheckin()");
        PassengerManager.confirmCheckin("000004");
        assert PassengerManager.getPassengerById("000004").status==true;
        PassengerManager.confirmCheckin("NIE","2019213334");
        assert PassengerManager.getPassengerById("NIE","2019213334").status==true;
        System.out.println("test for confirmCheckin() end");
        System.out.println("");
    }

}