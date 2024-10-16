package KoD;

public class UnitDimensions implements KoDConstants
{

   // using a function rather than a static array for readability
   public static int[] getIndividualSizeMM(UnitType type)
   {
      int[] result = {-1, -1};
      switch(type)
      {
         case INFANTRY :            result[0] = 20; 
                                    result[1] = 20;
                                    break;
         case HEAVY_INFANTRY :      result[0] = 25; 
                                    result[1] = 25;
                                    break;
         case CAVALRY :             result[0] = 25; 
                                    result[1] = 50;
                                    break;
         case LARGE_INFANTRY :
         case SWARM :               result[0] = 40; 
                                    result[1] = 40;
                                    break;
         case MONSTER:
         case WAR_MACHINE :
         case LARGE_CAVALRY :
         case MONSTROUS_INFANTRY :  result[0] = 50; 
                                    result[1] = 50;
                                    break;
         case CHARIOT :             result[0] = 50; 
                                    result[1] = 100;
                                    break;
         case TITAN :               result[0] = 75; 
                                    result[1] = 75;
                                    break;
      }
      return result;
   }
   
   public static int[] getTroopSizeModels(UnitType type)
   {
      int[] result = {-1, -1};
      switch(type)
      {
         case INFANTRY :
         case HEAVY_INFANTRY :      result[0] = 5; 
                                    result[1] = 2;
                                    break;
         case CAVALRY :             result[0] = 5; 
                                    result[1] = 1;
                                    break;
         case LARGE_INFANTRY :
         case SWARM :
         case LARGE_CAVALRY:
         case MONSTROUS_INFANTRY :  break;
         case CHARIOT :             result[0] = 2; 
                                    result[1] = 1;
                                    break;
         case TITAN :
         case MONSTER:
         case WAR_MACHINE :         break;
      }
      return result;
   }
   
   public static int[] getRegimentSizeModels(UnitType type)
   {
      int[] result = {-1, -1};
      switch(type)
      {
         case INFANTRY : 
         case HEAVY_INFANTRY :      result[0] = 5; 
                                    result[1] = 4;
                                    break;
         case CAVALRY :             result[0] = 5; 
                                    result[1] = 2;
                                    break;
         case LARGE_INFANTRY:
         case SWARM :               
         case LARGE_CAVALRY:
         case MONSTROUS_INFANTRY :  
         case CHARIOT :             result[0] = 3; 
                                    result[1] = 1;
                                    break;
         case TITAN :
         case MONSTER:
         case WAR_MACHINE :         break;
      }
      return result;
   }
   
   public static int[] getHordeSizeModels(UnitType type)
   {
      int[] result = {-1, -1};
      switch(type)
      {
         case INFANTRY : 
         case HEAVY_INFANTRY :      result[0] = 10; 
                                    result[1] = 4;
                                    break;
         case CAVALRY :             result[0] = 10; 
                                    result[1] = 2;
                                    break;
         case LARGE_INFANTRY:
         case SWARM :               
         case LARGE_CAVALRY:
         case MONSTROUS_INFANTRY :  result[0] = 3; 
                                    result[1] = 2;
                                    break;
         case CHARIOT :             result[0] = 4; 
                                    result[1] = 1;
                                    break;
         case TITAN :
         case MONSTER:
         case WAR_MACHINE :         break;
      }
      return result;
   }
   
   public static int[] getLegionSizeModels(UnitType type)
   {
      int[] result = {-1, -1};
      switch(type)
      {
         case INFANTRY : 
         case HEAVY_INFANTRY :      result[0] = 10; 
                                    result[1] = 6;
                                    break;
         case CAVALRY :             break;
         case LARGE_INFANTRY:
         case SWARM :               
         case LARGE_CAVALRY:
         case MONSTROUS_INFANTRY :  result[0] = 6; 
                                    result[1] = 2;
                                    break;
         case CHARIOT :             result[0] = 3; 
                                    result[1] = 2;
                                    break;
         case TITAN :
         case MONSTER:
         case WAR_MACHINE :         break;
      }
      return result;
   }
}

