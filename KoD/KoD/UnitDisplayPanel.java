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
      if(parent.hasValidUnitShape())
      {
         double[] center = getCenterPointInInches();
         Unit curUnit = parent.getCurUnit();
         double[][] pointsInInches = curUnit.getCornersCenteredOnPoint(center);
         int[] pixelPointsX = new int[pointsInInches[0].length];
         int[] pixelPointsY = new int[pointsInInches[1].length];
         for(int i = 0; i < pixelPointsX.length; i++)
         {
            pixelPointsX[i] = (int)(pointsInInches[0][i] * pixelsPerInch);
            pixelPointsY[i] = (int)(pointsInInches[1][i] * pixelsPerInch);
         }
         g2d.setColor(Color.WHITE);
         g2d.fillPolygon(pixelPointsX, pixelPointsY, pixelPointsX.length);
         g2d.setColor(Color.BLACK);
         g2d.drawPolygon(pixelPointsX, pixelPointsY, pixelPointsX.length);
         FontMetrics fontMetrics = g2d.getFontMetrics();
         int xInset = pixelPointsX[0] + (fontMetrics.stringWidth(curUnit.getName()) / 2);
         int yInset = pixelPointsY[0] + (fontMetrics.stringWidth(curUnit.getName()) / 2);
      }
   }
   
   
   // must be able to show 12" x 8"
   private void setPixelsPerInch()
   {
      double maxByWidth = getWidth() / 12.0;
      double maxByHeight = getHeight() / 8.0;
      pixelsPerInch = Math.min(maxByWidth, maxByHeight);
   }
   
   private double[] getCenterPointInInches()
   {
      double[] center = {0.0, 0.0};
      
      center[0] = (getWidth() / 2) / pixelsPerInch;
      center[1] = (getHeight() / 2) / pixelsPerInch;
      
      return center;
   }
}