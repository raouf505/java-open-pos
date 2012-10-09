package openPOS;
/**
 * @author Dustin Evans
 *
 */

//Import external classes
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;
import java.awt.*;
import java.awt.event.*;

public class NewUser extends JFrame{

	//Serial ID
	private static final long serialVersionUID = -8193003534545083647L;

	//Constructor method	
	protected NewUser(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//define main GUI object
		final JFrame newUser = new JFrame("New User");


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
		JLabel title = new JLabel("Create a New User");
		final JLabel lUserName = new JLabel("Type your User Name");
		final JLabel lpassword = new JLabel("Type your password:");
		JButton submit = new JButton("Submit");
		newUser.getContentPane().setLayout(new GridLayout(0,1,5,5));
		title.setPreferredSize(new Dimension(510,0));
		final JTextField tusername = new JTextField("");
		final JTextField tpassword = new JTextField("");

		//------Add GUI elements to content pane
		newUser.getContentPane().add(title);
		newUser.getContentPane().add(lUserName);
		newUser.getContentPane().add(tusername);
		newUser.getContentPane().add(lpassword);
		newUser.getContentPane().add(tpassword);
		newUser.getContentPane().add(submit);
		newUser.pack();
		newUser.setVisible(true);

		submit.addActionListener(new ActionListener() {
			//Add Listener and events for the button
			public void actionPerformed(ActionEvent e){
				String plain = tusername.getText();
				String username = Encrypt.sha256(tusername.getText());
				String password = Encrypt.sha256(tpassword.getText());
				String login = plain+","+username+","+password;
				Login.NewUser(login);
				newUser.dispose();
			}//end actionPerformed
		});//end action listener
	}
}