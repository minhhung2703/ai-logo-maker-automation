    package org.ai_logo_maker.pages.LanguageScreen;

    import io.appium.java_client.AppiumBy;
    import io.appium.java_client.android.AndroidDriver;
    import org.ai_logo_maker.pages.baseScreen.baseScreen;
    import org.openqa.selenium.By;

    public class LanguageScreen extends baseScreen{
        private By titleLanguageLocator = AppiumBy.androidUIAutomator("new UiSelector().text(\"Language\")");
        private By tickButtonLocator = AppiumBy.id("com.thmobile.three.logomaker:id/btnOK");

        public LanguageScreen(AndroidDriver driver){
            super(driver);
        }

        public boolean isTitleDisplay(){
            return waitForElementVisible(titleLanguageLocator).isDisplayed();
        }

        public String getTitleOnLanguageScreen(){
            return waitForElementVisible(titleLanguageLocator).getText();
        }

        public boolean isTickButtonDisplay(){
            return  waitForElementVisible(tickButtonLocator).isDisplayed();
        }

        public boolean isStickButtonHidden(){
            return  !waitForElementVisible(tickButtonLocator).isEnabled();
        }

        public void selectLanguage (String languageName){
            String xpathBuilder = "//android.widget.TextView[@text='" + languageName + "']" +
                    "/following-sibling::android.widget.ImageView[@resource-id='com.thmobile.three.logomaker:id/checkbox']";
            waitForElementVisible(AppiumBy.xpath(xpathBuilder)).click();
        }



    }
