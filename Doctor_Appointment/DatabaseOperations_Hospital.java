package Doctor_Appointment;

import java.sql.*;

public class DatabaseOperations_Hospital {
    private Connection connection;
    private Statement statement;
    private String connectionUrl = "jdbc:mysql://localhost:3306/doctor_appointment";

    public DatabaseOperations_Hospital() throws SQLException {
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

    public void addHospital(int HospitalId, String Location) {
        String sql = "INSERT INTO hospital(HospitalId,Location) VALUES(?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setInt(1, HospitalId);
            preparedStatement.setString(2, Location);

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

    public void updateHospital(int HospitalId, String Location)
    {
        String sql = "UPDATE hospital SET Location=? WHERE HospitalId=?";
        PreparedStatement preparedStatement = null;
        try
        {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Location);
            preparedStatement.setInt(2, HospitalId);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Record Updated Successfully");
            } else {
                System.out.println("No record found with HospitalId: " + HospitalId);
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


    public void deleteHospital(int HospitalId)
    {
        String sql = "DELETE FROM hospital WHERE HospitalId=?";
        PreparedStatement preparedStatement = null;
        try
        {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, HospitalId);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0)
            {
                System.out.println("Record Deleted Successfully");
            }
            else
            {
                System.out.println("No record found with HospitalId: " + HospitalId);
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



