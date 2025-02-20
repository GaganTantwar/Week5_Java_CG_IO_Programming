package practiceproblems.advanceproblems.encryptdecrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;

public class DecryptCSV {
    private static final String ALGORITHM = "AES";
    private static final byte[] KEY_BYTES = new byte[] { /* Your AES key bytes here */ };

    public static void main(String[] args) {
        String csvFilePath = "encrypted_employees.csv";
        SecretKey secretKey = new SecretKeySpec(KEY_BYTES, ALGORITHM);

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] nextLine;

            // Skip header
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {
                nextLine[3] = decrypt(nextLine[3], secretKey); // Decrypt Salary
                nextLine[4] = decrypt(nextLine[4], secretKey); // Decrypt Email
                System.out.println(String.join(", ", nextLine));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String decrypt(String data, SecretKey key) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decodedBytes = Base64.getDecoder().decode(data);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
