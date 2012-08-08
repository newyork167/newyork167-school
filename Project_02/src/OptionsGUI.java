import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class OptionsGUI extends OrganizerGUI{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8373082191463613140L;
	// Instantiate variables
	public Lobby lobby;
	private OpenAccountGUI accountGUI;
	public JRadioButton close = new JRadioButton("Close your account");
	public JRadioButton access = new JRadioButton("Access your account");
	public JRadioButton open = new JRadioButton("Open a new account");	
	
	public OptionsGUI(final Lobby lobby, final OpenAccountGUI accountGUI){
		this.lobby = lobby;
		this.accountGUI = accountGUI;
		accountGUI.optionsGUI = this;
		
		
		// Instantiate panels
		panelCenter = new JPanel(new BorderLayout());
		
		// Add radio buttons to group
		final ButtonGroup actions = new ButtonGroup();
		
		actions.add(open);
		actions.add(close);
		actions.add(access);	
		
		// I added inner classes to handle action events
		// instead of utilizing the implemented ActionListener
		// from OrganizerGUI just because this made the code
		// more maintainable
		
		// Open radio button action
		open.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
//				System.out.println("Open Account");
				frame.setVisible(false);
				accountGUI.frame.setVisible(true);
				actions.clearSelection();
			}
			
		});

		// Close radio button action
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
//				frame.setVisible(false);
				actions.clearSelection();
				frame.setVisible(false);
				lobby.close.frame.setVisible(true);
			}
		});
		
		// Access radio button action
		access.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				frame.setVisible(false);
				actions.clearSelection();
				lobby.transaction.frame.setVisible(true);
			}
		});
		
		// Cancel button action
		cancelProcess.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				frame.setVisible(false);
				lobby.nextCustomer();
			}
		});
		

		// Add buttons to panel
		panelCenter.add(open, BorderLayout.NORTH);
		panelCenter.add(close, BorderLayout.CENTER);
		panelCenter.add(access, BorderLayout.SOUTH);
		
		// Add panel to frame, pack and make visible
		frame.add(panelCenter, BorderLayout.CENTER);
		frame.pack();
	}
	
	public void windowClosed(WindowEvent e){
		lobby.closeTheLobby();
	}
}
