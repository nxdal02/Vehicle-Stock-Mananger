package tutorial;

abstract public class MotorisedVehicle extends Vehicle {
	
	protected Motor motor;
	
	public MotorisedVehicle() {
		this("", "");
	}
	
	public MotorisedVehicle(String brand, String make) {
		this(brand, make, new Motor());
	}
	
	public MotorisedVehicle(String brand, String make, int horseP, int Cc) {
	    this(brand, make, new Motor(horseP, Cc));
		
	}
	
	public MotorisedVehicle(String brand, String make, Motor motor) {
		super(brand, make);
		this.motor = motor;
	}

	public int getHorseP() {
		return motor.getHorseP();
	}
	
	public int getCc() {
		return motor.getCc();
	}

	public void setHorseP(int horseP) {
		motor.setHorseP(horseP);
	}
	
	public void setCc(int cc) {
		motor.setCc(cc);
	}
	
	public String getDetails() {
		return super.getDetails() + getHorseP() + "HP " + "(" + getCc() + "cc)\n";
	}

}
