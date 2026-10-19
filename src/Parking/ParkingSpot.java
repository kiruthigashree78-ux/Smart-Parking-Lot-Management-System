package Parking;

public class ParkingSpot {
    private int spotId;
    private VehicleType spotType;
    private boolean isOccupied;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotId, VehicleType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isOccupied = false;
        this.parkedVehicle = null;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public boolean park(Vehicle vehicle) {
        if (isOccupied || vehicle.getType() != this.spotType) {
            return false; // Cannot park if occupied or type mismatches
        }
        this.parkedVehicle = vehicle;
        this.isOccupied = true;
        return true;
    }

    public void unpark() {
        this.parkedVehicle = null;
        this.isOccupied = false;
    }

    public int getSpotId() {
        return spotId;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}
