import java.util.*;  
class Main   
{  

  public static void main(String[] args)  
  {  
 
      Scanner sc = new Scanner(System.in);     
      System.out.print("Welcome to parking Lot please choose the configuration to use (type bestfit or firstcome): "); 
        String cnfg= sc.next();
        Configuration config;

        if(cnfg.equals("bestfit")){
          config =Configuration.BestFit;
        }else {
          config =Configuration.FirstCome;
        }
     
        System.out.print("Parking Lot started Successfully and have 60 slots \n");  

        Map<String,Vehicle> map=new HashMap<String,Vehicle>();
        ParkingLot pl = new ParkingLot(10, 10, config);
        String decision = "";
    
        for(int i =0; i < 100000; i++){
        
        System.out.print("park or unpark or display ?");
          
        decision = sc.next();

        if(decision.equals("park")){
              decision = "";
             
            System.out.print("Enter type (car or motorcycle or largecar), owner name, liceseplate and carModel in respective order: "); 
            String type = sc.next();
            String name= sc.next();  
            String license= sc.next();
            String model= sc.next();

          
            if(type.equals("car")){
               Car car = new Car(name, license, model);
               map.put(license,car);
               pl.parkVehicle(map.get(license));
            }else if(type.equals("motorcycle")){
               Motorcycle moto = new Motorcycle(name, license, model);
               map.put(license,moto);
               pl.parkVehicle(map.get(license));
            }else {
              continue;
            }; 
            System.out.print("Vehicle with license plate " + license + " Successfully parked in the system \n");
           decision = "";
        }else if(decision.equals("unpark")){
              decision = "";
              System.out.print("Enter licesne plate of vehicle u wish to unpark from system ");
                
              String license= sc.next();  
            
              if(map.containsKey(license)){
                  pl.unParkVehicle(map.get(license));
                  System.out.print("Vehicle with license plate " + map.get(license).licensePlate + " Successfully unparked from the system \n");
                  map.get(license).print();
                  map.remove(license);
              }else {
                  System.out.print("This is incorrect licesne plate \n");
              };  
              decision = "";
        }else if(decision.equals("display")){
              pl.print();
        }else {
          System.out.print("Incorrect Enter a right action to system \n");
        }
        
      }
      sc.close();      

  }  


}
