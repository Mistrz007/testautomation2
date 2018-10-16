package pl.mif.qa.frontend.factory;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class FrontEndTest {


    @Test
    public void firstFrontTest(){

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--stert-maximized");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

}
