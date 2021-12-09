package PageObjects.WebPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GrafanaCreateUserPage {

    @FindBy(xpath = "//a[@href='admin/users/create']")
    private WebElement newUserBtn;
    @FindBy(xpath = "//input[@name='login']")
    private WebElement userName_txt;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement password_txt;
    @FindBy(xpath = "//input[@name='name']")
    private WebElement name_txt;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement email_txt;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createUserBtn;
    @FindBy(xpath = "//input[@placeholder='Search user by login, email, or name.']")
    private WebElement searchInput;
    @FindBy(xpath = "//tbody/tr/td[2]/a")
    private List<WebElement> searchResult;

    public WebElement getNewUserBtn() {
        return newUserBtn;
    }

    public WebElement getUserName_txt() {
        return userName_txt;
    }

    public WebElement getPassword_txt() {
        return password_txt;
    }

    public WebElement getName_txt() {
        return name_txt;
    }

    public WebElement getEmail_txt() {
        return email_txt;
    }

    public WebElement getCreateUserBtn() {
        return createUserBtn;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public List<WebElement> getSearchResult() {
        return searchResult;
    }
}
