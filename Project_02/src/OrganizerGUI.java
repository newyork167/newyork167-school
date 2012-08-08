import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class OrganizerGUI extends JFrame implements ActionListener, WindowListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3683976647549286330L;
	public JFrame frame = new JFrame("Welcome to the Programmer\'s Bank!");
	private JLabel instructions = new JLabel("Enter information for the required process!");
	JButton cancelProcess = new JButton("Cancel Process");
	public JPanel panelNorth, panelEast, panelSouth, panelWest, panelCenter;
	
	OrganizerGUI(){
		// Set frame operations
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.addWindowListener(this);
		
		// Create panel objects
		panelNorth = new JPanel();
		panelSouth = new JPanel();
		
		// Add permanent panels
		panelNorth.add(instructions);
		panelSouth.add(cancelProcess);
		
		// Add components to frame
		frame.add(panelNorth, BorderLayout.NORTH);
		frame.add(panelSouth, BorderLayout.SOUTH);
		
		// Automatically set frame to center of screen
		frame.setLocationRelativeTo(null);
	}
	
	// I implemented windowListener to easily handle
	// window actions instead of actionEvents.
	public void actionPerformed(ActionEvent arg0) {
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
