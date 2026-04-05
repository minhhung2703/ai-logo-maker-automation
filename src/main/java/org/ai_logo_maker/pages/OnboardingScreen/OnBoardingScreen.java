package org.ai_logo_maker.pages.OnboardingScreen;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.ai_logo_maker.pages.baseScreen.baseScreen;
import org.openqa.selenium.By;

public class OnBoardingScreen extends baseScreen {

    private By imageLocator = By.id("com.thmobile.three.logomaker:id/img");

    public OnBoardingScreen(AndroidDriver driver){
        super(driver);
    }

    public void isImageDisplayed(){
        waitForElementVisible(imageLocator).isDisplayed();
    }

    public String isTitleDisplayedOnBoardingScreen(){
        return waitForElementVisible(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.thmobile.three.logomaker:id/tvTitle\"]")).getText();
    }

    public String isDescriptionDisplayedOnBoardingScreen(){
        return waitForElementVisible(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.thmobile.three.logomaker:id/tvDes\"]")).getText();
    }

}
