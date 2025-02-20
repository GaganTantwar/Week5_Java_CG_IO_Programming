package practiceproblems.advanceproblems.encryptdecrypt;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

public class EncryptCSV {
    private static final String ALGORITHM = "AES";

    public static void main(String[] args) {
        String csvFilePath = "encrypted_employees.csv";
        SecretKey secretKey = generateKey();

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
            // Write header
            writer.writeNext(new String[]{"Employee ID", "Name", "Department", "Salary", "Email"});

            // Sample data
            String[][] data = {
                    {"1", "John Doe", "IT", "50000", "john.doe@example.com"},
                    {"2", "Jane Smith", "Sales", "60000", "jane.smith@example.com"}
            };

            for (String[] row : data) {
                row[3] = encrypt(row[3], secretKey); // Encrypt Salary
                row[4] = encrypt(row[4], secretKey); // Encrypt Email
                writer.writeNext(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Data has been encrypted and written to " + csvFilePath);
    }

    private static SecretKey generateKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
            keyGen.init(128); // AES-128
            return keyGen.generateKey();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String encrypt(String data, SecretKey key) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
