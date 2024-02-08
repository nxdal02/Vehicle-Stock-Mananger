package tutorial;

public class Hatchback extends Car {
	
	private static final int DOORS = 3;
	
	public Hatchback() {
		this("", "", 0, 0);
	}
	
	public Hatchback(String brand, String make, int horseP, int Cc) {
		super(brand, make, DOORS, horseP, Cc);	
	}
	
	public Hatchback(String brand, String make, Motor motor) {
		super(brand, make, DOORS, motor);	
	}
	
	public String getDetails() {
		return "(Hatchback) " + super.getDetails();
	}

}
