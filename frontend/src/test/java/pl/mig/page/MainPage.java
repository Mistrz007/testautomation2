package pl.mig.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
//    WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
//        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "li.x-nav-item.x-nav-item--wide.x-nav-item--logged-in a.x-nav-link.x-link")
    public WebElement logIn;

    //public WebElement logIn = driver.findElement(By.cssSelector("li.x-nav-item.x-nav-item--wide.x-nav-item--logged-in a.x-nav-link.x-link"))


}
