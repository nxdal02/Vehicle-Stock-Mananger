package tutorial;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class LSCustoms extends JFrame implements ActionListener{
	private JTextArea showStock;
	private JPanel buttons;
	private JButton showStockButton, addStockButton;
	private JScrollPane displayArea;
	
	public LSCustoms() {
        setLayout(new BorderLayout());

        // Stock display area
        showStock = new JTextArea();
        showStock.setEditable(false);
        displayArea = new JScrollPane(showStock);
        add(displayArea, BorderLayout.CENTER);

        // Show, Add stock buttons
        buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(buttons, BorderLayout.SOUTH);

        // Set preferred size for buttons
        showStockButton = new JButton("Show Stock");
        showStockButton.setPreferredSize(new Dimension(120, 40));
        showStockButton.addActionListener(this);

        addStockButton = new JButton("Add Stock");
        addStockButton.setPreferredSize(new Dimension(120, 40));
        addStockButton.addActionListener(this);

        buttons.add(showStockButton);
        buttons.add(addStockButton);
    }
	
	//
	private void displayStock() throws IOException {
		TutorialFileReader vr = new TutorialFileReader();
		// Create vehicle objects from text file
		ArrayList<Vehicle> vehicles = vr.readVehiclesFile("vehicle-stock.txt");
		showStock.setText("");
		// Output info about each vehicle
		for(Vehicle v: vehicles) {
			showStock.append(v.getDetails() + "\n");
		}
	}
	
	// Open new window when Add Stock button is pressed
	private void showAddStock() {
		new AddStockWindow(this);
	}
	
	public void actionPerformed(ActionEvent e){
		// Display stock when show stock button pressed
		if(e.getSource() == showStockButton) {
			try {
				displayStock();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource() == addStockButton) {
			showAddStock();
		}
	}
	
	public static void main(String[] args) {
		LSCustoms l = new LSCustoms();
		l.setTitle("Los Santos Customs");
		l.setSize(1280, 720);
		l.setVisible(true);
		l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon logo = new ImageIcon("Los_Santos_Customs_29.png");
		l.setIconImage(logo.getImage());
	}
}