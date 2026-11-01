package parking_vehicle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {
	private List<ParkingSpot> spots;
	private HashMap<String, ParkingTicket> tickets;
	
    public ParkingLot(int bikeSpots,int carSpots,int vanSpots) {
        spots = new ArrayList<>();
        tickets = new HashMap<>();
        int id = 1;
        //initializing the bike spots
        for (int i = 0; i < bikeSpots; i++) {
            spots.add( new ParkingSpot(id++,Vehicle_type.BIKE));
            // make a new BIKE spot with the next id
        }
        //initializing the car spots
        for (int i = 0; i < carSpots; i++) {
            spots.add( new ParkingSpot(id++,Vehicle_type.CAR));
          // make a new car spot with the next id
        }
        for (int i = 0; i < vanSpots; i++) {
            
            spots.add( new ParkingSpot(id++,Vehicle_type.VAN));// make a new van spot with the next id
        }
    }
    public int freeSpots() {
        int count = 0;
        for (ParkingSpot s : spots) {
            if (s.isavailable()) {
                count++;
            }
        }
        return count;
    }
    

	public ParkingTicket parkVehicle(Vehicle v) {
		if(tickets.containsKey(v.getlicenseplate())) {
			return null;
		}
    	for(ParkingSpot s:spots) {
    		if(s.isavailable()&&s.getspot()==v.gettype()) {
    			s.park(v);
    			ParkingTicket t=new ParkingTicket(v,s.getspotid());
    			tickets.put(v.getlicenseplate(), t);
    			return t;
    			}
    	}
    	return null;
    }
    
	public ParkingTicket unparkVehicle(String plate) {
	    ParkingTicket t = tickets.get(plate);
	    if (t ==null) {
	        return null;                      // not found
	    }
	    double fee=t. calculateFee(LocalDateTime.now());
	    for (ParkingSpot s : spots) {
	        if (s.getspotid()==t.getspotid() ) {
	            s.unpark();
	        }
	    }
	    tickets.remove(plate);
	    return t;
	}
     
}