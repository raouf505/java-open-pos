/**
 * 
 */
package openPOS;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Dustin Evans
 *
 */
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;
public class NotUser extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1319668655634562360L;

	public NotUser(){
		final JFrame notUser = new JFrame("Open POS");

		//------Begin window listner 
		notUser.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {System.exit(0);}
		});
		//------End window listner



		//------Begin Try-Catch for setting look and feel
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (ClassNotFoundException e1) {
			//TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			//TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			//TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			//TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//------End Try-Catch for setting look and feel



		//------Define GUI Elements
		MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		JLabel title = new JLabel("No such user.");
		JButton ok = new JButton("OK");
		notUser.getContentPane().setLayout(new GridLayout(0,1,5,5));
		title.setPreferredSize(new Dimension(510,0));

		//------Add GUI elements to content pane
		notUser.setLocation(450, 250);
		notUser.getContentPane().add(title);
		notUser.getContentPane().add(ok);
		notUser.pack();
		notUser.setVisible(true);
		//------add action listener for "OK" button
		ok.addActionListener(new ActionListener() {
			//Add Listener and events for the button
			public void actionPerformed(ActionEvent e){
				notUser.dispose();
			}//end actionPerformed
		});//end action listener
	}//end constructor method
}//end class