//
// Project Phase 2
// Creator: Meagan Waldo
// Last Updated: 05/07/21
// Course: 2021 Spring-CS-482-M70-DATABASE MGT SYS I
// Purpose: The purpose of this code is to handle the user chosen actions on the home page of the application.
//


package Driver;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;


public class application extends JFrame {


	//
	// This code is to launch the application.
	// Parameters: A string array called args which is used for command line arguments. 
	// Returns: Nothing.
	//
	public static void main(String[] args) {

		// Organizes the event queue list by only letting runnable run after all pending events have been processed. 
		EventQueue.invokeLater(
				new Runnable() {

					// Used to set up and show the application home page.
					public void run() {

						// Try creating a new home page for the application and show it to the user.
						try {
							application frame = new application();
							frame.setVisible(true);
						} // end of try
						catch (Exception e) {
							e.printStackTrace();
						} // end of catch
					} // end of run
				} // end of Runnable
				); 
	} // end of main


	//
	// This code is used to display buttons for the user to click to redirect to other parts of the application.
	// Parameters: None.
	// Returns: Nothing.
	//
	public application() {

		// Sets up basic information and rules for the application home page.
		setTitle("Application");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		// Creates a layeredPane and sets basic rules for it.
		JLayeredPane layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.CENTER);

		// Creates a button and sets up basic information and rules for it.
		JButton btnSingleInsert = new JButton("Single Insertion");
		btnSingleInsert.setBounds(10, 42, 166, 58);
		layeredPane.add(btnSingleInsert);

		// Creates a button and sets up basic information and rules for it.
		JButton btnBulkInsert = new JButton("Bulk Loading");
		btnBulkInsert.setBounds(258, 42, 166, 58);
		layeredPane.add(btnBulkInsert);

		// Creates a button and sets up basic information and rules for it.
		JButton btnDeleteTableData = new JButton("Delete Table Data");
		btnDeleteTableData.setBounds(10, 131, 166, 58);
		layeredPane.add(btnDeleteTableData);
		
		// Opens next application window and closes current one.
		btnDeleteTableData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				application4 frame = new application4();
				frame.setVisible(true);
			} // end of actionPreformed
		});
		
		// Opens next application window and closes current one.
		JButton btnEnterQuery = new JButton("Enter Query");
		btnEnterQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				application5 frame = new application5();
				frame.setVisible(true);		
			} // end of actionPreformed
		});
		
		// Opens next application window and closes current one.
		btnEnterQuery.setBounds(258, 131, 166, 58);
		layeredPane.add(btnEnterQuery);
		btnBulkInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				application3 frame = new application3();
				frame.setVisible(true);
			} // end of actionPreformed
		});
		
		// Opens next application window and closes current one.
		btnSingleInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				application2 frame = new application2();
				frame.setVisible(true);
			} // end of actionPreformed
		});
	} // end of application

	
	//
	// This code is to close a application window.
	// Parameters: None. 
	// Returns: Nothing.
	//
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	} // end of close
} // end of application class