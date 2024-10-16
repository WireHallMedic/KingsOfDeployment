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
         case LARGE_INFANTRY:
         case SWARM :               result[0] = 40; 
                                    result[1] = 40;
                                    break;
         case MONSTER:
         case WAR_MACHINE :
         case LARGE_CAVALRY:
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
}

