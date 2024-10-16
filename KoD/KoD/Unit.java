package KoD;

public class Unit implements KoDConstants
{
	private double width;
	private double length;
	private double angle;
	private String name;
   private String displayName;
	private double[] origin;
   private boolean aura6;
   private boolean aura9;
   private boolean deployed;


	public double getWidth(){return width;}
	public double getLength(){return length;}
	public double getAngle(){return angle;}
	public String getName(){return name;}
   public String getDisplayName(){return displayName;}
	public double[] getOrigin(){return origin;}
   public boolean hasAura6(){return aura6;}
   public boolean hasAura9(){return aura9;}
   public boolean isDeployed(){return deployed;}


	public void setWidth(double w){width = w;}
	public void setLength(double l){length = l;}
   public void setSize(double s[]){width = s[0]; length = s[1];}
	public void setAngle(double a){angle = a;}
	public void setName(String n){name = n;}
   public void setDisplayName(String n){displayName = n;}
	public void setOrigin(double[] o){origin = o;}
   public void setOrigin(int x, int y){origin[0] = x; origin[1] = y;}
   public void setAura6(boolean a6){aura6 = a6;}
   public void setAura9(boolean a9){aura9 = a9;}
   public void setDeployed(boolean d){deployed = d;}


   public Unit()
   {
      this("Unknown Unit", 20 * MM_TO_IN, 20 * MM_TO_IN);
   }
   
   public Unit(String n, double w, double l)
   {
      name = n;
      displayName = "";
      width = w;
      length = l;
      origin = new double[2];
      angle = 0.0;
      aura6 = false;
      aura9 = false;
      deployed = false;
   }
   
   public Unit(Unit that)
   {
      this.name = that.name;
      this.displayName = that.displayName;
      this.width = that.width;
      this.length = that.length;
      this.origin = new double[2];
      this.origin[0] = that.origin[0];
      this.origin[1] = that.origin[1];
      this.angle = that.angle;
      this.aura6 = that.aura6;
      this.aura9 = that.aura9;
      this.deployed = that.deployed;
   }
   
   // returns list of x points and parallel list of y points, relative to field position
   public double[][] getCorners(double xOffset, double yOffset)
   {
      return getCornersCenteredOnPoint(origin[0] - xOffset, origin[1] - yOffset);
   }
   public double[][] getCorners(){return getCorners(0.0, 0.0);}
   
   // returns list of x points and parallel list of y points, relative to explicit position
   // TODO: implement rotation
   public double[][] getCornersCenteredOnPoint(double xCenter, double yCenter)
   {
      double[] xList = new double[4];
      double[] yList = new double[4];
      xList[0] = xCenter - (width / 2); yList[0] = yCenter - (length / 2);
      xList[1] = xCenter + (width / 2); yList[1] = yCenter - (length / 2);
      xList[2] = xCenter + (width / 2); yList[2] = yCenter + (length / 2);
      xList[3] = xCenter - (width / 2); yList[3] = yCenter + (length / 2);
      
      double[][] fullList = {xList, yList};
      return fullList;
   }
   public double[][] getCornersCenteredOnPoint(double[] center){return getCornersCenteredOnPoint(center[0], center[1]);}
   
   // returns true if the passed point is within this unit, else false
   public boolean pointIsIn(double x, double y)
   {
      return x >= origin[0] - (width / 2) &&
             x <= origin[0] + (width / 2) &&
             y >= origin[1] - (length / 2) &&
             y <= origin[1] + (length / 2);
   }
   public boolean pointIsIn(double[] coord){return pointIsIn(coord[0], coord[1]);}
}