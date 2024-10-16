package KoD;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class DeployPanel extends JPanel implements KoDConstants, MouseListener, MouseMotionListener
{
   private int widthInInches;
   private int heightInInches;
   private double pixelsPerInch;
   private int fieldStartX;
   private int fieldStartY;
   private int fieldWidth;
   private int fieldHeight;
   private Vector<Unit> unitList;
   private Unit selectedUnit;
   
   public DeployPanel()
   {
      super();
      widthInInches = 6 * 12;
      heightInInches = 1 * 12;
      pixelsPerInch = 10.0;
      unitList = new Vector<Unit>();
      selectedUnit = null;
      addMouseListener(this);
      addMouseMotionListener(this);
   }
   
   public void deleteSelectedUnit()
   {
      if(selectedUnit != null)
         deleteUnit(selectedUnit);
      selectedUnit = null;
   }
   
   public void addUnit(Unit u)
   {
      if(!unitList.contains(u))
      {
         unitList.add(u);
         u.setDeployed(true);
         selectedUnit = u;
      }
   }
   
   public void addUnitCopy(Unit u)
   {
      u = new Unit(u);
      addUnit(u);
   }
   
   public void deleteUnit(Unit u)
   {
      unitList.remove(u);
   }
   
   // must be able to show full area
   private void setPixelsPerInch()
   {
      double maxByWidth = getWidth() / (double)widthInInches;
      double maxByHeight = getHeight() / (double)heightInInches;
      pixelsPerInch = Math.min(maxByWidth, maxByHeight);
      fieldWidth = (int)(widthInInches * pixelsPerInch);
      fieldHeight = (int)(heightInInches * pixelsPerInch);
      fieldStartX = (getWidth() - fieldWidth) / 2;
      fieldStartY = (getHeight() - fieldHeight) / 2;
   }
   
   @Override
   public void paint(Graphics g)
   {
      super.paint(g);
      Graphics2D g2d = (Graphics2D)g;
      setPixelsPerInch();
      
      // paint the field
      g2d.setColor(FIELD_COLOR);
      g2d.fillRect(fieldStartX, fieldStartY, fieldWidth, fieldHeight);
      g2d.setColor(Color.BLACK);
      g2d.drawRect(fieldStartX, fieldStartY, fieldWidth, fieldHeight);
      for(int x = 0; x <= widthInInches; x++)
         g2d.drawLine(fieldStartX + (int)(x * pixelsPerInch), fieldStartY, fieldStartX + (int)(x * pixelsPerInch), fieldStartY + fieldHeight);
      for(int y = 0; y < heightInInches; y++)
         g2d.drawLine(fieldStartX, fieldStartY + (int)(y * pixelsPerInch), fieldStartX + fieldWidth, fieldStartY + (int)(y * pixelsPerInch));
      
      // paint the units
      for(Unit curUnit : unitList)
      {
         double[][] pointsInInches = curUnit.getCorners();
         int[] pixelPointsX = new int[pointsInInches[0].length];
         int[] pixelPointsY = new int[pointsInInches[1].length];
         for(int i = 0; i < pixelPointsX.length; i++)
         {
            pixelPointsX[i] = (int)(pointsInInches[0][i] * pixelsPerInch) + fieldStartX;
            pixelPointsY[i] = (int)(pointsInInches[1][i] * pixelsPerInch) + fieldStartY;
         }
         g2d.setColor(Color.WHITE);
         if(curUnit == selectedUnit)
            g2d.setColor(Color.BLUE);
         g2d.fillPolygon(pixelPointsX, pixelPointsY, pixelPointsX.length);
         g2d.setColor(Color.BLACK);
         g2d.drawPolygon(pixelPointsX, pixelPointsY, pixelPointsX.length);
         double[] center = curUnit.getOrigin();
         FontMetrics fontMetrics = g2d.getFontMetrics();
         int lineWidth = fontMetrics.stringWidth(curUnit.getDisplayName());
         int lineHeight = fontMetrics.getHeight();
         int centerX = (int)(center[0] * pixelsPerInch) + fieldStartX;
         int centerY = (int)(center[1] * pixelsPerInch) + fieldStartY;
         g2d.drawString(curUnit.getDisplayName(), centerX - (lineWidth / 2), centerY + (lineHeight / 2));
      }
      
      // paint the auras
   }
   
   public double[] translatePixelToInches(int x, int y)
   {
      double newX = (x - fieldStartX) / pixelsPerInch;
      double newY = (y - fieldStartY) / pixelsPerInch;
      double[] val = {newX, newY};
      return val;
   }
   
   // mouse stuff
   public void mouseClicked(MouseEvent e){}
   public void mouseEntered(MouseEvent e){}
   public void mouseExited(MouseEvent e){}
   public void mouseMoved(MouseEvent e){}
   public void mouseReleased(MouseEvent e){}
   
   public void mousePressed(MouseEvent e)
   {
      Unit u = null;
      double[] loc = translatePixelToInches(e.getX(), e.getY());
      for(int i = unitList.size() - 1; i >= 0; i--)
      {
         if(unitList.elementAt(i).pointIsIn(loc))
         {
            u = unitList.elementAt(i);
            break;
         }
      }
      if(u != null)
      {
         selectedUnit = u;
      }
      repaint();
   }
   
   public void mouseDragged(MouseEvent e)
   {
      double[] loc = translatePixelToInches(e.getX(), e.getY());
      if(selectedUnit.pointIsIn(loc))
      {
         selectedUnit.setOrigin(loc);
      }
      repaint();
   }
}