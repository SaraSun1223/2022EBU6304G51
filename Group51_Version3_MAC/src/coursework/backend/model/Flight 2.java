package coursework.backend.model;

import com.alibaba.fastjson.annotation.JSONField;

/*
 * class for Flight
 * author: Zhang Jiayi
 */

public class Flight {
    @JSONField(name = "FlightNum")
    public String FlightNum;

    @JSONField(name = "Time")
    public String Time;

    @JSONField(name = "From")
    public String From;

    @JSONField(name = "To")
    public String To;

    public coursework.Entity.Flight converter(){
        return new coursework.Entity.Flight(this.FlightNum, this.Time, this.From, this.To);
    }
}
