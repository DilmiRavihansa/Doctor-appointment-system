package Doctor_Appointment;

import javax.swing.*;
import java.awt.*;

public class InputPanel_Clinic extends JPanel
{
    private JLabel ClinicId,AppointmentDate,DoctorId,HospitalId;
    private JTextField AppointmentDateField;
    private JComboBox ClinicIdBox,DoctorIdBox,HospitalIdBox;

    public InputPanel_Clinic()
    {
        setLayout(new GridLayout(4,2,5,10));
        ClinicId=new JLabel("Clinic ID:");
        AppointmentDate=new JLabel("Appointment Date:");
        DoctorId=new JLabel("Doctor ID:");
        HospitalId=new JLabel("Hospital ID:");

        ClinicIdBox=new JComboBox<>();
        ClinicIdBox.setName("ClinicIdBoxName");

        AppointmentDateField=new JTextField(13);
        AppointmentDateField.setName("AppointmentDateFieldName");

        DoctorIdBox=new JComboBox<>();
        DoctorIdBox.setName("DoctorIdBoxName");

        HospitalIdBox=new JComboBox<>();
        HospitalIdBox.setName("HospitalIdBoxName");

        add(ClinicId);
        add(ClinicIdBox);
        add(AppointmentDate);
        add(AppointmentDateField);
        add(DoctorId);
        add(DoctorIdBox);
        add(HospitalId);
        add(HospitalIdBox);

        //Add items into combo boxes
        Integer[] clinicIds={101,102,103,104,105,106,107,108,109,110,111,112,113,114,115};
        Integer[] doctorIds={1001,1002,1003,1004,1005,1006,1007,1008,1009,1010,1011,1012,1013,1014,1015};
        Integer[] hospitalIds={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        for (Integer id : clinicIds)
        {
            ClinicIdBox.addItem(id);
        }
        for (Integer id : doctorIds)
        {
            DoctorIdBox.addItem(id);
        }
        for (Integer id : hospitalIds)
        {
            HospitalIdBox.addItem(id);
        }
    }

    //Define getters to get these values out

    public JTextField getAppointmentDateField()
    {
        return AppointmentDateField;
    }

    public JComboBox getClinicIdBox()
    {
        return ClinicIdBox;
    }

    public JComboBox getDoctorIdBox()
    {
        return DoctorIdBox;
    }

    public JComboBox getHospitalIdBox()
    {
        return HospitalIdBox;
    }
}
