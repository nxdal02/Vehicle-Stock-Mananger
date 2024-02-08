/**
 * 
 */
package tutorial;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author Nedal
 *
 */
public class TutorialFileWriter {
	
	public void writeRegister(String filename, HashMap<String, MotorisedVehicle> register) throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(filename));
		
		for(String key: register.keySet()) {		
			out.write(key + register.get(key));
		}
		out.close();
	}
}
