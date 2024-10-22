package Doctor_Appointment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainScreen_Doctor extends JFrame
{
    private JPanel titleBar;
    private JPanel inputPanel;
    private JPanel buttonPanel;
    private JPanel tablePanel;
    private JButton addButton,updateButton,deleteButton,nextButton,backButton;

    public MainScreen_Doctor() throws HeadlessException
    {
        this("Select a doctor Application");
    }

    public MainScreen_Doctor(String title) throws HeadlessException
    {
        super(title);
        titleBar=new TitlePanel_Doctor();
        inputPanel=new InputPanel_Doctor();
        tablePanel=new DatabaseTablePanel_Doctor();

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
                JComboBox<String> DoctorIdComboBox = new JComboBox<>();
                JComboBox<String> DoctorNameComboBox = new JComboBox<>();
                JComboBox<String> SpecializationComboBox=new JComboBox<>();

                //Created a component array
                //Inside this array it has 10 components(5 ComboBoxes & 5 Labels)
                Component[] components = inputPanel.getComponents();
                for (Component cmp : components)
                {
                    if (cmp instanceof JComboBox<?> && cmp.getName().equals("DoctorIdBoxName"))
                    {
                        DoctorIdComboBox = (JComboBox<String>) cmp;
                    }
                    else if (cmp instanceof JComboBox<?> && cmp.getName().equals("DoctorNameBoxName"))
                    {
                        DoctorNameComboBox = (JComboBox<String>) cmp;
                    }
                    else if (cmp instanceof JComboBox<?> && cmp.getName().equals("SpecializationBoxName"))
                    {
                        SpecializationComboBox=(JComboBox<String>) cmp;
                    }
                }

                if (DoctorIdComboBox.getSelectedItem() == null || DoctorNameComboBox.getSelectedItem() == null ||
                        SpecializationComboBox.getSelectedItem()==null)
                {
                    JOptionPane.showMessageDialog(buttonPanel, "All fields must be filled");
                }
                else
                {
                    System.out.println(DoctorIdComboBox.getSelectedItem());
                    System.out.println(DoctorNameComboBox.getSelectedItem());
                    System.out.println(SpecializationComboBox.getSelectedItem());

                    try
                    {
                        int DoctorId = Integer.parseInt(DoctorIdComboBox.getSelectedItem().toString().trim());
                        String DoctorName = DoctorNameComboBox.getSelectedItem().toString().trim();
                        String Specialization=SpecializationComboBox.getSelectedItem().toString().trim();

                        DatabaseOperations_Doctor databaseOperationsDoctor = new DatabaseOperations_Doctor();
                        databaseOperationsDoctor.addDoctor(DoctorId, DoctorName,Specialization);

                        JOptionPane.showMessageDialog(tablePanel, "Details added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                    }
                    catch (SQLException ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Handling next button event to switch to the next form
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switching to the next form (replace NextForm with your actual next form)
                MainScreen_Hospital nextForm = new MainScreen_Hospital();
                nextForm.setVisible(true);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JComboBox<String> DoctorIdComboBox = new JComboBox<>();
                JComboBox<String> DoctorNameComboBox = new JComboBox<>();
                JComboBox<String> SpecializationComboBox = new JComboBox<>();

                // Created a component array
                // Inside this array, it has 10 components(5 ComboBoxes & 5 Labels)
                Component[] components = inputPanel.getComponents();
                for (Component cmp : components)
                {
                    if (cmp instanceof JComboBox<?> && cmp.getName().equals("DoctorIdBoxName"))
                    {
                        DoctorIdComboBox = (JComboBox<String>) cmp;
                    }
                    else if (cmp instanceof JComboBox<?> && cmp.getName().equals("DoctorNameBoxName"))
                    {
                        DoctorNameComboBox = (JComboBox<String>) cmp;
                    }
                    else if (cmp instanceof JComboBox<?> && cmp.getName().equals("SpecializationBoxName"))
                    {
                        SpecializationComboBox = (JComboBox<String>) cmp;
                    }
                }

                try
                {
                    int DoctorId = Integer.parseInt(DoctorIdComboBox.getSelectedItem().toString().trim());
                    String updatedDoctorName = DoctorNameComboBox.getSelectedItem().toString().trim();
                    String updatedSpecialization = SpecializationComboBox.getSelectedItem().toString().trim();

                    // Get other updated values (if any)

                    DatabaseOperations_Doctor databaseOperationsDoctor = new DatabaseOperations_Doctor();
                    databaseOperationsDoctor.updateDoctor(DoctorId, updatedDoctorName, updatedSpecialization);

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
                JComboBox<String> DoctorIdComboBox = new JComboBox<>();

                // Created a component array
                // Inside this array, it has 10 components(5 ComboBoxes & 5 Labels)
                Component[] components = inputPanel.getComponents();
                for (Component cmp : components)
                {
                    if (cmp instanceof JComboBox<?> && cmp.getName().equals("DoctorIdBoxName"))
                    {
                        DoctorIdComboBox = (JComboBox<String>) cmp;
                    }
                }
                try
                {
                    int DoctorId = Integer.parseInt(DoctorIdComboBox.getSelectedItem().toString().trim());

                    DatabaseOperations_Doctor databaseOperationsDoctor = new DatabaseOperations_Doctor();
                    databaseOperationsDoctor.deleteDoctor(DoctorId);

                    JOptionPane.showMessageDialog(tablePanel, "Details deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
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
        new MainScreen_Doctor();
    }
}
