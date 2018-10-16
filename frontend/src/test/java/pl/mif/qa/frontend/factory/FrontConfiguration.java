package pl.mif.qa.frontend.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import pl.mig.qa.frontend.Configuration;

import java.util.concurrent.TimeUnit;

public class FrontConfiguration {

    public WebDriver driver;

    @BeforeAll
    public static void beforeAll(){
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.edgedriver().setup();
    }

    @BeforeEach
    public void beforeEach(){
        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--stert-maximized");
        //WebDriver driver = new ChromeDriver(chromeOptions);
        if(driver ==null){
            driver = new ChromeDriver();
        //    driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(Configuration.WORDPRESS_URL);
    }

    @AfterEach
    public void afterEach(){
        if(driver != null){
        //    driver.quit();
        }
        //driver=null;
    }
}
