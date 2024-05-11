import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

public class AppiumAndroidTest {
    private AppiumSetup appiumSetup;
    private AppiumDriver<WebElement> driver;
    private MobileGestures gestures;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        appiumSetup = new AppiumSetup();
        appiumSetup.initializeDriver();
        driver = appiumSetup.getDriver();
        gestures = new MobileGestures(driver);
    }

    @Test
    public void click_app_button() {
        // Find the element by its accessibility ID and click on it
        driver.findElement(MobileBy.AccessibilityId("Views")).click();
        gestures.scrollDown();
        driver.findElement(MobileBy.AccessibilityId("Lists")).click();

    }

    @AfterTest
    public void tearDown() {
        appiumSetup.quitDriver();
    }
}