package coursework.Entity;

import java.util.ArrayList;
import java.util.Iterator;

public class Reservations {
    //
    String bookingNum;
    String IDNum;
    String flightNum;

    ArrayList<String> standardMeal;//original meal selected
    Boolean ifExtraMeal;
    ArrayList<String> extraMealName;


    Integer baggageNum;
    Integer baggageWeight;

    Boolean ifExtraRoom;
    String gate;

    Boolean status;

    public Reservations(String bookingNum, String IDNum, String flightNum,  ArrayList<String> standardMeal,
                        Boolean ifExtraMeal, ArrayList<String> extraMealName, Integer baggageNum,
                        Integer baggageWeight, Boolean ifExtraRoom, String gate, Boolean status) {
        this.bookingNum = bookingNum;
        this.IDNum = IDNum;
        this.flightNum = flightNum;
        this.standardMeal = standardMeal;
        this.ifExtraMeal = ifExtraMeal;
        this.extraMealName = extraMealName;
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
                "\n meal='" + standardMeal + '\n' +
                "\n ifExtraMeal=" + ifExtraMeal +
                "\n extraMealName=" + extraMealName +
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
        }else{
            c="Not check-in";
        }

        String [] a = new String[9];
        a[0] = "BookingNum:" + bookingNum;
        a[1] = "Meal selected:";
        for(int i = 0 ; i < standardMeal.size() ;  i++){
            a[1]+=standardMeal.get(i)+"  ";
            System.out.println(a[1]);
        }
        a[2] = "BaggageNum:" + baggageNum;
        a[3] = "Baggage Weight:" + baggageWeight;
        a[4] = "Has Extra Meal: " + ifExtraMeal;
        if(ifExtraMeal){
            a[5] = "Extra Meal:";
            for(int i = 0 ; i < extraMealName.size() ;  i++){
                a[5]+=extraMealName.get(i)+"  ";
            }
        }else{
            a[5] = "";
        }
        a[6]="   ";
        a[7] = "Status:"+c;
        a[8] = "Gate:" + gate;
        return a;
    }
    public coursework.backend.model.Reservations convert()
    {
        coursework.backend.model.Reservations reservations = new coursework.backend.model.Reservations();
        reservations.bookingNum = this.bookingNum ;
        reservations.IDNum = this.IDNum;
        reservations.flightNum = this.flightNum;
        reservations.standardMeal = this.standardMeal;
        reservations.ifExtraMeal = this.ifExtraMeal;
        reservations.extraMealName = this.extraMealName;
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
}
