package Doctor_Appointment;

import java.sql.*;

public class DatabaseOperations_Clinic
{
    private Connection connection;
    private Statement statement;
    private String connectionUrl="jdbc:mysql://localhost:3306/doctor_appointment";

    public DatabaseOperations_Clinic() throws SQLException
    {
        connect();
    }
    private void connect() throws SQLException
    {
        try
        {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            this.connection= DriverManager.getConnection(connectionUrl,"root","123");
            this.statement= this.connection.createStatement();
            System.out.println("Database Connected....");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void addClinic(int ClinicId,Date AppointmentDate,int DoctorId,int HospitalId)
    {
        String sql="INSERT INTO clnic(ClinicId,AppointmentDate,DoctorId,HospitalId) VALUES(?,?,?,?)";
        PreparedStatement preparedStatement=null;
        try
        {
            preparedStatement=connection.prepareStatement(sql.toString());
            preparedStatement.setInt(1,ClinicId);
            preparedStatement.setDate(2,AppointmentDate);
            preparedStatement.setInt(3,DoctorId);
            preparedStatement.setInt(4,HospitalId);

            int rowInserted=preparedStatement.executeUpdate();
            if (rowInserted > 0)
            {
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
    public void updateClinic(int ClinicId, Date AppointmentDate,int DoctorId,int HospitalId)
    {
        String sql = "UPDATE clnic SET AppointmentDate=?, DoctorId=?, HospitalId=? WHERE ClinicId=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, AppointmentDate);
            preparedStatement.setInt(2, DoctorId);
            preparedStatement.setInt(3, HospitalId);
            preparedStatement.setInt(4,ClinicId);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Record Updated Successfully");
            } else {
                System.out.println("No record found with ClinicId: " + ClinicId);
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

    public void deleteClnic(int ClinicId)
    {
        String sql = "DELETE FROM clnic WHERE ClinicId=?";
        PreparedStatement preparedStatement = null;
        try
        {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ClinicId);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0)
            {
                System.out.println("Record Deleted Successfully");
            }
            else
            {
                System.out.println("No record found with ClinicId: " + ClinicId);
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
