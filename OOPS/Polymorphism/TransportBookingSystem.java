/*
Transport booking system

Interface Bookable with methods book(String from, String to) and cancelBooking(). Implement FlightBooking, TrainBooking,
and CabBooking. Each prints booking confirmation differently. Store all in Bookable[] and simulate booking and cancellation.

Flight: book("Mumbai","Delhi") → "Flight booked: Mumbai → Delhi | PNR: FL001"
Train: book("Pune","Mumbai") → "Train booked: Pune → Mumbai | Seat: TN042"
Cab: book("Home","Airport") → "Cab booked: Home → Airport | OTP: 4521"

Skills: interface, implements, Bookable[] array, two-method contract

 */

package Polymorphism;
public class TransportBookingSystem {
    public static void main(String[] args) {
        Bookable[] bk = new Bookable[3];
        bk[0] = new FlightBooking();
        bk[1] = new TrainBooking();
        bk[2] = new CabBooking();

        for(Bookable b: bk){
            b.book("Mumbai", "Delhi"); // with iteration/loop same source and destination
        }
        for(Bookable b: bk){
            b.cancelBooking();
        }

        bk[0].book("Mumbai", "Delhi"); // Without loop different source and destination for each method
        bk[1].book("Pune","Mumbai");
        bk[2].book("Home","Airport");
    }
}

interface Bookable{
    void book(String from, String to);
    void cancelBooking();
}

class FlightBooking implements Bookable{
    @Override
    public void book(String from, String to){
        System.out.println("Flight booked: "+from+" to "+to+" | PNR: FL001");
    }

    @Override
    public void cancelBooking(){
        System.out.println("Flight booking canceled...");
    }

}

class TrainBooking implements Bookable{
    @Override
    public void book(String from, String to){
        System.out.println("Train booked: "+from+" to "+to+" | Seat: TN042");
    }

    @Override
    public void cancelBooking(){
        System.out.println("Train booking canceled...");
    }
}

class CabBooking implements Bookable{
    @Override
    public void book(String from, String to){
        System.out.println("Cab booked: "+from+" to "+to+" | OTP: 4521");
    }

    @Override
    public void cancelBooking(){
        System.out.println("Cab booking canceled...");
    }
}
