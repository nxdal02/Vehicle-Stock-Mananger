package tutorial;

public class Motor {
	
	// Declare variables
    int horseP, cc;
	
    // Create constructors
	public Motor() {
		horseP = 0;
		cc = 0;
	}
	
	public Motor(int horseP, int cc) {
		this.horseP = horseP;
		this.cc  = cc;
	}
    
	// Getters and setters
	public int getHorseP() {
		return horseP;
	}

	public int getCc() {
		return cc;
	}

	public void setHorseP(int horseP) {
		this.horseP = horseP;
	}
	
	public void setCc(int cc) {
		this.cc = cc;
	}

}
