package coursework.TDD;

import coursework.backend.dblayer.StaffManager;
import org.junit.Test;

import java.io.IOException;
/**
 * StaffTest is used to run TDD tests on StaffManager
 *
 * @author Shiyang Nie
 * @version:1.0
 *
 */
public class StaffTest {
    @Test
    public void getStaffById() throws IOException {
        //复制，参照FlightTest 和 StaffManager
        System.out.println("begin to test getStaffById()");
        System.out.println(StaffManager.getStaffById("1001","10011001").converter().toString());
        System.out.println("test for getStaffById() end");
        System.out.println("");
    }

}