package practiceproblems.intermediateproblems.filtercsvfile;

import com.opencsv.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class FilterStudent {

    // Method to filter students based on marks and return the filtered list
    public ArrayList<String> filterStudents(String path) {
        ArrayList<String> list = new ArrayList<>(); // Initialize the list to store filtered students

        // Try-with-resources to ensure CSVReader is closed after usage
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            reader.readNext(); // Skip the header line
            String[] columns;

            // Read each line until the end of the file
            while ((columns = reader.readNext()) != null) {
                int marks = Integer.parseInt(columns[2]); // Parse marks from the third column
                if (marks >= 80) { // Check if marks are greater than or equal to 80
                    String ans = Arrays.toString(columns); // Convert the columns array to a string
                    list.add(ans); // Add the string to the list
                    System.out.println(ans); // Print the string
                }
            }
        } catch (Exception e) {
            // Print the exception message if an error occurs
            System.out.println(e.getMessage());
        }

        return list; // Return the filtered list
    }

    // Main method to test the filterStudents method
    public static void main(String args[]) {
        FilterStudent filter = new FilterStudent(); // Create an instance of FilterStudent
        ArrayList<String> list = filter.filterStudents("StudentMarks.csv"); // Call the filterStudents method with the specified path
    }
}
