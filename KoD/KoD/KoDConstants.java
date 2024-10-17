package KoD;

import java.awt.*;

public interface KoDConstants
{
   public enum UnitType 
   {
      INFANTRY             ("Infantry", 20, 20), 
      HEAVY_INFANTRY       ("Heavy Infantry", 25, 25), 
      CAVALRY              ("Cavalry", 25, 50), 
      LARGE_INFANTRY       ("Large Infantry", 40, 40), 
      SWARM                ("Swarm", 40, 40), 
      LARGE_CAVALRY        ("Large Cavalry", 50, 50), 
      MONSTROUS_INFANTRY   ("Monstrous Infantry", 50, 50), 
      CHARIOT              ("Chariot", 50, 100), 
      MONSTER              ("Monster", 50, 50), 
      WAR_MACHINE          ("War Machine", 50, 50), 
      TITAN                ("Titan", 75, 75);
      
      public String name;
      public int width;
      public int length;
      
      private UnitType(String n, int w, int l)
      {
         name = n;
         width = w;
         length = l;
      }
      
      @Override
      public String toString(){return this.name;}
   };
   
   public enum UnitSize 
   {
      INDIVIDUAL  ("Individual"), 
      TROOP       ("Troop"), 
      REGIMENT    ("Regiment"), 
      HORDE       ("Horde"), 
      LEGION      ("Legion");
      
      public String name;
      
      private UnitSize(String n)
      {
         name = n;
      }
      
      @Override
      public String toString(){return this.name;}
   };
   
   public enum RingColor 
   {
      BLUE     ("Blue", Color.CYAN), 
      BLACK    ("Black", Color.BLACK), 
      WHITE    ("White", Color.WHITE), 
      RED      ("Red", Color.RED), 
      ORANGE   ("Orange", Color.ORANGE), 
      YELLOW   ("Yellow", Color.YELLOW), 
      PURPLE   ("Purple", Color.MAGENTA);
      
      public String name;
      public Color color;
      
      private RingColor(String n, Color c)
      {
         name = n;
         color = c;
      }
      
      @Override
      public String toString(){return this.name;}
   };
   
   public static final double MM_TO_IN = 0.0393701;
   
   public static final Color FIELD_COLOR = Color.GREEN.darker();
   public static final Color AURA_COLOR = new Color(173, 216, 230);
}

