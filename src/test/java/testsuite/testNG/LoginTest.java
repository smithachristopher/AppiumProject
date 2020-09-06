package testsuite.testNG;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;


public class LoginTest extends BaseClass {


        @Test(priority = 1)
        public void validLoginTest() throws InterruptedException {

           WebDriverWait wait = new WebDriverWait(driver, 60);

            LoginPage loginPage= new LoginPage();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.chrome:id/search_box_text")));
            Thread.sleep(6000);
            driver.findElementById("com.android.chrome:id/search_box_text").sendKeys("https://app.mycraftnote.de", Keys.RETURN);
            Thread.sleep(6000);
            loginPage.isLoaded(driver);
            driver.findElementById("email").sendKeys("qa-challenge@craftnote.de");
            driver.findElementById("password").sendKeys("Automation@2020");
            driver.findElementById("login").click();

            //verify Dashboard page is by checking if projects id returns the correct text.
            DashboardPage dashboardPage = new DashboardPage();
            Assert.assertEquals(dashboardPage.projects.getText() ,"projects");

        }

    @Test(priority = 2)
    public void invalidLoginTest() {


        WebDriverWait wait = new WebDriverWait(driver, 60);

        LoginPage loginPage= new LoginPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.chrome:id/search_box_text")));
        //Thread.sleep(6000);
        driver.findElementById("com.android.chrome:id/search_box_text").sendKeys("https://app.mycraftnote.de", Keys.RETURN);
        //Thread.sleep(3000);

        loginPage.email.sendKeys("qa-challenge@craftnote.de");
        loginPage.password.sendKeys("wrongPassword");
        loginPage.loginButton.click();

        //verify URL belongs to login page.
        String  actualUrl= loginPage.getUrl();
        String  expectedUrl= "https://app.mycraftnote.de/#/";

        Assert.assertEquals(actualUrl ,expectedUrl);
    }

    }

