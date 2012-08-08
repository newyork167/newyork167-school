package codyPersonalProjects;

import java.util.Random;

import javax.swing.JOptionPane;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = JOptionPane.showInputDialog(null, "Enter number of Restaurants");
		String[] stringArray = new String[Integer.parseInt(input)];
		
		for(int i=0;i<Integer.parseInt(input);i++)
		{
			stringArray[i] = JOptionPane.showInputDialog(null, "Enter Restaurant Name");
		}
		JOptionPane.showMessageDialog(null, chooser(stringArray));
	}
	
	public static String chooser(String[] stringArray){
		Random rand = new Random();
		return stringArray[rand.nextInt(stringArray.length)];
	}

}
