package KoD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControlPanel extends JPanel implements KoDConstants, ActionListener
{
   private KoDFrame parent;
   private JButton deployB;
   private JButton deleteB;
   private JButton saveB;
   private JButton loadB;
   
   public ControlPanel(KoDFrame p)
   {
      super();
      parent = p;
      setLayout(new GridLayout(4, 1));
      
      deployB = new JButton("Deploy");
      deleteB = new JButton("Delete");
      saveB = new JButton("Save");
      loadB = new JButton("Load");
      
      deployB.addActionListener(this);
      deleteB.addActionListener(this);
      saveB.addActionListener(this);
      loadB.addActionListener(this);
      
      this.add(deployB);
      this.add(deleteB);
      this.add(saveB);
      this.add(loadB);
   }
   
   public void actionPerformed(ActionEvent ae)
   {
      System.out.println("Button pressed");
   }
}