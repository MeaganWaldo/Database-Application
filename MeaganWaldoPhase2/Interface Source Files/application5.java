//
// Project Phase 2
// Creator: Meagan Waldo
// Last Updated: 05/07/21
// Course: 2021 Spring-CS-482-M70-DATABASE MGT SYS I
// Purpose: The purpose of this code is to let the user query the database.
//


package Driver;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class application5 extends JFrame {

	private JPanel contentPane;


	public static JLabel lblNewLabel = new JLabel("");
	private JTable table_1;

	//
	// This code is used to set up the window of the application as well as let the use query the database.
	// Parameters: None. 
	// Returns: Nothing.
	//
	public application5() {

		// Set up and give rules for the window frame.
		setTitle("Enter Query");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Set up and give rules for the layeredPane.
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);

		// Set up and give rules for the JScrollPane.
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(444, 78, 420, 462);
		layeredPane.add(scrollPane);

		// Set up and give rules to table_1.
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setEnabled(false);

		// Set up and give rules to the label.
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 420, 314, 46);
		layeredPane.add(lblNewLabel);

		// Set up and give rules to the label.
		JLabel lblSdfad = new JLabel("");
		lblSdfad.setHorizontalAlignment(SwingConstants.CENTER);
		lblSdfad.setBounds(0, 530, 334, 21);
		layeredPane.add(lblSdfad);

		// Set up and give rules to the JTextArea.
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 78, 314, 331);
		layeredPane.add(textArea);

		// Create a new button and give it an action when clicked.
		JButton btnNewButton_1 = new JButton("Submit query");
		btnNewButton_1.addActionListener(new ActionListener() {

			// This performs the query request.
			public void actionPerformed(ActionEvent arg0) {

				// Get the use query.
				String sql = textArea.getText();
				lblNewLabel.setText("");

				// Starts the getting the query and gets the running time.
				long startTime = System.nanoTime();
				ResultSet resultSet = Driver.query(sql);
				long stopTime = System.nanoTime();
				long nano = stopTime - startTime;

				// If time taken is less then a millisecond then print using nanoseconds. Else print using hours, minutes, seconds and milliseconds.
				if(nano <= 1000000) {
					lblSdfad.setText("Run Time: " + nano + " Nanoseconds ");
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

					lblSdfad.setText("Run Time: "+ time);
				} // end of else


				// Set up the table correctly.
				table_1.setModel(resultSetToTableModel(resultSet));

				// Get the data for the table and place it inside.
				java.sql.ResultSetMetaData rsmd = null;
				try {
					rsmd = resultSet.getMetaData();
				} // end of try 
				catch (SQLException e) {
					lblNewLabel.setText("Error: " + e.getMessage());
					e.printStackTrace();
				} // end of catch

				int columnsNumber = 0;

				try {
					columnsNumber = rsmd.getColumnCount();
				} // end of try
				catch (SQLException e1) {
					lblNewLabel.setText("Error: " + e1.getMessage());
					e1.printStackTrace();
				} // end of catch

				try {

					// Get the next column of data.
					while (resultSet.next()) {

						// While there are still columns grab the data.
						for (int i = 1; i <= columnsNumber; i++) {

							// Formatting help.
							if (i > 1) System.out.print(", ");

							String columnValue = resultSet.getString(i);
							System.out.printf(columnValue + " " + rsmd.getColumnName(i));
						} // end of for

						System.out.println("");
					} // end of while
				} // end of try
				catch (SQLException e) {
					lblNewLabel.setText("Error: " + e.getMessage());
					e.printStackTrace();
				} // end of catch

				// If there is a error do nothing. Else correct label.
				if(lblNewLabel.getText() != "") {
				} // end of if
				else {
					lblNewLabel.setText("Query Complete!");
				} // end of else

				int number = table_1.getColumnCount();

				table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

				// Update the width of the columns in the table.
				for (int i = 0; i < number; i++) {
					table_1.getColumnModel().getColumn(i).setPreferredWidth(200);
				} // end of for
			} // end of actionPerformed
		});

		// Set up and give rules to button.
		btnNewButton_1.setBounds(91, 472, 152, 57);
		layeredPane.add(btnNewButton_1);

		// Set up and give rules to label.
		JLabel lblPleaseEnterQuery = new JLabel("Please Enter Query Below");
		lblPleaseEnterQuery.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterQuery.setBounds(10, 21, 314, 46);
		layeredPane.add(lblPleaseEnterQuery);

		// Set up and give rules to label.
		JLabel lblResultsOfQuery = new JLabel("Results Of Query");
		lblResultsOfQuery.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultsOfQuery.setBounds(495, 21, 314, 46);
		layeredPane.add(lblResultsOfQuery);

		// Set up and give rules to button.
		JButton btnBack = new JButton("Back");
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
	} // end of application5

	//
	// This code is used to set up table for the query results.
	// Parameters: A ResultSet called rs.
	// Returns: Null if error or DefaultTableModel if everything worked. 
	//
	public static TableModel resultSetToTableModel(ResultSet rs) {
		try {

			// Set up to get query data in a ResultSet.
			ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			Vector<String> columnNames = new Vector<String>();

			// Get the column names.
			for (int column = 0; column < numberOfColumns; column++) {
				columnNames.addElement(metaData.getColumnLabel(column + 1));
			} // end of for

			// Get all rows.
			Vector<Vector<Object>> rows = new Vector<Vector<Object>>();

			// Get the next data.
			while (rs.next()) {
				Vector<Object> newRow = new Vector<Object>();

				// Add a new row.
				for (int i = 1; i <= numberOfColumns; i++) {
					newRow.addElement(rs.getObject(i));
				} // end of for

				rows.addElement(newRow);
			} // end of while

			return new DefaultTableModel(rows, columnNames);
		} // end of try
		catch (Exception e) {
			e.printStackTrace();
			return null;
		} // end of catch
	} // end of resultSetToTableModel
} // end of application5 class