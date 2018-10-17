package pl.mig.qa.frontend.factory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPersonalPage extends BasePage{

    public UserPersonalPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".masterbar__item.masterbar__item-me")
    public WebElement userAvatar;

    @FindBy(css = "svg.gridicon.gridicons-visible")
    public WebElement privateButton;

    @FindBy(css = "a[href=\"/me/notifications\"] span.menu-link-text")
    public WebElement notyficationSetup;

}
