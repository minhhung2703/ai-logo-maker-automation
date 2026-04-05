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
    public void initScreen(){
        splashScreen = new SplashScreen(driver);
        languageScreen= new LanguageScreen(driver);
        onBoardingScreen = new OnBoardingScreen(driver);

        languageScreen.selectLanguage("English");
        Assert.assertTrue(languageScreen.isTickButtonDisplay(),"Tick Button displayed");
        Assert.assertTrue(languageScreen.navigatedToOnboardingScreen());
    }

    @Test
    public void verifyTitleOnboardingScreen1(){
        // OnBoarding 1 Screen
        Assert.assertEquals(onBoardingScreen.isTitleDisplayedOnBoardingScreen(),"LogoX - AI Logo Maker", "Title does not match on Onboarding 1 Screen");
        Assert.assertEquals(onBoardingScreen.isDescriptionDisplayedOnBoardingScreen(),"Edit your design easily!", "Description does not match on Onboarding 1 Screen");
    }

}
