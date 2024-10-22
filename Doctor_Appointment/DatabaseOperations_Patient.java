package Doctor_Appointment;


import javax.swing.*;
import java.sql.*;

public class DatabaseOperations_Patient {
    private Connection connection;
    private Statement statement;
    private String connectionUrl = "jdbc:mysql://localhost:3306/doctor_appointment";

    public DatabaseOperations_Patient() throws SQLException {
        connect();
    }

    private void connect() throws SQLException {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            this.connection = DriverManager.getConnection(connectionUrl, "root", "123");
            this.statement = this.connection.createStatement();
            System.out.println("Database Connected....");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPatient(int PatientId,String FirstName, String LastName, int Age, String PatientAddress, int ContactNo) {
        String sql = "INSERT INTO patient(PatientId,FirstName,LastName,Age,PatientAddress,ContactNo) VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setInt(1,PatientId);
            preparedStatement.setString(2, FirstName);
            preparedStatement.setString(3, LastName);
            preparedStatement.setInt(4, Age);
            preparedStatement.setString(5, PatientAddress);
            preparedStatement.setInt(6, ContactNo);

            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Record Inserted Successfully");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void updatePatient(int PatientId, String FirstName, String LastName, int Age, String PatientAddress, int ContactNo)
    {
        String sql = "UPDATE patient SET FirstName=?, LastName=?, Age=?, PatientAddress=?, ContactNo=? WHERE PatientId=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, FirstName);
            preparedStatement.setString(2, LastName);
            preparedStatement.setInt(3, Age);
            preparedStatement.setString(4, PatientAddress);
            preparedStatement.setInt(5, ContactNo);
            preparedStatement.setInt(6, PatientId);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Record Updated Successfully");
            } else {
                System.out.println("No record found with PatientId: " + PatientId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally
        {
            try
            {
                preparedStatement.close();
                connection.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
    public void deletePatient(int PatientId)
    {
        String sql = "DELETE FROM patient WHERE PatientId=?";
        PreparedStatement preparedStatement = null;
        try
        {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, PatientId);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0)
            {
                System.out.println("Record Deleted Successfully");
            }
            else
            {
                System.out.println("No record found with PatientId: " + PatientId);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                preparedStatement.close();
                connection.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}