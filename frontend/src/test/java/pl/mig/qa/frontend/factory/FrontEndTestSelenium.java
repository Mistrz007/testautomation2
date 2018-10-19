package pl.mig.qa.frontend.factory;

import org.junit.jupiter.api.Test;
import pl.mig.qa.frontend.Configuration;
import pl.mig.qa.frontend.factory.page.*;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrontEndTestSelenium extends FrontConfiguration {

    @Test
    public void firstFrontTest(){

        MainPage mainPage = new MainPage(driver);

        assertTrue(driver.getTitle().contains("WordPress.com"));
        assertEquals(mainPage.logIn.getText(),"Log In");
        assertTrue(mainPage.logIn.isDisplayed());

        mainPage.logIn.click();

        LoginEmailPage loginEmailPage = new LoginEmailPage(driver);
        loginEmailPage.waitForVisibility(loginEmailPage.loginEmail,10);
        assertTrue(loginEmailPage.loginEmail.isDisplayed());
        //assertEquals(loginEmailPage.loginEmail.getTagName(),"usernameOrEmail");
        assertTrue(loginEmailPage.emailContinueButton.isDisplayed());
        assertTrue(loginEmailPage.emailContinueButton.isEnabled());

        loginEmailPage.loginEmail.clear();
        loginEmailPage.loginEmail.sendKeys(Configuration.LOGIN);
        loginEmailPage.emailContinueButton.click();

        LoginPassPage loginPassPage = new LoginPassPage(driver);
        // napisana metoda która jest dziedziczona z basepage do czekania na element strony
        loginPassPage.waitForVisibility(loginPassPage.loginPass,10);

        assertTrue(loginPassPage.loginPass.isDisplayed());
        assertTrue(loginPassPage.passContinueButton.isDisplayed());
        assertTrue(loginPassPage.passContinueButton.isEnabled());
        loginPassPage.loginPass.clear();
        loginPassPage.loginPass.sendKeys(Configuration.PASSWORD);
        loginPassPage.passContinueButton.click();

        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.waitForVisibility(userMainPage.userAvatar,10);
        assertTrue(userMainPage.userAvatar.isDisplayed());
        userMainPage.userAvatar.click();

        userMainPage.waitForVisibility(userMainPage.privateButton,10);
        assertTrue(userMainPage.privateButton.isDisplayed());
        userMainPage.privateButton.click();

        UserPersonalPage userPersonalPage = new UserPersonalPage(driver);

        PrivatePage privatePage = new PrivatePage(driver);
        userMainPage.waitForVisibility(privatePage.toggleSwitchPrivateSite,10);
        assertTrue(privatePage.toggleSwitchPrivateSite.isDisplayed());
        if(!privatePage.toggleSwitchPrivateSiteSave.isEnabled()){
            privatePage.toggleSwitchPrivateSite.click();
        }
        privatePage.toggleSwitchPrivateSiteSave.click();


    }

    @Test
    public void secondtFrontTest(){

        //System.getenv()
        MainPage mainPage = new MainPage(driver);

        assertTrue(driver.getTitle().contains("WordPress.com"));
        assertEquals(mainPage.logIn.getText(),"Log In");
        assertTrue(mainPage.logIn.isDisplayed());

        mainPage.logIn.click();

        LoginEmailPage loginEmailPage = new LoginEmailPage(driver);
        loginEmailPage.waitForVisibility(loginEmailPage.loginEmail,10);
        assertTrue(loginEmailPage.loginEmail.isDisplayed());
        //assertEquals(loginEmailPage.loginEmail.getTagName(),"usernameOrEmail");
        assertTrue(loginEmailPage.emailContinueButton.isDisplayed());
        assertTrue(loginEmailPage.emailContinueButton.isEnabled());

        loginEmailPage.loginEmail.clear();
        loginEmailPage.loginEmail.sendKeys(Configuration.LOGIN);
        loginEmailPage.emailContinueButton.click();

        LoginPassPage loginPassPage = new LoginPassPage(driver);
        // napisana metoda która jest dziedziczona z basepage do czekania na element strony
        loginPassPage.waitForVisibility(loginPassPage.loginPass,10);

        assertTrue(loginPassPage.loginPass.isDisplayed());
        assertTrue(loginPassPage.passContinueButton.isDisplayed());
        assertTrue(loginPassPage.passContinueButton.isEnabled());
        loginPassPage.loginPass.clear();
        loginPassPage.loginPass.sendKeys(Configuration.PASSWORD);
        loginPassPage.passContinueButton.click();

        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.waitForVisibility(userMainPage.userAvatar,10);
        assertTrue(userMainPage.userAvatar.isDisplayed());
        userMainPage.userAvatar.click();

        userMainPage.waitForVisibility(userMainPage.privateButton,10);
        assertTrue(userMainPage.privateButton.isDisplayed());
        userMainPage.privateButton.click();

        UserPersonalPage userPersonalPage = new UserPersonalPage(driver);
        userPersonalPage.notyficationSetup.click();

        NotyficationSetupPage notyficationSetupPage = new NotyficationSetupPage(driver);
        notyficationSetupPage.waitForVisibility(notyficationSetupPage.newObservEmailToggle,10);
        assertTrue(notyficationSetupPage.newObservEmailToggle.isSelected());
        notyficationSetupPage.newObservEmailToggle.click();
        if(notyficationSetupPage.saveButton.isEnabled()){
            notyficationSetupPage.saveButton.click();
        }
        assertFalse(notyficationSetupPage.newObservEmailToggle.isSelected());
        notyficationSetupPage.newObservEmailToggle.click();
        if(notyficationSetupPage.saveButton.isEnabled()){
            notyficationSetupPage.saveButton.click();
        }

        //NotyficationSetupPage notyficationSetupPage = new NotyficationSetupPage(driver);
        //notyficationSetupPage.waitForVisibility(notyficationSetupPage.);


    }
}
