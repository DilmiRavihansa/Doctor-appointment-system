package Doctor_Appointment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel_Clinic extends JPanel
{
    private JButton addButton,updateButton,deleteButton,nextButton,backButton;

    public ButtonPanel_Clinic()
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
        setBackground(new Color(40,50,60));
        InputPanel_Clinic inputPanel=new InputPanel_Clinic();
        JComboBox ClinicIdBox = inputPanel.getClinicIdBox();
        JTextField AppointmentDateField = inputPanel.getAppointmentDateField();
        JComboBox DoctorIdBox = inputPanel.getDoctorIdBox();
        JComboBox HospitalIdBox=inputPanel.getHospitalIdBox();

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
