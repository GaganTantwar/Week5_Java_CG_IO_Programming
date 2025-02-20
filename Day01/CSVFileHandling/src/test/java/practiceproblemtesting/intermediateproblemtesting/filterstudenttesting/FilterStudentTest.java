package practiceproblemtesting.intermediateproblemtesting.filterstudenttesting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practiceproblems.intermediateproblems.filtercsvfile.FilterStudent;
import java.util.ArrayList;
public class FilterStudentTest {
    @Test
    public void filterStudenttesting(){
        FilterStudent filter= new FilterStudent();
        ArrayList<String> list = filter.filterStudents("StudentMarks.csv");
        ArrayList<String>expected=new ArrayList<>();
        expected.add("[Gagan, 21, 90]");
        expected.add("[Shubham, 22, 83]");
        expected.add("[Raju, 21, 85]");
        Assertions.assertEquals(expected,list);
        System.out.println("Testing Pass");

    }
}
