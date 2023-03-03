package TestsUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.utils.AppiumUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class AndroidBaseTest extends AppiumUtils {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass(alwaysRun = true)
    public void ConfigureAppium() throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("E://Appium -Mobile Testing//CookMate//untitled//src//main//resources//data.properties");
        //if using cmd maven, in command line write : mvn test -P{name_of_groupe of tests} -DipAddress={ipAddress}
        String ipAddress = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
        System.out.println(ipAddress);
        prop.load(file);
        String port = prop.getProperty("port");
        service = startAppiumServer(ipAddress, Integer.parseInt(port));

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(prop.getProperty("AndroidDeviceName"));
        options.setChromedriverExecutable("E://Appium -Mobile Testing//CookMate//chromedriver_win32");
        options.setApp("E://Appium -Mobile Testing//CookMate//untitled//src//test//java//Resources//COOKmate.apk");

        driver = new AndroidDriver(service.getUrl(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
        service.stop();
    }
}
