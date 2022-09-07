package stepDefs;

import base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BlazeDemoConfirmationPage;
import pages.BlazeDemoLandingPage;
import pages.BlazeDemoPurchasePage;
import pages.BlazeDemoReservePage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class BlazeDemoStepDefs extends BaseUtil {
    private BaseUtil base;

    public BlazeDemoStepDefs(BaseUtil base) {
        this.base = base;
    }

    @Given("I am on the Welcome to Simple Travel Agency landing page")
    public void i_am_on_the_welcome_to_simple_travel_agency_landing_page() {
        base.driver.manage().window().maximize();
        //base.driver.switchTo().alert().accept();
        base.driver.get("https://blazedemo.com/");
    }
    @When("I choose from the {string} and {string} from the drop down")
    public void i_choose_from_the_and_from_the_drop_down(String depCityName, String destCityName) {
        BlazeDemoLandingPage blazeDemoLandingPage = new BlazeDemoLandingPage(base.driver);
        blazeDemoLandingPage.selectDepartureCity(depCityName);
        blazeDemoLandingPage.selectDestinationCity(destCityName);
    }
    @And("I click on the find flight button")
    public void i_click_on_the_find_flight_button() {
        BlazeDemoLandingPage blazeDemoLandingPage = new BlazeDemoLandingPage(base.driver);
        blazeDemoLandingPage.clickContinueButton();
    }
    @Then("I should be able to see {string} and {string} on the BlazeDemo reserve page")
    public void i_should_be_able_to_see_and_on_the_blaze_demo_reserve_page(String depCity, String destCity) {
        BlazeDemoReservePage blazeDemoReservePage = new BlazeDemoReservePage(base.driver);
        String str = blazeDemoReservePage.getHeadingText();
        assertThat(str.contains(depCity), is(true));
        assertThat(str.contains(destCity), is(true));
    }

    @And("I choose the first flight from the reserve page")
    public void iChooseTheFirstFlightFromTheReservePage() {
        BlazeDemoReservePage blazeDemoReservePage = new BlazeDemoReservePage(base.driver);
        blazeDemoReservePage.clickOnFlightChooseButton();
    }

    @And("I click Purchase Flight button on the Purchase page")
    public void iClickPurchaseFlightButtonOnThePurchasePage() {
        BlazeDemoPurchasePage blazeDemoPurchasePage = new BlazeDemoPurchasePage(base.driver);
        blazeDemoPurchasePage.purchaseButton();
    }

    @Then("{string} message is displayed on the confirmation page")
    public void messageIsDisplayedOnTheConfirmationPage(String msg) {
        BlazeDemoConfirmationPage blazeDemoConfirmationPage = new BlazeDemoConfirmationPage(base.driver);
        assertThat(blazeDemoConfirmationPage.confirmationPageTitle(), is(equalTo(msg)));
    }
}
