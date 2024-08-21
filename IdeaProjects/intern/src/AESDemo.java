import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;

public class AESDemo {
    public static SecretKey getKey(int n) throws NoSuchAlgorithmException {
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        keygen.init(n);
        return keygen.generateKey();
    }

    public static IvParameterSpec generateIV() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public String encrypt(String algorithm, String plaintext, SecretKey key, IvParameterSpec iv) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] encrypted = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public String decrypt(String algorithm, String ciphertext, SecretKey key, IvParameterSpec iv) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException,
            InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
        return new String(decrypted);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the plain text to be encrypted: ");
        String input = sc.next();
        System.out.println("Enter the key size (only 128/192/256):");
        int keySize = sc.nextInt();
        SecretKey key = AESDemo.getKey(keySize);
        IvParameterSpec iv = AESDemo.generateIV();
        String algorithm = "AES/CBC/PKCS5Padding";
        AESDemo aes =  new AESDemo();
        String ciphertext = aes.encrypt(algorithm,input,key,iv);
        String decrypted = aes.decrypt(algorithm,ciphertext,key,iv);
        System.out.println("Original Text:\t"+input);
        System.out.println("Encrypted Text:\t"+ciphertext);
        System.out.println("Decrypted Text:\t"+decrypted);
    }

}
