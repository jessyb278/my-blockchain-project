/*
This class contains the function that creates our hashes based on the information given and
through the SHA-256 algorithm
 */
package blockchain;
import java.security.MessageDigest;
public class StringUtil {

    public static String applySha256(String input){
        try {
                // Create a SHA-256 digest object
                MessageDigest digest = MessageDigest.getInstance("SHA-256");

                // Convert the input string to bytes and compute the hash
                byte [] hash = digest.digest(input.getBytes("UTF-8"));

                // Convert binary bytes to a readable hex string
                StringBuffer hexString = new StringBuffer();

                for (int i = 0; i<hash.length; i++)
                {
                    String hex = Integer.toHexString((0xff & hash[i]));
                    if(hex.length() == 1) hexString.append('0');
                    hexString.append(hex);
                }
                //return the final 64-character hash
                return hexString.toString();

        }
        catch(Exception e) {throw new RuntimeException(e);}
    }
}
