package practiceproblemtesting.intermediateproblemtesting.searchfiletest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practiceproblems.intermediateproblems.searchincsvfile.SearchInCSVFile;

import java.util.Arrays;

public class SearchFileTest {
    @Test
    public void searchTest(){
        SearchInCSVFile search=new SearchInCSVFile();
        String[] answer = search.searchEmployee("employee.csv", "kamal");
        Assertions.assertEquals(Arrays.toString(answer),"[EID63, Kamal, 60000]");
        System.out.println("Testing Pass");
    }
}
