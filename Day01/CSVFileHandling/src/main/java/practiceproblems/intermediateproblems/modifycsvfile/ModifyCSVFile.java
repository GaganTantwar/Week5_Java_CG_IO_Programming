package practiceproblems.intermediateproblems.modifycsvfile;

import com.opencsv.*;
import java.io.FileReader;
import java.io.FileWriter;

public class ModifyCSVFile {

    // Method to modify CSV data and save it to a new file
    public void modifyData(String source) {
        // Try-with-resources to ensure CSVReader and CSVWriter are closed after usage
        try (CSVReader reader = new CSVReader(new FileReader(source));
             CSVWriter writer = new CSVWriter(new FileWriter("employee2.csv"))) {

            // Read and write the header line
            String[] header = reader.readNext();
            writer.writeNext(header);

            String[] columns;

            // Read each line until the end of the file
            while ((columns = reader.readNext()) != null) {
                // Check if the department is IT
                if (columns[3].equalsIgnoreCase("IT")) {
                    // Parse the salary and increase it by 10%
                    int x = Integer.parseInt(columns[2]);
                    double ans = x + (0.1 * x);
                    // Update the salary column with the new value
                    columns[2] = String.valueOf(ans);
                }
                // Write the modified (or unmodified) columns to the new file
                writer.writeNext(columns);
            }

            // Print success message
            System.out.println("File Copied Successfully");

        } catch (Exception e) {
            // Print the exception message if an error occurs
            System.out.println(e.getMessage());
        }
    }

    // Main method to test the modifyData method
    public static void main(String args[]) {
        ModifyCSVFile modify = new ModifyCSVFile(); // Create an instance of ModifyCSVFile
        modify.modifyData("employee1.csv"); // Call the modifyData method with the specified source path
    }
}
