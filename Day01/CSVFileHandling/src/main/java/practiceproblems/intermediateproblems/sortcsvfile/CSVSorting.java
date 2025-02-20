package practiceproblems.intermediateproblems.sortcsvfile;

import java.util.*;
import java.io.*;
import com.opencsv.*;

public class CSVSorting {

    // Method to read a CSV file, sort its values, and return the sorted list
    public ArrayList<String[]> getSortedValues(String path) {
        ArrayList<String[]> list = new ArrayList<>(); // Initialize the list to store CSV rows

        // Try-with-resources to ensure CSVReader is closed after usage
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            reader.readNext(); // Skip the header line
            String[] columns;

            // Read each line until the end of the file
            while ((columns = reader.readNext()) != null) {
                list.add(columns); // Add each row to the list
            }

            // Sort the list based on the third column (index 2)
            Collections.sort(list, new Comparator<String[]>() {
                public int compare(String[] a, String[] b) {
                    // Parse and compare the integer values in descending order
                    return Integer.compare(Integer.parseInt(b[2]), Integer.parseInt(a[2]));
                }
            });

            // Print the sorted list
            for (String[] employee : list) {
                System.out.println("[" + employee[0] + ", " + employee[1] + ", " + employee[2] + ", " + employee[3] + "]");
            }

        } catch (Exception e) {
            // Print the exception message if an error occurs
            System.out.println(e.getMessage());
        }

        return list; // Return the sorted list
    }

    // Main method to test the getSortedValues method
    public static void main(String args[]) {
        CSVSorting sort = new CSVSorting(); // Create an instance of CSVSorting
        ArrayList<String[]> list = sort.getSortedValues("employee1.csv");// Call the getSortedValues method with the specified path
        String ans="";
        for(String [] employee:list){
            ans+=Arrays.toString(employee);
            ans+=" ";
        }
        System.out.println(ans);
    }
}
