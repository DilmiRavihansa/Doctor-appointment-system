package Doctor_Appointment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel_Patient extends JPanel
{
    private JButton addButton,deleteButton,updateButton,nextButton,backButton;

    public ButtonPanel_Patient()
    {
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        updateButton = new JButton("Update");
        nextButton=new JButton("Next");
        backButton=new JButton("Back");
        initializeUI();
    }
    private void initializeUI()
    {
        setBackground(new Color(40,50,60));
        InputPanel_Patient inputPanel = new InputPanel_Patient();
       // JTextField patientIdField = inputPanel.getPatientIdField();
        JTextField FirstNameField = inputPanel.getFirstNameField();
        JTextField LastNameField = inputPanel.getLastNameField();
        JTextField ageField = inputPanel.getAgeField();
        JTextField patientAddressField = inputPanel.getPatientAddressField();
        JTextField contactNoField=inputPanel.getContactNoField();

        addButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Add Button Clicked");
            }
        });
        add(addButton);
        add(updateButton);
        add(deleteButton);
        add(nextButton);
        add(backButton);
    }
}
