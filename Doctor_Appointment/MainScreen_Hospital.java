package Doctor_Appointment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainScreen_Hospital extends JFrame {
    private JPanel titleBar;
    private JPanel inputPanel;
    private JPanel buttonPanel;
    private JPanel tablePanel;
    private JButton addButton, updateButton, deleteButton, nextButton,backButton;

    public MainScreen_Hospital() throws HeadlessException {
        this("Select a Hospital Application");
    }

    public MainScreen_Hospital(String title) throws HeadlessException {
        super(title);
        titleBar = new TitlePanel_Hospital();
        inputPanel = new InputPanel_Hospital();
        tablePanel = new DatabaseTablePanel_Hospital();

        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        updateButton = new JButton("Update");
        nextButton = new JButton("Next");
        backButton=new JButton("Back");

        initializeUI();
    }

    private void initializeUI()
    {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JPanel titleBarAndInputPanel = new JPanel();

        titleBarAndInputPanel.setLayout(new BorderLayout());
        titleBarAndInputPanel.add(titleBar, BorderLayout.NORTH);
        titleBarAndInputPanel.add(inputPanel, BorderLayout.CENTER);

        container.add(titleBarAndInputPanel, BorderLayout.NORTH);
        container.add(tablePanel, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(backButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JComboBox<String> HospitalIdComboBox = new JComboBox<>();
                JComboBox<String> LocationComboBox = new JComboBox<>();

                //Created a component array
                //Inside this array it has 10 components(5 ComboBoxes & 5 Labels)
                Component[] components = inputPanel.getComponents();
                for (Component cmp : components)
                {
                    if (cmp instanceof JComboBox<?> && cmp.getName().equals("HospitalIdBoxName"))
                    {
                        HospitalIdComboBox = (JComboBox<String>) cmp;
                    }
                    else if (cmp instanceof JComboBox<?> && cmp.getName().equals("LocationBoxName"))
                    {
                        LocationComboBox = (JComboBox<String>) cmp;
                    }
                }

                if (HospitalIdComboBox.getSelectedItem() == null || LocationComboBox.getSelectedItem() == null)
                {
                    JOptionPane.showMessageDialog(buttonPanel, "All fields must be filled");
                }
                else
                {
                    System.out.println(HospitalIdComboBox.getSelectedItem());
                    System.out.println(LocationComboBox.getSelectedItem());

                    try
                    {
                        int HospitalId = Integer.parseInt(HospitalIdComboBox.getSelectedItem().toString().trim());
                        String Location = LocationComboBox.getSelectedItem().toString().trim();

                        DatabaseOperations_Hospital databaseOperationsHospital = new DatabaseOperations_Hospital();
                        databaseOperationsHospital.addHospital(HospitalId, Location);

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
                JComboBox<String> HospitalIdComboBox = new JComboBox<>();
                JComboBox<String> LocationComboBox = new JComboBox<>();

                // Created a component array
                // Inside this array, it has 10 components(5 ComboBoxes & 5 Labels)
                Component[] components = inputPanel.getComponents();
                for (Component cmp : components)
                {
                    if (cmp instanceof JComboBox<?> && cmp.getName().equals("HospitalIdBoxName"))
                    {
                        HospitalIdComboBox = (JComboBox<String>) cmp;
                    }
                    else if (cmp instanceof JComboBox<?> && cmp.getName().equals("LocationBoxName"))
                    {
                        LocationComboBox = (JComboBox<String>) cmp;
                    }
                }
                try
                {

                    int HospitalId = Integer.parseInt(HospitalIdComboBox.getSelectedItem().toString().trim());
                    String updatedLocation = LocationComboBox.getSelectedItem().toString().trim();

                    // Get other updated values (if any)

                    DatabaseOperations_Hospital databaseOperationsHospital = new DatabaseOperations_Hospital();
                    databaseOperationsHospital.updateHospital(HospitalId, updatedLocation);

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
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> HospitalIdComboBox = new JComboBox<>();

                // Created a component array
                // Inside this array, it has 10 components(5 ComboBoxes & 5 Labels)
                Component[] components = inputPanel.getComponents();
                for (Component cmp : components) {
                    if (cmp instanceof JComboBox<?> && cmp.getName().equals("HospitalIdBoxName")) {
                        HospitalIdComboBox = (JComboBox<String>) cmp;
                    }
                }
                try {
                    int HospitalId = Integer.parseInt(HospitalIdComboBox.getSelectedItem().toString().trim());

                    DatabaseOperations_Hospital databaseOperationsHospital = new DatabaseOperations_Hospital();
                    databaseOperationsHospital.deleteHospital(HospitalId);

                    JOptionPane.showMessageDialog(tablePanel, "Details deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Handling next button event to switch to the next form
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switching to the next form (replace NextForm with your actual next form)
                MainScreen_Clinic nextForm = new MainScreen_Clinic();
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


        container.add(buttonPanel, BorderLayout.SOUTH);

        setSize(1300, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new MainScreen_Hospital();
    }
}
