package practiceproblems.basicproblems.writecsvfile;

import java.io.*;

public class WritingCSV {

    // Method to write data to a CSV file
    public void writeFile(String path) {
        File file = new File(path); // Create a File object with the given path

        // Try-with-resources to ensure BufferedWriter is closed after usage
        try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
            // Write header line to the CSV file
            br.write("Id,Name,Age,Marks\n");

            // Write data rows to the CSV file
            br.write("Id234,Ramendra,23,482\n");
            br.write("Id238,Ramu,21,382\n");
            br.write("Id225,Rohit,22,420\n");
            br.write("Id220,Rohan,20,430\n");
            br.write("Id223,Roshan,19,410\n");
            br.write("Id201,Ramesh,18,400\n");
            br.write("Id305,Raju,22,250\n");
        } catch (IOException e) {
            // Print the exception message if an error occurs
            System.out.println(e.getMessage());
        }
    }

    // Main method to test the writeFile method
    public static void main(String args[]) {
        WritingCSV write = new WritingCSV(); // Create an instance of WritingCSV
        write.writeFile("students.csv"); // Call the writeFile method with the specified path
    }
}
