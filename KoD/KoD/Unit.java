package KoD;

public class Unit implements KoDConstants
{
	private double width;
	private double length;
	private double angle;
	private String name;
	private double[] origin;


	public double getWidth(){return width;}
	public double getLength(){return length;}
	public double getAngle(){return angle;}
	public String getName(){return name;}
	public double[] getOrigin(){return origin;}


	public void setWidth(double w){width = w;}
	public void setLength(double l){length = l;}
   public void setSize(double s[]){width = s[0]; length = s[1];}
	public void setAngle(double a){angle = a;}
	public void setName(String n){name = n;}
	public void setOrigin(double[] o){origin = o;}
   public void setOrigin(int x, int y){origin[0] = x; origin[1] = y;}


   public Unit()
   {
      this("Unknown Unit", 20 * MM_TO_IN, 20 * MM_TO_IN);
   }
   
   public Unit(String n, double w, double l)
   {
      name = n;
      width = w;
      length = l;
      origin = new double[2];
      angle = 0.0;
   }
   
   // returns list of x points and parallel list of y points, relative to field position
   public double[][] getCorners(double xOffset, double yOffset)
   {
      return getCornersCenteredOnPoint(origin[0] - xOffset, origin[1] - yOffset);
   }
   
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
}