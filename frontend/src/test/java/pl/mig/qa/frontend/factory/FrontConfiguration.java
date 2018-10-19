package pl.mig.qa.frontend.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pl.mig.qa.frontend.Configuration;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FrontConfiguration {

    public WebDriver driver;

    @BeforeAll
    public static void beforeAll(){
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.edgedriver().setup();
    }

    @BeforeEach
    /*public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WIN10);

        if (driver == null) {
            try {
                // BROWSER zmienna srodowiskowa ktora decyduje czy testy mamy lokalnie czy na zdalnym chrome
                if (System.getenv().get("BROWSER").equals("remote")) {
                    System.out.println("REMOTE !~!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");


                    driver = new RemoteWebDriver(new URL(Configuration.REMOTE_URL), capabilities);
                    driver.manage().window().setSize(new Dimension(1920, 1080));
                } else {
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                }
            } catch (MalformedURLException | NullPointerException n) {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }
        }
    }
    */
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
