package Doctor_Appointment;

import java.sql.*;

public class DatabaseOperations_Doctor {
    private Connection connection;
    private Statement statement;
    private String connectionUrl = "jdbc:mysql://localhost:3306/doctor_appointment";

    public DatabaseOperations_Doctor() throws SQLException {
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

    public void addDoctor(int DoctorId, String DoctorName, String Specialization) {
        String sql = "INSERT INTO doctor(DoctorId,DoctorName,Specialization) VALUES(?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setInt(1, DoctorId);
            preparedStatement.setString(2, DoctorName);
            preparedStatement.setString(3, Specialization);

            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Record Inserted Successfully");
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
    public void updateDoctor(int DoctorId, String DoctorName, String Specialization) {
        String sql = "UPDATE doctor SET DoctorName=?, Specialization=? WHERE DoctorId=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, DoctorName);
            preparedStatement.setString(2, Specialization);
            preparedStatement.setInt(3, DoctorId);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Record Updated Successfully");
            } else {
                System.out.println("No record found with DoctorId: " + DoctorId);
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

    public void deleteDoctor(int DoctorId)
    {
        String sql = "DELETE FROM doctor WHERE DoctorId=?";
        PreparedStatement preparedStatement = null;
        try
        {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, DoctorId);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0)
            {
                System.out.println("Record Deleted Successfully");
            }
            else
            {
                System.out.println("No record found with DoctorId: " + DoctorId);
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


