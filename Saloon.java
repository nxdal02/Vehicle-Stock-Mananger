package tutorial;

public class Saloon extends Car {
	
	private static final int DOORS = 4;
	
	public Saloon() {
		this("", "", 0, 0);
	}
	
	public Saloon(String brand, String make, int horseP, int Cc) {
		super(brand, make, DOORS, horseP, Cc);
	}
	
	public Saloon(String brand, String make, Motor motor) {
		super(brand, make, DOORS, motor);	
	}
	
	public String getDetails() {
		return "(Saloon) " + super.getDetails();
	}

}
