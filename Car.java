class Car extends Vehicle {

    public Car(String ownr, String licPlt, String mod) {
        owner = ownr;
        licensePlate = licPlt;
        model = mod;
        spotsNeeded = 1;
        size = VehicleSize.Compact;

    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact;
    }

    public void print() {  
               System.out.print("Model: " + model + ", " + "license plates: " + licensePlate + ", owner: " + owner  + ", Parked Time: " + captureParkedSeconds() + " seconds" + ", total fee: " + calculateFee() + " L.E" + '\n');
    }  
}