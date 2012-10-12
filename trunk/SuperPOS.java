package openPOS;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

public class SuperPOS extends JFrame {

	protected static String store = null;
	private static final long serialVersionUID = -2573006206249959776L;
	protected static int ticketnum;
	static DefaultListModel<String> ItemPriceArray = new DefaultListModel<String>();
	static DefaultListModel<String> ItemNumberArray = new DefaultListModel<String>();
	static DefaultListModel<String> ItemNameArray= new DefaultListModel<String>();

	public static void clearItemList(){
		ItemPriceArray.clear();
		ItemNumberArray.clear();
		ItemNameArray.clear();
	}

	public static String setItemNameArray(String i){
		int index = 0;
		Object[] ItemArray = Login.getInventory(i);
		for(Object item : ItemArray){
			if(index<=ItemNameArray.getSize()-1){
				ItemNameArray.set(index, item.toString());
				String ItemArrayString = item.toString();
				System.err.println(ItemArrayString);
			}
			else{
				index++;
				System.err.println("String is:"+ItemArray[index].toString());
				System.err.println("Advancing index");
			}
		}
		String z = ItemArray[0].toString();
		return z;
	}

	public static String setItemNumberArray(String i){
		int index = 0;
		Object[] ItemArray = Login.getInventory(i);
		for(Object item : ItemArray){
			if(item.equals(null)){
				ItemArray[index]=i;	
			}
			else{
				index++;	
			}
		}
		String z = ItemArray[1].toString();
		return z;
	}

	public static String setItemPriceArray(String i){
		int index = 0;
		Object[] ItemArray = Login.getInventory(i);
		for(Object item : ItemArray){
			if(item.equals(null)){
				ItemArray[index]=i;
			}
			else{
				index++;	
			}
		}
		String z = ItemArray[2].toString();
		return z;
	}

	public static String getStore() {
		String store=Login.GetStore2();
		return store;
	}

	public static void setStore(String store) {
		POS1.store = store;
	}

	public static String SetTicknum(int i) {
		String ticknum = String.valueOf(i);
		int l = ticknum.length();
		if(l<5){
			ticknum = "0000"+ticknum;
		}//end if
		return ticknum;
	}//end set method

	public SuperPOS() throws HeadlessException {
		super();
	}

	public SuperPOS(GraphicsConfiguration gc) {
		super(gc);
	}

	public SuperPOS(String title) throws HeadlessException {
		super(title);
	}

	public SuperPOS(String title, GraphicsConfiguration gc) {
		super(title, gc);
	}

}