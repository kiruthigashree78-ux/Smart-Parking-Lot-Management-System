package parking_vehicle;

public class ParkingSpot {
private int spotid;
private boolean isoccupied;
private Vehicle_type vehicletype;
private Vehicle vehicle;
public ParkingSpot(int spotid,Vehicle_type vehicletype) {
	super();
	this.spotid = spotid;
	this.isoccupied = false;
	this.vehicletype = vehicletype;
	this.vehicle = null;
}
public boolean park(Vehicle v) {
	if(isoccupied||v.gettype()!=vehicletype) {
		return false;
	}
	else {
		vehicle =v;
		isoccupied=true;
		return true;
	}
}
public void unpark( ) {
	isoccupied=false;
	vehicle=null;
}
public int getspotid() {
	return spotid;
}
public Vehicle_type getspot() {
	return vehicletype;
}
public boolean isavailable() {
	return !isoccupied;
}
public Vehicle getVehicle() {
	return vehicle;
}
}
