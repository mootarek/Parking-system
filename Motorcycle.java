class Motorcycle extends Vehicle {

    public Motorcycle(String ownr, String licPlt, String mod) {
        owner = ownr;
        licensePlate = licPlt;
        model = mod;
        spotsNeeded = 1;
        size = VehicleSize.Motorcycle;

    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return true;
    }

    public void print() {  
               System.out.print("Model: " + model + ", " + "license plates: " + licensePlate + ", owner: " + owner  + ", Parked Time: " + captureParkedSeconds() + " seconds" + ", total fee: " + calculateFee() + " L.E" + '\n');
    } 
  
}

