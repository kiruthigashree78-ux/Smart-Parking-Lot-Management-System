package Parking;

public class Main {
    public static void main(String[] args) {
        // Create a parking lot with 2 Bike spots, 1 Car spot, and 1 Truck spot
        ParkingLot lot = new ParkingLot(2, 1, 1);

        Vehicle car1 = new Vehicle("KA-01-HH-1234", VehicleType.CAR);
        Vehicle car2 = new Vehicle("KA-01-HH-9999", VehicleType.CAR);
        Vehicle bike1 = new Vehicle("KA-02-EE-5678", VehicleType.BIKE);

        System.out.println("--- PARKING VEHICLES ---");
        lot.parkVehicle(car1);  // Should succeed (Car spot #3)
        lot.parkVehicle(car2);  // Should fail (Only 1 Car spot)
        lot.parkVehicle(bike1); // Should succeed (Bike spot #1)

        System.out.println("\n--- UNPARKING VEHICLES ---");
        lot.unparkVehicle("KA-01-HH-1234"); // Frees up the Car spot

        System.out.println("\n--- RETRY PARKING ---");
        lot.parkVehicle(car2);  // Should succeed now
    }
}