package Doctor_Appointment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel_Appoint extends JPanel
{
    private JButton addButton,updateButton,deleteButton,nextButton,backButton;

    public ButtonPanel_Appoint()
    {
        addButton=new JButton("Add");
        updateButton=new JButton("Update");
        deleteButton=new JButton("Delete");
        nextButton=new JButton("Next");
        backButton=new JButton("Back");

        initializeUI();
    }

    private void initializeUI()
    {
        setBackground(new Color(45, 149, 150));
        InputPanel_Appoint inputPanel=new InputPanel_Appoint();
        JTextField PatientIdField = inputPanel.getPatientIdField();
        JTextField ClinicIdField = inputPanel.getClinicIdField();
        JTextField PayDateField = inputPanel.getPayDateField();
        JTextField PayDescriptionField=inputPanel.getPayDescriptionField();
        JComboBox PayTypeBox=inputPanel.getPayTypeBox();

        addButton.addActionListener(new ActionListener() {
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
