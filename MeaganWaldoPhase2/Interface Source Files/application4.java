//
// Project Phase 2
// Creator: Meagan Waldo
// Last Updated: 05/07/21
// Course: 2021 Spring-CS-482-M70-DATABASE MGT SYS I
// Purpose: The purpose of this code is to let the user delete data.
//


package Driver;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class application4 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public static JLabel lblNewLabel = new JLabel("Please Enter Table Name Below");
	private JButton btnBack;
	private JLabel lblNewLabel_1;

	//
	// This code is used to set up the window of the application as well as delete data.
	// Parameters: None. 
	// Returns: Nothing.
	//
	public application4() {

		// Set up and give rules for the window frame.
		setTitle("Delete Table Data");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Set up and give rules for the layeredPane.
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);

		// Set up and give rules to the label.
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 404, 79);
		layeredPane.add(lblNewLabel);


		// Create a new button and give it an action when clicked.
		JButton btnNewButton_1 = new JButton("Submit Input");
		btnNewButton_1.addActionListener(new ActionListener() {

			// This performs the delete.
			public void actionPerformed(ActionEvent arg0) {

				// Gets the user input.
				String test = textField.getText();
				lblNewLabel.setText("");


				// Starts the data delete and gets the running time.
				long startTime = System.nanoTime();
				Driver.delete(test);
				long stopTime = System.nanoTime();
				long nano = stopTime - startTime;

				// If time taken is less then a millisecond then print using nanoseconds. Else print using hours, minutes, seconds and milliseconds.
				if(nano <= 1000000) {
					lblNewLabel_1.setText("Run Time: " + nano + " Nanoseconds ");
				} // end of if
				else {
					
					// Conversions for time.
					long millisecondsInNano = 1000000;
					long secondsInNano = 1000000000;
					long minutesInNano = secondsInNano * 60;
					long hoursInNano = minutesInNano * 60;

					// Get total hours.
					long elapsedHours = nano / hoursInNano;
					nano = nano % hoursInNano;

					// Get total minutes.
					long elapsedMinutes = nano / minutesInNano;
					nano = nano % minutesInNano;

					// Get total seconds.
					long elapsedSeconds = nano / secondsInNano;
					nano = nano % secondsInNano;

					// Get total milliseconds.
					long elapsedMilliseconds = nano / millisecondsInNano;

					String time = "";
					
					// Print out the correct format for the time taken.
					if(elapsedHours != 0) { 
						time = String.format("%d Hours, %d Minutes, %d Seconds, %d Milliseconds%n", elapsedHours, elapsedMinutes, elapsedSeconds, elapsedMilliseconds);
					} // end of if
					
					// Print out the correct format for the time taken.
					if(elapsedHours == 0) { 
						time = String.format("%d Minutes, %d Seconds, %d Milliseconds%n", elapsedMinutes, elapsedSeconds, elapsedMilliseconds);
					} // end of if
					
					// Print out the correct format for the time taken.
					if (elapsedMinutes == 0) {
						time = String.format("%d Seconds, %d Milliseconds%n", elapsedSeconds, elapsedMilliseconds);
					} // end of if
					
					// Print out the correct format for the time taken.
					if (elapsedSeconds == 0) {
						time = String.format("%d Milliseconds%n", elapsedMilliseconds);
					} // end of if
					
					lblNewLabel_1.setText("Run Time: "+ time);
				} // end of else

				// If there is a error do nothing. Else correct label.
				if(lblNewLabel.getText() != "") {
				} // end of if
				else {
					lblNewLabel.setText("Data Deleted!");
				} // end of else
			} // end of actionPreformed
		});
		
		// Set up and give rules to button.
		btnNewButton_1.setBounds(243, 89, 152, 57);
		layeredPane.add(btnNewButton_1);

        // Set up and give rules to button textField.
		textField = new JTextField();
		textField.setBounds(60, 89, 186, 57);
		layeredPane.add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
			} // end of actionPerformed
		});
		
		// Set up and give rules to button.
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 11, 69, 23);
		layeredPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
		
			// Give the button the action to close the window when pushed.
			public void actionPerformed(ActionEvent e) {
				application frame2 = new application();
				frame2.setVisible(true);
				setVisible(false);
				dispose();
			} // end of actionPerformed
		});
		
		// Set up and give rules to button new label.
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 145, 424, 79);
		layeredPane.add(lblNewLabel_1);
	} // end of application4
} // end of application4 class