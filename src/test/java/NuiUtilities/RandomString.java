package NuiUtilities;

import java.util.Random;

public class RandomString {
	
	public static String generateRandomString(int size) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < size ; i++) {
            char c = 'a';
            c += rand.nextInt(26);
            sb.append(c);
        }

        return sb.toString();
    }

}
