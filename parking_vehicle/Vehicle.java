package parking_vehicle;

public class Vehicle {
	private String ownername;
private String license_plate;
private Vehicle_type type;
public Vehicle(String license_plate, Vehicle_type type,String ownername) {
	super();
	this.license_plate = license_plate;
	this.type=type;
	this.ownername=ownername;
}
public String getlicenseplate() {
	return license_plate;
}
public Vehicle_type gettype()
{
	return type;
}

public String getownername() {
	return ownername;
}
}
