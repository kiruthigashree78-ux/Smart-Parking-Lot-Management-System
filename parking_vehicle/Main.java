package parking_vehicle;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
	static Scanner sc=new Scanner(System.in);
public static void main(String[] args) throws Exception  {	
	ParkingLot park1 = new ParkingLot(2, 1, 1);
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");   // ← here
	int choice = 0;

	while (choice != 3) {
		System.out.println("Free spots: " + park1.freeSpots());
	    System.out.println("1. Park a vehicle");
	    System.out.println("2. Exit a vehicle");
	    System.out.println("3. Exit program");
	    System.out.println("Enter choice:");
	    choice = sc.nextInt();
	    sc.nextLine();    // throws away the leftover Enter
	    switch (choice) {
	    case 1:
	    	System.out.println("Enter your name:");
	    	String owner=sc.nextLine();
	        System.out.println("Enter plate:");
	        String plate = sc.nextLine();
	        plate=plate.toUpperCase();
	        boolean isplate=plate.matches("[A-Z]{2}-\\d{2}-\\d{4}");
	       
	        if(!isplate){
	        System.out.println("Invalid plate format");	
	        } 
	        else {
	        System.out.println("Enter type (BIKE / CAR / VAN):");
	        String typeText = sc.nextLine();
	        Vehicle_type type = null;
	        try {
	            type = Vehicle_type.valueOf(typeText.toUpperCase());
	        } catch (IllegalArgumentException e) {
	            System.out.println("Invalid vehicle type. Please enter BIKE, CAR or VAN.");
	        }
	        if (type != null) {
	        	 Vehicle v = new Vehicle(plate,type,owner);
	 	        ParkingTicket t = park1.parkVehicle( v );
	 	        	System.out.println("Spot allocating.....");
	 		        Thread.sleep(2500);
	 		       
	 		        spotnum( t);}
	        
	        }     
	        break;
	        case 2:
	        	  System.out.println("Enter plate:");
	  	        String exitplate = sc.nextLine();
	  	      exitplate=exitplate.toUpperCase();
	  	    ParkingTicket exitticket = park1.unparkVehicle(exitplate);
	  	  if (exitticket == null) {
	  	      System.out.println("No vehicle found with that plate");
	  	  } else {
	  		System.out.println("========== PARKING RECEIPT ==========");
	  		System.out.println("Owner        : " + exitticket.getVehicle().getownername());
	  		System.out.println("Vehicle      : " + exitticket.getVehicle().getlicenseplate() + " (" + exitticket.getVehicle().gettype() + ")");
	  		System.out.println("Spot         : " + exitticket.getspotid());
	  		System.out.println("Entry time   : " + exitticket.getentrytime().format(fmt));
	  		System.out.println("Exit time    : " + exitticket.getexittime().format(fmt));
	  		System.out.println("Hours billed : " + exitticket.gethoursbilled());
	  		System.out.println("Fee          : Rs. " + exitticket.getfee());
	  	  System.out.println("=====================================");
	  	  }
	  	  
	            break;
	        case 3:
	            System.out.println("Exit the program");
	            break;
	        default:
	            System.out.println("Invalid choice");
	    }
	}
}public static void spotnum(ParkingTicket t) {
	if (t != null) {
		
	    System.out.println("\t\t*****Parked in spot:" + t.getspotid()+"*****");
	} else {
	    System.out.println("\t\t*****No spot available*****");
	}
}

}
