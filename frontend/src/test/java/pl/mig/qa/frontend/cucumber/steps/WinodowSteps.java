package pl.mig.qa.frontend.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.mig.qa.frontend.cucumber.CucumbertStepConfig;
import pl.mig.qa.frontend.cucumber.page.DiaryTestPage;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinodowSteps {

    WebDriver driver;
    DiaryTestPage diaryTestPage;
    String firstPageWindowHandle;
    String secondTestWindowHandle;

    public WinodowSteps(CucumbertStepConfig config) {

        try {
            this.driver = config.setUp();
        } catch(Exception e){
            System.out.println(e.toString());
        }
    }

    @Given("^User is one main page$")
    public void userIsOneMainPage()  {

        firstPageWindowHandle = driver.getWindowHandle();

        driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");
        diaryTestPage = new DiaryTestPage(driver);
        diaryTestPage.windowFrame.isDisplayed();

        int hyperLinkYCord = diaryTestPage.windowFrame.getLocation().getY();
        int hyperLinkXCord = diaryTestPage.windowFrame.getLocation().getX();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(" + hyperLinkXCord + ","+ hyperLinkYCord + ")");
        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.linkText("Open page in a new window")));

        assertTrue( true);
    }


    @When("^User press link$")
    public void userPressLink()  {
        diaryTestPage.windowFrame.click();
        assertTrue( true);
    }

    @Then("^User is switch to othen window$")
    public void userIsSwitchToOthenWindow()  {
        Set<String> testPageWindows = driver.getWindowHandles();
        for(String s : testPageWindows){
            if (!firstPageWindowHandle.equals(s)) {
                secondTestWindowHandle = s;
            }
        }
        driver.switchTo().window(secondTestWindowHandle);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("testpagelink")));

        driver.switchTo().window(secondTestWindowHandle).close();

        driver.switchTo().window(firstPageWindowHandle);

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Open page in a new window")));

        assertTrue( true);
    }
}
