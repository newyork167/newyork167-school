import java.io.IOException;

import javax.swing.JOptionPane;


public class MainDriver {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[] choices = {"Yes", "No"};
		
		int openBank = JOptionPane.showOptionDialog(null, "Ready to open the Lobby?\nClick no to terminate the program", "Programmer's Bank", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choices, "No");
		
		switch (openBank){
		case 0:
			Lobby lobby = new Lobby();
			break;
		case -1:
		default:
			System.exit(0);
		}
	}
}
