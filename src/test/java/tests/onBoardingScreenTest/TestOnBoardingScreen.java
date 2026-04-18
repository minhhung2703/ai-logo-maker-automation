package tests.onBoardingScreenTest;

import org.ai_logo_maker.pages.LanguageScreen.LanguageScreen;
import org.ai_logo_maker.pages.OnboardingScreen.OnBoardingScreen;
import org.ai_logo_maker.pages.SplashScreen.SplashScreen;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseTest;

public class TestOnBoardingScreen extends BaseTest {
    SplashScreen splashScreen;
    LanguageScreen languageScreen;
    OnBoardingScreen onBoardingScreen;

    @org.testng.annotations.BeforeClass
    public void initScreen() {
        splashScreen = new SplashScreen(driver);
        languageScreen = new LanguageScreen(driver);
        onBoardingScreen = new OnBoardingScreen(driver);

        languageScreen.selectLanguage("English");
        Assert.assertTrue(languageScreen.isTickButtonDisplay(), "Tick Button displayed");
        Assert.assertTrue(languageScreen.navigatedToOnboardingScreen());
    }

    @Test
    public void gestureRightToLeftOnBoardingScreen() {
        // Swipe first
        Assert.assertEquals(onBoardingScreen.isTitleDisplayedOnBoardingScreen(), "LogoX - AI Logo Maker", "Title does not match on Onboarding 1 Screen");
        Assert.assertEquals(onBoardingScreen.isDescriptionDisplayedOnBoardingScreen(), "Edit your design easily!", "Description does not match on Onboarding 1 Screen");
        Assert.assertTrue(onBoardingScreen.isImageDisplayed(), "Image don't display on the OnBoarding Screen.");
        Assert.assertEquals(onBoardingScreen.isButtonNameDiplayed(), "Continue");
        onBoardingScreen.swipeRightToLeft();

        // Swipe second
        Assert.assertEquals(onBoardingScreen.isTitleDisplayedOnBoardingScreen(), "1000+ Templates");
        Assert.assertEquals(onBoardingScreen.isDescriptionDisplayedOnBoardingScreen(), "Create stunning logos!");
        Assert.assertTrue(onBoardingScreen.isImageDisplayed(), "Image don't display on the OnBoarding Screen.");
        Assert.assertEquals(onBoardingScreen.isButtonNameDiplayed(), "Continue");
        onBoardingScreen.swipeRightToLeft();

        // Swipe third
        Assert.assertEquals(onBoardingScreen.isTitleDisplayedOnBoardingScreen(), "Style Magic AI for Logo");
        Assert.assertEquals(onBoardingScreen.isDescriptionDisplayedOnBoardingScreen(), "Create stunning logos — fast and easy.");
        Assert.assertTrue(onBoardingScreen.isImageDisplayed(), "Image don't display on the OnBoarding Screen.");
        Assert.assertEquals(onBoardingScreen.isButtonNameDiplayed(), "Continue");

    }

    @Test
    public void gestureLeftToRightOnBoardingScreen(){
        // Swipe first
        Assert.assertEquals(onBoardingScreen.isTitleDisplayedOnBoardingScreen(), "LogoX - AI Logo Maker", "Title does not match on Onboarding 1 Screen");
        Assert.assertEquals(onBoardingScreen.isDescriptionDisplayedOnBoardingScreen(), "Edit your design easily!", "Description does not match on Onboarding 1 Screen");
        Assert.assertTrue(onBoardingScreen.isImageDisplayed(), "Image don't display on the OnBoarding Screen.");
        Assert.assertEquals(onBoardingScreen.isButtonNameDiplayed(), "Continue");
        onBoardingScreen.swipeRightToLeft();

        // Swipe second
        Assert.assertEquals(onBoardingScreen.isTitleDisplayedOnBoardingScreen(), "1000+ Templates");
        Assert.assertEquals(onBoardingScreen.isDescriptionDisplayedOnBoardingScreen(), "Create stunning logos!");
        Assert.assertTrue(onBoardingScreen.isImageDisplayed(), "Image don't display on the OnBoarding Screen.");
        Assert.assertEquals(onBoardingScreen.isButtonNameDiplayed(), "Continue");
        onBoardingScreen.swipeLeftToRight();

        Assert.assertEquals(onBoardingScreen.isTitleDisplayedOnBoardingScreen(), "LogoX - AI Logo Maker", "Title does not match on Onboarding 1 Screen");
        Assert.assertEquals(onBoardingScreen.isDescriptionDisplayedOnBoardingScreen(), "Edit your design easily!", "Description does not match on Onboarding 1 Screen");
        Assert.assertTrue(onBoardingScreen.isImageDisplayed(), "Image don't display on the OnBoarding Screen.");
        Assert.assertEquals(onBoardingScreen.isButtonNameDiplayed(), "Continue");

    }

    @Test
    public void verifyTitleOnboardingScreen1() {
        // OnBoarding 1 Screen
        Assert.assertEquals(onBoardingScreen.isTitleDisplayedOnBoardingScreen(), "LogoX - AI Logo Maker", "Title does not match on Onboarding 1 Screen");
        Assert.assertEquals(onBoardingScreen.isDescriptionDisplayedOnBoardingScreen(), "Edit your design easily!", "Description does not match on Onboarding 1 Screen");
        Assert.assertTrue(onBoardingScreen.isImageDisplayed(), "Image don't display on the OnBoarding Screen.");
        Assert.assertEquals(onBoardingScreen.isButtonNameDiplayed(), "Continue");
        onBoardingScreen.clickOnButtontoSwitchScreen("Continue");

        // OnBoarding 2 Screen
        Assert.assertEquals(onBoardingScreen.isTitleDisplayedOnBoardingScreen(), "1000+ Templates");
        Assert.assertEquals(onBoardingScreen.isDescriptionDisplayedOnBoardingScreen(), "Create stunning logos!");
        Assert.assertTrue(onBoardingScreen.isImageDisplayed(), "Image don't display on the OnBoarding Screen.");
        Assert.assertEquals(onBoardingScreen.isButtonNameDiplayed(), "Continue");
        onBoardingScreen.clickOnButtontoSwitchScreen("Continue");

        // OnBoarding 3 Screen
        Assert.assertEquals(onBoardingScreen.isTitleDisplayedOnBoardingScreen(), "Style Magic AI for Logo");
        Assert.assertEquals(onBoardingScreen.isDescriptionDisplayedOnBoardingScreen(), "Create stunning logos — fast and easy.");
        Assert.assertTrue(onBoardingScreen.isImageDisplayed(), "Image don't display on the OnBoarding Screen.");
        Assert.assertEquals(onBoardingScreen.isButtonNameDiplayed(), "Continue");
        onBoardingScreen.clickOnButtontoSwitchScreen("Continue");

        // Navigated to HomeScreen
    }

}
