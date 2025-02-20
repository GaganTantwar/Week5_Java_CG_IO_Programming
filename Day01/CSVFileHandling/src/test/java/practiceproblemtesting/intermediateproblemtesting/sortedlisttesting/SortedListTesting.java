package practiceproblemtesting.intermediateproblemtesting.sortedlisttesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practiceproblems.intermediateproblems.sortcsvfile.CSVSorting;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedListTesting {
    @Test
    public void testSortedCsv(){
        CSVSorting sort=new CSVSorting();
        ArrayList<String[]> list=sort.getSortedValues("employee1.csv");
        String ans="";
        for(String [] employee:list){
            ans+= Arrays.toString(employee);
            ans+=" ";
        }
        Assertions.assertEquals(ans,"[EID89, Rani, 100000, IT] [EID78, Kishor, 80000, HR] [EID63, Kamal, 60000, Sales] [EID96, Gajendra, 55000, Marketing] [EID56, Raj, 50000, IT] ");
        System.out.println("Testing Pass");
    }
}
