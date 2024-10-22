package Doctor_Appointment;

import javax.swing.*;
import java.awt.*;

public class InputPanel_Appoint extends JPanel
{
    private JLabel PatientId,ClinicId,PayDate,PayDescription,PayType;
    private JTextField PatientIdField,ClinicIdField,PayDateField,PayDescriptionField;
    private JComboBox  PayTypeBox;

    public InputPanel_Appoint() {
        setLayout(new GridLayout(3, 6, 5, 10));
        PatientId = new JLabel("Patient ID:");
        ClinicId = new JLabel("Clinic ID:");
        PayDate = new JLabel("Pay Date:");
        PayDescription = new JLabel("Pay Description");
        PayType = new JLabel("Payment Type");

        PatientIdField = new JTextField(13);
        PatientIdField.setName("PatientIdFieldName");

        ClinicIdField = new JTextField(13);
        ClinicIdField.setName("ClinicIdFieldName");

        PayDateField = new JTextField(13);
        PayDateField.setName("PayDateFieldName");

        PayDescriptionField = new JTextField(13);
        PayDescriptionField.setName("PayDesFieldName");

        PayTypeBox=new JComboBox<>();
        PayTypeBox.setName("PayTypeBoxName");

        add(PatientId);
        add(PatientIdField);
        add(ClinicId);
        add(ClinicIdField);
        add(PayDate);
        add(PayDateField);
        add(PayDescription);
        add(PayDescriptionField);
        add(PayType);
        add(PayTypeBox);

        // Add items to combo boxes
        String[] payTypes = { "Cash","Credit"};

        for (String type : payTypes)
        {
            PayTypeBox.addItem(type);
        }

    }

    //Define getters to get these values out

    public JTextField getPatientIdField()
    {
        return PatientIdField;
    }

    public JTextField getClinicIdField()

    {
        return ClinicIdField;
    }

    public JTextField getPayDateField()
    {
        return PayDateField;
    }

    public JTextField getPayDescriptionField()
    {
        return PayDescriptionField;
    }

    public JComboBox getPayTypeBox()
    {
        return PayTypeBox;
    }
}

