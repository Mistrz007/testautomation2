package pl.mig.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForVisibility(WebElement we ,int maxWaitTime){
        WebDriverWait wait = new WebDriverWait(driver,maxWaitTime);
        wait.until(ExpectedConditions.visibilityOf(we));
    }

}
