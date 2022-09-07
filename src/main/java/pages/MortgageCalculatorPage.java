package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MortgageCalculatorPage extends BasePage{
    public MortgageCalculatorPage(WebDriver driver) {
        super(driver);
    }

    // Elements finding
    @FindBy(id = "homeval") private WebElement homeValueElement;
    @FindBy(id = "downpayment") private WebElement downPaymentElement;
    @FindBy(id = "intrstsrate") private WebElement interestRateElement;
    @FindBy(id = "loanterm") private WebElement loanTermElement;
    @FindBy(name = "param[start_month]") private WebElement startMonthElement;
    @FindBy(id = "start_year") private WebElement startYearElement;
    @FindBy(css = "input[type='submit']") private WebElement calculateButtonElement;
    @FindBy(xpath = "//div[@class='repayment-block']/div/div/h3") private List<WebElement> repaymentSummaryList;

    // Methods to manipulate the elements
    public void enterHomeValue(String hValue){
        homeValueElement.sendKeys(hValue);
    }
    public void enterDownPayment(String dPayment){
        downPaymentElement.sendKeys(dPayment);
    }
    public void enterInterestRate(String iRate){
        interestRateElement.sendKeys(iRate);
    }
    public void enterLoanTerm(String lTerm){
        loanTermElement.sendKeys(lTerm);
    }
    public void enterStartMonth(String sMonth){
        Select select = new Select(startMonthElement);
        select.selectByVisibleText(sMonth);
    }
    public void enterStartYear(String sYear){
        startYearElement.sendKeys(sYear);
    }
    public void clickCalculateButton(){
        calculateButtonElement.click();
    }
    public String getTotalMonthlyPayment(){
        return repaymentSummaryList.get(0).getText();
    }
    public String getDownPaymentAmount(){
        return repaymentSummaryList.get(2).getText();
    }
    public String getDownPaymentPercentage(){
        return repaymentSummaryList.get(3).getText();
    }
    public String getLoanPayoffDate(){
        return repaymentSummaryList.get(4).getText();
    }
    public String getTotalInterestPaid(){
        return repaymentSummaryList.get(5).getText();
    }
    public String getMonthlyTaxPaid(){
        return repaymentSummaryList.get(6).getText();
    }
}
