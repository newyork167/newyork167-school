/**
 * 
 */

/**
 * @author Cody Dietz
 *
 */
public class Exam {

	String name;
	int score;
	
	// Constructor
	public Exam(String name, int score){
		this.name = name;
		this.score = score;
	}
	
	// Accessors
	public int getScore(){
		return score;
	}
	
	public String getName(){
		return name;
	}
	
	// Mutators
	public void changeScore(int score){
		this.score = score;
	}
	
	public void changeName(String name){
		this.name = name;
	}
	
	// toString method
	public String toString(){
		return "Name: " + name + ", Score: " + score;
	}
}
