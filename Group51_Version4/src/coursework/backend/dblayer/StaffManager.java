package coursework.backend.dblayer;

import coursework.backend.model.Staff;

import java.io.IOException;
import java.util.ArrayList;


public class StaffManager {

    public static Staff getStaffById(String staffid, String password) throws IOException {
        ArrayList<Staff> staffs = DataManager.getInstance().staffs;
        for (Staff staff : staffs) {
            if (staff.staffid.equals(staffid)&& staff.password.equals(password)) {
                return staff;
            }
        }
        return null;
    }

}
