package Doctor_Appointment;

import java.sql.*;

public class DatabaseOperations_Appoint
{
    private Connection connection;
    private Statement statement;
    private String connectionUrl="jdbc:mysql://localhost:3306/doctor_appointment";

    public DatabaseOperations_Appoint() throws SQLException
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

    public void addAppoint(Date PayDate,String PayDescription,String PayType,int PatientId,int ClinicId)
    {
        String sql="INSERT INTO appointment(PayDate,PayDescription,PayType,PatientId,ClinicId) VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement=null;
        try
        {
            preparedStatement=connection.prepareStatement(sql.toString());
            preparedStatement.setDate(1,PayDate);
            preparedStatement.setString(2,PayDescription);
            preparedStatement.setString(3,PayType);
            preparedStatement.setInt(4,PatientId);
            preparedStatement.setInt(5,ClinicId);

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
    public void updateAppoint(Date PayDate,String PayDescription,String PayType,int PatientId,int ClinicId)
    {
        String sql = "UPDATE appointment SET PayDate=?, PayDescription=?, PayType=?, ClinicId=? WHERE PatientId=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, PayDate);
            preparedStatement.setString(2, PayDescription);
            preparedStatement.setString(3, PayType);
            preparedStatement.setInt(4, ClinicId);
            preparedStatement.setInt(5, PatientId);

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

    public void deleteAppoint(int PatientId)
    {
        String sql = "DELETE FROM appointment WHERE PatientId=?";
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


