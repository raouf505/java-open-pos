/**
 * 
 */
package openPOS;

import java.io.*;

/**
 * @author Dustin Evans
 *
 */
public class Login {

	public static boolean ExistingUser(String input) {
		String fileName="users.txt";
		boolean isUser=false;
		File f = new File(fileName);
		FileReader fr;
		try {
			fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			int lineCount = count(fileName);
			System.err.println(lineCount);// TODO erase this line when coding is complete
			int i = 1;
			while(i<=lineCount){
			String line=br.readLine();
			boolean same = input.equals(line);
			System.err.println(same);
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
	public static void NewUser(String input){
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(new File("users.txt"),true));
			pw.println(input);
			pw.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
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

}
