package Doctor_Appointment;

import javax.swing.*;
import java.awt.*;

public class InputPanel_Hospital extends JPanel
{
    private JLabel HospitalId,Location;
    private JComboBox HospitalIdBox,LocationBox;

    public InputPanel_Hospital()
    {
        setLayout(new GridLayout(2,6,5,10));
        HospitalId=new JLabel("Hospital ID:");
        Location=new JLabel("Location");

        HospitalIdBox=new JComboBox<>();
        HospitalIdBox.setName("HospitalIdBoxName");

        LocationBox=new JComboBox<>();
        LocationBox.setName("LocationBoxName");

        add(HospitalId);
        add(HospitalIdBox);
        add(Location);
        add(LocationBox);

        //Add items to combo Boxes
        Integer[] hospitalIds={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        String[] locations={"Karapitiya Hospital","Galle Cooperative","Galle Asiri","Karapitiya Cooperative",
        "Karapitiya Ruhunu","Coop Heart Centre","Cancer Hospital Karapitiya","International Medical Centre","Khasim Hospital","Lanka Hospitals Medical Centre",
        "Galle Mahamodara","Srikatha Hospital","Quensbury Karapitiya","New Matenity Hospital","Sahana Medical Centre"};

        for (Integer id : hospitalIds)
        {
            HospitalIdBox.addItem(id);
        }
        for (String location : locations)
        {
            LocationBox.addItem(location);
        }

    }

    //Define getters to get these values out


    public JComboBox getHospitalIdBox()
    {
        return HospitalIdBox;
    }

    public JComboBox getLocationBox()
    {
        return LocationBox;
    }
}
