package practiceproblems.basicproblems.countlineincsv;

import com.opencsv.*;
import java.io.*;
import java.util.*;

public class CountLine {
    // Method to count the number of lines in the CSV file
    public int countLines(String path){
        int count = 0; // Initialize counter

        // Try-with-resources to ensure the CSVReader is closed after usage
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            reader.readNext(); // Skip the header line

            String[] columns;
            // Read each line until the end of the file
            while ((columns = reader.readNext()) != null) {
                System.out.println(Arrays.toString(columns)); // Print the current line
                count += 1; // Increment the counter
            }
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Print the exception message if an error occurs
        }

        return count; // Return the total count of lines
    }

    // Main method to test the countLines method
    public static void main(String args[]) {
        CountLine counter = new CountLine(); // Create an instance of CountLine
        int count = counter.countLines("student.csv"); // Call the countLines method and store the result
        System.out.println(count); // Print the total count of lines
    }
}
