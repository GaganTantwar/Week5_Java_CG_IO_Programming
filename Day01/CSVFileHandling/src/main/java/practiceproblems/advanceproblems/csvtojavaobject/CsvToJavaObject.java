package practiceproblems.advanceproblems.csvtojavaobject;
import java.util.*;
import java.io.*;
public class CsvToJavaObject {
    public static void main(String []args){
        String csvFile = "student.csv"; // Path to your CSV file

        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                // Use comma as separator
                String[] data = line.split(",");
                // Create a Student object from the data
                Student student = new Student(data[0], data[1], Integer.parseInt(data[2]),Integer.parseInt(data[3]));
                // Add the Student object to the list
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the students
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
