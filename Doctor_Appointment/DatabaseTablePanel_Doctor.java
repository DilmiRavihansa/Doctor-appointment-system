package Doctor_Appointment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseTablePanel_Doctor extends JPanel
{
    //private DatabaseOperations databaseOperations;


    private JTable table;
    public DatabaseTablePanel_Doctor()
    {

        setLayout(new BorderLayout());
        // Create a DefaultTableModel
        DefaultTableModel model = new DefaultTableModel();

        // Set column names
        model.setColumnIdentifiers(new Object[]{"Doctor ID","Doctor Name", "Specialization"});

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
            ResultSet rs = statement.executeQuery("SELECT * FROM doctor");

            // Iterate through the result set and add data to the model
            while (rs.next())
            {
                int DoctorId;
                String DoctorName;
                String Specialization;
                model.addRow(new Object[]{
                        DoctorId = rs.getInt("DoctorId"),
                        DoctorName = rs.getString("DoctorName"),
                        Specialization = rs.getString("Specialization"),
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
