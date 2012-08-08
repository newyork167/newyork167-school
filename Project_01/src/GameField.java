import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * 
 */

/**
 * @author Cody Dietz
 *
 */
public class GameField extends JFrame {
	
	/**
	 * 
	 * I changed the layout of the code, was unsure whether that was what was meant
	 * in the Project Notes that were given to us. I decided not to implement a new
	 * method for the actionListener and instead made inner classes for each
	 * 
	 */
	private static final long serialVersionUID = 409226195175835068L;
	// Create variables and JFrame reference for the score board
	private double yellow;
	private ScoreBoard board;
	int round = 0;
	private boolean choseRed = false, choseBlue = false;
	
	// Create JPanel
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();

	// Instantiate components for panels
	JButton activateButtons = new JButton("Activate Buttons");
	private JButton randomColoring = new JButton("Random Coloring");
	private JButton colorRed = new JButton("Color Red");
	private JButton colorBlue = new JButton("Color Blue");
	private JButton stopProcess = new JButton("Stop the Process");
	private JLabel randomColorMessage = new JLabel("This field is randomly colored");
	private JLabel buttonColorMessage = new JLabel("This field is button colored");

	// Create an enumerated color type for randomColor() use
	public enum color{
		RED, BLUE, YELLOW
	}
	
	// Start JFrame for Game Field
	public void open(){	
		setTitle("Game Field - Round " + round + " --- Player 1");
		setBounds(100, 200, 300, 300);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel1.add(activateButtons);
		activateButtons.setEnabled(false);
		panel1.setBorder(new LineBorder(Color.GREEN, 3));
		activateButtons.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				colorRed.setEnabled(true);
				colorBlue.setEnabled(true);
				activateButtons.setEnabled(false);
			}
		});
		
		panel2.add(randomColorMessage);
		panel2.setBorder(new LineBorder(Color.BLACK, 3));
		randomColorMessage.setBorder(new LineBorder(Color.BLACK, 2));
		randomColorMessage.setBackground(Color.MAGENTA);
		randomColorMessage.setOpaque(true);
		
		panel3.add(buttonColorMessage);
		panel3.setBorder(new LineBorder(Color.BLACK, 3));
		buttonColorMessage.setBorder(new LineBorder(Color.BLACK, 2));
		buttonColorMessage.setBackground(Color.WHITE);
		buttonColorMessage.setOpaque(true);
		
		// Add Random coloring button
		panel4.add(randomColoring);
		randomColoring.setEnabled(false);
		// Random Coloring inner class for action handling
		randomColoring.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				randomColoring.setEnabled(false);
				board.nextPlayer.setEnabled(true);
				color temp = randomColor();
				
				// Based on player turn and randomColor() find out 
				// whether player has won or lost against computer
				// This is done by comparing the randomly chosen 
				// enumerated type to the player chosen color
				// I chose to implement this as part of actionPerformed
				// rather than having a separate method. Not sure
				// if that was what was meant when it was said we are free to 
				// change whatever we wanted in the notes.
				
				// Player 1
				if(board.playerTurn == true){
					if(temp == color.RED){
					panel2.setBackground(Color.RED);
						if(choseRed == true){
							board.updateScore(board.player1);
						}
						else{
							board.updateScore(-board.player1);
						}
						board.playerTurn = false;
						choseRed = false; choseBlue = false;
					}
					else if(temp == color.BLUE){
						panel2.setBackground(Color.BLUE);
						
						if(choseBlue == true){
							board.updateScore(board.player1);
						}
						else{
							board.updateScore(-board.player1);
						}
						board.playerTurn = false;
						choseRed = false; choseBlue = false;
					}
					else{
						panel2.setBackground(Color.YELLOW);
						choseRed = false; choseBlue = false;
						board.updateScore(-board.player1);
						board.playerTurn = false;
					}
				}
				// Player 2
				else{
					if(temp == color.RED){
						panel2.setBackground(Color.RED);
					
						if(choseRed == true){
							board.updateScore(board.player2);
						}
						else{
							board.updateScore(-board.player2);
						}
						board.playerTurn = true;
						choseRed = false; choseBlue = false;
					}
					else if(temp == color.BLUE){
						panel2.setBackground(Color.BLUE);
						
						if(choseBlue == true){
							board.updateScore(board.player2);
						}
						else{
							board.updateScore(-board.player2);
						}
						board.playerTurn = true;
						choseRed = false; choseBlue = false;
					}
					else{
						panel2.setBackground(Color.YELLOW);
						choseRed = false; choseBlue = false;
						board.updateScore(-board.player2);
						board.playerTurn = true;
					}
				}
			}
		});
		
		// Create red coloring button
		panel4.add(colorRed);
		colorRed.setBackground(Color.RED);
		colorRed.setForeground(Color.WHITE);
		colorRed.setEnabled(false);
		colorRed.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				panel3.setBackground(Color.RED);
				panel3.setOpaque(true);
				buttonColorMessage.setBackground(Color.WHITE);
				buttonColorMessage.setForeground(Color.BLACK);
				buttonColorMessage.setOpaque(true);
				colorRed.setEnabled(false);
				colorBlue.setEnabled(false);
				randomColoring.setEnabled(true);
				choseRed = true;
			}
		});
		
		// Create blue coloring button
		panel4.add(colorBlue);
		colorBlue.setBackground(Color.BLUE);
		colorBlue.setForeground(Color.YELLOW);
		colorBlue.setEnabled(false);
		colorBlue.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				panel3.setBackground(Color.BLUE);
				panel3.setOpaque(true);
				colorRed.setEnabled(false);
				colorBlue.setEnabled(false);
				randomColoring.setEnabled(true);
				choseBlue = true;
			}
		});
		
		// Create stop process for button for exiting game immediately
		panel4.add(stopProcess, BorderLayout.SOUTH);
		stopProcess.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		// Add panels to JFrame
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.WEST);
		add(panel3, BorderLayout.EAST);
		add(panel4, BorderLayout.SOUTH);
		
		// Pack JFrame and print to screen
		pack();
		setSize(500, 200);
		setVisible(true);
	}
	
	public void setBoard(ScoreBoard board){
		// Create JFrame reference for Score Board
		this.board = board;
	}
	
	public void setYellow(double yellow){
		// Instantiate probability of yellow
		this.yellow = yellow;
	}
	
	public void reset(){
		panel2.setBackground(null);
		panel3.setBackground(null);

	}
	
	// Return a random color based on random choosing of enumerated type
	public color randomColor(){
		int pick = new Random().nextInt(color.values().length);
		double pick2 = new Random().nextDouble();
		
		if(yellow == 0){
			while(color.values()[pick] == color.YELLOW){
				pick = new Random().nextInt(color.values().length);
			}
			return color.values()[pick];
		}
		else{
			if(pick2 <= yellow){
				return color.YELLOW;
			}
			else
				return color.values()[pick];
		}
	}
}
