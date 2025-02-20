package practiceproblemtesting.advanceproblemtesting.largefiletesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practiceproblems.advanceproblems.readlargefile.ReadLargeFile;

public class LargeFileTesting {
    @Test
    public void largeFileTesting(){
        ReadLargeFile read=new ReadLargeFile();
        int count=read.largeFileRead();
        Assertions.assertNotEquals(0,count);
    }
}
