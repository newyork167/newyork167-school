import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

/**
 * 
 */

/**
 * @author Cody Dietz
 *
 */
public class SortingApplication {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
//		Scanner keyboard = new Scanner(System.in);
//		System.out.print("Enter file path: ");
//		String input = keyboard.nextLine();
		
		// Test file - Mac
		String input = "/Users/Newyork167/Dropbox/School/Summer 2012/CS 161/Labs/input.txt";
		
		File gradesFile = new File(input);
		ArrayList<Exam> gradesList = new ArrayList<Exam>();
		Scanner grade = new Scanner(gradesFile);
		
		while(grade.hasNext()){
			gradesList.add(new Exam(grade.next(), grade.nextInt()));
		}
		
		SortingExams sorted = new SortingExams();
		
//		for(int i=0;i<3;i++){
//			System.out.print("Enter name to find");
//			String name = keyboard.next();
//			System.out.println(sorted.searchByName(gradesList, name));
//		}
		
		sorted.sortByScore(gradesList);
		
		for(int i=0;i<gradesList.size();i++){
			System.out.println(gradesList.get(i));
		}
		
		System.out.println();
		
		sorted.sortByName(gradesList);
		
		for(int i=0;i<gradesList.size();i++){
			System.out.println(gradesList.get(i));
		}
		
//		System.out.print("Enter name to find: ");
//		String name = keyboard.next();
//		
//		System.out.print(sorted.searchByName(gradesList, name));
	}
}
