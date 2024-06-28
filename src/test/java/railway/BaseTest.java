package railway;

import org.railway.utils.ConfigLoader;
import org.railway.utils.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseTest {

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        String browser = System.getProperty("browser", ConfigLoader.getProperty("browser"));
        Driver.setupDriver(browser);
        Driver.driver.manage().window().maximize();
        Driver.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        Driver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void tearDown() {
        Driver.driver.quit();
    }
}
