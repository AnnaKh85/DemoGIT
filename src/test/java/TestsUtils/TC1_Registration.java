package TestsUtils;

import com.aventstack.extentreports.App;
import io.appium.java_client.AppiumBy;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1_Registration extends AndroidBaseTest{
    @Test
    public void FillFormRegistration(){
        driver.findElement(By.id("fr.cookbook:id/button1")).click();

        driver.findElement(AppiumBy.id("fr.cookbook:id/agree_text")).click();

        driver.findElement(AppiumBy.id("fr.cookbook:id/username")).click();
        driver.findElement(AppiumBy.id("fr.cookbook:id/username")).sendKeys("Anna");
        driver.findElement(AppiumBy.id("fr.cookbook:id/password")).click();
        driver.findElement(AppiumBy.id("fr.cookbook:id/password")).sendKeys("123");
        driver.findElement(By.id("fr.cookbook:id/login_button")).click();
        String errorMsg = driver.findElement(By.id("fr.cookbook:id/error")).getText();
        Assert.assertEquals(errorMsg, "Unable to log in with provided credentials.");

        System.out.println("This text is from the NewBranch");
    }
}
