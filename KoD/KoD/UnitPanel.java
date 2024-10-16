package KoD;

import javax.swing.*;
import java.awt.*;

public class UnitPanel extends JPanel implements KoDConstants
{
   private Unit curUnit;
   private JComboBox<UnitType> unitTypeDD;
   private JComboBox<UnitSize> unitSizeDD;
   private JTextField nameF;
   private JTextField infoF;
   private JPanel[] subpanel;
   private static final int CONTROL_ROWS = 6;
   
   public UnitPanel()
   {
      super();
      curUnit = new Unit();
      JPanel leftPanel = new JPanel();
      JPanel rightPanel = new JPanel();
      setLayout(new GridLayout(1, 2));
      leftPanel.setBackground(Color.GREEN);
      add(leftPanel);
      add(rightPanel);
      rightPanel.setLayout(new GridLayout(CONTROL_ROWS, 1));
      
      subpanel = new JPanel[CONTROL_ROWS];
      for(int i = 0; i < CONTROL_ROWS; i++)
      {
         subpanel[i] = new JPanel();
         rightPanel.add(subpanel[i]);
      }
      
      subpanel[0].setLayout(new GridLayout(1, 2));
      subpanel[0].add(new JLabel("Name"));
      nameF = new JTextField(curUnit.getName());
      subpanel[0].add(nameF);
      
      subpanel[1].setLayout(new GridLayout(1, 2));
      subpanel[1].add(new JLabel("Unit Type"));
      unitTypeDD = new JComboBox<UnitType>(UnitType.values());
      subpanel[1].add(unitTypeDD);
      
      subpanel[2].setLayout(new GridLayout(1, 2));
      subpanel[2].add(new JLabel("Unit Size"));
      unitSizeDD = new JComboBox<UnitSize>(UnitSize.values());
      subpanel[2].add(unitSizeDD);
      
      subpanel[3].setLayout(new GridLayout(1, 2));
      subpanel[3].add(new JLabel("Decoration"));
      
      subpanel[4].setLayout(new GridLayout(1, 1));
      infoF = new JTextField("infoF");
      infoF.setEditable(false);
      infoF.setFocusable(false);
      subpanel[4].add(infoF);
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