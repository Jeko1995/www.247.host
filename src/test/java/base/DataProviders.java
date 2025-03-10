package base;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataProviders {

    // This method reads a CSV file from the given file path and converts the rows into an array
    private static Object[][] readCsvData(String filePath, int columnCount) throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            List<String[]> csvData = csvReader.readAll();

            // Skip lines starting with // (comments)
            List<String[]> validRows = csvData.stream()
                    .filter(row -> row.length > 0 && !row[0].startsWith("//")).toList();

            // Transfer to Object[][]
            Object[][] csvDataObj = new Object[validRows.size()][columnCount];
            for (int i = 0; i < validRows.size(); i++) {
                csvDataObj[i] = validRows.get(i);
            }
            return csvDataObj;
        }
    }

    //Data provider for correct login credentials
    @DataProvider(name = "correctLoginCredentials")
    public Object[][] readCorrectLoginCredentials() throws IOException, CsvException {
        return readCsvData("src/test/resources/correctLoginCredentials.csv", 2);
    }

    //Data provider for invalid login credentials
    @DataProvider(name = "invalidLoginCredentials")
    public Object[][] readInvalidLoginCredentials() throws IOException, CsvException {
        return readCsvData("src/test/resources/invalidLoginCredentials.csv", 2);
    }

    //Data provider for getting correct email credentials of the user
    @DataProvider(name = "getEmail")
    public Object[][] readCorrectEmails() throws IOException, CsvException {
        Object[][] data = readCsvData("src/test/resources/correctLoginCredentials.csv", 2);
        Object[][] emails = new Object[data.length][1];
        for (int i = 0; i < data.length; i++) {
            emails[i][0] = data[i][0].toString().trim();
        }
        return emails;
    }

    //Data provider for invalid registration credentials
    @DataProvider(name = "invalidRegistrationCredentials")
    public Object[][] readInvalidRegistrationCredentials() throws IOException, CsvException {
        return readCsvData("src/test/resources/invalidRegistrationCredentials.csv", 8);
    }

    //Data provider for correct registration credentials
    @DataProvider(name = "correctRegistrationCredentials")
    public Object[][] readCorrectRegistrationCredentials() throws IOException, CsvException {
        return readCsvData("src/test/resources/correctRegistrationCredentials.csv", 8);
    }
}
