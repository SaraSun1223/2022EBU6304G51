package coursework.Entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Passenger {
    private String surname;
    private String firstName;
    private String bookingNumber;
    private String idNumber;
    private boolean status;
    private String phoneNumber;
    private String flightNumber;
    private ArrayList<String> flightInform;
    private ArrayList<String> options;


    public String getSurname(){
    return surname;
    }

    public void setSurname(String surname){
    this.surname=surname;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getBookingNumber(){
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber){
        this.bookingNumber=bookingNumber;
    }

    public String getIdNumber(){
        return idNumber;
    }

    public void setIdNumber(String idNumber){
        this.idNumber=idNumber;
    }

    public boolean getStatus(){
        return status;
    }

    public void setStatus(boolean status){
        this.status=status;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public String getFlightNumber(){
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber){
        this.flightNumber=flightNumber;
    }

    public ArrayList<String> getFlightInform() {
        return flightInform;
    }

    public void setFlightInform(ArrayList<String> flightInform) {
        this.flightInform = flightInform;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public Passenger(String surname, String firstName, String bookingNumber, String idNumber,
                     boolean status, String phoneNumber, String flightNumber){
        this.surname=surname;
        this.firstName=firstName;
        this.bookingNumber=bookingNumber;
        this.idNumber=idNumber;
        this.status=status;
        this.phoneNumber=phoneNumber;
        this.flightNumber=flightNumber;
    }

    public Passenger(String surname, String firstName, String bookingNumber, String idNumber,
                     boolean status, String phoneNumber, String flightNumber,
                     ArrayList<String> flightInform, ArrayList<String> options){
        this.surname=surname;
        this.firstName=firstName;
        this.bookingNumber=bookingNumber;
        this.idNumber=idNumber;
        this.status=status;
        this.phoneNumber=phoneNumber;
        this.flightNumber=flightNumber;
        this.flightInform=flightInform;
        this.options=options;
    }

    @Override
    public String toString(){
        return "Passenger{" +
                "surname='" + surname + '\'' +
                ", firstName='" + firstName +'\''+
                ", bookingNumber='" + bookingNumber + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", status=" + status +
                ", phoneNumber=" + phoneNumber +
                ", flightNumber='" + flightNumber +'\''+
                '}';
    }

    public coursework.backend.model.Passenger convert()
    {
        coursework.backend.model.Passenger passenger = new coursework.backend.model.Passenger();
        passenger.surname = this.surname;
        passenger.firstName = this.firstName;
        passenger.flightInform = (ArrayList<String>)this.flightInform.clone();
        passenger.options = (ArrayList<String>)this.options.clone();
        passenger.bookingNumber = this.bookingNumber;
        passenger.idNumber = this.idNumber;
        passenger.phoneNumber = this.phoneNumber;
        passenger.status = this.status;
        passenger.flightNumber = this.flightNumber;

        return passenger;
    }
    public String[] confirmationPrint(){
        String c = new String();
        String [] a = new String[3];
        a[0] = "Surname:" + surname;
        a[1] = "First Name:" + firstName;
        a[2] = "Phone Number: " + phoneNumber;
        return a;
    }

}




