package Doctor_Appointment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainScreen_Patient extends JFrame
{
    private JPanel titleBar;
    private JPanel inputPanel;
    private JPanel buttonPanel;
    private JPanel tablePanel;
    private JButton addButton,updateButton,deleteButton,nextButton,backButton;
    private JPanel panel;

    public MainScreen_Patient() throws HeadlessException
    {
        this("Patient List Application");
    }

    public MainScreen_Patient(String title) throws HeadlessException
    {
        super(title);
        titleBar=new TitlePanel_Patient();
        inputPanel=new InputPanel_Patient();
        tablePanel=new DatabaseTablePanel_Patient();

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

        //Handling add event using anonymous class
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField PatientIdTextField=new JTextField();
                JTextField FnameTextField=new JTextField();
                JTextField LnameTextField=new JTextField();
                JTextField AgeTextField=new JTextField();
                JTextField PAddressTextField=new JTextField();
                JTextField ContactTextField=new JTextField();

                //Created a component array
                //Inside this array it have 10 components(5 textFields & 5 Labels)
                Component[] components=inputPanel.getComponents();
                for (Component cmp:components)
                {
                    if (cmp instanceof JTextField && cmp.getName().equals("PatientIdFieldName"))
                    {
                        PatientIdTextField= (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("FirstNameFieldName"))
                    {
                         FnameTextField= (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("LastNameFieldName"))
                    {
                         LnameTextField= (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("ageFieldName"))
                    {
                         AgeTextField= (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("patientAddressFieldName"))
                    {
                         PAddressTextField= (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("contactNoFieldName"))
                    {
                         ContactTextField= (JTextField) cmp;
                    }
                }
                if (PatientIdTextField.getText().isEmpty() ||FnameTextField.getText().isEmpty() || LnameTextField.getText().isEmpty() || AgeTextField.getText().isEmpty() ||
                PAddressTextField.getText().isEmpty() || ContactTextField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(buttonPanel,"All fields must be filled");
                }
                else
                {
                    System.out.println(PatientIdTextField.getText());
                    System.out.println(FnameTextField.getText());
                    System.out.println(LnameTextField.getText());
                    System.out.println(AgeTextField.getText());
                    System.out.println(PAddressTextField.getText());
                    System.out.println(ContactTextField.getText());
                    try
                    {
                        int PatientId= Integer.parseInt(PatientIdTextField.getText().trim());
                        String FirstName=FnameTextField.getText().trim();
                        //Triming means reserving extra spaces
                        String LastName=LnameTextField.getText().trim();
                        int Age= Integer.valueOf(AgeTextField.getText().trim());
                        String PatientAddress=PAddressTextField.getText().trim();
                        int ContactNo=Integer.valueOf(ContactTextField.getText().trim());

                        DatabaseOperations_Patient databaseOperationsPatient=new DatabaseOperations_Patient();
                        databaseOperationsPatient.addPatient(PatientId,FirstName,LastName, Age,PatientAddress,ContactNo);

                        JOptionPane.showMessageDialog(tablePanel, "Patient added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
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
            public void actionPerformed(ActionEvent e) {
                JTextField PatientIdTextField=new JTextField();
                JTextField FnameTextField=new JTextField();
                JTextField LnameTextField=new JTextField();
                JTextField AgeTextField=new JTextField();
                JTextField PAddressTextField=new JTextField();
                JTextField ContactTextField=new JTextField();

                //Created a component array
                //Inside this array it have 10 components(5 textFields & 5 Labels)
                Component[] components=inputPanel.getComponents();
                for (Component cmp:components)
                {
                    if (cmp instanceof JTextField && cmp.getName().equals("PatientIdFieldName"))
                    {
                        PatientIdTextField= (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("FirstNameFieldName"))
                    {
                        FnameTextField= (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("LastNameFieldName"))
                    {
                        LnameTextField= (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("ageFieldName"))
                    {
                        AgeTextField= (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("patientAddressFieldName"))
                    {
                        PAddressTextField= (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("contactNoFieldName"))
                    {
                        ContactTextField= (JTextField) cmp;
                    }
                }
                try
                {
                    int PatientId = Integer.parseInt(PatientIdTextField.getText().toString().trim());
                    String updatedFirstName = FnameTextField.getText().toString().trim();
                    String updatedLastName = LnameTextField.getText().toString().trim();
                    int updatedAge = Integer.parseInt(AgeTextField.getText().toString().trim());
                    String updatedPAddress = PAddressTextField.getText().toString().trim();
                    int updatedContactNo = Integer.parseInt(ContactTextField.getText().toString().trim());

                    // Get other updated values (if any)

                    DatabaseOperations_Patient databaseOperationsPatient = new DatabaseOperations_Patient();
                    databaseOperationsPatient.updatePatient(PatientId, updatedFirstName, updatedLastName,updatedAge,updatedPAddress,updatedContactNo);

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
                JTextField PatientIdTextField = new JTextField();

                //Created a component array
                //Inside this array it have 10 components(5 textFields & 5 Labels)
                Component[] components=inputPanel.getComponents();
                for (Component cmp:components)
                {
                    if (cmp instanceof JTextField && cmp.getName().equals("PatientIdFieldName"))
                    {
                        PatientIdTextField = (JTextField) cmp;
                    }
                }
                try
                {
                    int PatientId = Integer.parseInt(PatientIdTextField.getText().toString().trim());

                    DatabaseOperations_Patient databaseOperationsPatient = new DatabaseOperations_Patient();
                    databaseOperationsPatient.deletePatient(PatientId);

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
            public void actionPerformed(ActionEvent e)
            {
                // Switching to the next form (replace NextForm with your actual next form)
                MainScreen_Doctor nextForm = new MainScreen_Doctor();
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
        new MainScreen_Patient();
    }
}


