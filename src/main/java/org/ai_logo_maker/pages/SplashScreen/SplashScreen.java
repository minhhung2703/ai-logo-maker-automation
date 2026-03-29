package org.ai_logo_maker.pages.SplashScreen;

import io.appium.java_client.android.AndroidDriver;
import org.ai_logo_maker.pages.baseScreen.baseScreen;
import org.openqa.selenium.By;

public class SplashScreen extends baseScreen {

    // Locator on splashScreen
    private By titleAILogoMakerLocator = By.id("com.thmobile.three.logomaker:id/lp_tv_app_name");
    private By progressBar = By.id("com.thmobile.three.logomaker:id/lp_progress_bar");
    private By descriptionLocator = By.id("com.thmobile.three.logomaker:id/lp_tv_ad_message");

    public SplashScreen(AndroidDriver driver){
        super(driver);
    }

    public boolean isTitleAILogoMakerDisplay(){
        return waitForElementVisible(titleAILogoMakerLocator).isDisplayed();
    }

    public boolean isProgressBarDisplay(){
        return waitForElementVisible(progressBar).isDisplayed();
    }

    public boolean isDescriptionDisplay(){
        return waitForElementVisible(descriptionLocator).isDisplayed();
    }

    public String getTitleAILogoMaker(){
        return waitForElementVisible(titleAILogoMakerLocator).getText();
    }

    public String getDescription(){
        return waitForElementVisible(descriptionLocator).getText();
    }

}
