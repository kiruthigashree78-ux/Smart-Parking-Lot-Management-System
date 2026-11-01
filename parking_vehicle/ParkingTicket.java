package parking_vehicle;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingTicket {
    private Vehicle vehicle;
    private int spotid;
    private LocalDateTime entrytime;
    private LocalDateTime exittime;
    private long hoursbilled;
    private double fee;

    public ParkingTicket(Vehicle vehicle, int spotid) {
        super();
        this.vehicle = vehicle;
        this.spotid = spotid;
        this.entrytime = LocalDateTime.now();
    }

    public double calculateFee(LocalDateTime exittime) {
    	long minutes = Duration.between(entrytime, exittime).toMinutes();
    	long hours = (long) Math.ceil(minutes / 60.0);
    	if (hours == 0) { hours = 1; }
        
        if (hours == 0) { hours = 1; }

        double rate;
        if (vehicle.gettype() == Vehicle_type.BIKE) {
            rate = 20;
        }
        else if (vehicle.gettype() == Vehicle_type.CAR) {
            rate = 50;
        }
        else {
            rate = 100;
        }

        this.exittime = exittime;
        this.hoursbilled = hours;
        this.fee = hours * rate;
        return this.fee;
    }

    public Vehicle getVehicle() { return vehicle; }
    public int getspotid() { return spotid; }
    public LocalDateTime getentrytime() { return entrytime; }
    public LocalDateTime getexittime() { return exittime; }
    public long gethoursbilled() { return hoursbilled; }
    public double getfee() { return fee; }
}