//
// Project Phase 2
// Creator: Meagan Waldo
// Last Updated: 05/07/21
// Course: 2021 Spring-CS-482-M70-DATABASE MGT SYS I
// Purpose: The purpose of this code is to let the user perform single insert.
//


package Driver;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class application2 extends JFrame {

	private JPanel contentPane;

	public static JLabel lblNewLabel = new JLabel("");

	//
	// This code is used to set up the window of the application as well as perform single insertion.
	// Parameters: None. 
	// Returns: Nothing.
	//
	public application2() {

		// Set up and give rules for the window frame.
		setTitle("Single Insert");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Set up and give rules for the layeredPane.
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 404, 106);
		layeredPane.add(lblNewLabel);


		// Set up and give rules to the label.
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 117, 404, 123);
		layeredPane.add(lblNewLabel_1);

		// Create a new button and give it an action when clicked.
		JButton btnNewButton_1 = new JButton("Open file...");
		btnNewButton_1.addActionListener(new ActionListener() {

			// This performs the Single Insertion.
			public void actionPerformed(ActionEvent arg0) {

				// Handles grabbing the file information.
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String test = f.getName();
				test = test.substring(0, test.length() - 4);
				lblNewLabel.setText("");

				// Reads in data line by line as well as keeps time of doing process.
				try (BufferedReader br = new BufferedReader(new FileReader(f))) {
					String line;
					long startTime = System.nanoTime();

					// The while loop that loops to read the next line.
					while ((line = br.readLine()) != null) {
						System.out.println(line);
						Driver.insert1(line, test);	
					} // end of while

					// Gets the end of the time and performs an operation to get the running time.
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
						if(elapsedMinutes == 0) {
							time = String.format("%d Seconds, %d Milliseconds%n", elapsedSeconds, elapsedMilliseconds);
						} // end of if

						// Print out the correct format for the time taken.
						if(elapsedSeconds == 0) {
							time = String.format("%d Milliseconds%n", elapsedMilliseconds);
						} // end of if

						lblNewLabel_1.setText("Run Time: "+ time);
					} // end of else


				} // end of try
				catch (IOException e) {
					lblNewLabel.setText("Error: " + e.getMessage());
					e.printStackTrace();
				} // end of catch

				// If there is a error do nothing. Else correct label.
				if(lblNewLabel.getText() != "") {
				} // end of if
				else {
					lblNewLabel.setText("Data Inserted!");
				} // end of else
			} // end of actionPreformed	
		});

		// Set up and give rules to button.
		btnNewButton_1.setBounds(125, 79, 166, 57);
		layeredPane.add(btnNewButton_1);

		// Set up and give rules to button.
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10, 11, 69, 23);
		layeredPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {

			// Give the button the action to close the window when pushed.
			public void actionPerformed(ActionEvent arg0) {
				application frame2 = new application();
				frame2.setVisible(true);
				setVisible(false);
				dispose();
			} // end of actionPreformed
		});
	} // end of application2
} // end of application2 class