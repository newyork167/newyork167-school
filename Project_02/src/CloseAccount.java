import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class CloseAccount extends OrganizerGUI{
	Lobby lobby;
	private JTextField name = new JTextField(20);
	private JPasswordField pin = new JPasswordField(4);
	private JButton accept = new JButton("Accept");
	
	public CloseAccount(final Lobby lobby){
		this.lobby = lobby;
		panelEast = new JPanel(new GridLayout(3,0));
		panelWest = new JPanel(new GridLayout(3,0));
		
		panelWest.add(new JLabel("Enter name -------->"));
		panelWest.add(new JLabel("Enter PIN---------->"));
		panelEast.add(name);
		panelEast.add(pin);
		panelEast.add(accept);
		
		accept.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				char[] pinCheck = pin.getPassword();
				// Check for empty fields
				if(name.getText().toString().trim().equals("")){
					
				}
				else if(pin.getPassword().equals("")){
					
				}
				else{
					if(lobby.identifier(name.getText(), new String(pinCheck)) != null){
						new InformationGuiCloseAccount(lobby.identifier(name.getText(), new String(pinCheck)), lobby);
						lobby.customers.remove(lobby.identifier(name.getText(), new String(pinCheck)));
						frame.setVisible(false);
						name.setText(null);
						pin.setText(null);
					}
					else{
						frame.setVisible(false);
						JOptionPane.showMessageDialog(null, "Customer not found");
						name.setText("");
						pin.setText(null);
						lobby.nextCustomer();
					}
					
				}
			}
		});
		
		cancelProcess.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				frame.setVisible(false);
				name.setText(null);
				pin.setText(null);
				lobby.nextCustomer();
			}
		});	
		frame.add(panelEast, BorderLayout.EAST);
		frame.add(panelWest, BorderLayout.WEST);
		
		frame.pack();
	}
}
