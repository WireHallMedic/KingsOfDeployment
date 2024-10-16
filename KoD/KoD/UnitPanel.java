package KoD;

import javax.swing.*;
import java.awt.*;

public class UnitPanel extends JPanel implements KoDConstants
{
   private Unit curUnit;
   private JComboBox<UnitType> unitTypeDD;
   private JComboBox<UnitSize> unitSizeDD;
   
   public UnitPanel()
   {
      super();
      curUnit = new Unit();
      JPanel subpanel0 = new JPanel();
      JPanel subpanel1 = new JPanel();
      setLayout(new GridLayout(1, 2));
      subpanel0.setBackground(Color.RED);
      subpanel1.setBackground(Color.BLUE);
      add(subpanel0);
      add(subpanel1);
      this.repaint();
   }
   
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      frame.setSize(1000, 400);
      frame.add(new UnitPanel());
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}