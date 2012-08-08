import java.util.Scanner;


public class Lab4Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		Division division = new Division();
		
		System.out.print("Enter integer 1: ");
		int num1 = keyboard.nextInt();
		System.out.print("Enter integer 2: ");
		int num2 = keyboard.nextInt();
		
		System.out.println("Result: " + division.divide(num1, num2));
		
		System.out.print("Enter double 1: ");
		double num3 = keyboard.nextDouble();
		System.out.print("Enter double 2: ");
		double num4 = keyboard.nextDouble();
		
		System.out.println("Result: " + division.divide(num3, num4));
	}

}
