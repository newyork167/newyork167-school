import java.util.Scanner;

//package Lab_02;

public class MainApplicationDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		
		// Solicit input from user and create two points
		System.out.print("Enter X Coordinate (Point 1): ");
		double x1 = keyboard.nextDouble();
		System.out.print("Enter Y Coordinate (Point 1): ");
		double y1 = keyboard.nextDouble();
		
		Point point1 = new Point(x1, y1);
		
		System.out.print("Enter X Coordinate (Point 2): ");
		double x2 = keyboard.nextDouble();
		System.out.print("Enter Y Coordinate (Point 2): ");
		double y2 = keyboard.nextDouble();
		
		Point point2 = new Point(x2, y2);
		
		System.out.println("\nPoint 1: " + point1);
		System.out.println("Point 2: " + point2);
		
		// Create Circle object and print data
		Circle circle = new Circle(point1, point2);
		
		System.out.println("\nArea of Circle: " + circle.calculateArea());
		System.out.println("Radius of Circle: " + circle.getRadius());
		System.out.println("Circumference of Circle: " + circle.calculateCircumference());
		
		// Create Cylinder object and output data
		System.out.print("\nEnter height of Cylinder: ");
		double height = keyboard.nextDouble();
		
		Cylinder cylinder = new Cylinder(point1, point2, height);
		
		System.out.println("\nSurface Area of Cylinder: " + cylinder.getSurfaceArea());
		System.out.println("Volume of Cylinder: " + cylinder.getVolume());
	}

}
