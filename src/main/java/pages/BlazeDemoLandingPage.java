package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BlazeDemoLandingPage extends BasePage{

    public BlazeDemoLandingPage(WebDriver driver) {
        super(driver);
    }

    // WebElements (Finding)
    @FindBy(xpath = "//select[@name='fromPort']") private WebElement departureCityElement;
    @FindBy(xpath = "//select[@name='toPort']") private WebElement destinationCityElement;
    @FindBy(css = "input[type='submit']") private WebElement clickButton;


    // Methods (Actions)
    public void selectDepartureCity(String cityName){
        Select select = new Select(departureCityElement);
        select.selectByVisibleText(cityName);
    }

    public void selectDestinationCity(String cityName){
        Select select = new Select(destinationCityElement);
        select.selectByVisibleText(cityName);
    }

    public void clickContinueButton(){
        clickButton.click();
    }

}
