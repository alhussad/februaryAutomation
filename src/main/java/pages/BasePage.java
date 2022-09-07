package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriverWait wait;

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    }
}
