package practiceproblems.intermediateproblems.searchincsvfile;

import com.opencsv.*;
import java.io.FileReader;
import java.util.*;

public class SearchInCSVFile {

    // Method to search for an employee by name in a CSV file
    public String[] searchEmployee(String path, String name) {
        String[] answer = {}; // Initialize the answer array

        // Try-with-resources to ensure CSVReader is closed after usage
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            reader.readNext(); // Skip the header line
            String[] columns;

            // Read each line until the end of the file
            while ((columns = reader.readNext()) != null) {
                // Check if the name matches the given name
                if (columns[1].equalsIgnoreCase(name)) {
                    answer = columns.clone(); // Clone the columns array to answer
                }
            }
        } catch (Exception e) {
            // Print the exception message if an error occurs
            System.out.println(e.getMessage());
        }

        return answer; // Return the answer array
    }

    // Main method to test the searchEmployee method
    public static void main(String args[]) {
        SearchInCSVFile search = new SearchInCSVFile(); // Create an instance of SearchInCSVFile
        Scanner sc = new Scanner(System.in); // Create a Scanner object for user input
        System.out.println("Enter Employee Name: ");
        String name = sc.next(); // Read the employee name from user input

        // Call the searchEmployee method and store the result
        String[] answer = search.searchEmployee("employee.csv", name);

        // Print the result
        System.out.println("Employee Found: " + Arrays.toString(answer));
    }
}
