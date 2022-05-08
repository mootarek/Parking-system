public class ParkingLot {
    private Configuration config;
    private Floor floor;
    private Level level;

    // @param n number of leves
    // @param num_rows  each level has num_rows rows of spots
    // @param spots_per_row each row has spots_per_row spots
    public ParkingLot(int num_rows, int spots_per_row, Configuration cnfg) {
        config = cnfg; 
        if(config == Configuration.BestFit){
          level = new Level(num_rows, spots_per_row);
        }else if(config == Configuration.FirstCome) {
          floor = new Floor(num_rows, spots_per_row);
        }
    }

    // Park the vehicle in a spot (or multiple spots)
    // Return false if failed
    public boolean parkVehicle(Vehicle vehicle) {

      if(config == Configuration.BestFit) {
            if (level.parkVehicle(vehicle)) {
                return true;
            }
        return false;
      }else {
        if (floor.parkVehicle(vehicle)) {
                return true;
            }
        return false;
      }
    }

    public void unParkVehicle(Vehicle vehicle) {
        vehicle.clearSpots();
    }

    public void print() {    
      if(config == Configuration.BestFit){
            System.out.print("Vehicles availabe in the lot based on bestfit: " + '\n');  
            level.print();
            System.out.println("");   
      }else {
            System.out.print("Vehicles availabe in the lot based on firstcome: " + '\n');  
            floor.print();
            System.out.println(""); 
      }
    } 
}