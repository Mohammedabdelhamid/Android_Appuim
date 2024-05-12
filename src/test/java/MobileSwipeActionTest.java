import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MobileSwipeActionTest {
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
    public void click_app_button() throws InterruptedException {
        // Find the element by its accessibility ID and click on it
        driver.findElement(MobileBy.AccessibilityId("Views")).click();
        driver.findElement(MobileBy.AccessibilityId("Gallery")).click();
        driver.findElement(MobileBy.AccessibilityId("1. Photos")).click();

        int startX = 500;
        int startY = 325;
        int endX = 1000;
        int endY = 325;
        Duration duration = Duration.ofMillis(3000); // Duration in milliseconds

        gestures.swipe(startX, startY, endX, endY, duration);



    }


}
