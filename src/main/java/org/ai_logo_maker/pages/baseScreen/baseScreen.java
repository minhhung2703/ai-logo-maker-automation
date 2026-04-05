package org.ai_logo_maker.pages.baseScreen;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class baseScreen {
    protected AndroidDriver driver;

    public baseScreen(AndroidDriver driver){
        this.driver = driver;
    }

    public WebElement waitForElementVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isElementClickable(By locator) {
        try {
            WebElement element = waitForElementVisible(locator);
            String clickableAttr = element.getAttribute("clickable");
            return Boolean.parseBoolean(clickableAttr);
        } catch (Exception e) {
            return false;
        }
    }


}
