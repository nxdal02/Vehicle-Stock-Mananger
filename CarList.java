package tutorial;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class CarList {

	public static void main(String[] args) throws IOException {
		
		Random rand = new Random();
		TutorialFileReader fr = new TutorialFileReader();
		TutorialFileWriter fw = new TutorialFileWriter();
		
		// Declare new ArrayLists of Car and plates
		ArrayList<Vehicle> vehicles = fr.readVehiclesFile("vehicles.txt");
		ArrayList<String> plates = fr.readPlatesFile("plates.txt");
		
		// Declare HashMap with String as Key, and Vehicle as Value
		HashMap<String, MotorisedVehicle> register = new HashMap<>();
	
		// Loop through list of vehicles, assign a random plate and add to register
		for(Vehicle a: vehicles) {
			if(a instanceof MotorisedVehicle) {
				String randPlate = plates.get(rand.nextInt(plates.size()));
				register.put(randPlate, (MotorisedVehicle) a);
				plates.remove(randPlate); 
			}
		}
		
		fw.writeRegister("register.txt", register);
		
		for(String key: register.keySet()) {
			System.out.println(key + ": " + register.get(key) + "\n");
		}    
		
    }
}
