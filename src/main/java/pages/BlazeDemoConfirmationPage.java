package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlazeDemoConfirmationPage extends BasePage{

    public BlazeDemoConfirmationPage(WebDriver driver) {
        super(driver);
    }

    // WebElements (Finding)
    @FindBy(xpath = "//h1") private WebElement confirmationElement;

    // Methods (Action)
    public String confirmationPageTitle(){
        return confirmationElement.getText();
    }
}
