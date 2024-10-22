package Doctor_Appointment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class DatabaseTablePanel_Clinic extends JPanel
{
    //private DatabaseOperations databaseOperations;


    private JTable table;
    public DatabaseTablePanel_Clinic()
    {

        setLayout(new BorderLayout());
        // Create a DefaultTableModel
        DefaultTableModel model = new DefaultTableModel();

        // Set column names
        model.setColumnIdentifiers(new Object[]{"Clinic ID","Appointment Date", "Doctor ID","Hospital ID"});

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
            ResultSet rs = statement.executeQuery("SELECT * FROM clnic");

            // Iterate through the result set and add data to the model
            while (rs.next())
            {
                int CliniId;
                Date AppointmentDate;
                int DoctorId;
                int HospitalId;
                model.addRow(new Object[]{
                        CliniId = rs.getInt("ClinicId"),
                        AppointmentDate = rs.getDate("AppointmentDate"),
                        DoctorId = rs.getInt("DoctorId"),
                        HospitalId=rs.getInt("HospitalId"),
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
