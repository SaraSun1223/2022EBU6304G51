package coursework.Entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Reservations {
    //
    String bookingNum;
    String IDNum;
    String flightNum;

    String meal;//original meal selected
    Boolean ifExtraMeal;
    String extraMealName[];
    Integer extraMealNum[];

    Integer baggageNum;
    Integer baggageWeight;

    Boolean ifExtraRoom;
    String gate;

    Boolean status;

    public Reservations(String bookingNum, String IDNum, String flightNum, String meal,
                        Boolean ifExtraMeal, String[] extraMealName, Integer[] extraMealNum,
                        Integer baggageNum, Integer baggageWeight, Boolean ifExtraRoom, String gate,
                        Boolean status) {
        this.bookingNum = bookingNum;
        this.IDNum = IDNum;
        this.flightNum = flightNum;
        this.meal = meal;
        this.ifExtraMeal = ifExtraMeal;
        this.extraMealName = extraMealName;
        this.extraMealNum = extraMealNum;
        this.baggageNum = baggageNum;
        this.baggageWeight = baggageWeight;
        this.ifExtraRoom = ifExtraRoom;
        this.gate = gate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservations:" +
                "\nbookingNum:" + bookingNum  +
                "\n IDNum='" + IDNum + '\n' +
                "\n flightNum='" + flightNum + '\n' +
                "\n meal='" + meal + '\n' +
                "\n ifExtraMeal=" + ifExtraMeal +
                "\n extraMealName=" + Arrays.toString(extraMealName) +
                "\nextraMealNum=" + Arrays.toString(extraMealNum) +
                "\nbaggageNum=" + baggageNum +
                "\nbaggageWeight=" + baggageWeight +
                "\nifExtraRoom=" + ifExtraRoom +
                "\ngate='" + gate + '\n' +
                "\nstatus=" + status +
                '}';
    }
    public String[] confirmationPrint(){
        String c = new String();
        if(status){
            c = "Check-in";
        }
        int length = this.extraMealName.length;
        int i = 0;
        String b= new String();
        while( i <length){
            b += extraMealName[i];
        }
        String [] a = new String[8];
        a[0] = "BookingNum:" + bookingNum;
        a[1] = "Meal selected:" + meal;
        a[2] = "BaggageNum:" + baggageNum;
        a[3] = "Baggage Weight:" + baggageWeight;
        a[4] = "Gate:" + gate;
        a[5] = "Status:"+c;
        a[6] = "Has Extra Meal: " + ifExtraMeal;
        if(ifExtraMeal){
            a[7] = "Extra Meal:"+b;
        }else{
            a[7] = "";
        }
        return a;
    }
    public coursework.backend.model.Reservations convert()
    {
        coursework.backend.model.Reservations reservations = new coursework.backend.model.Reservations();
        reservations.bookingNum = this.bookingNum ;
        reservations.IDNum = this.IDNum;
        reservations.flightNum = this.flightNum;
        reservations.meal = this.meal;
        reservations.ifExtraMeal = this.ifExtraMeal;
        reservations.extraMealName = this.extraMealName;
        reservations.extraMealNum = this.extraMealNum;
        reservations.baggageNum =this.baggageNum;
        reservations.baggageWeight = this.baggageWeight;
        reservations.ifExtraRoom = this.ifExtraRoom;
        reservations.gate = this.gate;
        reservations.status = this.status;

        return reservations;
    }

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
}
