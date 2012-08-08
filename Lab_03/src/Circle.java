//package Lab_02;

public class Circle extends Point{
	double radius;
	Point center;
	
	// Constructor for point objects 
	public Circle(Point point1, Point point2){
		super(point1.x, point1.y);
		center = point1;
		radius = calculateRadius(point2);
	}
	
	// Calculate area of circle
	public double calculateArea(){
		return Math.PI*radius*radius;
	}
	
	// Calculate circumference of circle
	public double calculateCircumference(){
		return 2*Math.PI*radius;
	}
	
	// Calculate radius 
	public double calculateRadius(Point point){
		return center.getDistance(point);
	}
	
	public String getRadius(){
		return new String("" + radius);
	}
}
