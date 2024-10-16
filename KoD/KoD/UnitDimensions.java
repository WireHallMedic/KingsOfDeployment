package KoD;

public class UnitDimensions implements KoDConstants
{
   
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
      if(result[0] == -1 || result[1] == -1)
         return null;
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
      if(result[0] == -1 || result[1] == -1)
         return null;
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
      if(result[0] == -1 || result[1] == -1)
         return null;
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
      if(result[0] == -1 || result[1] == -1)
         return null;
      return result;
   }
   
   public static double[] getUnitSizeInches(UnitType unitType, UnitSize unitSize)
   {
      int[] unitSizeModels = {1, 1};
      switch(unitSize)
      {
         case INDIVIDUAL : break;
         case TROOP :      unitSizeModels = getTroopSizeModels(unitType);
                           break;
         case REGIMENT :   unitSizeModels = getRegimentSizeModels(unitType);
                           break;
         case HORDE :      unitSizeModels = getHordeSizeModels(unitType);
                           break;
         case LEGION :     unitSizeModels = getLegionSizeModels(unitType);
                           break;
      }
      if(unitSizeModels == null)
         return null;
      double[] unitSizeInches = new double[2];
      unitSizeInches[0] = unitType.width * unitSizeModels[0] * MM_TO_IN;
      unitSizeInches[1] = unitType.length * unitSizeModels[1] * MM_TO_IN;
      return unitSizeInches;
   }
}

