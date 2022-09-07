package stepDefs;

import base.BaseUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MortgageCalculatorPage;
import utilities.ConfigReader;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class MortgageCalculatorStepDefs extends BaseUtil {
    private BaseUtil base;

    public MortgageCalculatorStepDefs(BaseUtil base) {
        this.base = base;
    }

    @Given("I am on the Mortgage Calculator website")
    public void i_am_on_the_mortgage_calculator_website() throws IOException {
        ConfigReader configReader = new ConfigReader();
        base.driver.manage().window().maximize();
        base.driver.get(configReader.getMortgageCal_URL());
    }
    @When("I enter the following")
    public void i_enter_the_following(List<List<String>> data) {
        MortgageCalculatorPage page = new MortgageCalculatorPage(base.driver);
        page.enterHomeValue(data.get(1).get(1));
        page.enterDownPayment(data.get(2).get(1));
        page.enterInterestRate(data.get(3).get(1));
        page.enterLoanTerm(data.get(4).get(1));
        page.enterStartMonth(data.get(5).get(1));
        page.enterStartYear(data.get(6).get(1));
    }
    @And("I click on the calculate button")
    public void iClickOnTheCalculateButton() {
        MortgageCalculatorPage page = new MortgageCalculatorPage(base.driver);
        page.clickCalculateButton();
    }
    @Then("I should get mortgage offer with {string}, {string}, {string}, {string}, {string}, and {string}")
    public void i_should_get_mortgage_offer_with_and(String TMP, String DPA, String DPP, String LPD, String TIP, String MTP) {
        MortgageCalculatorPage page = new MortgageCalculatorPage(base.driver);
        assertThat(page.getTotalMonthlyPayment(), is(equalTo(TMP)));
        assertThat(page.getDownPaymentAmount(), is(equalTo(DPA)));
        assertThat(page.getDownPaymentPercentage(), is(equalTo(DPP)));
        assertThat(page.getLoanPayoffDate(), is(equalTo(LPD)));
        assertThat(page.getTotalInterestPaid(), is(equalTo(TIP)));
        assertThat(page.getMonthlyTaxPaid(), is(equalTo(MTP)));
    }

}
