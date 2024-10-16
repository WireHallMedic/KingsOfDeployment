package KoD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControlPanel extends JPanel implements KoDConstants, ActionListener
{
   private KoDFrame parent;
   private JButton newB;
   private JButton deployB;
   private JButton deleteB;
   private JButton saveB;
   private JButton loadB;
   
   public ControlPanel(KoDFrame p)
   {
      super();
      parent = p;
      setLayout(new GridLayout(5, 1));
      
      newB = new JButton("New Unit");
      deployB = new JButton("Deploy");
      deleteB = new JButton("Delete");
      saveB = new JButton("Save");
      loadB = new JButton("Load");
      
      newB.addActionListener(this);
      deployB.addActionListener(this);
      deleteB.addActionListener(this);
      saveB.addActionListener(this);
      loadB.addActionListener(this);
      
      this.add(newB);
      this.add(deployB);
      this.add(deleteB);
      this.add(saveB);
      this.add(loadB);
   }
   
   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource() == newB)
         parent.setNewUnit();
      if(ae.getSource() == deployB)
         ;
      if(ae.getSource() == deleteB)
         ;
      if(ae.getSource() == saveB)
         ;
      if(ae.getSource() == loadB)
         ;
      updateAvailableButtons();
   }
   
   public void updateAvailableButtons()
   {
      Unit curUnit = parent.getCurUnit();
      if(curUnit.isDeployed())
      {
         newB.setEnabled(true);
         deployB.setText("Deploy Copy");
         deleteB.setEnabled(true);
         saveB.setEnabled(false);
         loadB.setEnabled(false);
      }
      else
      {
         newB.setEnabled(true);
         deployB.setText("Deploy");
         deleteB.setEnabled(false);
         saveB.setEnabled(false);
         loadB.setEnabled(false);
      }
   }
}