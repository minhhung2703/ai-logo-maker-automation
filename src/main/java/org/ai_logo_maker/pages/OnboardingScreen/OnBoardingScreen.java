package org.ai_logo_maker.pages.OnboardingScreen;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.ai_logo_maker.pages.baseScreen.baseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;
import java.time.Duration;
import java.util.Collections;

public class OnBoardingScreen extends baseScreen {
    private By imageLocator = By.id("com.thmobile.three.logomaker:id/img");

    public OnBoardingScreen(AndroidDriver driver) {
        super(driver);
    }

    public void swipeRightToLeft() {
        // Wait for the element to appear to ensure the interface is ready
        waitForElementVisible(imageLocator);

        Dimension size = driver.manage().window().getSize();
        // Swipe from right (90% width) to left (10% width)
        int startX = (int) (size.width * 0.90);
        int endX = (int) (size.width * 0.10);
        int centerY = (int) (size.height / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        // 1. Move to start position
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, centerY));
        // 2. Touch the screen
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        // 3. Short pause (necessary for W3C action to recognize touch/scroll)
        swipe.addAction(new org.openqa.selenium.interactions.Pause(finger, Duration.ofMillis(200)));
        // 4. Drag screen to the left
        swipe.addAction(
                finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, centerY));
        // 5. Lift finger
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        // 6. Execute
        driver.perform(Collections.singletonList(swipe));
    }

    public void swipeLeftToRight() {
        // Wait for the element to appear to ensure the interface is ready
        waitForElementVisible(imageLocator);

        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.10);
        int endX = (int) (size.width * 0.90);
        int centerY = (int) (size.height / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, centerY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(new org.openqa.selenium.interactions.Pause(finger, Duration.ofMillis(200)));
        swipe.addAction(
                finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, centerY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(swipe));
    }

    public boolean isImageDisplayed() {
        return waitForElementVisible(imageLocator).isDisplayed();
    }

    public void clickOnButtontoSwitchScreen(String titleButton) {
        String xpathTemplate = "//android.widget.Button[@resource-id='com.thmobile.three.logomaker:id/btnStart' and @text='%s']";
        By dynamicButtonLocator = By.xpath(String.format(xpathTemplate, titleButton));
        waitForElementVisible(dynamicButtonLocator).click();
    }

    public String isButtonNameDiplayed() {
        By dynamicButtonLocator = By
                .xpath("//android.widget.Button[@resource-id='com.thmobile.three.logomaker:id/btnStart']");
        return waitForElementVisible(dynamicButtonLocator).getText();
    }

    public String isTitleDisplayedOnBoardingScreen() {
        return waitForElementVisible(
                AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.thmobile.three.logomaker:id/tvTitle\"]"))
                .getText();
    }

    public String isDescriptionDisplayedOnBoardingScreen() {
        return waitForElementVisible(
                AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.thmobile.three.logomaker:id/tvDes\"]"))
                .getText();
    }

}
