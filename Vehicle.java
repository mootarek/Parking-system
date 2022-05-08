import java.util.ArrayList;
import java.time.Duration;
import java.time.Instant;


// enum type for Vehicle
enum VehicleSize {
    Motorcycle,
    Compact,
    Large,
}


//abstract Vehicle class
abstract class Vehicle {
    protected String owner; 
    Instant arrivalTime;
    double fee;
    Instant departureTime;
    protected String model; 
    protected int spotsNeeded;
    protected VehicleSize size;
    protected String licensePlate;  // id for a vehicle

    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>(); // id for parking where may occupy multi

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleSize getSize() {
        return size;
    }

    /* Park vehicle in this spot (among others, potentially) */
    public void parkInSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
        captureArrival();
    }

    public void captureArrival() {
         arrivalTime = Instant.now();
    }

    public double captureParkedSeconds() {
        Instant current = Instant.now();

        Duration timeElapsed = Duration.between(arrivalTime, current);
      
        return timeElapsed.toMillis() / 1000;
    }

    public void captureDeparture() {
         departureTime = Instant.now();
    }


    public double calculateFee(){
       fee = captureParkedSeconds() * 0.00138888888;
       return (double)Math.round(fee * 100000d) / 100000d;
    }

    /* Remove car from spot, and notify spot that it's gone */
    public void clearSpots() {
        for (int i = 0; i < parkingSpots.size(); i++) {
            parkingSpots.get(i).removeVehicle();
        }
        parkingSpots.clear();
        captureDeparture();
    }
    //this need to be implement in subclass
    public abstract boolean canFitInSpot(ParkingSpot spot);
    public abstract void print(); 
}





