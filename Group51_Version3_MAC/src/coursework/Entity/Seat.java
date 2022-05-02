package coursework.Entity;

public class Seat {
    private String seat;
    private boolean status;
    private int price;

    public String getSeat(){
        return seat;
    }
    public int getPrice(){
        return price;
    }
    public void setStatus(boolean status){
        this.status= status;
    }

    public boolean getStatus(){
        return status;
    }


    public Seat(String seat, boolean status, int price){
        this.seat=seat;
        this.status=status;
        this.price=price;
    }


    @Override
    public String toString(){
        return "Seat{" +
                "seat='" + seat + '\'' +
                ", status='" + status +'\''+"price='" + price + '\'' +
                '}';
    }

    public coursework.backend.model.Seat convert()
    {
        coursework.backend.model.Seat seat = new coursework.backend.model.Seat();
        seat.seat = this.seat;
        seat.status = this.status;
        seat.price=this.price;
        return seat;
    }

}




