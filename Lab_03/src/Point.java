//package Lab_02;

public class Point {
	double x, y;
	
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public double getDistance(Point point){
		double xDistance = x - point.x;
		double yDistance = y - point.y;
		double distance = Math.sqrt(xDistance*xDistance + yDistance*yDistance);
		return distance;
	}
	
	public String toString(){
		return "(" + x + "," + y + ")";
	}
}
