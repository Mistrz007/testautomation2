package pl.mig.qa.frontend.factory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForVisibility(WebElement we ,int maxWaitTime){



        // WebDriverWait klasa odpowiedzialna za to że czeka maxymalnie zadaną ilość czasu na wykonanie funkcji np na pokazanei sei elementu 10s potem wywali błąd, jak wykona sie szybciej to pojkdzie szybciej

        WebDriverWait wait = new WebDriverWait(driver,maxWaitTime);
        wait.until(ExpectedConditions.visibilityOf(we));
    }

}
