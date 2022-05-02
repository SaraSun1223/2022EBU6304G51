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

    @JSONField(name = "standardMeal")
    public ArrayList<String> standardMeal;//original meal selected

    @JSONField(name = "ifExtraMeal")
    public Boolean ifExtraMeal;

    @JSONField(name = "extraMealName")
    public ArrayList<String> extraMealName;


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

    public ArrayList<String> getStandardMeal() {
        return standardMeal;
    }

    public void setStandardMeal(ArrayList<String> standardMeal) {
        this.standardMeal = standardMeal;
    }

    public Boolean getIfExtraMeal() {
        return ifExtraMeal;
    }

    public void setIfExtraMeal(Boolean ifExtraMeal) {
        this.ifExtraMeal = ifExtraMeal;
    }

    public ArrayList<String> getExtraMealName() {
        return extraMealName;
    }

    public void setExtraMealName(ArrayList<String> extraMealName) {
        this.extraMealName = extraMealName;
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

    @Override
    public String toString() {
        return "Reservations{" +
                "bookingNum='" + bookingNum + '\'' +
                ", IDNum='" + IDNum + '\'' +
                ", flightNum='" + flightNum + '\'' +
                ", standardMeal=" + standardMeal +
                ", ifExtraMeal=" + ifExtraMeal +
                ", extraMealName=" + extraMealName +
                ", baggageNum=" + baggageNum +
                ", baggageWeight=" + baggageWeight +
                ", ifExtraRoom=" + ifExtraRoom +
                ", gate='" + gate + '\'' +
                ", status=" + status +
                '}';
    }

    public  coursework.Entity.Reservations converter()
    {
        return new coursework.Entity.Reservations(this.bookingNum,this.IDNum,this.flightNum,this.standardMeal,
                this.ifExtraMeal,this.extraMealName,this.baggageNum,this.baggageWeight,
                this.ifExtraRoom,this.gate,this.status);
    }
}
