import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class DragAndDrop {
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
        driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
        WebElement sourceElement = driver.findElement(By.id("drag_dot_1"));
        WebElement targetElement = driver.findElement(By.id("drag_dot_2"));
        gestures.dragAndDrop(sourceElement, targetElement);
    }

    @AfterTest
    public void tearDown() {
        appiumSetup.quitDriver();
    }
}
