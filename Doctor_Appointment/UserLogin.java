package Doctor_Appointment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UserLogin extends JFrame {
    private JPanel panel;
    private JLabel lblUserName, lblPassword;
    private JTextField txtUserName;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public UserLogin()
    {
        setTitle("User Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 700);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        panel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon img = new ImageIcon("C:\\EAD\\Java Exersices\\doctorApp.jpg");
                g.drawImage(img.getImage(), 0, 0, 1500, 800, null);

                JLabel titleLabel = new JLabel("User Login");
                titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
                titleLabel.setHorizontalAlignment(JLabel.CENTER);
                titleLabel.setVerticalAlignment(JLabel.TOP);
                titleLabel.setForeground(Color.WHITE);
                titleLabel.setBounds(400, 50, 450, 100);
                panel.add(titleLabel);
            }
        };
        panel.setBounds(0, 0, 1500, 800);
        getContentPane().add(panel);
        panel.setLayout(null);


        lblUserName = new JLabel("User Name:");
        lblUserName.setBounds(50, 150, 100, 30);
        lblUserName.setFont(new Font("Serif", Font.BOLD, 18));
        lblUserName.setForeground(Color.WHITE); // Set font color to Black
        panel.add(lblUserName);

        txtUserName = new JTextField();
        txtUserName.setBounds(200, 150, 300, 30);
        panel.add(txtUserName);

        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 200, 100, 30);
        lblPassword.setFont(new Font("Serif", Font.BOLD, 18));
        lblPassword.setForeground(Color.WHITE); // Set font color to Black
        panel.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(200, 200, 300, 30);
        panel.add(txtPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(200, 250, 100, 30);
        btnLogin.setForeground(Color.BLACK);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                loginUser();
            }
        });pr
        btnLogin.setForeground(Color.BLACK); // Set font color to white
        panel.add(btnLogin);
    }

    private void loginUser()
    {
        String UserName = txtUserName.getText();
        String password = new String(txtPassword.getPassword());

        //Validate input fields
        if (UserName.isEmpty()  || password.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor_appointment", "root", "123");
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM user WHERE UserName='" + UserName + "' AND Pswrd='" + password + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next())
            {
                JOptionPane.showMessageDialog(this, "Login is successfully.");

                // Proceed to the next form (replace MainScreen_Patient with your actual next form)
                HomePage homePage = new HomePage();
                homePage.setVisible(true);

                // Close the current registration form
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Invalid User Name or password.");
            }

        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserLogin userLogin = new UserLogin();
            userLogin.setVisible(true);
        });
    }
}
