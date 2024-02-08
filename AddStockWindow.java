package tutorial;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddStockWindow extends JFrame implements ActionListener{
	private JRadioButton isCar, isMotorBike, isBike;
	private ButtonGroup vehicleChoice;
	private JPanel vehicleChoicePanel;
	private JComboBox<String> carTypeMenu;
	private JTextField brand, make, hp, cc;
	private JButton addVehicle, closeWindow;
	
	private static final String FILE_PATH = "vehicle-stock.txt";

	
	
	public AddStockWindow(JFrame parent){
		setLayout(new GridLayout(7,2));
		 // GUI properties
		setSize(480,480);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(parent);
		
		//Create Radio buttons and group them
		isCar = new JRadioButton("Car");
		isMotorBike = new JRadioButton("MotorBike"); 
		isBike = new JRadioButton("Bike"); 
		isCar.addActionListener(this);
		isMotorBike.addActionListener(this);
		isBike.addActionListener(this);
		vehicleChoice = new ButtonGroup();
		vehicleChoice.add(isCar);
		vehicleChoice.add(isMotorBike);
		vehicleChoice.add(isBike);
		
		// Put radio buttons group in panel and add to window
		vehicleChoicePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		vehicleChoicePanel.add(isCar);
		vehicleChoicePanel.add(isMotorBike);
		vehicleChoicePanel.add(isBike);
		add(vehicleChoicePanel);
		
		// Car type drown down menu
		String[] carTypes = {"SUV", "Saloon", "Hatchback"};
	    carTypeMenu = new JComboBox<>(carTypes);
	    carTypeMenu.setPreferredSize(new Dimension(120, 25));
	    add(carTypeMenu);
	    
	    // Text input fields for brand, make, hp, and cc
        brand = new JTextField();
        make = new JTextField();
        hp = new JTextField();
        cc = new JTextField();

        add(new JLabel("Brand:"));
        add(brand);
        add(new JLabel("Make:"));
        add(make);
        add(new JLabel("Horsepower (hp):"));
        add(hp);
        add(new JLabel("Engine size (cc):"));
        add(cc);
        
        // Add vehicle button
        addVehicle = new JButton("Add");
        addVehicle.addActionListener(this);
        add(addVehicle);
        
        // Close window button
        closeWindow = new JButton("Close");
        closeWindow.addActionListener(this);
        add(closeWindow);
        
        // Disable all components to begin with
        setAllEnabled(false);
	}
	
	// enable/disable all components, apart from the radio buttons
	private void setAllEnabled(boolean b) {
        carTypeMenu.setEnabled(b);
        brand.setEnabled(b);
        make.setEnabled(b);
        hp.setEnabled(b);
        cc.setEnabled(b);
        addVehicle.setEnabled(b);
	}
	
	// Change state of window based on vehicle type selected	
	private void carState(){
		setAllEnabled(true);
	}
	
	private void motorBikeState() {	
		setAllEnabled(true);
		carTypeMenu.setEnabled(false);
	}
	
	private void bikeState() {
		setAllEnabled(true);
		carTypeMenu.setEnabled(false);
		hp.setEnabled(false);
        cc.setEnabled(false);
	}
	
	// Clear text fields 
	private void clearFields() {
	    brand.setText("");
	    make.setText("");
	    hp.setText("");
	    cc.setText("");
	}
	
	 private void saveVehicle() {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
	        	/* 
	        	 * Append data to the file. Which of the fields are saved depends on the vehicle type, 
	        	 * i.e Bike won't have 'HP' or 'CC'so no need to save those fields.
	        	 */
	        	
	        	if (isCar.isSelected() || isMotorBike.isSelected()) {
	        		// Check whether hp and cc inputs are Integers
	        		try {
	        		    int horsepower = Integer.parseInt(hp.getText());
	        		    int displacement = Integer.parseInt(cc.getText());

	        		} catch (NumberFormatException e) {
	        		    // Handle the case where hp or cc cannot be parsed as integers
	        		    JOptionPane.showMessageDialog(this, "Invalid format for horsepower or displacement. Please enter valid integers.", "Error", JOptionPane.ERROR_MESSAGE);
	        		    return;
	        		}
	        		if(isCar.isSelected()){
	        			writer.write(((String) carTypeMenu.getSelectedItem()) + "\n");    
	        		} else {
	        			writer.write("MotorBike" + "\n");
	        		}
	 	            writer.write(brand.getText() + "\n");
	 	            writer.write(make.getText() + "\n");
	 	            writer.write(hp.getText() + "\n");
	 	            writer.write(cc.getText() + "\n");
	        	}
	        	else {
	        		writer.write("Bike" + "\n");
	        		writer.write(brand.getText() + "\n");
		            writer.write(make.getText() + "\n");
	        	}

	            JOptionPane.showMessageDialog(this, "Data saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
	            
	            // Clear text fields so user can input another vehicle without re-opening window
	            clearFields();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Error saving data.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
		
	public void actionPerformed(ActionEvent e) {
		// enable/disable fields depending on what vehicle type the user selects
		if(isCar.isSelected()) {
			carState();
		}
		else if(isMotorBike.isSelected()) {
			motorBikeState();
		}
		else if(isBike.isSelected()) {
			bikeState();
		}
		// Save inputs if add button pressed
		if(e.getSource() == addVehicle) {
			saveVehicle();
		}
		
		// Close window is close button pressed
		if(e.getSource() == closeWindow) {
			dispose();
		}

	}

}
