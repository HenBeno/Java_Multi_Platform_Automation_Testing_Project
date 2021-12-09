package PageObjects.WebPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GrafanaDeleteUserPage {

    @FindBy(xpath = "//tbody/tr/td[2]")
    private List<WebElement> listOfAllUserNames;
    @FindBy(xpath = "//tbody/tr/td[7]")
    private List<WebElement> listOfAllDeleteUsersBtn;
    @FindBy(xpath = "//button[@aria-label='Confirm Modal Danger Button']")
    private WebElement approveDeleteBtn;
    @FindBy(xpath = "//input[@placeholder='Search user by login, email or name']")
    private WebElement search;


    public List<WebElement> getListOfAllUserNames() {
        return listOfAllUserNames;
    }

    public List<WebElement> getListOfAllDeleteUsersBtn() {
        return listOfAllDeleteUsersBtn;
    }

    public WebElement getApproveDeleteBtn() {
        return approveDeleteBtn;
    }

    public WebElement getSearch() {
        return search;
    }

}
