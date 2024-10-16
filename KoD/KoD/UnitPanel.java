package KoD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class UnitPanel extends JPanel implements KoDConstants, ActionListener, DocumentListener
{
   private Unit curUnit;
   private JComboBox<UnitType> unitTypeDD;
   private JComboBox<UnitSize> unitSizeDD;
   private JTextField nameF;
   private JTextField displayNameF;
   private JTextField infoF;
   private JCheckBox aura6CB;
   private JCheckBox aura9CB;
   private JPanel[] subpanel;
   private UnitDisplayPanel unitDisplayPanel;
   private static final int CONTROL_ROWS = 6;
   
   public Unit getCurUnit(){return curUnit;}
   
   public UnitPanel()
   {
      super();
      curUnit = new Unit();
      unitDisplayPanel = new UnitDisplayPanel(this);
      JPanel rightPanel = new JPanel();
      setLayout(new GridLayout(1, 2));
      add(unitDisplayPanel);
      add(rightPanel);
      rightPanel.setLayout(new GridLayout(CONTROL_ROWS, 1));
      
      subpanel = new JPanel[CONTROL_ROWS];
      for(int i = 0; i < CONTROL_ROWS; i++)
      {
         subpanel[i] = new JPanel();
         rightPanel.add(subpanel[i]);
      }
      
      int curRow = 0;
      subpanel[curRow].setLayout(new GridLayout(1, 2));
      subpanel[curRow].add(new JLabel("Name"));
      nameF = new JTextField(curUnit.getName());
      nameF.getDocument().addDocumentListener(this);
      subpanel[curRow].add(nameF);
      curRow++;
      
      subpanel[curRow].setLayout(new GridLayout(1, 2));
      subpanel[curRow].add(new JLabel("Display Name"));
      displayNameF = new JTextField();
      displayNameF.getDocument().addDocumentListener(this);
      subpanel[curRow].add(displayNameF);
      curRow++;
      
      subpanel[curRow].setLayout(new GridLayout(1, 2));
      subpanel[curRow].add(new JLabel("Unit Type"));
      unitTypeDD = new JComboBox<UnitType>(UnitType.values());
      unitTypeDD.addActionListener(this);
      subpanel[curRow].add(unitTypeDD);
      curRow++;
      
      subpanel[curRow].setLayout(new GridLayout(1, 2));
      subpanel[curRow].add(new JLabel("Unit Size"));
      unitSizeDD = new JComboBox<UnitSize>(UnitSize.values());
      unitSizeDD.addActionListener(this);
      subpanel[curRow].add(unitSizeDD);
      curRow++;
      
      subpanel[curRow].setLayout(new GridLayout(1, 3));
      aura6CB = new JCheckBox("6\" Ring");
      aura9CB = new JCheckBox("9\" Ring");
      aura6CB.addActionListener(this);
      aura9CB.addActionListener(this);
      subpanel[curRow].add(aura6CB);
      subpanel[curRow].add(aura9CB);
      subpanel[curRow].add(new JLabel(""));
      curRow++;
      
      subpanel[curRow].setLayout(new GridLayout(1, 1));
      infoF = new JTextField("");
      infoF.setEditable(false);
      infoF.setFocusable(false);
      subpanel[curRow].add(infoF);
      curRow++;
      
      newUnit();
      
      this.repaint();
   }
   
   public boolean hasValidUnitShape()
   {
      return UnitDimensions.getUnitSizeInches((UnitType)unitTypeDD.getSelectedItem(), (UnitSize)unitSizeDD.getSelectedItem()) != null;
   }
   
   public void updateUnitName()
   {
      curUnit.setName(nameF.getText());
      curUnit.setDisplayName(displayNameF.getText());
      unitDisplayPanel.repaint();
   }
   
   public void newUnit()
   {
      curUnit = new Unit();
      nameF.setText(curUnit.getName());
      unitTypeDD.setSelectedIndex(0);
      unitSizeDD.setSelectedIndex(0);
      displayNameF.setText("");
      aura6CB.setSelected(false);
      aura9CB.setSelected(false);
      infoF.setText("");
   }
   
   public void actionPerformed(ActionEvent aeRef)
   {
      if(!hasValidUnitShape())
         infoF.setText("Invalid Unit Type and Size configuration.");
      else
      {
         infoF.setText("");
         curUnit.setSize(UnitDimensions.getUnitSizeInches((UnitType)unitTypeDD.getSelectedItem(), (UnitSize)unitSizeDD.getSelectedItem()));
         curUnit.setAura6(aura6CB.isSelected());
         curUnit.setAura9(aura9CB.isSelected());
      }
      unitDisplayPanel.repaint();
   }
   
   public void changedUpdate(DocumentEvent e){updateUnitName();}
   public void insertUpdate(DocumentEvent e){updateUnitName();}
   public void removeUpdate(DocumentEvent e){updateUnitName();}
   
   
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      frame.setSize(1000, 400);
      frame.add(new UnitPanel());
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}