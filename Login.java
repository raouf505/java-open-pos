package openPOS;

import java.io.*;

/**
 * @author Dustin Evans
 *
 */
public class Login {

	/**
	This class is used to test the login information provided by the user against the user database.
	If the user exists and the password is correct, the POS1 class is called.
	If the username+password hash does not match, the NotUser class is called.
	The ExistingUser method accepts string and returns boolean.
	The NewUser method accepts string and is void.
	The count method is used to count the number of lines in a file and returns integer.
	 **/

	public static boolean ExistingUser(String input) {
		String fileName="users.txt";
		boolean isUser=false;
		File f = new File(fileName);
		FileReader fr;
		try {
			fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			int lineCount = count(fileName);
			System.err.println("Line count:"+lineCount);// TODO erase this line when coding is complete
			int i = 1;
			while(i<=lineCount){
				String line=br.readLine();
				boolean same = input.equals(line);
				System.err.println("Matched user="+same);
				if(same==true){
					isUser=true;
					i=lineCount;
				}
				else{
					System.err.println("no match");// TODO erase this line when coding is complete
				}
				++i;
			}
			br.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return isUser;
	}

	/**
	 * The following method takes string as an input and has a void return type.
	 * Writes String "input" to a file.
	 * Variable "input" translates to a SHA hash of the username and password input by the user
	 * in the NewUser Class.
	 * @param input
	 */
	public static void NewUser(String input){
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(new File("users.txt"),true));
			pw.println(input);
			pw.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * The following method get the store name from the file called "settings".
	 * Returns a string.
	 * @return
	 */
	public static String GetStore2(){

		String fileName="settings";
		File f = new File(fileName);
		FileReader fr;
		String storename2;
		try {
			fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			int lineCount = count(fileName);
			int i = 1;
			while(i<=lineCount){
				String line=br.readLine();
				if(line!=null){
					storename2 = line;
					i=lineCount;
					return storename2;
				}
				else{
					System.err.println("No Store Name Configured");
					storename2 = "Store";
					i=lineCount;
					return storename2;
				}
			}
			br.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		storename2=null;
		return storename2;
	}

	/**
	 * Prints the store name to a file
	 * @param input
	 */

	public static void NewStoreName(String input){
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(new File("settings"),false));
			pw.print(input);
			pw.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * The following method counts lines in a file.
	 * @param filename
	 * @return
	 * @throws IOException
	 */

	public static int count(String filename) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(filename));
		try {
			byte[] c = new byte[1024];
			int count = 0;
			int readChars = 0;
			boolean empty = true;
			while ((readChars = is.read(c)) != -1) {
				empty = false;
				for (int i = 0; i < readChars; ++i) {
					if (c[i] == '\n')
						++count;
				}
			}
			return (count == 0 && !empty) ? 1 : count;
		} finally {
			is.close();
		}
	}

	public static String[] getInventory(String input) {
		String fileName="inventory.txt";
		File f = new File(fileName);
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			int lineCount = count(fileName);
			for(int i=1;i<=lineCount;i++){
				String[] a;
				String line=br.readLine();
				a=line.split(",");
				String b=a[1];
				if(b.equals(input)){
					i=lineCount;
					return a;
				}
			}

			br.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (NullPointerException e1){
			System.err.println("String array is null.");
		}
		String[] a = {"null","null","null"};
		return a;
	}

}
