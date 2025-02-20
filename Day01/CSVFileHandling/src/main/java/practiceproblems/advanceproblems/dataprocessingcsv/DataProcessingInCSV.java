package practiceproblems.advanceproblems.dataprocessingcsv;

import java.io.*;
import com.opencsv.*;
import java.util.*;
public class DataProcessingInCSV {

    // Method to process the CSV file and validate email and phone number fields
    public  ArrayList<String> processData(String path) {
        // Try-with-resources to ensure CSVReader is closed after usage
        ArrayList<String> arr=new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            reader.readNext(); // Skip the header line
            String[] values;

            // Read each line until the end of the file
            while ((values = reader.readNext()) != null) {
                // Validate email format using regex
                if (!values[2].matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}$")) {
                    System.out.println("Invalid Email: " + "\"" + values[2] + "\"");
                    arr.add(values[0]);
                    continue; // Skip further processing for this line
                }

                // Validate phone number format using regex
                if (!values[1].matches("^\\+?(\\d{1,3})?[-. ]?(\\d{10})$")) {
                    System.out.println("Invalid Phone Number: " + "\"" + values[1] + "\"");
                    arr.add(values[0]);
                }
            }
        } catch (Exception e) {
            // Print the exception message if an error occurs
            System.out.println(e.getMessage());
        }
        return arr;
    }

    // Main method to test the processData method
    public static void main(String args[]) {
        DataProcessingInCSV process = new DataProcessingInCSV(); // Create an instance of DataProcessingInCSV
        ArrayList<String> arr=process.processData("personfile.csv"); // Call the processData method with the specified path
        System.out.println(arr.toString());
    }

}
