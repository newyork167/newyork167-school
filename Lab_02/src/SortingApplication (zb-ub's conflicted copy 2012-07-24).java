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
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter file path: ");
		String input = keyboard.nextLine();
		
		// Test file
//		String input = "/home/zerobytegeek/Dropbox/School/Summer 2012/CS 161/Labs/input.txt";
		
		File gradesFile = new File(input);
		ArrayList<Exam> gradesList = new ArrayList<Exam>();
		Scanner grade = new Scanner(gradesFile);
		
		while(grade.hasNext()){
			gradesList.add(new Exam(grade.next(), grade.nextInt()));
		}
		
		SortingExams sorted = new SortingExams();
		
		// Print sorted by name
		sorted.sortByName(gradesList);
		
		for(int i=0;i<gradesList.size();i++){
			System.out.println(gradesList.get(i));
		}
		System.out.println();
		
		// Print sorted by score
		sorted.sortByScore(gradesList);
		
		for(int i=0;i<gradesList.size();i++){
			System.out.println(gradesList.get(i));
		}
		
		System.out.println();
		
		// Searching for three names, one of which is not in the list
		sorted.searchByName(gradesList, "Cody");
		sorted.searchByName(gradesList, "Superkraut");
		sorted.searchByName(gradesList, "Einstein");
		
		// Removing one object and checking to make sure it has been removed
		sorted.removeByName(gradesList, "Einstein");
		sorted.searchByName(gradesList, "Einstein");
	}
}
