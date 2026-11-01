# Smart-Parking-Lot-Management-System
An object-oriented Java application designed to automate vehicle entry/exit tracking, dynamic slot allocation, and fee calculation using custom domain models and Java Collection frameworks.
## Features

- Parking spots for three vehicle types: Bike, Car, Van
- Allocates the first free spot that matches the vehicle's type
- Records the owner name, license plate and vehicle type
- Validates the license plate format (for example `TN-45-3455`) and the vehicle type
- Rejects a license plate that is already parked
- Issues a ticket and stores it in a `HashMap` keyed by license plate
- Fee based on parking time, rounded up to the next full hour (minimum 1 hour), with a different hourly rate per vehicle type
- Prints a receipt on exit: owner, vehicle, spot, entry time, exit time, hours billed, fee
- Shows the number of free spots in the menu
- ## Project Structure

| Class | Role |
|---|---|
| `Vehicle_type` | Enum of allowed vehicle kinds: BIKE, CAR, VAN |
| `Vehicle` | A vehicle with a license plate, a type and an owner name |
| `ParkingSpot` | One parking space: its id, type, and whether it is free or occupied |
| `ParkingLot` | Holds the list of spots and the ticket map; handles park, exit and the free-spot count |
| `ParkingTicket` | Stores the vehicle, spot id and entry time; calculates the fee and records exit time, hours billed and fee |
| `Main` | Menu that runs the program |
## Sample Output
```
Free spots: 4
1. Park a vehicle
2. Exit a vehicle
3. Exit program
Enter choice:
'''
1
Enter your name:
kiara
Enter plate:
TN-45-3455
Enter type (BIKE / CAR / VAN):
car
Spot allocating.....
		*****Parked in spot:3*****
Free spots: 3
1. Park a vehicle
2. Exit a vehicle
3. Exit program
Enter choice:
2
Enter plate:
TN-45-3455
========== PARKING RECEIPT ==========
Owner        : kiara
Vehicle      : TN-45-3455 (CAR)
Spot         : 3
Entry time   : 01-11-2026 11:50
Exit time    : 01-11-2026 11:51
Hours billed : 1
Fee          : Rs. 50.0
=====================================
Free spots: 4
1. Park a vehicle
2. Exit a vehicle
3. Exit program
Enter choice:
```
