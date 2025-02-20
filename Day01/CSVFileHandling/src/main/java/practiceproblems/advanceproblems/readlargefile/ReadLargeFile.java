package practiceproblems.advanceproblems.readlargefile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeFile {
    public int  largeFileRead(){
        String csvFile = "customers-1000.csv"; // Path to your large CSV file
        int chunkSize = 100; // Number of lines to process at a time
        int processedCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            int lineCount = 0;

            while ((line = br.readLine()) != null) {
                lineCount++;

                // Process the line (you can add your processing logic here)

                if (lineCount % chunkSize == 0) {
                    processedCount += chunkSize;
                    System.out.println("Processed " + processedCount + " records so far...");
                }
            }

            // Process remaining lines if they are less than chunkSize
            if (lineCount % chunkSize != 0) {
                processedCount += lineCount % chunkSize;
                System.out.println("Processed " + processedCount + " records so far...");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Finished processing all records.");
        return  processedCount;
    }

    public static void main(String[] args) {
        ReadLargeFile read=new ReadLargeFile();
        read.largeFileRead();
    }
}

