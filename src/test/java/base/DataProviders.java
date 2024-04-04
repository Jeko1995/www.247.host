package base;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataProviders {

    //Data provider for valid login credentials.
    @DataProvider(name = "validLoginCredentials")
    public Object[][] readValidLoginCredentials() {
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/validLoginCredentials.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObj = new Object[csvData.size()][2];

            for (int i = 0; i < csvData.size(); i++) {
                csvDataObj[i] = csvData.get(i);
            }

            return csvDataObj;

        } catch (IOException | CsvException e) {
            System.out.println(e);
            return null;
        }
    }

    //Data provider for invalid login credentials.
    @DataProvider(name = "invalidLoginCredentials")
    public Object[][] readInvalidLoginCredentials() {
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/invalidLoginCredentials.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object[][] csvDataObj = new Object[csvData.size()][2];

            for (int i = 0; i < csvData.size(); i++) {
                csvDataObj[i] = csvData.get(i);
            }

            return csvDataObj;

        } catch (IOException | CsvException e) {
            System.out.println(e);
            return null;
        }
    }
}
