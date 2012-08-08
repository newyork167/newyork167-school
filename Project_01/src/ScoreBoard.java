import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * 
 */

/**
 * @author Cody Dietz
 *
 */
public class ScoreBoard extends JFrame {
	
	/**
	 * I changed the layout of the code, was unsure whether that was what was meant
	 * in the Project Notes that were given to us. I decided not to implement a new
	 * method for the actionListener and instead made inner classes for each
	 */
	private static final long serialVersionUID = 6057258600722958619L;
	// Create primitive variables for basic tasks
	boolean playerTurn = true, playerHasBet = false;
	int player1Score = 0, player2Score = 0;
	GameField field;
	int player1=0, player2=0;
	
	// Create components for panels
	JLabel instructions = new JLabel("Click 'Next Player' then make your bet and push 'Enter' on the keyboard");
	JTextField player1wager = new JTextField(3);
	JTextField player2wager = new JTextField(3);
	JLabel player1ScoreLabel = new JLabel(Integer.toString(player1Score));
	JLabel player2ScoreLabel = new JLabel(Integer.toString(player2Score));
	JLabel player1WagerLabel = new JLabel("Player 1 wager:");
	JLabel player2WagerLabel = new JLabel("Player 2 wager");
	JLabel player1Total = new JLabel("Player 1 Total:");
	JLabel player2Total = new JLabel("Player 2 Total:");
	JButton nextPlayer = new JButton("Next Player");
	
	// Create panels for components
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	JPanel panel6 = new JPanel();
	
	// Create JFrame and paint to screen
	public void open(){
		// Create JFrame references
		setTitle("Score Board");
		setSize(new Dimension(300, 500));
		setBounds(800,200,200,150);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Intialize instructions for players
		panel1.add(instructions);
		instructions.setBackground(Color.CYAN);
		instructions.setOpaque(true);
		
		
		// Initialize panel 2 with appropriate inner classes - (Player running totals)
		panel2.add(player1Total);
//		panel2.setBackground(Color.GREEN);
		panel2.setPreferredSize(new Dimension(100, 30));
		player1Total.setBackground(Color.GREEN);
		player1Total.setOpaque(true);
		panel2.add(player1ScoreLabel);
		player1ScoreLabel.setPreferredSize(new Dimension(100, 30));
		player1ScoreLabel.setBorder(new LineBorder(Color.BLACK, 3));
		panel2.add(player2Total);
		panel2.add(player2ScoreLabel);
		player2Total.setBackground(Color.PINK);
		player2Total.setOpaque(true);
		player2ScoreLabel.setPreferredSize(new Dimension(100, 30));
		player2ScoreLabel.setBorder(new LineBorder(Color.BLACK, 3));
		
		
		// Initialize panel 3 with appropriate inner classes - (Wager input and wager labels)
		// Add Player 1 wager label/text field
		panel3.add(player1WagerLabel);
		player1WagerLabel.setPreferredSize(new Dimension(100, 30));
		player1WagerLabel.setBorder(new LineBorder(Color.BLACK, 3));
		player1WagerLabel.setBackground(Color.GREEN);
		player1WagerLabel.setOpaque(true);
		panel3.add(player1wager);
		player1wager.setPreferredSize(new Dimension(100, 30));
		player1wager.setBorder(new LineBorder(Color.GREEN, 3));
		player1wager.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String wager = player1wager.getText();
				player1wager.setEditable(false);
				field.activateButtons.setEnabled(true);
				player1 = Integer.parseInt(wager);
			}
		});
		
		// Add Player 2 wager label/text field
		panel3.add(player2WagerLabel);
		player2WagerLabel.setPreferredSize(new Dimension(100, 30));
		player2WagerLabel.setBorder(new LineBorder(Color.BLACK, 3));
		player2WagerLabel.setBackground(Color.PINK);
		player2WagerLabel.setOpaque(true);
		panel3.add(player2wager);
		player2wager.setEditable(false);
		player2wager.setPreferredSize(new Dimension(100, 30));
		player2wager.setBorder(new LineBorder(Color.PINK, 3));
		player2wager.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String wager = player2wager.getText();
				player2wager.setEditable(false);
				field.activateButtons.setEnabled(true);
				player2 = Integer.parseInt(wager);
			}
		});
		
		
		// Initialize nextPlayer button and create actionListener inner class
		panel5.add(nextPlayer);
		nextPlayer.setEnabled(false);
		nextPlayer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				field.reset();
				
				// Set GameField title based on nextPlayer button press
				if(playerTurn == true){
					field.round++;
					field.setTitle("Game Field - Round " + field.round + " --- Player 1");
				}
				else{
					field.round++;
					field.setTitle("Game Field - Round " + field.round + " --- Player 2");
				}
				
				// Disable nextPlayer button
				nextPlayer.setEnabled(false);
				
				// Make next player textField editable
				if(playerTurn == true){
					player1wager.setEditable(true);
				}
				else{
					player2wager.setEditable(true);
				}
			}
		});
		
		// Add panels to JFrame
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.EAST);
		add(panel3, BorderLayout.WEST);
		add(panel5, BorderLayout.SOUTH);
		
		// Pack frame and make visible on screen
		pack();
		setSize(450, 225);
		setVisible(true);
	}
	
	public void setField(GameField field){
		// Create reference to GameField JFrame
		this.field = field;
	}
	
	// Update score and repaint corresponding JPanels
	public void updateScore(int score){
		if(playerTurn == true){
			player1Score += score;
			panel2.removeAll();
			
			// Recreate panel with correct information
			panel2.add(player1Total);
//			panel2.setBackground(Color.GREEN);
			panel2.setPreferredSize(new Dimension(100, 30));
			player1Total.setBackground(Color.GREEN);
			player1Total.setOpaque(true);
			panel2.add(player1ScoreLabel = new JLabel(Integer.toString(player1Score)));
			player1ScoreLabel.setPreferredSize(new Dimension(100, 30));
			player1ScoreLabel.setBorder(new LineBorder(Color.BLACK, 3));
			panel2.add(player2Total);
			panel2.add(player2ScoreLabel = new JLabel(Integer.toString(player2Score)));
			player2Total.setBackground(Color.PINK);
			player2Total.setOpaque(true);
			player2ScoreLabel.setPreferredSize(new Dimension(100, 30));
			player2ScoreLabel.setBorder(new LineBorder(Color.BLACK, 3));
			
			// Repaint panel
			panel2.revalidate();
			panel2.repaint();
		}
		else{
			player2Score += score;
			panel2.removeAll();
			
			// Recreate panel with correct information
			panel2.add(player1Total);
//			panel2.setBackground(Color.GREEN);
			panel2.setPreferredSize(new Dimension(100, 30));
			player1Total.setBackground(Color.GREEN);
			player1Total.setOpaque(true);
			panel2.add(player1ScoreLabel = new JLabel(Integer.toString(player1Score)));
			player1ScoreLabel.setPreferredSize(new Dimension(100, 30));
			player1ScoreLabel.setBorder(new LineBorder(Color.BLACK, 3));
			panel2.add(player2Total);
			panel2.add(player2ScoreLabel = new JLabel(Integer.toString(player2Score)));
			player2Total.setBackground(Color.PINK);
			player2Total.setOpaque(true);
			player2ScoreLabel.setPreferredSize(new Dimension(100, 30));
			player2ScoreLabel.setBorder(new LineBorder(Color.BLACK, 3));
			
			// Repaint panel
			panel2.revalidate();
			panel2.repaint();
		}
			
	}
}
