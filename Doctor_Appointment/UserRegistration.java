package Doctor_Appointment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRegistration extends JFrame {
    private JPanel panel;
    private JLabel lblUserName, lblEmail, lblPassword;
    private JTextField txtUserName, txtEmail;
    private JPasswordField txtPassword;
    private JButton btnRegister;

    public UserRegistration()
    {
        setTitle("User Registration");
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

                JLabel titleLabel = new JLabel("User Registration");
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
        lblUserName.setForeground(Color.white); // Set font color to white
        panel.add(lblUserName);

        txtUserName = new JTextField();
        txtUserName.setBounds(200, 150, 300, 30);
        panel.add(txtUserName);

        lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50, 200, 100, 30);
        lblEmail.setFont(new Font("Serif", Font.BOLD, 18));
        lblEmail.setForeground(Color.white); // Set font color to white
        panel.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(200, 200, 300, 30);
        panel.add(txtEmail);

        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 250, 100, 30);
        lblPassword.setFont(new Font("Serif", Font.BOLD, 18));
        lblPassword.setForeground(Color.white); // Set font color to white
        panel.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(200, 250, 300, 30);
        panel.add(txtPassword);

        btnRegister = new JButton("Register");
        btnRegister.setBounds(200, 300, 100, 30);
        btnRegister.setForeground(Color.white);

        btnRegister.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                registerUser();
            }
        });
        btnRegister.setForeground(Color.BLACK); // Set font color to white
        panel.add(btnRegister);
    }

    private void registerUser() {
        String Username = txtUserName.getText();
        String Email = txtEmail.getText();
        String password = new String(txtPassword.getPassword());

        //Validate input fields
        if (Username.isEmpty() || Email.isEmpty() || password.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Additional email validation
        if (!isValidEmail(Email))
        {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor_appointment", "root", "123");
            Statement stmt = con.createStatement();
            String query = "INSERT INTO User (UserName, Email, Pswrd) VALUES ('" + Username + "', '" + Email + "','" + password + "')";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(this, "User registered successfully.");

            // Proceed to the next form (replace MainScreen_Patient with your actual next form)
            UserLogin userLogin = new UserLogin();
            userLogin.setVisible(true);

            // Close the current registration form
            dispose();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
    // Email validation method
    private boolean isValidEmail(String Email)
    {
        // Add your email validation logic here
        // Example: Using a simple regex for demonstration
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Email.matches(emailRegex);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserRegistration registration = new UserRegistration();
            registration.setVisible(true);
        });
    }
}