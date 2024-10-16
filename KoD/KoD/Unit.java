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
}