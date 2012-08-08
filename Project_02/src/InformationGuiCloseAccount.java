import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class InformationGuiCloseAccount extends JFrame{
	// Add Components/panels/variables
	Lobby lobby;
	private JPanel panelNorth = new JPanel();
	private JPanel panelEast = new JPanel(new GridLayout(2,0));
	private JPanel panelWest = new JPanel(new GridLayout(2,0));
	private JPanel panelSouth = new JPanel();
	private JButton returnButton = new JButton("RETURN");
	
	public InformationGuiCloseAccount(Customer customer, final Lobby lobby){
		// Create frame
		final JFrame frame = new JFrame("Welcome to the Programmer\'s Bank!");
		frame.setBounds(100, 100, 300, 150);
		this.setLayout(new BorderLayout());
		
		// Add components to panels
		panelNorth.add(new JLabel("Thank you for banking with us"));
		panelWest.add(new JLabel("Customer name ------>"));
		panelWest.add(new JLabel("Total balance ------>"));
		
		panelEast.add(new JLabel(customer.name));
		panelEast.add(new JLabel(Double.toString(customer.accounts[0].balance + customer.accounts[1].balance + customer.accounts[2].balance)));
		
		panelSouth.add(returnButton);
		
		// Add button listener
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				frame.setVisible(false);
				lobby.nextCustomer();
			}
		});
		
		// Add panels to frame
		frame.add(panelNorth, BorderLayout.NORTH);
		frame.add(panelEast, BorderLayout.EAST);
		frame.add(panelSouth, BorderLayout.SOUTH);
		frame.add(panelWest, BorderLayout.WEST);
		
//		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
