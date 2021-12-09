package Utilities;


import PageObjects.AppiumPageObjects.MortgageCalcPage;
import PageObjects.AppiumPageObjects.MortgageCalcSavePage;
import PageObjects.DesktopPageObjects.CalculatorRegularPage;
import PageObjects.DesktopPageObjects.CalculatorScientificPage;
import PageObjects.ElectronPageObjects.ToDoListMainPage;
import PageObjects.WebPageObjects.*;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager extends Base {

    public static void pageObjectManager(String platform) {
        switch (platform.toLowerCase()) {
            case "web":
                grafanaLoginPage = PageFactory.initElements(driver, GrafanaLoginPage.class);
                grafanaMainPage = PageFactory.initElements(driver, GrafanaMainPage.class);
                grafanaLeftBarPage = PageFactory.initElements(driver, GrafanaLeftBarPage.class);
                grafanaCreateUserPage = PageFactory.initElements(driver, GrafanaCreateUserPage.class);
                grafanaDeleteUserPage = PageFactory.initElements(driver, GrafanaDeleteUserPage.class);
                break;
            case "desktop":
                calculatorRegularPage = PageFactory.initElements(driverDesktop, CalculatorRegularPage.class);
                calculatorScientificPage = PageFactory.initElements(driverDesktop, CalculatorScientificPage.class);
                break;
            case "appium":
                mortgageCalcPage = new MortgageCalcPage(driverAndroid);
                mortgageCalcSavePage = new MortgageCalcSavePage(driverAndroid);
                break;
            case "electron":
                toDoListMainPage = PageFactory.initElements(driver, ToDoListMainPage.class);
                break;

        }
    }
}
