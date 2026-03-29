package tests.languageScreenTest;

import org.ai_logo_maker.pages.LanguageScreen.LanguageScreen;
import org.ai_logo_maker.pages.SplashScreen.SplashScreen;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseTest;


public class TestLanguageScreen extends BaseTest {
    SplashScreen splashScreen;
    LanguageScreen languageScreen;

    @org.testng.annotations.BeforeClass
    public void initScreen(){
        splashScreen = new SplashScreen(driver);
        languageScreen = new LanguageScreen(driver);
    }

    @Test()
    public void isElementsDiplayOnSplashScreen(){
        Assert.assertTrue(splashScreen.isTitleAILogoMakerDisplay(),"Title don't display on the Splash Screen");
        Assert.assertTrue(splashScreen.isProgressBarDisplay(),"Progress Bar don't display on the Splash Screen");
        Assert.assertTrue(splashScreen.isDescriptionDisplay(),"Description don't display on the Splash Screen");

        Assert.assertEquals(splashScreen.getTitleAILogoMaker(),"LogoX - AI Logo Maker");
        Assert.assertEquals(splashScreen.getDescription(),"This process may contain ads");
    }

    @Test
    public void isTitleLanguageScreenDisplayed(){
        Assert.assertTrue(languageScreen.isTitleDisplay(),"Title Language don't display");
        Assert.assertEquals(languageScreen.getTitleOnLanguageScreen(),"Language");
        Assert.assertTrue(languageScreen.isStickButtonHidden(),"Tick Button dont'hidden");
    }

}
