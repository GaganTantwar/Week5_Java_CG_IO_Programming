package practiceproblems.basicproblems.readcsvfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.*;

public class ReadingCSV {

    // Method to read a CSV file and print its content
    public boolean readFile(String path) {
        File file = new File(path); // Create a File object with the given path

        // Check if the file exists
        if (!file.exists()) {
            return false; // Return false if the file does not exist
        }

        // Try-with-resources to ensure BufferedReader is closed after usage
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            br.readLine(); // Skip the header line

            // Read each line until the end of the file
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(","); // Split the line into columns based on comma delimiter
                // Print the column values
                System.out.println("Id: " + columns[0] + " Name: " + columns[1] + " Age: " + columns[2] + " Marks " + columns[3]);
            }
        } catch (IOException e) {
            // Print the exception message if an error occurs
            System.out.println("Exception Caught: " + e.getMessage());
        }

        return true; // Return true if the file is read successfully
    }

    // Main method to test the readFile method
    public static void main(String args[]) {
        String path = "student.csv"; // Path to the CSV file
        ReadingCSV read = new ReadingCSV(); // Create an instance of ReadingCSV
        boolean check = read.readFile(path); // Call the readFile method and store the result
    }
}
