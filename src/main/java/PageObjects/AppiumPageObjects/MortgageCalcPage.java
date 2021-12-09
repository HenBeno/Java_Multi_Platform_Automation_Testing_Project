package PageObjects.AppiumPageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MortgageCalcPage {

    private AndroidDriver<AndroidElement> driver;
    @AndroidFindBy(xpath = "//*[@id='etAmount']")
    private WebElement gpbFiled;
    @AndroidFindBy(xpath = "//*[@id='etTerm']")
    private WebElement years;
    @AndroidFindBy(xpath = "//*[@id='etRate']")
    private WebElement rate;
    @AndroidFindBy(xpath = "//*[@id='add_schedule_text']")
    private WebElement calculateBTN;
    @AndroidFindBy(xpath = "//*[@id='tvRepayment']")
    private WebElement paymentResult;
    @AndroidFindBy(xpath = "//*[@id='tvInterestOnly']")
    private WebElement interestResult;
    @AndroidFindBy(xpath = "//*[@id='btnSave']")
    private WebElement saveResultBtn;


    public MortgageCalcPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public WebElement getSaveResultBtn() {
        return saveResultBtn;
    }

    public WebElement getGpbFiled() {
        return gpbFiled;
    }

    public WebElement getYears() {
        return years;
    }

    public WebElement getRate() {
        return rate;
    }

    public WebElement getCalculateBTN() {
        return calculateBTN;
    }

    public WebElement getPaymentResult() {
        return paymentResult;
    }

    public WebElement getInterestResult() {
        return interestResult;
    }
}
