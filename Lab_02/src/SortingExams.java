import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Cody Dietz
 *
 */
public class SortingExams {

	// Method for sorting by name
	// I know there are simpler and better ways to sort, 
	// I was just playing around with different ways to sort the material
	public ArrayList<Exam> sortByName(ArrayList<Exam> nameList){
		for(int i=0;i<nameList.size();i++){
			Exam lowest = nameList.get(i);
			for(int j=1;j<nameList.size();j++){
				if(nameList.get(j).name.charAt(0) > lowest.name.charAt(0)){
					Exam temp = new Exam(lowest.name, lowest.score);
					lowest.name = nameList.get(j).name;
					lowest.score = nameList.get(j).score;
					nameList.get(j).name = temp.name;
					nameList.get(j).score = temp.score;
				}
			}
		}
		Exam temp = new Exam(nameList.get(0).name, nameList.get(0).score);
		nameList.add(nameList.size(), temp);
		nameList.remove(0);
		return nameList;
	}
	
	// Method for sorting by score
	public ArrayList<Exam> sortByScore(ArrayList<Exam> scoreList){
		for(int i=0;i<scoreList.size();i++){
			Exam lowest = scoreList.get(i);
			
			for(int j=1;j<scoreList.size();j++){
				if(scoreList.get(j).score > lowest.score){
					Exam temp = new Exam(lowest.name, lowest.score);
					lowest.name = scoreList.get(j).name;
					lowest.score = scoreList.get(j).score;
					scoreList.get(j).name = temp.name;
					scoreList.get(j).score = temp.score;
				}
			}
		}
		Exam temp = new Exam(scoreList.get(0).name, scoreList.get(0).score);
		scoreList.add(scoreList.size(), temp);
		scoreList.remove(0);
		return scoreList;
	}
	
	// Method to search for name and return value
	public int searchByName(ArrayList<Exam> namesList, String name){
		for(int i=0;i<namesList.size();i++){			
//			System.out.println("namesList(i) = " + namesList.get(i).name + ", String name = " + name.toString());
			if(namesList.get(i).name.equals(name)){
				return i;
			}
		}
		
		System.out.println("Search failed for " + name);
		return -1;
	}
	
	// Method to remove elements based on name
	public void removeByName(ArrayList<Exam> namesList, String name){
		for(int i=0;i<namesList.size();i++){
			if(namesList.get(i).name.equals(name)){
				namesList.remove(i);
				System.out.println("Item has been removed");
				return;
			}
		}
		
		System.out.println("No item was removed");
	}
}
