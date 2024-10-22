package Doctor_Appointment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class MainScreen_Clinic extends JFrame
{
    private JPanel titleBar;
    private JPanel inputPanel;
    private JPanel buttonPanel;
    private JPanel tablePanel;
    private JButton addButton,updateButton,deleteButton,nextButton,backButton;

    public MainScreen_Clinic() throws HeadlessException
    {
        this("Select a Clinic Application");
    }

    public MainScreen_Clinic(String title) throws HeadlessException
    {
        super(title);
        titleBar=new TitlePanel_Clinic();
        inputPanel=new InputPanel_Clinic();
        tablePanel=new DatabaseTablePanel_Clinic();

        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        updateButton = new JButton("Update");
        nextButton=new JButton("Next");
        backButton=new JButton("Back");

        initializeUI();
    }

    private void initializeUI()
    {
        Container container=getContentPane();
        container.setLayout(new BorderLayout());
        JPanel titleBarAndInputPanel = new JPanel();

        //Creates a new panel to include title panel and input panel
        titleBarAndInputPanel.setLayout(new BorderLayout());
        titleBarAndInputPanel.add(titleBar,BorderLayout.NORTH);
        titleBarAndInputPanel.add(inputPanel,BorderLayout.CENTER);

        container.add(titleBarAndInputPanel,BorderLayout.NORTH);

        container.add(tablePanel,BorderLayout.CENTER);

        //Adding button panel to south
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(backButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> ClinicIdComboBox = new JComboBox<>();
                JTextField AppointmentDateTextField = new JTextField();
                JComboBox<String> DoctorIdComboBox=new JComboBox<>();
                JComboBox<String> HospitalIdComboBox=new JComboBox<>();

                //Created a component array
                //Inside this array it has 10 components(5 ComboBoxes & 5 Labels)
                Component[] components = inputPanel.getComponents();
                for (Component cmp : components)
                {
                    if (cmp instanceof JComboBox<?> && cmp.getName().equals("ClinicIdBoxName"))
                    {
                        ClinicIdComboBox = (JComboBox<String>) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("AppointmentDateFieldName"))
                    {
                        AppointmentDateTextField = (JTextField) cmp;
                    }
                    else if (cmp instanceof JComboBox<?> && cmp.getName().equals("DoctorIdBoxName"))
                    {
                        DoctorIdComboBox=(JComboBox<String>) cmp;
                    }
                    else if (cmp instanceof JComboBox<?> && cmp.getName().equals("HospitalIdBoxName"))
                    {
                        HospitalIdComboBox=(JComboBox<String>) cmp;
                    }
                }

                if (ClinicIdComboBox.getSelectedItem() == null || AppointmentDateTextField.getText().isEmpty() ||
                        DoctorIdComboBox.getSelectedItem()==null || HospitalIdComboBox.getSelectedItem()==null)
                {
                    JOptionPane.showMessageDialog(buttonPanel, "All fields must be filled");
                }
                else
                {
                    System.out.println(ClinicIdComboBox.getSelectedItem());
                    System.out.println(AppointmentDateTextField.getText());
                    System.out.println(DoctorIdComboBox.getSelectedItem());
                    System.out.println(HospitalIdComboBox.getSelectedItem());

                    try
                    {
                        int ClinicId = Integer.parseInt(ClinicIdComboBox.getSelectedItem().toString().trim());
                        Date AppointmentDate = Date.valueOf(AppointmentDateTextField.getText().toString().trim());
                        int DoctorId= Integer.parseInt(DoctorIdComboBox.getSelectedItem().toString().trim());
                        int HospitalId= Integer.parseInt(HospitalIdComboBox.getSelectedItem().toString().trim());

                        DatabaseOperations_Clinic databaseOperationsClinic = new DatabaseOperations_Clinic();
                        databaseOperationsClinic.addClinic(ClinicId,AppointmentDate,DoctorId,HospitalId);

                        JOptionPane.showMessageDialog(tablePanel, "Details added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                    }
                    catch (SQLException ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JComboBox<String> ClinicIdComboBox = new JComboBox<>();
                JTextField AppointmentDateTextField = new JTextField();
                JComboBox<String> DoctorIdComboBox=new JComboBox<>();
                JComboBox<String> HospitalIdComboBox=new JComboBox<>();

                // Created a component array
                // Inside this array, it has 10 components(5 ComboBoxes & 5 Labels)
                Component[] components = inputPanel.getComponents();
                for (Component cmp : components)
                {
                    if (cmp instanceof JComboBox<?> && cmp.getName().equals("ClinicIdBoxName"))
                    {
                        ClinicIdComboBox = (JComboBox<String>) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("AppointmentDateFieldName"))
                    {
                        AppointmentDateTextField = (JTextField) cmp;
                    }
                    else if (cmp instanceof JComboBox<?> && cmp.getName().equals("DoctorIdBoxName"))
                    {
                        DoctorIdComboBox=(JComboBox<String>) cmp;
                    }
                    else if (cmp instanceof JComboBox<?> && cmp.getName().equals("HospitalIdBoxName"))
                    {
                        HospitalIdComboBox=(JComboBox<String>) cmp;
                    }
                }

                try
                {
                    int ClinicId = Integer.parseInt(ClinicIdComboBox.getSelectedItem().toString().trim());
                    Date updatedAppointmentDate=Date.valueOf(AppointmentDateTextField.getText().toString().trim());
                    int updatedDoctorId = Integer.parseInt(DoctorIdComboBox.getSelectedItem().toString().trim());
                    int updatedHospitalId = Integer.parseInt(HospitalIdComboBox.getSelectedItem().toString().trim());

                    // Get other updated values (if any)

                    DatabaseOperations_Clinic databaseOperationsClinic = new DatabaseOperations_Clinic();
                    databaseOperationsClinic.updateClinic(ClinicId, updatedAppointmentDate, updatedDoctorId,updatedHospitalId);

                    JOptionPane.showMessageDialog(tablePanel, "Details updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JComboBox<String> ClinicIdComboBox = new JComboBox<>();

                // Created a component array
                // Inside this array, it has 10 components(5 ComboBoxes & 5 Labels)
                Component[] components = inputPanel.getComponents();
                for (Component cmp : components)
                {
                    if (cmp instanceof JComboBox<?> && cmp.getName().equals("ClinicIdBoxName"))
                    {
                        ClinicIdComboBox = (JComboBox<String>) cmp;
                    }
                }
                try
                {
                    int ClinicId = Integer.parseInt(ClinicIdComboBox.getSelectedItem().toString().trim());

                    DatabaseOperations_Clinic databaseOperationsClinic = new DatabaseOperations_Clinic();
                    databaseOperationsClinic.deleteClnic(ClinicId);

                    JOptionPane.showMessageDialog(tablePanel, "Details deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        });

        // Handling next button event to switch to the next form
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switching to the next form (replace NextForm with your actual next form)
                MainScreen_Appoint nextForm = new MainScreen_Appoint();
                nextForm.setVisible(true);
            }
        });

        // Handling next button event to switch to the next form
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switching to the next form (replace NextForm with your actual next form)
                HomePage backForm = new HomePage();
                backForm.setVisible(true);
            }
        });

        container.add(buttonPanel,BorderLayout.SOUTH);


        setSize(1300,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new MainScreen_Clinic();
    }
}
