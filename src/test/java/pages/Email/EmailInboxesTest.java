package pages.Email;

import com.mailslurp.apis.InboxControllerApi;
import com.mailslurp.clients.ApiClient;
import com.mailslurp.clients.ApiException;
import com.mailslurp.clients.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import okhttp3.OkHttpClient;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.http.HttpClient;
import java.util.concurrent.TimeUnit;

public class EmailInboxesTest {
    private static ApiClient defautClient;
    private static InboxControllerApi inboxControllerApi;
    private static String API_KEY = "41eb0296fe555efb2fc3c60d8fbd3fe1eba30008b0c9c25243d36bb85b70e933";

    private static WebDriver driver;
    private static final Long TIMEOUT = 30000L;

    @BeforeMethod
    public static void setUpClass() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();

        static {
            // IMPORTANT set timeout for the http client
            OkHttpClient httpClient = new OkHttpClient.Builder()
                    .connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                    .writeTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                    .readTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                    .build();

            defautClient = Configuration.getDefaultApiClient();

            //IMPORTANT set api client timeouts
            defautClient.setConnectTimeout(TIMEOUT.intValue());
            defautClient.setWriteTimeout(TIMEOUT.intValue());
            defautClient.setReadTimeout(TIMEOUT.intValue());

            //IMPORTANT set API KEY and client
            defautClient.setHttpClient(httpClient);
            defautClient.setApiKey(API_KEY);

            inboxControllerApi = new InboxControllerApi(defautClient);
        }
    }

    @Test
    public void userCreateSuccessfully_when_validateEmail() throws ApiException {
        String user = "automation@eurocoders.org";
    }
}


// 20:58