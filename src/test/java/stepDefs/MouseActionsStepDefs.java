package stepDefs;

import base.BaseUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class MouseActionsStepDefs extends BaseUtil {
    private BaseUtil base;

    public MouseActionsStepDefs(BaseUtil base) {
        this.base = base;
    }

    @Given("I am on the Next Website")
    public void i_am_on_the_next_website() throws InterruptedException {
        base.driver.manage().window().maximize();
        base.driver.get("https://www.next.co.uk/");
        Thread.sleep(3000);
        base.driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
    }
    @When("I click on all Lighting")
    public void i_click_on_all_lighting() throws InterruptedException {
        WebElement homeLink = base.driver.findElement(By.xpath("//a[@title='HOME']"));
        new Actions(base.driver)
                .moveToElement(homeLink)
                .perform();
        Thread.sleep(3000);
        WebElement allLightingLink = base.driver.findElement(By.xpath("//span[contains(text(), 'All Lighting')]"));
        new Actions(base.driver)
                .click(allLightingLink)
                .perform();
    }
    @Then("I should see {string} displayed")
    public void i_should_see_displayed(String string) {
        WebElement header = base.driver.findElement(By.xpath("//h1"));
        //assertThat(header.isDisplayed(), is(equalTo(true)));
        assertThat(header.getText(), is(equalTo(string)));
    }
}
