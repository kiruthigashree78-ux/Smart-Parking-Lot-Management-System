package Parking;
import java.time.LocalDateTime;
import java.time.Duration;

public class ParkingTicket {
    private String ticketId;
    private Vehicle vehicle;
    private int spotId;
    private LocalDateTime entryTime;

    public ParkingTicket(String ticketId, Vehicle vehicle, int spotId) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spotId = spotId;
        this.entryTime = LocalDateTime.now(); // Records exact entry time
    }

    // Calculates fee: $2/hr for Bike, $5/hr for Car, $10/hr for Van
    public double calculateFee(LocalDateTime exitTime) {
        long hours = Duration.between(entryTime, exitTime).toHours();
        if (hours == 0) hours = 1; // Minimum 1-hour charge

        switch (vehicle.getType()) {
            case BIKE:  return hours * 2.0;
            case CAR:   return hours * 5.0;
            case VAN: return hours * 10.0;
            default:    return hours * 3.0;
        }
    }

    public String getTicketId() { return ticketId; }
    public Vehicle getVehicle() { return vehicle; }
}
