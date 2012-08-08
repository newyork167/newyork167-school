import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class InformationGuiTransaction extends JFrame{
	// Create necessary JComponents/Jpanels
	JFrame frame = new JFrame("Welcome to the Programmer\'s Bank!");
	JPanel panelNorth = new JPanel();
	JPanel panelEast = new JPanel(new GridLayout(4,0));
	JPanel panelWest = new JPanel(new GridLayout(4,0));
	JPanel panelSouth = new JPanel();
	JButton returnButton = new JButton("RETURN");
	Lobby lobby;
	
	public InformationGuiTransaction(String type, String account, Double amount, Customer customer, final Lobby lobby){
		frame.setLayout(new BorderLayout());
		this.lobby = lobby;
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		lobby.dailyTotal += amount;
		
		String[] transaction = new String[2];
		transaction[0] = customer.accountNumber;
		transaction[1] = Double.toString(amount);
		
		lobby.transactions.add(transaction);
		
		// Add JLabels
		if(type.equals("deposit")){
			panelNorth.add(new JLabel("You deposited $" + amount + " dollars to your " + account + " account"));
		}
		else if(type.equals("withdraw")){
			panelNorth.add(new JLabel("You withdrew $" + amount + " dollars from your " + account + " account"));
		}
		else{
			if(account.equals("checking")){
				panelNorth.add(new JLabel("You transferred $" + amount + " dollars from your checking to your savings"));
			}
			else{
				panelNorth.add(new JLabel("You transferred $" + amount + " dollars from your savings to your checking"));
			}
		}
		
		panelSouth.add(new JLabel("Click and return to lobby --->"));
		panelSouth.add(returnButton);
		
		panelWest.add(new JLabel("Account Holder --->"));
		panelWest.add(new JLabel("Checking Account ->"));
		panelWest.add(new JLabel("Savings Account -->"));
		panelWest.add(new JLabel("Money Market ----->"));
		panelEast.add(new JLabel(customer.name));
		panelEast.add(new JLabel(Double.toString(customer.accounts[0].balance)));
		panelEast.add(new JLabel(Double.toString(customer.accounts[1].balance)));
		panelEast.add(new JLabel(Double.toString(customer.accounts[2].balance)));
		
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				frame.setVisible(false);
				lobby.nextCustomer();
			}
		});
		
		frame.add(panelEast, BorderLayout.EAST);
		frame.add(panelNorth, BorderLayout.NORTH);
		frame.add(panelSouth, BorderLayout.SOUTH);
		frame.add(panelWest, BorderLayout.WEST);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		lobby.nextCustomer();
	}
}
