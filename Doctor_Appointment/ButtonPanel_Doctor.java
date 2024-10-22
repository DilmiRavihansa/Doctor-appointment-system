package Doctor_Appointment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel_Doctor extends JPanel
{
    private JButton addButton,updateButton,deleteButton,nextButton,backButton;

    public ButtonPanel_Doctor()
    {
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        nextButton = new JButton("Next");
        backButton=new JButton("Back");
        initializeUI();
    }

    private void initializeUI()
    {
        setBackground(new Color(40,50,60));
        InputPanel_Doctor inputPanel = new InputPanel_Doctor();
        JComboBox DoctorIdBox = inputPanel.getDoctorIdBox();
        JComboBox DoctorNameBox = inputPanel.getDoctorNameBox();
        JComboBox SpecializationBox = inputPanel.getSpecializationBox();

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
