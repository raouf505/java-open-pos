package openPOS;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

/**
 * @author Dustin Evans
 *
 */
public class POS1 extends JFrame {

	private static String store = null;
	private static final long serialVersionUID = -2573006206249959776L;
	private static int ticketnum;

	protected POS1(){
		final JFrame POS = new JFrame("Open POS");
		JPanel panel1 = new JPanel(new GridLayout(2,3));
		JPanel panel2 = new JPanel(new GridLayout(2,4));
		JPanel panel3 = new JPanel(new GridLayout(24,1));
		JPanel panel4 = new JPanel(new GridLayout(6,1));
		JPanel panel5 = new JPanel(new GridLayout(7,1));
		JSplitPane split1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panel4,panel5);
		split1.setDividerSize(2);
		JSplitPane split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panel2,panel3);
		split2.setDividerSize(2);
		JSplitPane split3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,split2,split1);
		split3.setDividerSize(2);
		JSplitPane split4 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,panel1,split3);
		split4.setDividerSize(2);

		//------Begin window listner 
		POS.addWindowListener(new WindowAdapter() {
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

		//------Variables for components		
		String a = StartScreen.GetUsername();
		store = POS1.GetStore();
		ticketnum = 0001;
		String ticknum = POS1.SetTicknum(ticketnum);


		//------Define GUI Elements (l for JLabel, t for JTextField, s for JList)

		//JFrame
		MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		JLabel title = new JLabel("Open POS");

		//Panel1
		JLabel lticket = new JLabel("Ticket Number");
		JTextField tTicket = new JTextField(ticknum);
		JLabel lassociate = new JLabel("Associate Name");
		JTextField tassociate = new JTextField(a);
		JLabel lstore = new JLabel("Store Name");
		final JTextField tstore = new JTextField(store);


		//Panel2
		JLabel itemlist = new JLabel("Item List");
		JLabel empty = new JLabel("");
		JLabel litemnum = new JLabel("Item #");
		JLabel lprice = new JLabel("Price");
		JLabel lqty = new JLabel("Quantity");
		String[] abcd = {"shampoo","harispray","straightener"};
		JList<String> sitemlist = new JList<String>(abcd);
		JList<String> sitemnum = new JList<String>();
		JList<String> sprice = new JList<String>();
		JList<String> sqty = new JList<String>();

		//Panel3
		JLabel lItemNumber= new JLabel("Item Number");
		JLabel lItemName = new JLabel("Item Name");
		JLabel lqty2 = new JLabel("Quantity");
		JLabel lprice2 = new JLabel("Price");
		JTextField tItemNumber = new JTextField();
		JTextField tItemName = new JTextField();
		JTextField tqty2 = new JTextField();
		JTextField tprice = new JTextField();

		//Panel4
		JLabel ltotal = new JLabel("Total");
		JTextField ttotal = new JTextField();
		JLabel ltax = new JLabel("Tax");
		JTextField ttax = new JTextField();
		JLabel lGrandTotal = new JLabel("Grand total");
		JTextField tGrandTotal = new JTextField();

		//Panel5
		JLabel paytype = new JLabel("Payment Type");
		JButton cash = new JButton("Cash");
		JButton check = new JButton("Check");
		JButton debit = new JButton("Debit");
		JButton credit = new JButton("Credit");
		JButton settings = new JButton("Settings");
		JButton close = new JButton("Close");

		//------Set component parameters
		title.setPreferredSize(new Dimension(800,600));
		lticket.setLabelFor(tTicket);
		lassociate.setLabelFor(tassociate);
		tassociate.setEditable(false);
		tstore.setEditable(false);
		title.setSize(0,0);
		POS.setSize(1024,768);

		//------Add GUI elements to panel1
		panel1.add(title);
		panel1.add(lticket);
		panel1.add(lassociate);
		panel1.add(lstore);
		panel1.add(empty);
		panel1.add(tTicket);
		tTicket.setEditable(false);
		panel1.add(tassociate);
		panel1.add(tstore);

		//------Add GUI elements to panel2
		panel2.add(itemlist);
		itemlist.setSize(0, 50);
		panel2.add(litemnum);
		litemnum.setSize(0, 50);
		panel2.add(lprice);
		lprice.setSize(0, 50);
		panel2.add(lqty);
		lqty.setSize(0, 50);
		panel2.add(sitemlist);
		panel2.add(sitemnum);
		panel2.add(sprice);
		panel2.add(sqty);

		//------Add GUI elements to panel3
		panel3.add(lItemNumber);
		panel3.add(tItemNumber);
		panel3.add(lItemName);
		panel3.add(tItemName);
		panel3.add(lqty2);
		panel3.add(tqty2);
		panel3.add(lprice2);
		panel3.add(tprice);

		//------Add GUI elements to panel 4
		panel4.add(ltotal);
		panel4.add(ttotal);
		panel4.add(ltax);
		panel4.add(ttax);
		panel4.add(lGrandTotal);
		panel4.add(tGrandTotal);

		//------Add GUI elements to panel 5
		panel5.add(paytype);
		panel5.add(cash);
		panel5.add(check);
		panel5.add(debit);
		panel5.add(credit);
		panel5.add(settings);
		panel5.add(close);

		//------Set pane configuration
		split4.setDividerLocation(50);
		split3.setDividerLocation(1000);
		split2.setDividerLocation(1000);
		split1.setDividerLocation(1000);
		POS.add(split4);
		POS.pack();
		POS.setVisible(true);

		//------add action listener for "Close" button
		close.addActionListener(new ActionListener() {
			//Add Listener and events for the button
			public void actionPerformed(ActionEvent e){
				POS.dispose();
			}//end actionPerformed
		});//end action listener

		//------add action listener for "Settings" button
		settings.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new Settings();
			}
		});

	}//end constructor method

	public static void SetStore(String s){
		POS1.store=s;
	}//end set method

	public static String GetStore(){
		String s=Login.GetStore2();
		return s;
	}//end get method

	public static String SetTicknum(int i){
		String ticknum = String.valueOf(i);
		int l = ticknum.length();
		if(l<5){
			System.err.println("ticket number should be at least 5 numbers.");
			ticknum = "0000"+ticknum;
		}//end if
		return ticknum;
	}//end set method

}//end class
