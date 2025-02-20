package practiceproblems.advanceproblems.csvtojsontocsv;
import com.opencsv.CSVWriter;
import org.json.JSONArray;
import org.json.JSONObject;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class CsvToJsonToCsv {
    public void csvToJson(){
        String source="student.csv";
        String destination="student.json";
        try {
            // Read CSV file
            CSVReader reader = new CSVReader(new FileReader(source));
            String[] headers = reader.readNext(); // Read headers
            JSONArray jsonArray = new JSONArray();

            String[] line;
            while ((line = reader.readNext()) != null) {
                JSONObject jsonObject = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    jsonObject.put(headers[i], line[i]);
                }
                jsonArray.put(jsonObject);
            }
            reader.close();

            // Write JSON to file
            FileWriter fileWriter = new FileWriter(destination);
            fileWriter.write(jsonArray.toString(4)); // Pretty print with indentation
            fileWriter.close();

            System.out.println("CSV data has been converted to JSON and saved to " + destination);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void jsonToCsv(){
        String destination="student5.csv";
        String source="student.json";
        try {
            // Read JSON file
            FileReader reader = new FileReader(source);
            StringBuilder sb = new StringBuilder();
            int i;
            while ((i = reader.read()) != -1) {
                sb.append((char) i);
            }
            reader.close();

            // Convert JSON to CSV
            JSONArray jsonArray = new JSONArray(sb.toString());
            FileWriter csvWriter = new FileWriter(destination);
            CSVWriter writer = new CSVWriter(csvWriter);

            // Write CSV headers
            JSONObject firstObject = jsonArray.getJSONObject(0);
            String[] headers = JSONObject.getNames(firstObject);
            writer.writeNext(headers);

            // Write data
            for (int j = 0; j < jsonArray.length(); j++) {
                JSONObject jsonObject = jsonArray.getJSONObject(j);
                String[] data = new String[headers.length];
                for (int k = 0; k < headers.length; k++) {
                    data[k] = jsonObject.get(headers[k]).toString();
                }
                writer.writeNext(data);
            }

            writer.close();
            System.out.println("JSON data has been converted to CSV and saved to " + destination);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        CsvToJsonToCsv obj=new CsvToJsonToCsv();
        obj.csvToJson();
        obj.jsonToCsv();
    }
}
