package stepDefs;

import base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UkbaStepDefs extends BaseUtil {
    private BaseUtil base;

    public UkbaStepDefs(BaseUtil base) {
        this.base = base;
    }

    @Given("I am on UKBA website {string}")
    public void iAmOnUKBAWebsite(String url) {
        base.driver.manage().window().maximize();
        base.driver.get(url);
        //base.driver.navigate().to(url);
        try {
            WebElement acceptCookies = base.driver.findElement(By.cssSelector("button[data-accept-cookies='truejj']"));
            if (acceptCookies.isDisplayed()){
                acceptCookies.click();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Given("I provide the nationality of {string}")
    public void i_provide_the_nationality_of(String string) {
        WebElement country = base.driver.findElement(By.xpath("//select[@id='response']"));
        Select select = new Select(country);
        select.selectByVisibleText(string);
    }
    @When("I click on Continue button")
    public void i_click_on_continue_button() {
        base.driver.findElement(By.xpath("//button[contains(text(), 'Continue')]")).click();
    }
    @When("I select the reason as study")
    public void i_select_the_reason_as_study() {
        WebElement study = base.driver.findElement(By.xpath("//input[@id='response-2']"));
        study.click();
    }
    @When("I state that I intend stay for more than {int} months")
    public void i_state_that_i_intend_stay_for_more_than_months(Integer int1) {
        WebElement duration = base.driver.findElement(By.xpath("//input[@id='response-1']"));
        duration.click();
    }
    @And("I select the reason as Tourism")
    public void iSelectTheReasonAsTourism() {
        WebElement tourism = base.driver.findElement(By.xpath("//input[@id='response-0']"));
        tourism.click();
    }
    @And("I state I am not travelling or visiting a partner or family")
    public void iStateIAmNotTravellingOrVisitingAPartnerOrFamily() {
        WebElement res = base.driver.findElement(By.xpath("//input[@id='response-1']"));
        res.click();
    }
    @Then("I should be informed that {string}")
    public void i_should_be_informed_that(String expected) {
        WebElement message = base.driver.findElement(By.xpath("//h2[starts-with(@class, 'gem-c-heading')]"));
        assertThat(message.getText(), is(equalTo(expected)));
//        List<WebElement> messages = base.driver.findElements(By.xpath("//h2[starts-with(@class, 'gem-c-heading')]"));
//        assertThat(messages.get(0).getText(), is(equalTo(expected)));

    }

}
