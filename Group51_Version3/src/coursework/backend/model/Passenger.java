package coursework.backend.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * class for customer
 * @author Lingsong Feng
 * @version 5.3
 */
public class Passenger {

    @JSONField(name = "surname")
    public String surname;

    @JSONField(name = "firstName")
    public String firstName;

    @JSONField(name = "bookingNumber")
    public String bookingNumber;

    @JSONField(name = "idNumber")
    public String idNumber;

    @JSONField(name = "status")
    public boolean status;

    @JSONField(name = "phoneNumber")
    public String phoneNumber;

    @JSONField(name = "flightNumber")
    public String flightNumber;

    @JSONField(name = "flightInform")
    public ArrayList<String> flightInform;

    @JSONField(name = "options")
    public  ArrayList<String> options;

    public coursework.Entity.Passenger converter() {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //String expireDateF = sdf.format(this.expireDate);
        return new coursework.Entity.Passenger(this.surname,this.firstName, this.bookingNumber, this.idNumber,
                this.status, this.phoneNumber, this.flightNumber,this.flightInform, this.options);
    }
}
