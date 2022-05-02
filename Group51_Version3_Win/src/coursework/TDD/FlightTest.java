package coursework.TDD;

import coursework.backend.dblayer.FlightManager;
import org.junit.Test;

import java.io.IOException;
/**
 * FlightTest is used to run TDD tests on FlightManager
 *
 * @author Shiyang Nie
 * @version:1.0
 *
 */
public class FlightTest {
    @Test
    public void getFlightByFlightNum() throws IOException {
        System.out.println("begin to test getPassengerById()");
        System.out.println(FlightManager.getFlightByFlightNum("MH666").converter().toString());
        System.out.println("test for getPassengerById() end");
        System.out.println("");
    }


}