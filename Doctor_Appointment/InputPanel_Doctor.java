package Doctor_Appointment;

import javax.swing.*;
import java.awt.*;

public class InputPanel_Doctor extends JPanel
{
    private JLabel DoctorId,DoctorName,Specialization;

    private JComboBox DoctorIdBox,DoctorNameBox,SpecializationBox;

    public InputPanel_Doctor()
    {
        setLayout(new GridLayout(3,2,5,10));
        DoctorId=new JLabel("Doctor ID:");
        DoctorName=new JLabel("Doctor Name:");
        Specialization=new JLabel("Specialization:");

        DoctorIdBox=new JComboBox<>();
        DoctorIdBox.setName("DoctorIdBoxName");

        DoctorNameBox=new JComboBox<>();
        DoctorNameBox.setName("DoctorNameBoxName");

        SpecializationBox=new JComboBox<>();
        SpecializationBox.setName("SpecializationBoxName");

        // Add components in reverse order
        add(DoctorId);
        add(DoctorIdBox);
        add(DoctorName);
        add(DoctorNameBox);
        add(Specialization);
        add(SpecializationBox);

        // Add items to combo boxes
        Integer[] doctorIds = { 1001,1002,1003,1004,1005,1006,1007,1008,1009,1010,1011,1012,1013,1014,1015};
        String[] doctorNames = { "Dr.Joong Archen","Dr.Bright Wachiravit","Dr.Win Metawin","Dr.Gemini Norawit","Dr.Net Sirapop",
        "Dr.Dunk Natachai","Dr.James Su","Dr.Jeon Jungkook","Dr.Park Jimin","Dr.Kim Namjoon","Dr.Kim Taehyung","Dr.Min Yoongi",
        "Dr.Jung Haesok","Dr.Kim Seokjin","DR.Boun Nappanut"};
        String[] specializations = { "Eye","Pediatrics","Cardiology","Allergy & Immunology","Anesthesiology","Colon and Rectal Surgery",
        "Dermatology","Neurology","Child Neurology","Radiology","Psychiatrist","Oncologist","Pediatrician","Internal Medicine",
        "Dentist","General Physician"};

        for (Integer id : doctorIds)
        {
            DoctorIdBox.addItem(id);
        }
        for (String name : doctorNames)
        {
            DoctorNameBox.addItem(name);
        }
        for (String spec : specializations)
        {
            SpecializationBox.addItem(spec);
        }

    }

    //Define getters to get these values out

    public JComboBox getDoctorIdBox()
    {
        return DoctorIdBox;
    }

    public JComboBox getDoctorNameBox()
    {
        return DoctorNameBox;
    }

    public JComboBox getSpecializationBox()
    {
        return SpecializationBox;
    }
}

