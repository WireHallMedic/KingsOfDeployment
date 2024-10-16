package KoD;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class DeployPanel extends JPanel implements KoDConstants
{
   private int widthInInches;
   private int heightInInches;
   private double pixelsPerInch;
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
         unitList.add(u);
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
      g2d.setColor(FIELD_COLOR);
      g2d.fillRect(startX, startY, fieldWidth, fieldHeight);
      g2d.setColor(Color.BLACK);
      g2d.drawRect(startX, startY, fieldWidth, fieldHeight);
      for(int x = 0; x <= widthInInches; x++)
         g2d.drawLine(startX + (int)(x * pixelsPerInch), startY, startX + (int)(x * pixelsPerInch), startY + fieldHeight);
      for(int y = 0; y < heightInInches; y++)
         g2d.drawLine(startX, startY + (int)(y * pixelsPerInch), startX + fieldWidth, startY + (int)(y * pixelsPerInch));
      
   }
}