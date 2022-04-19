// http://www.javabeginner.com/learn-java/java-abstract-class-and-interface

package shapeInterface;

public class Point implements Shape {

	private int x, y;
    private String color;
	
	public Point() 
	{
		x = 0;
		y = 0;
	}
	
	public Point(int x, int y)
	{
		this.x = x; 
		this.y = y; 
	}
	
	public void setColor(String c) 
	{
		color = c;
	}
	
	public String getColor() 
	{
		return color;
	}
	
	public double area() 
	{
		return 0;
	}
		
	public void print() 
	{
		System.out.println("point: " + x + "," + y);
	}
	
	public static void main(String args[]) 
	{
		Point p = new Point();
		p.print();
	}
}
