package tutorial;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TutorialFileReader {
	
	private Vehicle createVehicle(Vehicle v, BufferedReader in) throws IOException{
		v.setBrand(in.readLine());
		v.setMake(in.readLine());
		return v;
	}
	
	private MotorisedVehicle createMotorisedVehicle(MotorisedVehicle mv, BufferedReader in) throws NumberFormatException, IOException{
		mv = (MotorisedVehicle) createVehicle(mv, in);
		mv.setHorseP(Integer.valueOf(in.readLine()));
		mv.setCc(Integer.valueOf(in.readLine()));
		return mv;
	}
	
	public ArrayList<String> readPlatesFile(String filename) throws FileNotFoundException{
		ArrayList<String> plates = new ArrayList<>();
		BufferedReader in = new BufferedReader(new FileReader(filename));

		try {
			String line = in.readLine();
			while(line != null) {
				plates.add(line);
				line = in.readLine();
			}
			in.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return plates;
	}
	
	public ArrayList<Vehicle> readVehiclesFile(String filename) throws FileNotFoundException{
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		BufferedReader in = new BufferedReader(new FileReader(filename));
		try {
			String line = in.readLine();
			while(line != null) {
				switch(line) {
				case "Hatchback":
					vehicles.add(createMotorisedVehicle(new Hatchback(), in));
					break;
				case "SUV":
					vehicles.add(createMotorisedVehicle(new SUV(), in));
					break;
				case "Saloon":
					vehicles.add(createMotorisedVehicle(new Saloon(), in));
	                break;
				case "MotorBike":
					vehicles.add(createMotorisedVehicle(new MotorBike(), in));
	                break;
				case "Bike":
					vehicles.add(createVehicle(new Bike(), in));
	                break;
				}
				line = in.readLine();
			}
			in.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return vehicles;
	}

}
