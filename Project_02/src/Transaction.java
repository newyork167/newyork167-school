import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Transaction extends OrganizerGUI{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2469121505332674614L;
	// Create variables needed for class
	Lobby lobby;
	int tries = 0;
	
	// Panels for name/pin
	private JPanel panelCenterNorth = new JPanel(new BorderLayout());
	private JPanel panelCenterNorthNorth = new JPanel();
	private JPanel panelCenterNorthEast = new JPanel(new GridLayout(3,1));
	private JPanel panelCenterNorthWest = new JPanel();
	
	// Panels for transaction
	private JPanel panelCenterCenter = new JPanel(new BorderLayout());
	private JPanel panelCenterCenterNorth = new JPanel();
	private JPanel panelCenterCenterSouth = new JPanel();
	
	// Panels for radio buttons
	private JPanel panelCenterSouth = new JPanel(new BorderLayout());
	private JPanel panelCenterSouthEast = new JPanel(new GridLayout(3,0));
	private JPanel panelCenterSouthCenter = new JPanel(new GridLayout(3,0));
	private JPanel panelCenterSouthWest = new JPanel();
	
	//Radio buttons and JButtons
	private JButton ready = new JButton("READY");
	private JButton amountCorrect = new JButton("Amount Correct");
	private JRadioButton deposit = new JRadioButton("DEPOSIT");
	private JRadioButton withdraw = new JRadioButton("WITHDRAW");
	private JRadioButton transfer = new JRadioButton("TRANSFER");
	private JRadioButton checking = new JRadioButton("Checking");
	private JRadioButton savings = new JRadioButton("Savings");
	private JRadioButton moneyMarket = new JRadioButton("Money Market");
	
	// JLabels
	private JLabel name = new JLabel("<html>Enter your name here -------><br>Your PIN Code -----------><br>Click when ready ------------></html>");
	private JLabel amount = new JLabel("Enter Amount of Transaction ---------->");
	private JLabel selection = new JLabel("Select the transaction and the sub-account -->");
	
	//JTextFields
	private JTextField nameText = new JTextField(20);
	private JPasswordField pin = new JPasswordField(4);
	private JTextField amountTransaction = new JTextField(10);
	
	// Constructor
	public Transaction(final Lobby lobby){
		// Allow access to lobby object
		this.lobby = lobby;
		amountTransaction.setEnabled(false);
		deposit.setEnabled(false);
		withdraw.setEnabled(false);
		transfer.setEnabled(false);
		checking.setEnabled(false);
		savings.setEnabled(false);
		moneyMarket.setEnabled(false);
		amountCorrect.setEnabled(false);
		
		// Instantiate super panel
		panelCenter = new JPanel(new BorderLayout());
		
		// Add radio buttons to group
		final ButtonGroup choices = new ButtonGroup();
		choices.add(deposit);
		choices.add(withdraw);
		choices.add(transfer);
		
		final ButtonGroup accounts = new ButtonGroup();
		accounts.add(checking);
		accounts.add(savings);
		accounts.add(moneyMarket);
		
		// Add components to panels
		panelCenterNorthWest.add(name);
		panelCenterNorthEast.add(nameText);
		panelCenterNorthEast.add(pin);
		panelCenterNorthEast.add(ready);
		panelCenterNorthNorth.add(new JLabel("<html><font color = RED>Name and PIN do not match! Repeat!</font></html>"), BorderLayout.NORTH);
		panelCenterNorthNorth.setVisible(false);
		
		panelCenterCenterNorth.add(amount);
		panelCenterCenterNorth.add(amountTransaction);
		panelCenterCenterNorth.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 3));
		panelCenterCenterSouth.add(amountCorrect);
		
		panelCenterSouthWest.add(selection);
		panelCenterSouthCenter.add(deposit);
		panelCenterSouthCenter.add(withdraw);
		panelCenterSouthCenter.add(transfer);
		panelCenterSouthCenter.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
		panelCenterSouthEast.add(checking);
		panelCenterSouthEast.add(new JLabel("To Savings"));
		panelCenterSouthEast.add(savings);
		panelCenterSouthEast.add(new JLabel("To Checkings"));
		panelCenterSouthEast.add(moneyMarket);
		panelCenterSouthEast.add(new JLabel("<html>Deposit/Withdraw<br>Only</html>"));
		panelCenterSouthEast.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
		
		
		// Add button actions
		cancelProcess.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				choices.clearSelection();
				lobby.nextCustomer();
			}
		});
		
		ready.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String nameCheck = nameText.getText();
				char[] pinCheck = pin.getPassword();
				
				// Check for empty fields
				if(nameCheck.trim().equals("")){
					
				}
				else if(pinCheck.equals("")){
					
				}
				else{
					if(lobby.identifier(nameText.getText(), new String(pinCheck)) != null){
						ready.setEnabled(false);
						amountTransaction.setEnabled(true);
						amountCorrect.setEnabled(true);
						deposit.setEnabled(true);
						deposit.setSelected(true);
						withdraw.setEnabled(true);
						transfer.setEnabled(true);
						checking.setEnabled(true);
						checking.setSelected(true);
						savings.setEnabled(true);
						moneyMarket.setEnabled(true);
						amountCorrect.setEnabled(true);
						nameText.setEditable(false);
						pin.setEditable(false);
						frame.pack();
					}
					else{
						panelCenterNorthNorth.setVisible(true);
						System.out.println("Customer not found");
						frame.pack();
						nameText.setText("");
						pin.setText(null);
						tries++;
						if(tries == 3){
							tries = 0;
							frame.setVisible(false);
							lobby.nextCustomer();
						}
					}
				}
			}
		});
		
		// Add amountCorrect button action.
		amountCorrect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				if(checking.isSelected()){
					if(deposit.isSelected()){
						lobby.identifier(nameText.getText(), new String(pin.getPassword())).accounts[0].balance += Double.parseDouble(amountTransaction.getText());
						frame.setVisible(false);
						InformationGuiTransaction information = new InformationGuiTransaction("deposit", "checking", Double.parseDouble(amountTransaction.getText()), lobby.identifier(nameText.getText(), new String(pin.getPassword())), lobby);
						amountTransaction.setEnabled(false);
						deposit.setEnabled(false);
						withdraw.setEnabled(false);
						transfer.setEnabled(false);
						checking.setEnabled(false);
						savings.setEnabled(false);
						moneyMarket.setEnabled(false);
						amountCorrect.setEnabled(false);
						ready.setEnabled(true);
						nameText.setEditable(true);
						pin.setEditable(true);
						nameText.setText("");
						pin.setText("");
						amountTransaction.setText("");
					}
					else if(withdraw.isSelected()){
						lobby.identifier(nameText.getText(), new String(pin.getPassword())).accounts[0].balance -= Double.parseDouble(amountTransaction.getText());
						frame.setVisible(false);
						InformationGuiTransaction information = new InformationGuiTransaction("withdraw", "checking", Double.parseDouble(amountTransaction.getText()), lobby.identifier(nameText.getText(), new String(pin.getPassword())), lobby);
						amountTransaction.setEnabled(false);
						deposit.setEnabled(false);
						withdraw.setEnabled(false);
						transfer.setEnabled(false);
						checking.setEnabled(false);
						savings.setEnabled(false);
						moneyMarket.setEnabled(false);
						amountCorrect.setEnabled(false);
						ready.setEnabled(true);
						nameText.setEditable(true);
						pin.setEditable(true);
						nameText.setText("");
						pin.setText("");
						amountTransaction.setText("");
					}
					else{
						lobby.identifier(nameText.getText(), new String(pin.getPassword())).accounts[1].balance += Double.parseDouble(amountTransaction.getText());
						lobby.identifier(nameText.getText(), new String(pin.getPassword())).accounts[0].balance -= Double.parseDouble(amountTransaction.getText());
						frame.setVisible(false);
						InformationGuiTransaction information = new InformationGuiTransaction("transfer", "checking", Double.parseDouble(amountTransaction.getText()), lobby.identifier(nameText.getText(), new String(pin.getPassword())), lobby);
						amountTransaction.setEnabled(false);
						deposit.setEnabled(false);
						withdraw.setEnabled(false);
						transfer.setEnabled(false);
						checking.setEnabled(false);
						savings.setEnabled(false);
						moneyMarket.setEnabled(false);
						amountCorrect.setEnabled(false);
						ready.setEnabled(true);
						nameText.setEditable(true);
						pin.setEditable(true);
						nameText.setText("");
						pin.setText("");
						amountTransaction.setText("");
					}
				}
				else if(savings.isSelected()){
					if(deposit.isSelected()){
						lobby.identifier(nameText.getText(), new String(pin.getPassword())).accounts[1].balance += Double.parseDouble(amountTransaction.getText());
						frame.setVisible(false);
						InformationGuiTransaction information = new InformationGuiTransaction("deposit", "savings", Double.parseDouble(amountTransaction.getText()), lobby.identifier(nameText.getText(), new String(pin.getPassword())), lobby);
						amountTransaction.setEnabled(false);
						deposit.setEnabled(false);
						withdraw.setEnabled(false);
						transfer.setEnabled(false);
						checking.setEnabled(false);
						savings.setEnabled(false);
						moneyMarket.setEnabled(false);
						amountCorrect.setEnabled(false);
						ready.setEnabled(true);
						nameText.setEditable(true);
						pin.setEditable(true);
						nameText.setText("");
						pin.setText("");
						amountTransaction.setText("");
					}
					else if(withdraw.isSelected()){
						lobby.identifier(nameText.getText(), new String(pin.getPassword())).accounts[1].balance -= Double.parseDouble(amountTransaction.getText());
						frame.setVisible(false);
						InformationGuiTransaction information = new InformationGuiTransaction("withdraw", "savings", Double.parseDouble(amountTransaction.getText()), lobby.identifier(nameText.getText(), new String(pin.getPassword())), lobby);
						amountTransaction.setEnabled(false);
						deposit.setEnabled(false);
						withdraw.setEnabled(false);
						transfer.setEnabled(false);
						checking.setEnabled(false);
						savings.setEnabled(false);
						moneyMarket.setEnabled(false);
						amountCorrect.setEnabled(false);
						ready.setEnabled(true);
						nameText.setEditable(true);
						pin.setEditable(true);
						nameText.setText("");
						pin.setText("");
						amountTransaction.setText("");
					}
					else{
						lobby.identifier(nameText.getText(), new String(pin.getPassword())).accounts[0].balance += Double.parseDouble(amountTransaction.getText());
						lobby.identifier(nameText.getText(), new String(pin.getPassword())).accounts[1].balance -= Double.parseDouble(amountTransaction.getText());
						frame.setVisible(false);
						InformationGuiTransaction information = new InformationGuiTransaction("transfer", "savings", Double.parseDouble(amountTransaction.getText()), lobby.identifier(nameText.getText(), new String(pin.getPassword())), lobby);
						amountTransaction.setEnabled(false);
						deposit.setEnabled(false);
						withdraw.setEnabled(false);
						transfer.setEnabled(false);
						checking.setEnabled(false);
						savings.setEnabled(false);
						moneyMarket.setEnabled(false);
						amountCorrect.setEnabled(false);
						ready.setEnabled(true);
						nameText.setEditable(true);
						pin.setEditable(true);
						nameText.setText("");
						pin.setText("");
						amountTransaction.setText("");
					}
				}
				else{
					if(deposit.isSelected()){
						lobby.identifier(nameText.getText(), new String(pin.getPassword())).accounts[2].balance += Double.parseDouble(amountTransaction.getText());
						frame.setVisible(false);
						InformationGuiTransaction information = new InformationGuiTransaction("deposit", "moneyMarket", Double.parseDouble(amountTransaction.getText()), lobby.identifier(nameText.getText(), new String(pin.getPassword())), lobby);
						amountTransaction.setEnabled(false);
						deposit.setEnabled(false);
						withdraw.setEnabled(false);
						transfer.setEnabled(false);
						checking.setEnabled(false);
						savings.setEnabled(false);
						moneyMarket.setEnabled(false);
						amountCorrect.setEnabled(false);
						ready.setEnabled(true);
						nameText.setEditable(true);
						pin.setEditable(true);
						nameText.setText("");
						pin.setText("");
						amountTransaction.setText("");
					}
					else if(withdraw.isSelected()){
						lobby.identifier(nameText.getText(), new String(pin.getPassword())).accounts[2].balance -= Double.parseDouble(amountTransaction.getText());
						frame.setVisible(false);
						InformationGuiTransaction information = new InformationGuiTransaction("withdraw", "moneyMarket", Double.parseDouble(amountTransaction.getText()), lobby.identifier(nameText.getText(), new String(pin.getPassword())), lobby);
						amountTransaction.setEnabled(false);
						deposit.setEnabled(false);
						withdraw.setEnabled(false);
						transfer.setEnabled(false);
						checking.setEnabled(false);
						savings.setEnabled(false);
						moneyMarket.setEnabled(false);
						amountCorrect.setEnabled(false);
						ready.setEnabled(true);
						nameText.setEditable(true);
						pin.setEditable(true);
						nameText.setText("");
						pin.setText("");
						amountTransaction.setText("");
					}
					else{
						
					}
				}
			}
		});
		
		// Add lowest panels to helper panels
		panelCenterNorth.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		panelCenterNorth.add(panelCenterNorthEast, BorderLayout.EAST);
		panelCenterNorth.add(panelCenterNorthWest, BorderLayout.WEST);
		panelCenterNorth.add(panelCenterNorthNorth, BorderLayout.NORTH);
		
		panelCenterCenter.add(panelCenterCenterNorth, BorderLayout.NORTH);
		panelCenterCenter.add(panelCenterCenterSouth, BorderLayout.SOUTH);
		
		panelCenterSouth.add(panelCenterSouthCenter, BorderLayout.CENTER);
		panelCenterSouth.add(panelCenterSouthEast, BorderLayout.EAST);
		panelCenterSouth.add(panelCenterSouthWest, BorderLayout.WEST);
		
		// Add helper panels to main panel
		panelCenter.add(panelCenterCenter, BorderLayout.CENTER);
		panelCenter.add(panelCenterNorth, BorderLayout.NORTH);
		panelCenter.add(panelCenterSouth, BorderLayout.SOUTH);
		
		// Add main panel to frame
		frame.add(panelCenter);
		
		// Pack frame and set location on screen
		frame.pack();
		frame.setLocationByPlatform(true);
	}
	
	public void windowClosed(WindowEvent e) {
		frame.setVisible(false);
		lobby.nextCustomer();
	}
}
