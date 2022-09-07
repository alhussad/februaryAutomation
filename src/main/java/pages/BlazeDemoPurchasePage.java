package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlazeDemoPurchasePage extends BasePage{

    public BlazeDemoPurchasePage(WebDriver driver) {
        super(driver);
    }

    // WebElements (Finding)
    @FindBy(xpath = "//input[@type='submit']") private WebElement clickOnPurchaseButton;

    // Methods (Action)
    public void purchaseButton(){
         clickOnPurchaseButton.click();
    }
}
