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
      setPixelsPerInch();
      g2d.setColor(Color.BLACK);
      for(int x = 0; x <= (getWidth() / pixelsPerInch); x++)
         g2d.drawLine((int)(x * pixelsPerInch), 0, (int)(x * pixelsPerInch), getHeight());
      for(int y = 0; y <= (getHeight() / pixelsPerInch); y++)
         g2d.drawLine(0, (int)(y * pixelsPerInch), getWidth(), (int)(y * pixelsPerInch));
   }
   
   // must be able to show 12" x 8"
   private void setPixelsPerInch()
   {
      double maxByWidth = getWidth() / 12.0;
      double maxByHeight = getHeight() / 8.0;
      pixelsPerInch = Math.min(maxByWidth, maxByHeight);
   }
}