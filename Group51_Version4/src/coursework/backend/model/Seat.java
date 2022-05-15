package coursework.backend.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * class for Seat
 * @author Shiyang Nie
 * @version 1.0
 */
public class Seat {

    @JSONField(name = "seat")
    public String seat;

    @JSONField(name = "status")
    public boolean status;

    @JSONField(name = "price")
    public int price;
    public coursework.Entity.Seat converter() {
        return new coursework.Entity.Seat(this.seat,this.status,this.price);
    }
}
