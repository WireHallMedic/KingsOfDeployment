package KoD;

import javax.swing.*;
import java.awt.*;

public class KoDFrame extends JFrame
{
   private JPanel panel1;
   private JPanel controlPanel;
   private UnitPanel unitPanel;
   
   public KoDFrame()
   {
      super();
      setSize(1200, 800);
      setLayout(new GridLayout(2, 1));
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
   }
   
   public static void main(String[] args)
   {
      KoDFrame frame = new KoDFrame();
   }
}