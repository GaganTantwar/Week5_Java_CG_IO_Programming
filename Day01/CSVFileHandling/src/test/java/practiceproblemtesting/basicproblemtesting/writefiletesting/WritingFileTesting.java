package practiceproblemtesting.basicproblemtesting.writefiletesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class WritingFileTesting {
    @Test
    public void writeTest(){
        String path="student2.csv";
        File file=new File(path);
        try(BufferedWriter br= new BufferedWriter(new FileWriter(file))){
            br.write("Id234,Ramendra,23,482 \n");
            br.write("Id238,Ramu,21,382 \n");
            br.write("Id225,Rohit,22,420 \n");
            br.write("Id220,Rohan,20,430 \n");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testReadedFile(){
        String path = "student2.csv";
        StringBuilder words = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.append(line.trim()); // Add a comma and space for consistency
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Remove the last comma and space
        String word = words.toString().trim().replaceAll(",","");
        String expected="Id234Ramendra23482Id238Ramu21382Id225Rohit22420Id220Rohan20430";
        System.out.println(word);
        Assertions.assertEquals(word,expected);
        System.out.println("Testing Pass");

    }
}
