package pl.mig.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrivatePage extends BasePage{

    public PrivatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "span.form-toggle__switch")
    public WebElement toggleSwitchPrivateSite;

    @FindBy(css = ".button.form-button.is-primary")
    public WebElement toggleSwitchPrivateSiteSave;
}
