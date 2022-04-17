package coursework.backend.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Reservations {
    @JSONField(name = "bookingNum")
    public String bookingNum;

    @JSONField(name = "IDNum")
    public String IDNum;

    @JSONField(name = "flightNum")
    public String flightNum;

    @JSONField(name = "meal")
    public String meal;//original meal selected

    @JSONField(name = "ifExtraMeal")
    public Boolean ifExtraMeal;

    @JSONField(name = "extraMealName")
    public String extraMealName[];

    @JSONField(name = "extraMealName")
    public Integer extraMealNum[];

    @JSONField(name = "baggageNum")
    public Integer baggageNum;

    @JSONField(name = "baggageWeight")
    public Integer baggageWeight;

    @JSONField(name = "ifExtraRoom")
    public Boolean ifExtraRoom;

    @JSONField(name = "gate")
    public String gate;

    @JSONField(name = "status")
    public Boolean status;

    public String getBookingNum() {
        return bookingNum;
    }

    public String getIDNum() {
        return IDNum;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public Boolean getIfExtraMeal() {
        return ifExtraMeal;
    }

    public void setIfExtraMeal(Boolean ifExtraMeal) {
        this.ifExtraMeal = ifExtraMeal;
    }

    public String[] getExtraMealName() {
        return extraMealName;
    }

    public void setExtraMealName(String[] extraMealName) {
        this.extraMealName = extraMealName;
    }

    public Integer[] getExtraMealNum() {
        return extraMealNum;
    }

    public void setExtraMealNum(Integer[] extraMealNum) {
        this.extraMealNum = extraMealNum;
    }

    public Integer getBaggageNum() {
        return baggageNum;
    }

    public void setBaggageNum(Integer baggageNum) {
        this.baggageNum = baggageNum;
    }

    public Integer getBaggageWeight() {
        return baggageWeight;
    }

    public void setBaggageWeight(Integer baggageWeight) {
        this.baggageWeight = baggageWeight;
    }

    public Boolean getIfExtraRoom() {
        return ifExtraRoom;
    }

    public void setIfExtraRoom(Boolean ifExtraRoom) {
        this.ifExtraRoom = ifExtraRoom;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public  coursework.Entity.Reservations converter()
    {
        return new coursework.Entity.Reservations(this.bookingNum,this.IDNum,this.flightNum,this.meal,
                this.ifExtraMeal,this.extraMealName,this.extraMealNum,this.baggageNum,this.baggageWeight,
                this.ifExtraRoom,this.gate,this.status);
    }
}
