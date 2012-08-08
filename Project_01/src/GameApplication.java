import javax.swing.*;

/**
 * 
 */

/**
 * @author Cody Dietz
 *
 */
public class GameApplication extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4153159649269134645L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create primitive variables
		String input;
		double p;
		
		// Solicit probability of yellow
		do{
		input = JOptionPane.showInputDialog(null, "Enter the probability of yellow <= 0.3");
		}while(Double.parseDouble(input) > 0.3 || input == null || input == "");
		
		p = Double.parseDouble(input);
		
		// Instantiate all necessary JFrames
		ScoreBoard board = new ScoreBoard();
		GameField field = new GameField();
		
		// Set variables and paint JFrame to screen
		field.setBoard(board);
		board.setField(field);
		field.setYellow(p);
		field.open();
		board.open();
	}

}
