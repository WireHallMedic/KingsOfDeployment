package KoD;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class DeployPanel extends JPanel implements KoDConstants, MouseListener, MouseMotionListener
{
   private static int widthInInches;
   private static int heightInInches;
   private double pixelsPerInch;
   private int fieldStartX;
   private int fieldStartY;
   private int fieldWidth;
   private int fieldHeight;
   private Vector<Unit> unitList;
   private Unit selectedUnit;
   private boolean draggingSelected;
   private KoDFrame parent;
   
   public static int getFieldWidthInches(){return widthInInches;}
   public static int getFieldHeightInches(){return heightInInches;}
   
   public DeployPanel(KoDFrame p)
   {
      super();
      parent = p;
      widthInInches = 6 * 12;
      heightInInches = 1 * 12;
      pixelsPerInch = 10.0;
      unitList = new Vector<Unit>();
      selectedUnit = null;
      addMouseListener(this);
      addMouseMotionListener(this);
      draggingSelected = false;
   }
   
   public void setSelectedUnit(Unit u)
   {
      selectedUnit = u;
      parent.setCurUnit(u);
   }
   
   public void deleteSelectedUnit()
   {
      if(selectedUnit != null)
         selectedUnit.setDeployed(false);
         deleteUnit(selectedUnit);
      selectedUnit = null;
   }
   
   public void addUnit(Unit u)
   {
      if(!unitList.contains(u))
      {
         unitList.add(u);
         u.setDeployed(true);
         setSelectedUnit(u);
         
         int deployWidth = getWidth() / 2;
         int deployHeight = fieldStartY + fieldHeight - (int)(u.getLength() * pixelsPerInch);
         u.setOrigin(translatePixelToInches(deployWidth, deployHeight));
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
      {
         if(x == widthInInches / 2)
            g2d.setColor(Color.WHITE);
         else
            g2d.setColor(Color.BLACK);
         g2d.drawLine(fieldStartX + (int)(x * pixelsPerInch), fieldStartY, fieldStartX + (int)(x * pixelsPerInch), fieldStartY + fieldHeight);
      }
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
         if(isOverlapping(curUnit))
            g2d.setColor(Color.RED);
         else
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
      for(Unit curUnit : unitList)
      {
         if(curUnit.hasAura6())
            paintAura(curUnit, 6, g2d);
         if(curUnit.hasAura9())
            paintAura(curUnit, 9, g2d);
      }
   }
   
   public void paintAura(Unit curUnit, int radius, Graphics2D g2d)
   {
      int unitOriginX = (int)((curUnit.getOrigin()[0] - (curUnit.getWidth() / 2)) * pixelsPerInch) + fieldStartX;
      int unitOriginY= (int)((curUnit.getOrigin()[1] - (curUnit.getLength() / 2)) * pixelsPerInch) + fieldStartY;
      int unitWidth = (int)(curUnit.getWidth() * pixelsPerInch);
      int unitHeight = (int)(curUnit.getLength() * pixelsPerInch);
      radius = (int)(radius * pixelsPerInch);
      g2d.setColor(AURA_COLOR);
      // draw straight lines
      g2d.drawLine(unitOriginX - radius, unitOriginY, unitOriginX - radius, unitOriginY + unitHeight);
      g2d.drawLine(unitOriginX + radius + unitWidth, unitOriginY, unitOriginX + radius + unitWidth, unitOriginY + unitHeight);
      g2d.drawLine(unitOriginX, unitOriginY - radius, unitOriginX + unitWidth, unitOriginY - radius);
      g2d.drawLine(unitOriginX, unitOriginY + radius + unitHeight, unitOriginX + unitWidth, unitOriginY + radius + unitHeight);
      // draw arcs
      g2d.drawArc(unitOriginX - radius, unitOriginY - radius, radius * 2, radius * 2, 180, -90);
      g2d.drawArc(unitOriginX - radius, unitOriginY + unitHeight - radius, radius * 2, radius * 2, 180, 90);
      g2d.drawArc(unitOriginX + unitWidth - radius, unitOriginY - radius, radius * 2, radius * 2, 0, 90);
      g2d.drawArc(unitOriginX + unitWidth - radius, unitOriginY + unitHeight - radius, radius * 2, radius * 2, 0, -90);
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
   public void mouseMoved(MouseEvent e)
   {
      double[] loc = translatePixelToInches(e.getX(), e.getY());
      parent.updateLocF(loc);
   }
   
   public void mouseReleased(MouseEvent e)
   {
      draggingSelected = false;
   }
   
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
      selectedUnit = u;
      if(u != null)
      {
         draggingSelected = true;
         parent.setCurUnit(u);
      }
      else
      {
         parent.setNewUnit();
      }
      repaint();
   }
   
   public void mouseDragged(MouseEvent e)
   {
      double[] loc = translatePixelToInches(e.getX(), e.getY());
      if(draggingSelected)
      {
         selectedUnit.setOrigin(loc);
      }
      parent.updateLocF(loc);
      repaint();
   }
   
   public boolean isOverlapping(Unit u)
   {
      for(Unit that : unitList)
      {
         if(u != that && u.overlaps(that))
            return true;
      }
      return false;
   }
}