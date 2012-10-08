/**
 * 
 */
package openPOS;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Dustin Evans
 *
 */
public class Encrypt {

	static String md5;
	
    public static String sha256(String input) {
        int a = input.length();

        if(a>0){
        
        try {
             
        //Create MessageDigest object for MD5
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
         
        //Update input string in message digest
        digest.update(input.getBytes(), 0, input.length());
 
        //Converts message digest value in base 16 (hex)
        md5 = new BigInteger(1, digest.digest()).toString(16);
 
        }//end try
        
        catch (NoSuchAlgorithmException e) {
 
            e.printStackTrace();
        }//end catch
        
        return md5;
        
        }//end if
        
        else{
        	
        	md5 = null;
        	return md5;
        	
        }//end else
        
    }//end method
    
}//end class
