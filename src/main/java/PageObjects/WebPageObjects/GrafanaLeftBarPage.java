package PageObjects.WebPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GrafanaLeftBarPage {

    @FindBy(xpath = "//a[@aria-label='Configuration']")
    private WebElement settingsLogo;
    @FindBy(xpath = "//span[@class='css-vy1tg3']/img")
    private WebElement avatarLogo;
    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement avatarLogOut;
    @FindBy(xpath = "//a[@href='/org/users']")
    private WebElement settingsUsers;
    @FindBy(xpath = "//a[@href='/org/teams']")
    private WebElement settingsTeams;
    @FindBy(xpath = "//a[@aria-label='Server Admin']")
    private WebElement shieldLogo;
    @FindBy(xpath = "//li[2]/a[@href='/admin/users']")
    private WebElement shieldUsers;
    @FindBy(xpath = "//div/ul[@role='menu']/li[1]/a[@href='/profile']")
    private WebElement avatarUserName;

    public WebElement getSettingsLogo() {
        return settingsLogo;
    }

    public WebElement getAvatarLogo() {
        return avatarLogo;
    }

    public WebElement getAvatarLogOut() {
        return avatarLogOut;
    }

    public WebElement getSettingsUsers() {
        return settingsUsers;
    }

    public WebElement getSettingsTeams() {
        return settingsTeams;
    }

    public WebElement getShieldLogo() {
        return shieldLogo;
    }

    public WebElement getShieldUsers() {
        return shieldUsers;
    }

    public WebElement getAvatarUserName() {
        return avatarUserName;
    }
}
