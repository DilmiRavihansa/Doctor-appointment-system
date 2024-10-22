package Doctor_Appointment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame
{
    private JButton PatientDetailsButton,DoctorDetailsButton,HospitalDetailsButton,ClinicDetailsButton,
            AppointDetailsButton,btnExit;

    public HomePage()
    {
        setTitle("Home Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 700);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon img = new ImageIcon("C:\\EAD\\Java Exersices\\homwdoc1.jpg");
                g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
            }
        };
        panel.setBounds(0, 0, 1300, 700); // set bounds to match frame size
        getContentPane().add(panel);
        panel.setLayout(null);

        JButton PatientDetailsButton = new JButton("Patient Details");
        PatientDetailsButton.setBounds(130, 100, 160, 40);
        PatientDetailsButton.setForeground(Color.BLACK);
        PatientDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Switching to the next form (replace NextForm with your actual next form)
                MainScreen_Patient mainScreenPatient = new MainScreen_Patient();
                mainScreenPatient.setVisible(true);
            }
        });
        panel.add(PatientDetailsButton);

        JButton DoctorDetailsButton = new JButton("Doctor Details");
        DoctorDetailsButton.setBounds(330, 100, 160, 40);
        DoctorDetailsButton.setForeground(Color.BLACK);
        DoctorDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Switching to the next form (replace NextForm with your actual next form)
                MainScreen_Doctor mainScreenDoctor = new MainScreen_Doctor();
                mainScreenDoctor.setVisible(true);
            }
        });
        panel.add(DoctorDetailsButton);

        JButton HospitalDetailsButton = new JButton("Hospital Details");
        HospitalDetailsButton.setBounds(530, 100, 160, 40);
        HospitalDetailsButton.setForeground(Color.BLACK);
        HospitalDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Switching to the next form (replace NextForm with your actual next form)
                MainScreen_Hospital mainScreenHospital = new MainScreen_Hospital();
                mainScreenHospital.setVisible(true);
            }
        });
        panel.add(HospitalDetailsButton);

        JButton ClinicDetailsButton = new JButton("Clinic Details");
        ClinicDetailsButton.setBounds(730, 100, 160, 40);
        ClinicDetailsButton.setForeground(Color.BLACK);
        ClinicDetailsButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Switching to the next form (replace NextForm with your actual next form)
                MainScreen_Clinic mainScreenClinic = new MainScreen_Clinic();
                mainScreenClinic.setVisible(true);
            }
        });
        panel.add(ClinicDetailsButton);

        JButton AppointDetailsButton = new JButton("Appointment Details");
        AppointDetailsButton.setBounds(930, 100, 160, 40);
        AppointDetailsButton.setForeground(Color.BLACK);
        AppointDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Switching to the next form (replace NextForm with your actual next form)
                MainScreen_Appoint mainScreenAppoint = new MainScreen_Appoint();
                mainScreenAppoint.setVisible(true);
            }
        });
        panel.add(AppointDetailsButton);


        JLabel descriptionLabel = new JLabel("<html><div style='text-align: center;'>The doctor appointment application" +
                " streamlines the scheduling process by allowing users to book, manage, and track medical appointments online."
                + "Patients can easily find available slots, while doctors can efficiently manage their schedules," +
                "enhancing overall healthcare accessibility and efficiency.</div></html>");

        descriptionLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        descriptionLabel.setBounds(300, 500, 700, 100);
        descriptionLabel.setForeground(Color.BLACK);
        panel.add(descriptionLabel);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(600, 610, 100, 30);
        btnExit.setForeground(Color.BLACK);
        btnExit.setVerticalAlignment(JButton.BOTTOM);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        panel.add(btnExit);

        JLabel titleLabel = new JLabel("DOCTOR APPOINTMENT");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBounds(410, 10, 450, 100);
        panel.add(titleLabel);


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomePage homePage = new HomePage();
            homePage.setVisible(true);
        });
    }
}
