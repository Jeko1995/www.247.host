package base;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataProviders {

    //Data provider for valid login credentials.
    @DataProvider(name = "correctLoginCredentials")
    public Object[][] readCorrectLoginCredentials() {
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/correctLoginCredentials.csv"));
            List<String[]> csvData = csvReader.readAll();
            List<String[]> validRows = new ArrayList<>();

            for (String[] row : csvData) {
                if (!row[0].startsWith("//")) {
                    validRows.add(row);
                }
            }

            Object[][] csvDataObj = new Object[validRows.size()][2];

            for (int i = 0; i < validRows.size(); i++) {
                csvDataObj[i] = validRows.get(i);
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
            List<String[]> validRows = new ArrayList<>();

            for (String[] row : csvData) {
                if (!row[0].startsWith("//")) {
                    validRows.add(row);
                }
            }

            Object[][] csvDataObj = new Object[validRows.size()][2];
            for (int i = 0; i < validRows.size(); i++) {
                csvDataObj[i] = validRows.get(i);
            }

            return csvDataObj;

        } catch (IOException | CsvException e) {
            System.out.println(e);
            return null;
        }
    }

    //Data provider for getting correct email of the user.
    @DataProvider(name = "emails")
    public Object[][] readCorrectEmails() {
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/correctLoginCredentials.csv"));
            List<String[]> csvData = csvReader.readAll();
            List<String[]> validRows = new ArrayList<>();

            for (String[] row : csvData) {
                if (!row[0].startsWith("//")) {
                    validRows.add(row);
                }
            }

            Object[][] csvDataObj = new Object[validRows.size()][1];

            for (int i = 0; i < validRows.size(); i++) {
                csvDataObj[i][0] = validRows.get(i)[0].trim();
            }

            return csvDataObj;

        } catch (IOException | CsvException e) {
            System.out.println(e);
            return null;
        }
    }
}
