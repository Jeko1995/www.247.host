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
    @DataProvider(name = "getEmail")
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

    //Data provider for getting email of the user and email login credentials.
    @DataProvider(name = "getEmailAndEmailLoginCredentials")
    public Object[][] getEmailAndEmailLoginCredentials() {
        try {
            CSVReader csvReader1 = new CSVReader(new FileReader("src/test/resources/correctLoginCredentials.csv"));
            List<String[]> csvData1 = csvReader1.readAll();
            List<String[]> validRows1 = new ArrayList<>();

            for (String[] row : csvData1) {
                if (!row[0].startsWith("//")) {
                    validRows1.add(row);
                }
            }

            CSVReader csvReader2 = new CSVReader(new FileReader("src/test/resources/emailLoginCredentials.csv"));
            List<String[]> csvData2 = csvReader2.readAll();
            List<String[]> validRows2 = new ArrayList<>();

            for (String[] row : csvData2) {
                if (!row[0].startsWith("//")) {
                    validRows2.add(row);
                }
            }

            // Determine the size of the combined data
            int combinedSize = Math.min(validRows1.size(), validRows2.size());

            // Create a 2D array to hold the combined data
            Object[][] combinedData = new Object[combinedSize][3];

            // Combine the data from both lists
            for (int i = 0; i < combinedSize; i++) {
                combinedData[i][0] = validRows1.get(i)[0].trim();  // Username
                combinedData[i][1] = validRows2.get(i)[0].trim();  // Email
                combinedData[i][2] = validRows2.get(i)[1].trim();  // Password
            }

            return combinedData;

        } catch (IOException | CsvException e) {
            System.out.println(e);
            return null;
        }
    }
}
