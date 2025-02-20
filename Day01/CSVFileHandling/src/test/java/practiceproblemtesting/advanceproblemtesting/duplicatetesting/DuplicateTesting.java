package practiceproblemtesting.advanceproblemtesting.duplicatetesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practiceproblems.advanceproblems.detectduplicate.DetectDuplicate;
import java.util.*;
public class DuplicateTesting {
    @Test
    public void duplicateTesting(){
        DetectDuplicate duplicate=new DetectDuplicate();
        List<String> list=duplicate.duplicateFinder();
        Assertions.assertNotEquals(0,list.size());
        System.out.println("Testing Pass");
    }
}
