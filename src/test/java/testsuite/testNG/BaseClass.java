package testsuite.testNG;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.net.Urls;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.print.DocFlavor;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


    public class  BaseClass {

        static AppiumDriver<MobileElement> driver;;

        @BeforeTest

        public void setup()throws MalformedURLException {
            DesiredCapabilities cap =new DesiredCapabilities();
            cap.setCapability("deviceName","sdk_gphone_x86");
            cap.setCapability("platformName","Android");
            cap.setCapability("platformVersion","11.0");
            cap.setCapability("automationName","uiautomator2");

            cap.setCapability("noReset","true");
            //  cap.setCapability("skipUnlock","true");
            //  cap.setCapability("app","getAbsolutePath()");

            //application activity - install apk on playstore
            cap.setCapability("appPackage","com.android.chrome");
            cap.setCapability("appActivity","com.google.android.apps.chrome.Main");

            URL url = new URL("http://127.0.0.1:4723/wd/hub");

            driver = new AppiumDriver<MobileElement>(url , cap);
            System.out.println("Application started");

            String sessionId =driver.getSessionId().toString();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        @AfterTest
        public void quitDriver(){
            driver.quit();
        }
    }

