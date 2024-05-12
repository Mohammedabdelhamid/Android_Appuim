import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class MobileGestures {
    private AppiumDriver<?> driver;

    public MobileGestures(AppiumDriver<?> driver) {
        this.driver = driver;
    }

    public void scrollDown() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        new TouchAction<>(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(startX, endY))
                .release().perform();
    }

    public void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
        int startX = sourceElement.getLocation().getX() + (sourceElement.getSize().getWidth() / 2);
        int startY = sourceElement.getLocation().getY() + (sourceElement.getSize().getHeight() / 2);
        int endX = targetElement.getLocation().getX() + (targetElement.getSize().getWidth() / 2);
        int endY = targetElement.getLocation().getY() + (targetElement.getSize().getHeight() / 2);

        new TouchAction<>(driver)
                .longPress(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))) // Adjust the duration as needed
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }

    public void swipe(int startX, int startY, int endX, int endY, Duration duration) {

            new TouchAction<>(driver)
                    .press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(duration))
                    .moveTo(PointOption.point(endX, endY))
                    .release()
                    .perform();
    }
}

    // You can add more gesture functions like scrollUp, swipe, etc. here
