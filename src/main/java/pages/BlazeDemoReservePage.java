package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlazeDemoReservePage extends BasePage{

    public BlazeDemoReservePage(WebDriver driver) {
        super(driver);
    }

    // WebElements (Finding)
    @FindBy(xpath = "//h3[contains(text(), 'Flights')]") private WebElement heading;
    @FindBy(xpath = "//input[@type='submit']") private WebElement clickOnChooseButton;

    // Methods (Action)
    public String getHeadingText(){
        return heading.getText();
    }
    public void clickOnFlightChooseButton(){
        clickOnChooseButton.click();
    }
}
