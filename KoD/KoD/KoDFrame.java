package KoD;

import javax.swing.*;
import java.awt.*;

public class KoDFrame extends JFrame
{
   private JPanel panel1;
   private ControlPanel controlPanel;
   private UnitPanel unitPanel;
   private DeployPanel deployPanel;
   
   public KoDFrame()
   {
      super();
      setSize(1200, 800);
      setLayout(new GridLayout(2, 1));
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      JPanel anonPanel = new JPanel();
      anonPanel.setLayout(new GridLayout(1, 2));
      this.add(anonPanel);
      JPanel anonPanel2 = new JPanel();
      anonPanel2.setLayout(new GridLayout(1, 2));
      anonPanel.add(anonPanel2);
      panel1 = new JPanel();
      panel1.add(new JLabel("Unused Panel"));
      anonPanel2.add(panel1);
      controlPanel = new ControlPanel(this);
      anonPanel2.add(controlPanel);
      unitPanel = new UnitPanel(this);
      anonPanel.add(unitPanel);
      deployPanel = new DeployPanel();
      this.add(deployPanel);
      
      controlPanel.updateAvailableButtons();
      setVisible(true);
   }
   
   public Unit getCurUnit()
   {
      return unitPanel.getCurUnit();
   }
   
   public void setNewUnit()
   {
      unitPanel.newUnit();
   }
   
   public void deployUnit()
   {
      if(unitPanel.hasValidUnitShape())
      {
         deployPanel.addUnit(unitPanel.getCurUnit());
      }
      repaintField();
   }
   
   public void repaintField()
   {
      if(deployPanel != null)
         deployPanel.repaint();
   }
   
   public static void main(String[] args)
   {
      KoDFrame frame = new KoDFrame();
   }
}