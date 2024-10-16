package KoD;

import javax.swing.*;
import java.awt.*;

public class KoDFrame extends JFrame
{
   private JPanel panel1;
   private JPanel controlPanel;
   private UnitPanel unitPanel;
   private JPanel deployPanel;
   
   public KoDFrame()
   {
      super();
      setSize(1200, 800);
      setLayout(new GridLayout(2, 1));
      
      JPanel anonPanel = new JPanel();
      anonPanel.setLayout(new GridLayout(1, 2));
      this.add(anonPanel);
      JPanel anonPanel2 = new JPanel();
      anonPanel2.setLayout(new GridLayout(1, 2));
      anonPanel.add(anonPanel2);
      panel1 = new JPanel();
      panel1.add(new JLabel("Panel 1"));
      anonPanel2.add(panel1);
      controlPanel = new JPanel();
      controlPanel.add(new JLabel("Control Panel"));
      anonPanel2.add(controlPanel);
      unitPanel = new UnitPanel();
      anonPanel.add(unitPanel);
      deployPanel = new JPanel();
      deployPanel.add(new JLabel("Deploy Panel"));
      this.add(deployPanel);
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
   }
   
   public static void main(String[] args)
   {
      KoDFrame frame = new KoDFrame();
   }
}