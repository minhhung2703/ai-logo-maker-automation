package org.ai_logo_maker.pages.OnboardingScreen;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.ai_logo_maker.pages.baseScreen.baseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class OnBoardingScreen extends baseScreen {
    private By imageLocator = By.id("com.thmobile.three.logomaker:id/img");

    public OnBoardingScreen(AndroidDriver driver){
        super(driver);
    }

    public void swipeBack(){
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.05); // Very close to the left edge
        int endX = (int) (size.width * 0.5); // Move to the middle
        int centerY = (int) (size.height / 2 );

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence backAction = new Sequence(finger, 1);

        backAction.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, centerY));
        backAction.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        backAction.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, centerY));
        backAction.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(backAction));
    }

    public boolean isImageDisplayed(){
        return waitForElementVisible(imageLocator).isDisplayed();
    }

    public void clickOnButtontoSwitchScreen(String titleButton){
        String xpathTemplate = "//android.widget.Button[@resource-id='com.thmobile.three.logomaker:id/btnStart' and @text='%s']";
        By dynamicButtonLocator = By.xpath(String.format(xpathTemplate,titleButton));
        waitForElementVisible(dynamicButtonLocator).click();
    }

    public String isButtonNameDiplayed(){
        By dynamicButtonLocator = By.xpath("//android.widget.Button[@resource-id='com.thmobile.three.logomaker:id/btnStart']");
        return waitForElementVisible(dynamicButtonLocator).getText();
    }

    public String isTitleDisplayedOnBoardingScreen(){
        return waitForElementVisible(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.thmobile.three.logomaker:id/tvTitle\"]")).getText();
    }

    public String isDescriptionDisplayedOnBoardingScreen(){
        return waitForElementVisible(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.thmobile.three.logomaker:id/tvDes\"]")).getText();
    }

}
