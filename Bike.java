package tutorial;

public class Bike extends Vehicle {
	
	public Bike() {
		this("", "");
	}
	
	public Bike(String brand, String make) {
		super(brand, make);
		passenger = 1;
	}
	
	public void drive() {
		System.out.println("Ring Ring!");
	}
	
	public String getDetails() {
		return "(Bike) " + super.getDetails();
	}

}
