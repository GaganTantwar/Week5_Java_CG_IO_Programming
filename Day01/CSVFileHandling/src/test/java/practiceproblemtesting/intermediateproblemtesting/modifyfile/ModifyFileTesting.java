package practiceproblemtesting.intermediateproblemtesting.modifyfile;

import org.junit.jupiter.api.Test;
import practiceproblems.intermediateproblems.modifycsvfile.ModifyCSVFile;

public class ModifyFileTesting {
    @Test
    public void modifiedTesting(){
        ModifyCSVFile modify=new ModifyCSVFile();
        modify.modifyData("employee1.csv");
        System.out.println("Testing Pass");
    }
}
