class ParkingSpot {
    // Write your code here
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int row;
    private int spotNumber;
    private Level level;
    private Floor floor;

    public ParkingSpot(Level lvl, Floor flr,int r, int n, VehicleSize sz) {
        level = lvl;
        floor = flr;
        row = r;
        spotNumber = n;
        spotSize = sz;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    /* Checks if the spot is big enough for the vehicle (and is available). This compares
     * the SIZE only. It does not check if it has enough spots. */
    public boolean canFitVehicle(Vehicle vehicle) {
        return isAvailable() && vehicle.canFitInSpot(this);
    }
    /* Park vehicle in this spot. */
    public boolean park(Vehicle v) {
        if (level != null){
          if(!canFitVehicle(v)) {
            return false;
          }
        }
        vehicle = v;
        vehicle.parkInSpot(this);
        return true;
    }
    /* Remove vehicle from spot, and notify level that a new spot is available */
    public void removeVehicle() {
        if(level != null) {
          level.spotFreed();
        }else {
          floor.spotFreed();
        }
        vehicle = null;
    }

    public int getRow() {
        return row;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleSize getSize() {
        return spotSize;
    }

    public void print() {  
      int SRemaining = 0;
        if (vehicle == null) {  
            if (spotSize == VehicleSize.Compact) {  
                SRemaining++;
            } else if (spotSize == VehicleSize.Large) {  
                SRemaining++;
            } else if (spotSize == VehicleSize.Motorcycle) {  
                SRemaining++;  
            }  
        } else {  
            vehicle.print();  
        }  
    }
}