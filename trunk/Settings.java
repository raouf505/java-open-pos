/**
 * 
 */
package openPOS;

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

public class Settings extends JFrame{

	private static final long serialVersionUID = 1725837311980817453L;

	public Settings() {
		//define main GUI object
		final JFrame settings = new JFrame("Settings");
		
//------Begin window listner 
		settings.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {settings.dispose();}
		});
//------End window listner
		

		
//------Begin Try-Catch for setting look and feel
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
//------End Try-Catch for setting look and feel
		

		
//------Define GUI Elements
		MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		JLabel lstorename = new JLabel("Change store name");
		final JTextField tstorename = new JTextField();
		JButton submit = new JButton("Submit");
		settings.getContentPane().setLayout(new GridLayout(0,1,5,5));
		
		settings.add(lstorename);
		settings.add(tstorename);
		settings.add(submit);
		settings.pack();
		settings.setVisible(true);
		
		/**
		 * TODO Doesn't work for some reason.
		 */
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String a = tstorename.getText();
				Login.NewStoreName(a);				
			}
			
		});
	}

}
