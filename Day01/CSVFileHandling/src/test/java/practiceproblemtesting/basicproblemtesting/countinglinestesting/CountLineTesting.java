package practiceproblemtesting.basicproblemtesting.countinglinestesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practiceproblems.basicproblems.countlineincsv.CountLine;

public class CountLineTesting {
    @Test
    public void countLines(){
        CountLine counter= new CountLine();
        int count=counter.countLines("student.csv");
        Assertions.assertEquals(7,count);
    }
}
