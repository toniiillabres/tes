package JavaTesting.Resources;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.security.SecureRandom;

public class PasswordUtils {
    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTXYZ";

    public static String genSalt(){
        return genSalt(8);
    }

    public static String genSalt(int i){
        StringBuilder valor = new StringBuilder(i);

        for (int k=0; k< i; k++){
            valor.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(valor);
    }

    public static String genSecurePassword(String password, String salt) throws NoSuchAlgorithmException{

        return hashedPassword(password,salt);
    }

    public static String hashedPassword(String password, String salt) {
        MessageDigest md;
        String result = "";

        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update((salt+password).getBytes());
            result = new String(md.digest());
        } catch (NoSuchAlgorithmException nsae){
            System.out.println("Algoritme de hash erroni");
            System.exit(1);
        }

        return result;
    }

    public static boolean verifyUserPassword(String passwordEntered, String userSalt, String securePassword){

        return securePassword.equals(hashedPassword(passwordEntered, userSalt));
    }
}
