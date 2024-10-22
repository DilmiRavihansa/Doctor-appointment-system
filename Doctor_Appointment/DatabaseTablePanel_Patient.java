package Doctor_Appointment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseTablePanel_Patient extends JPanel
{
    //private DatabaseOperations databaseOperations;


    private JTable table;
    public DatabaseTablePanel_Patient() {

        setLayout(new BorderLayout());
        // Create a DefaultTableModel
        DefaultTableModel model = new DefaultTableModel();

        // Set column names
        model.setColumnIdentifiers(new Object[]{"Patient Id","First Name", "Last Name","Age","Patient Address","Contact No"});

        // Retrieve data from the database
        fetchDataFromDatabase(model);

        // Create the JTable with the DefaultTableModel
        table = new JTable(model);
        // Add the table to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the JScrollPane to the frame
        add(scrollPane,BorderLayout.CENTER);
        // Display the frame
        setVisible(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //MouseActionImpl mouseAction = new MouseActionImpl(table);
        //table.addMouseListener(mouseAction);

    }

    private void fetchDataFromDatabase(DefaultTableModel model)
    {
        // JDBC connection parameters
        String url = "jdbc:mysql://localhost:3306/doctor_appointment";
        String username = "root";
        String password = "123";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query to retrieve data
            ResultSet rs = statement.executeQuery("SELECT * FROM patient");

            // Iterate through the result set and add data to the model
            while (rs.next())
            {
                int PatientId;
                String FirstName;
                String LastName;
                int Age;
                String PatientAddress;
                int ContactNo;
                model.addRow(new Object[]{
                        PatientId = rs.getInt("PatientId"),
                        FirstName = rs.getString("FirstName"),
                        LastName = rs.getString("LastName"),
                        Age=rs.getInt("Age"),
                        PatientAddress=rs.getString("PatientAddress"),
                        ContactNo=rs.getInt("ContactNo"),
                });
            }

            // Close the resources
            rs.close();
            statement.close();
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
