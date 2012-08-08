//package Lab_02;

public class Cylinder extends Circle{
	Point center;
	double height;
	
	public Cylinder(Point center, Point point, double height){
		super(center, point);
		this.center = center;
		this.height = height;
	}
	
	// Return surface area of cylinder
	public double getSurfaceArea(){
		return calculateArea()*2 + calculateCircumference()*height;
	}
	
	// Return volume of cylinder
	public double getVolume(){
		return calculateArea()*height;
	}
}
