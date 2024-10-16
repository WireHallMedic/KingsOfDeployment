package KoD;

import javax.swing.*;
import java.awt.*;

public class UnitDisplayPanel extends JPanel implements KoDConstants
{
   private UnitPanel parent;
   private double pixelsPerInch;
   
   public UnitDisplayPanel(UnitPanel p)
   {
      super();
      parent = p;
      pixelsPerInch = 10.0;
      setBackground(Color.GREEN.darker());
   }
   
   @Override
   public void paint(Graphics g)
   {
      super.paint(g);
      Graphics2D g2d = (Graphics2D)g;
   }
}