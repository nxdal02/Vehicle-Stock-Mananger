# Vehicle-Stock-Mananger

**Vehicle Stock Management System**

The Vehicle Stock Management System is a Java-based application that allows users to manage and track the stock of various vehicles.

**Features**

Add new vehicles to the stock
Specify vehicle type (Car, MotorBike, Bike)
Differentiate Car types (SUV, Saloon, Hatchback)
Save vehicle details to a file (vehicle-stock.txt)

**Usage**

Two ways to use this program: 
1. Populate the 'vehicles.txt' file with vehicles in the form:
<type>
<brand>
<make>
<hp>
<cc>
note that not all fields are applicable.
e.g.
Skoda
Fabia
150
1500
MotorBike
Suzuki
Hayabusa
1340
194
Bike
Mountain
Bike

Populate the 'plates.txt' file with a different plates on each line.
Run the 'CarList' class.
The 'CarList' class will populate ArrayLists of vehicles and plates using the 'FileReader'.
The 'register' HashMap puts (randomPlate, vehicle).
All motorised vehicles and their properties are printed to the console.

2. Run the 'LSCustoms' class
Add Stock by clicking button and inputting fields.
Note that some fields will be disabled depending on type of vehicle selected.
Error occurs if HP and CC fields aren't Integers
Show Stock to display inventory.
