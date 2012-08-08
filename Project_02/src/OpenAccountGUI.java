import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class OpenAccountGUI extends OrganizerGUI{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7860220435385204613L;
	// Create necessary components for specific class
	private Lobby lobby;
	public OptionsGUI optionsGUI;
	public JTextField nameText = new JTextField(20);
    public JTextField checkingsText = new JTextField(10);
    public JTextField savingsText = new JTextField(10);
    public JTextField moneyMarketText = new JTextField(10);
    private JButton allInputCorrect = new JButton("All Input Correct");
    private JButton openMyAccount = new JButton("Open My Account");
	
	public OpenAccountGUI(final Lobby lobby){
		// Create variables and panels
		this.lobby = lobby;
		openMyAccount.setEnabled(false);
		panelCenter = new JPanel(new BorderLayout());
		JPanel panelCenterEast = new JPanel(new GridLayout(4,0));
		JPanel panelCenterWest = new JPanel(new GridLayout(4,0));
		JPanel panelCenterSouth = new JPanel();
		
		// Adds cancel button action
		cancelProcess.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
    			nameText.setText(null);
    			checkingsText.setText(null);
    			savingsText.setText(null);
    			moneyMarketText.setText(null);
    			lobby.nextCustomer();
			}
		});
		
        // Adds allInputCorrect button action
        allInputCorrect.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
            	openMyAccount.setEnabled(true);
                allInputCorrect.setEnabled(false);
            }
        });
        
        openMyAccount.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent event){
        		// Variables for next check
        		String name = nameText.getText();
        		String checkings = checkingsText.getText();
        		String savings = savingsText.getText();
        		String moneyMarket = moneyMarketText.getText();
        		
        		// Check for empty fields
        		if(name.trim().equals("")){
        			
        		}
        		else if(checkings.trim().equals("")){
        			
        		}
        		else if(savings.trim().equals("")){
        			
        		}
        		else if(moneyMarket.trim().equals("")){
        			
        		}
        		else{
        			lobby.openAccount(nameText.getText(), Double.parseDouble(checkingsText.getText()), Double.parseDouble(savingsText.getText()), Double.parseDouble(moneyMarketText.getText()));
        			nameText.setText(null);
        			checkingsText.setText(null);
        			savingsText.setText(null);
        			moneyMarketText.setText(null);
        			frame.setVisible(false);
        			openMyAccount.setEnabled(false);
        			allInputCorrect.setEnabled(true);
        		}
        		

        	}
        });
        
        // Add JComponents to panels
        panelCenterEast.add(nameText);
        panelCenterEast.add(checkingsText);
        panelCenterEast.add(savingsText);
        panelCenterEast.add(moneyMarketText);
        
        panelCenterWest.add(new JLabel("Enter your name here --------->"));
        panelCenterWest.add(new JLabel("Enter deposit to Checking ----->"));
        panelCenterWest.add(new JLabel("Enter deposit to Savings ------>"));
        panelCenterWest.add(new JLabel("Enter deposit to Money Market ->"));
        
        panelCenterSouth.add(allInputCorrect);
        panelCenterSouth.add(openMyAccount);
        
        // Add helper panels to main panel
        panelCenter.add(panelCenterEast, BorderLayout.EAST);
        panelCenter.add(panelCenterWest, BorderLayout.WEST);
        panelCenter.add(panelCenterSouth, BorderLayout.SOUTH);
                
		// Add main panel to frame
		frame.add(panelCenter, BorderLayout.CENTER);
		frame.pack();
	}
	
	public void windowClosed(WindowEvent e){
		frame.setVisible(false);
		optionsGUI.frame.setVisible(true);
	}
}
