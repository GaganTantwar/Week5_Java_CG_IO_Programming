package practiceproblems.advanceproblems.mergetwocsv;
import java.util.*;
import java.io.*;
import com.opencsv.*;
public class MergeCSV {
    public static void main(String[] args) {
        String csvFile1 = "student1.csv";
        String csvFile2 = "student2.csv";
        String outputFile = "merged_students.csv";

        Map<String, Student> studentMap = new HashMap<>();

        // Read students1.csv and store data in a map
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile1))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (!data[0].equals("Id")) { // Skip header
                    Student student = new Student(data[0], data[1], Integer.parseInt(data[2]), 0, "");
                    studentMap.put(data[0], student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read students2.csv and update the map
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile2))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (!data[0].equalsIgnoreCase("Id")) { // Skip header
                    Student student = studentMap.get(data[0]);
                    if (student != null) {
                        student.marks = Integer.parseInt(data[1]);
                        student.grade = data[2];
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write the merged data to a new file
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("ID,Name,Age,Marks,Grade\n");
            for (Student student : studentMap.values()) {
                writer.write(student.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Merge complete. Merged data written to " + outputFile);
    }
}
