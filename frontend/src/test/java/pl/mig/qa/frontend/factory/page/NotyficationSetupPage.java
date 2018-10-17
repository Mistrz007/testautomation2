package pl.mig.qa.frontend.factory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotyficationSetupPage extends BasePage{

    public NotyficationSetupPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".notification-settings-form-stream:nth-child(3) li.notification-settings-form-stream-options__item:nth-child(2) input")
    public WebElement newObservEmailToggle;

    @FindBy(css = ".button.form-button.is-primary")
    public WebElement saveButton;
}
