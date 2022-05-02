package coursework.Entity;


/*
** author： Zhang Jiayi
** version:1.0
 */

public class Flight
{
    private String FlightNum;
        public void setFlightNum(String flightNum) {
        FlightNum = flightNum;
         }
        public String getFlightNum() {
        return FlightNum;
        }
    
    private String Time;

        public void setTime(String time) {
            Time = time;
         }
        public String getTime() {
            return Time;
        }
        
    private String From;
        
        public void setFrom(String from) {
            From = from;
        }
        public String getFrom() {
            return From;
        }

    private  String To;

        public void setTo(String to) {
            To = to;
        }
        public String getTo() {
            return To;
        }

    public Flight(String FlightNum, String Time, String From, String To){
            this.FlightNum = FlightNum;
            this.Time = Time;
            this.From = From;
            this.To = To;
    }

    public String toString(){
            String s = "";
            s += FlightNum;
            s += Time;
            s += From;
            s += To;
            return s;
    }

    public coursework.backend.model.Flight convert(){
        coursework.backend.model.Flight flight = new coursework.backend.model.Flight();
        flight.FlightNum = this.FlightNum;
        flight.Time = this.Time;
        flight.From = this.From;
        flight.To = this.To;

        return flight;
    }

    public String[] confirmationPrint(){
        String c = new String();
        String [] a = new String[5];
        a[0] = "Flight Number:" + FlightNum;
        a[1] = "Time:" + Time;
        a[2] = "Original Place: " + From;
        a[3] = "Arrival Place:"+To;
        return a;
    }
}
