package openPOS;

/**
 * @author Dustin Evans
 *
 *This class is the starting point for all users. It begins with a gui that asks for a username and password.
 */

//Import external classes
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;
import java.awt.*;
import java.awt.event.*;

public class StartScreen extends JFrame{
	
	//define variables and make them invisible
	private static String username;
	private static String password;
	private static final long serialVersionUID = -4824059629095884651L;

	//Constructor method	
	public StartScreen(){
		
		//define main GUI object
		final JFrame startScreen = new JFrame("Open POS");
				
		//------Begin window listner 
		startScreen.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {System.exit(0);}
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
				

				
			//Define GUI Elements
			MetalLookAndFeel.setCurrentTheme(new OceanTheme());
			JLabel title = new JLabel("Welcome to Open POS");
			JLabel lUserName = new JLabel("Type your User Name");
			JLabel lpassword = new JLabel("Type your password:");
			JButton submit = new JButton("Submit");
			JButton newuser = new JButton("New User");
			startScreen.getContentPane().setLayout(new GridLayout(0,1,5,5));
			title.setPreferredSize(new Dimension(510,0));
			final JTextField tusername = new JTextField("");
			final JTextField tpassword = new JTextField("");
				
			//Add GUI elements to content pane
			startScreen.setLocation(450,300);
			startScreen.add(title);
			startScreen.add(lUserName);
			startScreen.add(tusername);
			startScreen.add(lpassword);
			startScreen.add(tpassword);
			startScreen.add(submit);
			startScreen.add(newuser);
			startScreen.pack();
			startScreen.setVisible(true);
				
			//Add Listener and events for the button------Method
		    submit.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e){
					username=tusername.getText();
					password=tpassword.getText();
		    		String login = GetLogin(username,password);
		    		System.err.println(login);
		    		boolean user=Login.ExistingUser(login);
						if(user==true){
							new POS1();
							startScreen.dispose();
						}
						else{
							new NotUser();
						}
		        }//end actionPerformed
		    });//end action listener
		        
		    //Add Listener and events for the button------Method
		    newuser.addActionListener(new ActionListener() {
					//Add Listener and events for the button
		    	public void actionPerformed(ActionEvent e){
					new NewUser();
			    }//end actionPerformed
		    });//end action listener
		    
	}//End Constructor
	
	public static String GetLogin(String username, String password){
		//this method gets the username and password that have been typed in
		String x=username;
		String y=password;
		String username1 = Encrypt.sha256(x);
		String password1 = Encrypt.sha256(y);
		String login = x+","+username1+","+password1;
		return login;
	}//End method
	
	public static String GetUsername(){
		String a = StartScreen.username;
		return a;
	}
	
}//End Class

