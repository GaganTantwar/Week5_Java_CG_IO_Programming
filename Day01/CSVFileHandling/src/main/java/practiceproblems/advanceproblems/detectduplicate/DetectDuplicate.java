package practiceproblems.advanceproblems.detectduplicate;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DetectDuplicate {
    public List<String> duplicateFinder(){
        String csvFile = "student.csv"; // Path to your CSV file

        Set<String> uniqueIDs = new HashSet<>();
        List<String> duplicateRecords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            ;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (!data[0].equalsIgnoreCase("ID")) { // Skip header
                    if (uniqueIDs.contains(data[0])) {
                        // If ID is already in the set, it's a duplicate
                        duplicateRecords.add(line);
                    }
                    else{
                        uniqueIDs.add(data[0]);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Print duplicate records
        if (duplicateRecords.isEmpty()) {
            System.out.println("No duplicates found.");
        } else {
            System.out.println("Duplicate records:");
            for (String record : duplicateRecords) {
                System.out.println(record);
            }
        }
        return duplicateRecords;
    }

    public static void main(String[] args) {
        DetectDuplicate detect=new DetectDuplicate();
        List<String> duplicate=detect.duplicateFinder();
    }
}
