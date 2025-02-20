package practiceproblemtesting.basicproblemtesting.readfiletesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practiceproblems.basicproblems.readcsvfile.ReadingCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileTest {

    @Test
    public void testReadedFile(){
        String path = "readtest.csv";
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

        System.out.println(word);
        String excpected="\uFEFFID520GaganJavaID633ShubhamPythonID632HrashitRust";
        Assertions.assertEquals(excpected,word);
    }

}
