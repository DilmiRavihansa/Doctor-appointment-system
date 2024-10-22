package Doctor_Appointment;

import javax.swing.*;
import java.awt.*;

public class InputPanel_Patient extends JPanel
{
    private JLabel PatientId,FirstName,LastName,age,patientAddress,contactNo;
    private JTextField PatientIdField,FirstNameField,LastNameField,ageField,patientAddressField,contactNoField;

    public InputPanel_Patient()
    {
        setLayout(new GridLayout(3,6,5,10));
        PatientId = new JLabel("Patient Id:");
        FirstName = new JLabel("First Name:");
        LastName = new JLabel("Last Name:");
        age = new JLabel("Age:");
        patientAddress = new JLabel("Patient Address:");
        contactNo = new JLabel("Contact No:");

        PatientIdField = new JTextField(13);
        PatientIdField.setName("PatientIdFieldName");

        FirstNameField = new JTextField(13);
        FirstNameField.setName("FirstNameFieldName");

        LastNameField=new JTextField(13);
        LastNameField.setName("LastNameFieldName");

        ageField=new JTextField(13);
        ageField.setName("ageFieldName");

        patientAddressField=new JTextField(13);
        patientAddressField.setName("patientAddressFieldName");

        contactNoField=new JTextField(13);
        contactNoField.setName("contactNoFieldName");

        add(PatientId); //row 1 column 1
        add(PatientIdField); //row 1 column 2
        add(FirstName); //row 2 column 1
        add(FirstNameField); //row 2 column 2
        add(LastName);
        add(LastNameField);
        add(age);
        add(ageField);
        add(patientAddress);
        add(patientAddressField);
        add(contactNo);
        add(contactNoField);
    }

    //Define getters to get these values out
    public JTextField getPatientIdField()
    {
        return PatientIdField;
    }

    public JTextField getFirstNameField()
    {
        return FirstNameField;
    }

    public JTextField getLastNameField()
    {
        return LastNameField;
    }

    public JTextField getAgeField()
    {
        return ageField;
    }

    public JTextField getPatientAddressField()
    {
        return patientAddressField;
    }

    public JTextField getContactNoField()
    {
        return contactNoField;
    }
}
