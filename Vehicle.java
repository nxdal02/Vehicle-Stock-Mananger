package tutorial;

public abstract class Vehicle {
	
	protected int passenger;
	private String brand, make;
	
	public Vehicle() {
		this("", "");
	}
	
	public Vehicle(String brand, String make) {
		this.brand = brand;
		this.make = make;
	}
	
	public abstract void drive();

	public String getBrand() {
		return brand;
	}
	
	public String getMake() {
		return make;
	}
	
	public int getPassenger() {
		return passenger;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public void setPassenger(int passenger) {
		this.passenger = passenger;
	}
	
	public String getDetails() {
		return getBrand() + " - " + getMake() + "\n" + "Number of passengers: " + passenger + "\n";
	}
	
	public String toString() {
		return getDetails();
	}

}
