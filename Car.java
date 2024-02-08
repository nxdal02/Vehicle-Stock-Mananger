 package tutorial;

public class Car extends MotorisedVehicle {
	
	// Declaration of fields
	private String brand, make;
	private int doors;
	private Motor motor;
	
	public Car() {
		this("", "", 0, new Motor());
	}
	
	public Car(String brand, String make, int horseP, int cc) {
		this(brand, make, new Motor(horseP, cc));
	}

	public Car(String brand, String make, int doors, int horseP, int cc) {
		this(brand, make, doors, new Motor(horseP, cc));
	}
	
	public Car(String brand, String make, Motor motor) {
		this(brand, make, 0, motor);
	}
	
	public Car(String brand, String make, int doors, Motor motor) {
		super(brand, make, motor);
		this.doors = doors;
		passenger = 5;
	}
	
	public void drive() {
		System.out.println("Wroom!");
	}
	
	
	public int getDoors() {
		return doors;
	}
	
	
	// Returns String containing all info of Car
	public String getDetails() {
		return super.getDetails() + "Doors: " + getDoors() + "\n";
	}
	
}
