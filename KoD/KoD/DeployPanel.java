package KoD;

import javax.swing.*;
import java.awt.*;

public class DeployPanel extends JPanel
{
   private int widthInInches = 6 * 12;
   private int heightInInches = 1 * 12;
   private double pixelsPerInch;
   
   public DeployPanel()
   {
      super();
      widthInInches = 6 * 12;
      heightInInches = 1 * 12;
      pixelsPerInch = 10.0;
   }
   
   // must be able to show full area
   private void setPixelsPerInch()
   {
      double maxByWidth = getWidth() / (double)widthInInches;
      double maxByHeight = getHeight() / (double)heightInInches;
      pixelsPerInch = Math.min(maxByWidth, maxByHeight);
   }
   
   @Override
   public void paint(Graphics g)
   {
      super.paint(g);
      Graphics2D g2d = (Graphics2D)g;
      setPixelsPerInch();
      
      int fieldWidth = (int)(widthInInches * pixelsPerInch);
      int fieldHeight = (int)(heightInInches * pixelsPerInch);
      int startX = (getWidth() - fieldWidth) / 2;
      int startY = (getHeight() - fieldHeight) / 2;
   }
}