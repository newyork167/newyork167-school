import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class InformationGuiOpenAccount extends JFrame{
	// Create various JComponents/JPanels
	JFrame frame = new JFrame("Welcome to the Programmer\'s Bank!");
	JPanel panelNorth = new JPanel();
	JPanel panelEast = new JPanel(new GridLayout(6,0));
	JPanel panelWest = new JPanel(new GridLayout(6,0));
	JPanel panelSouth = new JPanel();
	JButton returnButton = new JButton("RETURN");
	Lobby lobby;
	
	public InformationGuiOpenAccount(final Lobby lobby, String name, double checkings, double savings, double moneyMarket, String accountNumber, String pin){
		this.lobby = lobby;
		frame.setLayout(new BorderLayout());
		lobby.dailyTotal += checkings + savings;
		
		// Add button action
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				frame.setVisible(false);
				lobby.nextCustomer();
			}
		});
		
		// Insert JLabels. I decided it would be quicker
		// to instantiate them as I need them for now.
		panelNorth.add(new JLabel("We are happy to serve you!"));
		panelSouth.add(new JLabel("Click and return to the loby --->"));
		panelSouth.add(returnButton);
		panelWest.add(new JLabel("New Account Holder ------->"));
		panelWest.add(new JLabel("Your Account Number ------>"));
		panelWest.add(new JLabel("Your PIN Code ------------>"));
		panelWest.add(new JLabel("Checking Account Balance ->"));
		panelWest.add(new JLabel("Savings Account Balacnce ->"));
		panelWest.add(new JLabel("Money Market Balance ----->"));
		panelEast.add(new JLabel(name));
		panelEast.add(new JLabel(accountNumber));
		panelEast.add(new JLabel(pin));
		panelEast.add(new JLabel(Double.toString(checkings)));
		panelEast.add(new JLabel(Double.toString(savings)));
		panelEast.add(new JLabel(Double.toString(moneyMarket)));
		
		frame.add(panelEast, BorderLayout.EAST);
		frame.add(panelNorth, BorderLayout.NORTH);
		frame.add(panelSouth, BorderLayout.SOUTH);
		frame.add(panelWest, BorderLayout.WEST);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}

