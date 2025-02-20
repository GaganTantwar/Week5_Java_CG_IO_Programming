package practiceproblemtesting.advanceproblemtesting.dataprocessingtesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practiceproblems.advanceproblems.dataprocessingcsv.DataProcessingInCSV;

import java.io.*;
import java.util.ArrayList;

public class DataProcessingInCSVTest {

    @Test
    public void testProcessData(){
        DataProcessingInCSV process=new DataProcessingInCSV();
        ArrayList<String> arr=process.processData("personfile.csv");
        Assertions.assertEquals(arr.toString(),"[Kamal, Jay]");
    }
}