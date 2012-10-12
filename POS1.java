package openPOS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

/**
 * @author Dustin Evans
 *
 */
public class POS1 extends SuperPOS {

	private static final long serialVersionUID = 801781825510907132L;

	public POS1(){
		final JFrame POS = new JFrame("Open POS");
		JPanel panel1 = new JPanel(new GridLayout(2,3));
		BorderLayout BL = new BorderLayout();
		JPanel panel2 = new JPanel(BL);
		JPanel panel3 = new JPanel(new GridLayout(0,1,0,8));
		JPanel panel4 = new JPanel(new GridLayout(6,1));
		JPanel panel5 = new JPanel(new GridLayout(7,1));
		JPanel panel6 = new JPanel(new GridLayout(1,4));
		JPanel panel7 = new JPanel(new GridLayout(1,4));
		JSplitPane split1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panel4,panel5);
		split1.setDividerSize(2);
		JSplitPane split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panel2,panel3);
		split2.setDividerSize(2);
		JSplitPane split3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,split2,split1);
		split3.setDividerSize(2);
		JSplitPane split4 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,panel1,split3);
		split4.setDividerSize(2);

		//------Begin window listner 
		POS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		//------Define GUI Elements (l for JLabel, t for JTextField, s for JList)

		//JFrame
		MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		JLabel title = new JLabel("Open POS");

		//------Variables for components		
		String a = StartScreen.GetUsername();
		store = POS1.getStore();
		ticketnum = 0001;
		String ticknum = POS1.SetTicknum(ticketnum);

		//Panel1
		JLabel lticket = new JLabel("Ticket Number");
		JTextField tTicket = new JTextField(ticknum);
		JLabel lassociate = new JLabel("Associate Name");
		JTextField tassociate = new JTextField(a);
		JLabel lstore = new JLabel("Store Name");
		final JTextField tstore = new JTextField(store);

		//Panel3
		JLabel lItemNumber= new JLabel("Item Number");
		JLabel lItemName = new JLabel("Item Name");
		JLabel lqty2 = new JLabel("Quantity");
		JLabel lprice2 = new JLabel("Price");
		final JTextField tItemNumber = new JTextField();
		final JTextField tItemName = new JTextField();
		JTextField tqty2 = new JTextField();
		final JTextField tprice = new JTextField();
		final JButton voidAll = new JButton("Void All");

		//Panel6 - out of numerical order but in spatial order

		JLabel itemlist = new JLabel("Item List");
		JLabel empty = new JLabel("");
		JLabel litemnum = new JLabel("Item #");
		JLabel lprice = new JLabel("Price");
		JLabel lqty = new JLabel("Quantity");

		//Panel7 - same comment as above
		final JList<String> sitemlist = new JList<String>(ItemNameArray);
		final JList<String> sitemnum = new JList<String>(ItemNumberArray);
		final JList<String> sprice = new JList<String>(ItemPriceArray);
		final JList<String> sqty = new JList<String>();

		//Panel2 - will hold panels 6 and 7

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
		panel2.add(BorderLayout.NORTH,panel6);
		panel2.add(BorderLayout.CENTER,panel7);

		//------Add GUI elements to panel6
		panel6.add(itemlist);
		panel6.add(litemnum);
		panel6.add(lprice);
		panel6.add(lqty);

		//------Add GUI elements to panel7
		panel7.add(sitemlist);
		sitemlist.setBorder(BorderFactory.createLineBorder(Color.black));
		panel7.add(sitemnum);
		sitemnum.setBorder(BorderFactory.createLineBorder(Color.black));
		panel7.add(sprice);
		sprice.setBorder(BorderFactory.createLineBorder(Color.black));
		panel7.add(sqty);
		sqty.setBorder(BorderFactory.createLineBorder(Color.black));

		//------Add GUI elements to panel3
		panel3.add(lItemNumber);
		panel3.add(tItemNumber);
		panel3.add(lItemName);
		panel3.add(tItemName);
		panel3.add(lqty2);
		panel3.add(tqty2);
		panel3.add(lprice2);
		panel3.add(tprice);
		panel3.add(voidAll);

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
		split3.setDividerLocation(600);
		split2.setDividerLocation(1000);
		split1.setDividerLocation(1000);
		POS.add(split4);
		POS.pack();
		POS.setVisible(true);
		

		//------add action listener for "Close" button
		close.addActionListener(new ActionListener() {
			//Add Listener and events for the button
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(JFrame.EXIT_ON_CLOSE);
			}//end actionPerformed
		});//end action listener

		//------add action listener for "Settings" button
		settings.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new POS1.settings();
			}//end actionPerformed
		});//end ActionListener

		//------add action listener for "ItemNumber" text field
		tItemNumber.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String actionItemNumber = tItemNumber.getText();
				String actionItemName = setItemNameArray(actionItemNumber);
				tItemName.setText(actionItemName);
				String actionItemPrice = setItemPriceArray(actionItemNumber);
				tprice.setText(actionItemPrice);
				sitemlist.setModel(ItemNameArray);
			}//end action performed
		});//end ActionListener

		sitemlist.addMouseListener(new MouseListener() {


			@Override
			public void mouseReleased(MouseEvent e) {
				int itemindex = sitemlist.getSelectedIndex();
				tItemName.setText(ItemNameArray.get(itemindex));
				tItemNumber.setText(ItemNumberArray.get(itemindex));
				tprice.setText(ItemPriceArray.get(itemindex));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}//end constructor method

 	class settings extends JFrame{
		private static final long serialVersionUID = 1725837311980817453L;

		public settings() {
			//define main GUI object
			final JFrame settings = new JFrame("Settings");

			//------Begin window listner 
			settings.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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

			submit.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					String a = tstorename.getText();
					POS1.setStore(a);
				}

			});
		}
	}

}//end class
