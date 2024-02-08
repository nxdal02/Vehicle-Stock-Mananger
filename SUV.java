package tutorial;

public class SUV extends Car {
	
	private static final int DOORS = 5;
	
	public SUV() {
		this("", "", 0, 0);
	}
	
	public SUV(String brand, String make, int horseP, int Cc) {
		super(brand, make, DOORS, horseP, Cc);
	}
	
	public SUV(String brand, String make, Motor motor) {
		super(brand, make, DOORS, motor);	
	}
	
	public String getDetails() {
		return "(SUV) " + super.getDetails();
	}
	
}
