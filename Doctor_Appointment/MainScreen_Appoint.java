package Doctor_Appointment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class MainScreen_Appoint extends JFrame
{
    private JPanel titleBar;
    private JPanel inputPanel;
    private  JPanel buttonPanel;
    private JPanel tablePanel;

    private JButton addButton,updateButton,deleteButton,nextButton,backButton;

    public MainScreen_Appoint() throws HeadlessException
    {
        this("Appointment");
    }

    public MainScreen_Appoint(String title) throws HeadlessException
    {
        super(title);
        titleBar=new TitlePanel_Appoint();
        inputPanel=new InputPanel_Appoint();
        tablePanel=new DatabaseTablePanel_Appoint();

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
                JTextField ClinicIdTextField=new JTextField();
                JTextField PayDateTextField=new JTextField();
                JTextField PayDesTextField=new JTextField();
                JComboBox<String> PayTypeComboBox=new JComboBox<>();

                //Created a component array
                //Inside this array it have 10 components(5 textFields & 5 Labels)
                Component[] components=inputPanel.getComponents();
                for (Component cmp:components)
                {
                    if (cmp instanceof JTextField && cmp.getName().equals("PatientIdFieldName"))
                    {
                        PatientIdTextField= (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("ClinicIdFieldName"))
                    {
                        ClinicIdTextField= (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("PayDateFieldName"))
                    {
                        PayDateTextField= (JTextField) cmp;
                    }
                    else if (cmp instanceof JTextField && cmp.getName().equals("PayDesFieldName"))
                    {
                        PayDesTextField= (JTextField) cmp;
                    }
                    else if (cmp instanceof JComboBox<?> && cmp.getName().equals("PayTypeBoxName"))
                    {
                        PayTypeComboBox= (JComboBox<String>) cmp;
                    }
                }
                if (PatientIdTextField.getText().isEmpty() || ClinicIdTextField.getText().isEmpty() || PayDateTextField.getText().isEmpty() ||
                        PayDesTextField.getText().isEmpty() || PayTypeComboBox.getSelectedItem()==null)
                {
                    JOptionPane.showMessageDialog(buttonPanel,"All fields must be filled");
                }
                else
                {
                    System.out.println(PatientIdTextField.getText());
                    System.out.println(ClinicIdTextField.getText());
                    System.out.println(PayDateTextField.getText());
                    System.out.println(PayDesTextField.getText());
                    System.out.println(PayTypeComboBox.getSelectedItem());
                    try
                    {
                        int PatientId= Integer.parseInt(PatientIdTextField.getText().trim());
                        //Triming means reserving extra spaces
                        int ClinicId= Integer.parseInt(ClinicIdTextField.getText().trim());
                        Date PayDate = Date.valueOf(PayDateTextField.getText().toString().trim());
                        String PayDescription=PayDesTextField.getText().trim();
                        String PayType=PayTypeComboBox.getSelectedItem().toString().trim();

                        DatabaseOperations_Appoint databaseOperationsAppoint=new DatabaseOperations_Appoint();
                        databaseOperationsAppoint.addAppoint(PayDate,PayDescription,PayType,PatientId,ClinicId);

                        JOptionPane.showMessageDialog(tablePanel, "Appointment successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

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
                JTextField PatientIdTextField = new JTextField();
                JTextField ClinicIdTextField = new JTextField();
                JTextField PayDateTextField = new JTextField();
                JTextField PayDesTextField = new JTextField();
                JComboBox<String> PayTypeComboBox = new JComboBox<>();

                //Created a component array
                //Inside this array it have 10 components(5 textFields & 5 Labels)
                Component[] components = inputPanel.getComponents();
                for (Component cmp : components) {
                    if (cmp instanceof JTextField && cmp.getName().equals("PatientIdFieldName")) {
                        PatientIdTextField = (JTextField) cmp;
                    } else if (cmp instanceof JTextField && cmp.getName().equals("ClinicIdFieldName")) {
                        ClinicIdTextField = (JTextField) cmp;
                    } else if (cmp instanceof JTextField && cmp.getName().equals("PayDateFieldName")) {
                        PayDateTextField = (JTextField) cmp;
                    } else if (cmp instanceof JTextField && cmp.getName().equals("PayDesFieldName")) {
                        PayDesTextField = (JTextField) cmp;
                    } else if (cmp instanceof JComboBox<?> && cmp.getName().equals("PayTypeBoxName")) {
                        PayTypeComboBox = (JComboBox<String>) cmp;
                    }
                }
                try
                {
                    int PatientId = Integer.parseInt(PatientIdTextField.getText().trim());
                    //Triming means reserving extra spaces
                    int updatedClinicId = Integer.parseInt(ClinicIdTextField.getText().trim());
                    Date updatedPayDate = Date.valueOf(PayDateTextField.getText().toString().trim());
                    String updatedPayDescription = PayDesTextField.getText().trim();
                    String updatedPayType = PayTypeComboBox.getSelectedItem().toString().trim();

                    DatabaseOperations_Appoint databaseOperationsAppoint = new DatabaseOperations_Appoint();
                    databaseOperationsAppoint.updateAppoint(updatedPayDate, updatedPayDescription, updatedPayType, PatientId, updatedClinicId);
                    JOptionPane.showMessageDialog(tablePanel, "Appointment Updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

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
                JTextField PatientIdTextField = new JTextField();

                //Created a component array
                //Inside this array it have 10 components(5 textFields & 5 Labels)
                Component[] components = inputPanel.getComponents();
                for (Component cmp : components)
                {
                    if (cmp instanceof JTextField && cmp.getName().equals("PatientIdFieldName"))
                    {
                        PatientIdTextField = (JTextField) cmp;
                    }
                }
                try
                {
                    int PatientId = Integer.parseInt(PatientIdTextField.getText().trim());

                    DatabaseOperations_Appoint databaseOperationsAppoint = new DatabaseOperations_Appoint();
                    databaseOperationsAppoint.deleteAppoint(PatientId);

                    JOptionPane.showMessageDialog(tablePanel, "Appointment deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

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
                HomePage nextForm = new HomePage();
                nextForm.setVisible(true);
            }
        });

        // Handling next button event to switch to the next form
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
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
        new MainScreen_Appoint();
    }
}