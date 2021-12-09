package PageObjects.WebPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GrafanaLoginPage {

    @FindBy(xpath = "//input[@name='user']")
    private WebElement userNameInputField;
    @FindBy(xpath = "//input[@id='current-password']")
    private WebElement passwordInputField;
    @FindBy(className = "css-1xivtx2-button")
    private WebElement logInBtn;
    @FindBy(xpath = "//button[@class='css-1tbo7ox-button']")
    private WebElement skipChangePasswordBtn;

    public WebElement getUserNameInputField() {
        return userNameInputField;
    }

    public WebElement getPasswordInputField() {
        return passwordInputField;
    }

    public WebElement getLogInBtn() {
        return logInBtn;
    }

    public WebElement getSkipChangePasswordBtn() {
        return skipChangePasswordBtn;
    }
}
