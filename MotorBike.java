package tutorial;

public class MotorBike extends MotorisedVehicle {
	
	public MotorBike() {
		this("", "");
	}
	
	public MotorBike(String brand, String make) {
		this(brand, make, new Motor());
	}
	
	public MotorBike(String brand, String make, int horseP, int Cc) {
		this(brand, make, new Motor(horseP, Cc));
	}
	
	public MotorBike(String brand, String make, Motor motor) {
		super(brand, make, motor);
		passenger = 2;
	}
	
	public void drive() {
		System.out.println("Wroom Wroom!");
	}
	
	public String getDetails() {
		return "(MotorBike) " + super.getDetails();	
	}
	
}
