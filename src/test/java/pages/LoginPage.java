package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    protected  AppiumDriver driverAppium;

    @FindBy(id = "login")
    public WebElement loginButton;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;


   @AndroidBy(id = "com.android.chrome:id/search_box_text")
   //@AndroidBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText")
    public WebElement searchBox;



    public void isLoaded(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        driverAppium =driver;
    }

    public String getUrl(){
        return  driverAppium.getCurrentUrl();
    }


}
