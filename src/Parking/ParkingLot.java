package Parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingSpot> spots;

    public ParkingLot(int bikeSpots, int carSpots, int truckSpots) {
        spots = new ArrayList<>();
        int id = 1;

        // Initialize Bike spots
        for (int i = 0; i < bikeSpots; i++) {
            spots.add(new ParkingSpot(id++, VehicleType.BIKE));
        }
        // Initialize Car spots
        for (int i = 0; i < carSpots; i++) {
            spots.add(new ParkingSpot(id++, VehicleType.CAR));
        }
        // Initialize Truck spots
        for (int i = 0; i < truckSpots; i++) {
            spots.add(new ParkingSpot(id++, VehicleType.VAN));
        }
    }

    // Find the first available spot matching the vehicle type
    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.getSpotType() == vehicle.getType()) {
                spot.park(vehicle);
                System.out.println(vehicle.getType() + " [" + vehicle.getLicensePlate() + 
                                   "] parked successfully in Spot #" + spot.getSpotId());
                return true;
            }
        }
        System.out.println("No available " + vehicle.getType() + " spot for vehicle [" + 
                           vehicle.getLicensePlate() + "]");
        return false;
    }

    // Unpark a vehicle by license plate
    public boolean unparkVehicle(String licensePlate) {
        for (ParkingSpot spot : spots) {
            if (!spot.isAvailable() && spot.getParkedVehicle().getLicensePlate().equals(licensePlate)) {
                spot.unpark();
                System.out.println("Vehicle [" + licensePlate + "] cleared from Spot #" + spot.getSpotId());
                return true;
            }
        }
        System.out.println("Vehicle [" + licensePlate + "] not found in the parking lot.");
        return false;
    }
}