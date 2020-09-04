package testsuite.testNG;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Test1 extends BaseClass {

    static AppiumDriver<MobileElement> driver;;

    @Test(priority = 1)
    public void loginTest() {
        WebDriverWait wait = new WebDriverWait(driver, 20);

            driver.get("https://app.mycraftnote.de/");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")))
                    .sendKeys("qa-challenge@craftnote.de");
            driver.findElementById("email").sendKeys("qa-challenge@craftnote.de");
            driver.findElementById("password").sendKeys("Automation@2020");
            driver.findElementById("login").click();

    }

}


