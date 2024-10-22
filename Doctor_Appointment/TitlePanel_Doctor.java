package Doctor_Appointment;

import javax.swing.*;
import java.awt.*;

public class TitlePanel_Doctor extends JPanel
{
    private JLabel title;

    public TitlePanel_Doctor()
    {
        this.title = new JLabel();
        setLayout(new BorderLayout());
        initializeTitleBarUI();
    }
    private void initializeTitleBarUI()
    {
        JPanel coloredPanel=new JPanel();
        title.setText("Doctor Details");
        coloredPanel.setBackground(new Color(45,149,150));
        coloredPanel.add(title);

        JPanel emptyPanel=new JPanel();
        emptyPanel.setPreferredSize(new Dimension(getWidth(),15));

        add(coloredPanel,BorderLayout.NORTH);
        add(emptyPanel,BorderLayout.SOUTH);
    }
}
